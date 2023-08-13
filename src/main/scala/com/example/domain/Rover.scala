package com.example.domain

case class Rover(abscissa: Seq[Int], ordinate: Seq[Int], coordinates: (Int, Int), direction: Direction) {

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
