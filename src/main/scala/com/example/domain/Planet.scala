package com.example.domain

case class Planet(width: Int, height: Int) {

  private val emptySpot: Char = '.'
  private lazy val frontSide: Seq[Seq[Char]] = Seq.fill(height)(Seq.fill(width)(emptySpot))
  private lazy val backSide: Seq[Seq[Char]] = Seq.fill(height)(Seq.fill(width)(emptySpot))

  def drawPoint(point: Point, char: Char = 'X'): Seq[Seq[Char]] =
    frontSide.updated(point.longitude - 1, frontSide(point.longitude - 1).updated(point.latitude - 1, char))
      .zip(backSide)
      .map { case (value, value1) => value ++ Seq(':') ++ value1 }

}
