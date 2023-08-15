package com.example.domain

case class Point(latitude: Int, longitude: Int, side: Side = Side.Front) {
  def up: Point = copy(longitude = longitude - 1)

  def down: Point = copy(longitude = longitude + 1)

  def right: Point = copy(latitude = latitude + 1)

  def left: Point = copy(latitude = latitude - 1)
}
