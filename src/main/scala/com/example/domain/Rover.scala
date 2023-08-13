package com.example.domain

case class Rover(abscissa: Seq[Int], ordinate: Seq[Int], coordinates: (Int, Int), direction: Direction) {

  def moveForward(): Rover = copy(
    coordinates = direction match {
      case Direction.N => (coordinates._1, coordinates._2 - 1)
      case Direction.S => (coordinates._1, coordinates._2 + 1)
      case Direction.E => (coordinates._1 + 1, coordinates._2)
      case Direction.W => (coordinates._1 - 1, coordinates._2)
    }
  )

}

object Rover {

  def apply(abscissa: Seq[Int], ordinate: Seq[Int]): Rover =
    Rover(
      abscissa,
      ordinate,
      (abscissa((abscissa.size / 2).ceil.toInt), ordinate((ordinate.size / 2).ceil.toInt)),
      Direction.N
    )

}
