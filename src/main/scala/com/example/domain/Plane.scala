package com.example.domain

case class Plane(width: Int, height: Int) {

  private val emptySpot: Char = '.'
  private lazy val map: Seq[Seq[Char]] = Seq.fill(width)(Seq.fill(height)(emptySpot))

  def drawPoint(point: Point, char: Char = emptySpot): Seq[Seq[Char]] =
    map.updated(point.latitude - 1, map(point.latitude - 1).updated(point.longitude - 1, char))

}
