package com.example.domain

import org.assertj.core.api.Assertions.assertThat
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

import scala.collection.immutable.Seq

class RoverSpec extends AnyFunSuite with MockitoSugar {
  val plane: Plane = Plane(5, 5)

  test("Validar que un Rover se crea por defecto en el centro del plano en dirección norte") {
    val point: Point = Point(3, 3)

    val rover: Rover = Rover(plane)

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede crear con posición y dirección") {
    val point: Point = Point(2, 2)

    val rover: Rover = Rover(plane, point, Direction.S)

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección N") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(plane).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección S") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(plane, Direction.S).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección E") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(plane, Direction.E).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.E)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección W") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(plane, Direction.W).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.W)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección N") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(plane).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección S") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(plane, Direction.S).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección E") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(plane, Direction.E).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.E)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección W") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(plane, Direction.W).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.W)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección N") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(plane).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.E)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección S") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(plane, Direction.S).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.W)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección E") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(plane, Direction.E).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección W") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(plane, Direction.W).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección N") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(plane).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.W)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección S") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(plane, Direction.S).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.E)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección E") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(plane, Direction.E).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección W") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(plane, Direction.W).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Imprimir un mapa de ubicación y dirección del Rover") {
    val rover: Rover = Rover(plane)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.'),
        Seq('.', '.', '↑', '.', '.'),
        Seq('.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.')
      )
    )
  }

  test("Un Rover debe poder reaccionar a una serie de comandos (f,b,l,r)") {
    val commands: Seq[Char] = Seq('f', 'l', 'f', 'l', 'f', 'f', 'r', 'b', 'r', 'f')

    val rover = Rover(plane).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.'),
        Seq('.', '.', '↑', '.', '.'),
        Seq('.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.')
      )
    )
  }

}
