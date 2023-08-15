package com.example.domain

case class Planet(width: Int, height: Int) {

  private lazy val frontSide: Seq[Seq[Char]] = Seq.fill(height)(Seq.fill(width)(emptySpot))
  private lazy val backSide: Seq[Seq[Char]] = Seq.fill(height)(Seq.fill(width)(emptySpot))
  private val emptySpot: Char = '.'

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

    (point
      .side match {
      case Side.Front => addPointToSide(frontSide).zip(backSide)
      case Side.Back => frontSide.zip(addPointToSide(backSide))
    })
      .map { case (front, back) => front ++ Seq(':') ++ back }
  }

}
