package com.example.domain

case class Rover(abscissa: Seq[Int], ordinate: Seq[Int], coordinates: Point, direction: Direction) {

  def moveForward(): Rover = copy(
    coordinates = direction match {
      case Direction.N => coordinates.copy(y = coordinates.y - 1)
      case Direction.S => coordinates.copy(y = coordinates.y + 1)
      case Direction.E => coordinates.copy(x = coordinates.y + 1)
      case Direction.W => coordinates.copy(x = coordinates.x - 1)
    }
  )

}

object Rover {

  def apply(abscissa: Seq[Int], ordinate: Seq[Int]): Rover =
    Rover(
      abscissa,
      ordinate,
      Point(abscissa((abscissa.size / 2).ceil.toInt), ordinate((ordinate.size / 2).ceil.toInt)),
      Direction.N
    )

}
