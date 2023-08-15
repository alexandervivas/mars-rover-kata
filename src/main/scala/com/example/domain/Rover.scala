package com.example.domain

import com.example.exeptions.InvalidCommandException

case class Rover(planet: Planet, coordinates: Point, direction: Direction = Direction.North, sensor: Sensor = Sensor()) {

  private lazy val wheel: Wheel = Wheel(direction)

  // log the current status in each step
  println("\n" + printMap.map(_.mkString(" ")).mkString("\n") + "\n")

  def printMap: Seq[Seq[Char]] = planet.drawPoint(coordinates, direction.value)

  private def processCommand(command: Char): Rover = {
    ensureCommandIsValid(command)

    command match {
      case 'f' => moveForward()
      case 'b' => moveBackward()
      case 'r' => turnRight()
      case 'l' => turnLeft()
    }
  }

  private def ensureCommandIsValid(command: Char): Unit =
    if (!Seq('f', 'b', 'r', 'l').contains(command)) {
      throw new InvalidCommandException
    }

  def processCommands(commands: Seq[Char]): Rover =
    if(sensor.obstacleAhead) {
      println(s"Obstacle ahead detected, dropping the sequence of commands at coordinates: $coordinates")
      this
    } else {
      commands match {
        case Nil => this
        case head :: tail =>
          processCommand(head)
            .processCommands(tail)
      }
    }

  def turnLeft(): Rover = copy(direction = wheel.turnLeft.direction)

  def turnRight(): Rover = copy(direction = wheel.turnRight.direction)

  def moveForward(): Rover =
    direction match { // The ordering here matters!
      case Direction.North if atNorthPole => copy(coordinates = moveToTheOtherSide, direction = Direction.South)
      case Direction.North => copy(coordinates = coordinates.up)
      case Direction.South if atSouthPole => copy(coordinates = moveToTheOtherSide, direction = Direction.North)
      case Direction.South => copy(coordinates = coordinates.down)
      case Direction.East if atEastEnd => copy(coordinates = moveToTheOtherSide)
      case Direction.East => copy(coordinates = coordinates.right)
      case Direction.West => copy(coordinates = coordinates.left)
    }

  private def moveToTheOtherSide: Point = coordinates.copy(coordinates.latitude - planet.width - 1, coordinates.longitude)

  private def atEastEnd: Boolean = coordinates.latitude == planet.width

  private def atSouthPole: Boolean = coordinates.longitude == planet.height

  private def atNorthPole: Boolean = coordinates.longitude == 1

  def moveBackward(): Rover = copy(
    coordinates = direction match {
      case Direction.North => coordinates.down
      case Direction.South => coordinates.up
      case Direction.East => coordinates.left
      case Direction.West => coordinates.right
    }
  )

}
