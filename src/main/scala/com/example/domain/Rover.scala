package com.example.domain

import com.example.exeptions.InvalidArgumentException

case class Rover(abscissa: Seq[Int], ordinate: Seq[Int], coordinates: (Int, Int), direction: Char) {

  if (!Seq('N', 'S', 'E', 'W').contains(direction)) {
    throw new InvalidArgumentException
  }

}

object Rover {

  def apply(abscissa: Seq[Int], ordinate: Seq[Int]): Rover =
    Rover(
      abscissa,
      ordinate,
      (abscissa((abscissa.size / 2).ceil.toInt), ordinate((ordinate.size / 2).ceil.toInt)),
      'N'
    )

}
