package com.example.domain

import com.example.exeptions.InvalidCommandException
import org.assertj.core.api.Assertions.assertThat
import org.mockito.Mockito.when
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.mockito.MockitoSugar

import scala.collection.immutable.Seq

class RoverSpec extends AnyFunSuite with MockitoSugar {
  val planet: Planet = Planet(5, 5)
  val initialPoint: Point = Point((planet.width / 2F).ceil.toInt, (planet.height / 2F).ceil.toInt)

  test("Validar que un Rover se crea por defecto en el centro del plano en dirección norte") {
    val point: Point = Point(3, 3)

    val rover: Rover = Rover(planet, initialPoint)

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede crear con posición y dirección") {
    val point: Point = Point(2, 2)

    val rover: Rover = Rover(planet, point, Direction.S)

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección N") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(planet, initialPoint).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección S") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(planet, initialPoint, Direction.S).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección E") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.E).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.E)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección W") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.W).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.W)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección N") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(planet, initialPoint).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección S") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(planet, initialPoint, Direction.S).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección E") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.E).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.E)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección W") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.W).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.W)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección N") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(planet, initialPoint).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.E)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección S") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.S).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.W)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección E") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(planet, initialPoint, Direction.E).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección W") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(planet, initialPoint, Direction.W).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección N") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(planet, initialPoint).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.W)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección S") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.S).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.E)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección E") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(planet, initialPoint, Direction.E).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.N)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección W") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(planet, initialPoint, Direction.W).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.S)
  }

  test("Imprimir un mapa de ubicación y dirección del Rover") {
    val rover: Rover = Rover(planet, initialPoint)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '↑', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Un Rover debe poder reaccionar a una serie de comandos (f,b,l,r)") {
    val commands: Seq[Char] = Seq('f', 'l', 'f', 'l', 'f', 'f', 'r', 'b', 'r', 'f')

    val rover: Rover = Rover(planet, initialPoint).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '↑', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Un Rover debe lanzar una excepción si recibe un comando desconocido") {
    val commands: Seq[Char] = Seq('f', 'l', 'f', 'l', 'x', 'f', 'r', 'b', 'r', 'f')

    val rover: Rover = Rover(planet, initialPoint)

    intercept[InvalidCommandException] {
      rover.processCommands(commands)
    }
  }

  test("Un Rover debe abortar una serie de comandos al reconocer un obstáculo") {
    val commands: Seq[Char] = Seq('f', 'l', 'f', 'l', 'f', 'f', 'r', 'b', 'r', 'f')
    val sensor: Sensor = mock[Sensor]
    when(sensor.obstacleAhead)
      .thenReturn(false)
      .thenReturn(false)
      .thenReturn(false)
      .thenReturn(false)
      .thenReturn(false)
      .thenReturn(true)

    val rover: Rover = Rover(planet, initialPoint, sensor = sensor).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '↓', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el rover llega al polo norte debe reaparecer en la cara opuesta del planeta") {
    val rover: Rover = Rover(planet, initialPoint).moveForward().moveForward().moveForward()

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '↓', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el rover llega al polo norte de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el polo sur") {
    val commands: Seq[Char] = Seq('f', 'f', 'f', 'f', 'f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '↓', '.', '.')
      )
    )
  }

  test("Si el rover llega al polo sur debe reaparecer en la cara opuesta del planeta") {
    val commands: Seq[Char] = Seq('f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint, Direction.S).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '↓', '.', '.')
      )
    )
  }

}
