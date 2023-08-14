package com.example.domain

case class Planet(width: Int, height: Int) {

  private val emptySpot: Char = '.'
  private lazy val frontSide: Seq[Seq[Char]] = Seq.fill(height)(Seq.fill(width)(emptySpot))
  private lazy val backSide: Seq[Seq[Char]] = Seq.fill(height)(Seq.fill(width)(emptySpot))

  def drawPoint(point: Point, char: Char = 'X'): Seq[Seq[Char]] = {
    def addPointToSide(side: Seq[Seq[Char]]): Seq[Seq[Char]] =
      side
        .updated(
          Math.abs(point.longitude) - 1,
          side(Math.abs(point.longitude) - 1)
            .updated(
              Math.abs(point.latitude) - 1,
              char
            )
        )

    (point match {
      case Point(latitude, longitude) if latitude < 0 || longitude < 0 =>
        frontSide.zip(addPointToSide(backSide))
      case _ =>
        addPointToSide(frontSide).zip(backSide)
    })
      .map { case (front, back) => front ++ Seq(':') ++ back }
  }

}
