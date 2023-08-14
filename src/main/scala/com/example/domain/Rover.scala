package com.example.domain

case class Rover(plane: Plane, coordinates: Point, direction: Direction) {

  private lazy val wheel: Wheel = Wheel(direction)

  def printMap: Seq[Seq[Char]] = plane.drawPoint(coordinates, direction.value)

  def moveLeft(): Rover = copy(
    direction = wheel.turnLeft.direction
  ).moveForward()

  def moveRight(): Rover = copy(
    direction = wheel.turnRight.direction
  ).moveForward()

  def moveForward(): Rover = copy(
    coordinates = direction match {
      case Direction.N => coordinates.up
      case Direction.S => coordinates.down
      case Direction.E => coordinates.right
      case Direction.W => coordinates.left
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

object Rover {

  def apply(plane: Plane, direction: Direction = Direction.N): Rover =
    Rover(
      plane,
      Point((plane.width / 2F).ceil.toInt, (plane.height / 2F).ceil.toInt),
      direction
    )

}
