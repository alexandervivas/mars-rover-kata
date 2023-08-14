package com.example.domain

case class Plane(width: Int, height: Int) {

  private val emptySpot: Char = '.'
  private lazy val map: Seq[Seq[Char]] = Seq.fill(height)(Seq.fill(width)(emptySpot))

  def drawPoint(point: Point, char: Char = emptySpot): Seq[Seq[Char]] =
    map.updated(point.longitude - 1, map(point.longitude - 1).updated(point.latitude - 1, char))

}