package com.example.domain

case class Point(x: Int, y: Int) {
  def up: Point = copy(y = y - 1)

  def down: Point = copy(y = y + 1)

  def right: Point = copy(x = x + 1)

  def left: Point = copy(x = x - 1)
}
