package com.example.domain

import com.example.exeptions.InvalidCommandException

case class Rover(planet: Planet, coordinates: Point, direction: Direction = Direction.North, sensor: Sensor = Sensor()) {

  private lazy val wheel: Wheel = Wheel(direction)

  // log the current status in each step
  println(coordinates)
  println(printMap.map(_.mkString(" ")).mkString("\n") + "\n")

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
      case Direction.North if atNorthPole => copy(coordinates = moveBetweenPoles, direction = Direction.South)
      case Direction.North => copy(coordinates = coordinates.up)
      case Direction.South if atSouthPole => copy(coordinates = moveBetweenPoles, direction = Direction.North)
      case Direction.South => copy(coordinates = coordinates.down)
      case Direction.East if atEastEnd => copy(coordinates = moveToTheWest)
      case Direction.East => copy(coordinates = coordinates.right)
      case Direction.West if atWestEnd => copy(coordinates = moveToTheEast)
      case Direction.West => copy(coordinates = coordinates.left)
    }

  private def atWestEnd: Boolean = coordinates.latitude == 1

  private def moveToTheEast: Point =
    coordinates.copy(
      planet.width,
      Math.abs(coordinates.longitude - planet.height - 1),
      Side.switch(coordinates.side)
    )

  private def atEastEnd: Boolean = coordinates.latitude == planet.width

  private def moveToTheWest: Point =
    coordinates.copy(
      1,
      Math.abs(coordinates.longitude - planet.height - 1),
      Side.switch(coordinates.side)
    )

  private def moveBetweenPoles: Point =
    coordinates.copy(
      Math.abs(coordinates.latitude - planet.width - 1),
      coordinates.longitude,
      Side.switch(coordinates.side)
    )

  private def atSouthPole: Boolean = coordinates.longitude == planet.height

  private def atNorthPole: Boolean = coordinates.longitude == 1

  def moveBackward(): Rover =
    direction match {
      case Direction.North if atSouthPole => copy(coordinates = moveBetweenPoles, direction = Direction.South)
      case Direction.North => copy(coordinates = coordinates.down)
      case Direction.South if atNorthPole => copy(coordinates = moveBetweenPoles, direction = Direction.North)
      case Direction.South => copy(coordinates = coordinates.up)
      case Direction.East => copy(coordinates = coordinates.left)
      case Direction.West => copy(coordinates = coordinates.right)
    }

}
