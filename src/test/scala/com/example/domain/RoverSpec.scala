package com.example.domain

import org.assertj.core.api.Assertions.assertThat
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

import scala.collection.immutable.Seq

class RoverSpec extends AnyFunSuite with MockitoSugar {
  val abscissa: Seq[Int] = Seq(1, 2, 3, 4, 5)
  val ordinate: Seq[Int] = Seq(1, 2, 3, 4, 5)

  test("Validar que un Rover se crea por defecto en el centro del plano en dirección norte") {
    val rover: Rover = Rover(abscissa, ordinate)

    assertThat(rover.coordinates).isEqualTo((3, 3))
    assertThat(rover.direction).isEqualTo('N')
  }

  test("Validar que un Rover se puede crear con posición y dirección") {
    val rover: Rover = Rover(abscissa, ordinate, (2, 2), 'S')

    assertThat(rover.coordinates).isEqualTo((2, 2))
    assertThat(rover.direction).isEqualTo('S')
  }

}
