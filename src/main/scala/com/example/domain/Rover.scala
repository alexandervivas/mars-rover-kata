package com.example.domain

import com.example.exeptions.InvalidCommandException

case class Rover(planet: Planet, coordinates: Point, direction: Direction = Direction.N, sensor: Sensor = Sensor()) {

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

  def moveForward(): Rover = copy(
    coordinates = direction match {
      case Direction.N =>
        if(coordinates.longitude == 1) {
          coordinates.copy(coordinates.latitude - planet.width - 1, -coordinates.longitude)
        } else {
          coordinates.up
        }

      case Direction.S => coordinates.down
      case Direction.E => coordinates.right
      case Direction.W => coordinates.left
    },
    direction = direction match {
      case Direction.N =>
        if(coordinates.longitude == 1) {
          Direction.S
        } else {
          Direction.N
        }
      case Direction.S => Direction.S
      case Direction.E => Direction.E
      case Direction.W => Direction.W
    }
  )

  def moveBackward(): Rover = copy(
    coordinates = direction match {
      case Direction.N => coordinates.down
      case Direction.S => coordinates.up
      case Direction.E => coordinates.left
      case Direction.W => coordinates.right
    }
  )

}
