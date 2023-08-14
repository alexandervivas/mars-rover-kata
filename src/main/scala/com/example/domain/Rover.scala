package com.example.domain

case class Rover(plane: Plane, coordinates: Point, direction: Direction) {

  private lazy val wheel: Wheel = Wheel(direction)

  println("\n\n" + printMap.map(_.mkString(" ")).mkString("\n") + "\n\n")

  def printMap: Seq[Seq[Char]] = plane.drawPoint(coordinates, direction.value)

  def turnLeft(): Rover = copy(
    direction = wheel.turnLeft.direction
  )

  def turnRight(): Rover = copy(
    direction = wheel.turnRight.direction
  )

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
