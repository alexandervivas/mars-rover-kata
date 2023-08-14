package com.example.domain

case class Wheel(direction: Direction) {
  def turnRight: Wheel = copy(
    direction = direction match {
      case Direction.N => Direction.E
      case Direction.S => Direction.W
      case Direction.E => Direction.S
      case Direction.W => Direction.N
    }
  )

  def turnLeft: Wheel = copy(
    direction = direction match {
      case Direction.N => Direction.W
      case Direction.S => Direction.E
      case Direction.E => Direction.N
      case Direction.W => Direction.S
    }
  )
}
