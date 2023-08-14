package com.example.domain

case class Rover(abscissa: Seq[Int], ordinate: Seq[Int], coordinates: Point, direction: Direction) {
  def moveLeft(): Rover = copy(
    direction = direction match {
      case Direction.N => Direction.W
      case Direction.S => Direction.E
      case Direction.E => Direction.N
      case Direction.W => Direction.S
    }
  ).moveForward()

  def moveRight(): Rover = copy(
    direction = direction match {
      case Direction.N => Direction.E
      case Direction.S => Direction.W
      case Direction.E => Direction.S
      case Direction.W => Direction.N
    }
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
