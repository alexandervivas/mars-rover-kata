package com.example.domain

import com.example.exeptions.InvalidCoordinatesException

case class Point(latitude: Int, longitude: Int, side: Side = Side.Front) {
  if(latitude < 0 || longitude < 0) {
    throw new InvalidCoordinatesException
  }

  def up: Point = copy(longitude = longitude - 1)

  def down: Point = copy(longitude = longitude + 1)

  def right: Point = copy(latitude = latitude + 1)

  def left: Point = copy(latitude = latitude - 1)
}
