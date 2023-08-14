package com.example.domain

case class Rover(abscissa: Seq[Int], ordinate: Seq[Int], coordinates: Point, direction: Direction) {

  private lazy val wheel: Wheel = Wheel(direction)

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

  def apply(abscissa: Seq[Int], ordinate: Seq[Int], direction: Direction = Direction.N): Rover =
    Rover(
      abscissa,
      ordinate,
      Point(abscissa((abscissa.size / 2).ceil.toInt), ordinate((ordinate.size / 2).ceil.toInt)),
      direction
    )

}
