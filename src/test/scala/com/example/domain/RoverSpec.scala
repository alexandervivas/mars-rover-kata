package com.example.domain

import org.assertj.core.api.Assertions.assertThat
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

import scala.collection.immutable.Seq

class RoverSpec extends AnyFunSuite with MockitoSugar {
  val abscissa: Seq[Int] = Seq(1, 2, 3, 4, 5)
  val ordinate: Seq[Int] = Seq(1, 2, 3, 4, 5)

  test("Validar que un Rover se crea por defecto en el centro del plano en dirección norte") {
    val point: Point = Point(3, 3)

    val rover: Rover = Rover(abscissa, ordinate)

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede crear con posición y dirección") {
    val point: Point = Point(2, 2)

    val rover: Rover = Rover(abscissa, ordinate, point, Direction.S)

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia adelante") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(abscissa, ordinate).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

}
