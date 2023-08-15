package com.example.domain

case class Wheel(direction: Direction) {
  def turnRight: Wheel = copy(
    direction = direction match {
      case Direction.North => Direction.East
      case Direction.South => Direction.West
      case Direction.East => Direction.South
      case Direction.West => Direction.North
    }
  )

  def turnLeft: Wheel = copy(
    direction = direction match {
      case Direction.North => Direction.West
      case Direction.South => Direction.East
      case Direction.East => Direction.North
      case Direction.West => Direction.South
    }
  )
}
