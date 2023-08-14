package com.example.domain

import org.assertj.core.api.Assertions.assertThat
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

class PlanetSpec extends AnyFunSuite with MockitoSugar {

  test("El mapa debe incluir dos caras para representar el recorrido del Rover en ambas caras de un planeta") {
    val planet: Planet = Planet(5, 5)
    val point: Point = Point(3, 3)

    assertThat(planet.drawPoint(point)).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', 'X', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

}
