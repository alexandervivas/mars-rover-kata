package com.example.domain

import org.assertj.core.api.Assertions.assertThat
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

class RoverSpec extends AnyFunSuite with MockitoSugar {

  test("Validar que un Rover se crea por defecto en el centro del plano en dirección norte") {

    assertThat(rover.position).isEqualTo((3, 3))
    assertThat(rover.direction).isEqualTo('N')

  }

}
