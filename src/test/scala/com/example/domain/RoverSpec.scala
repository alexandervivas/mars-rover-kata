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
    assertThat(rover.direction).isEqualTo(Direction.North)
  }

  test("Validar que un Rover se puede crear con posición y dirección") {
    val point: Point = Point(2, 2)

    val rover: Rover = Rover(planet, point, Direction.South)

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.South)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección N") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(planet, initialPoint).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.North)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección S") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(planet, initialPoint, Direction.South).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.South)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección E") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.East).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.East)
  }

  test("Validar que un Rover se puede mover hacia adelante en dirección W") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.West).moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.West)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección N") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(planet, initialPoint).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.North)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección S") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(planet, initialPoint, Direction.South).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.South)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección E") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.East).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.East)
  }

  test("Validar que un Rover se puede mover hacia atrás estando en dirección W") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.West).moveBackward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.West)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección N") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(planet, initialPoint).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.East)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección S") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.South).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.West)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección E") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(planet, initialPoint, Direction.East).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.South)
  }

  test("Validar que un Rover se puede mover hacia la derecha estando en dirección W") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(planet, initialPoint, Direction.West).turnRight().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.North)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección N") {
    val point: Point = Point(2, 3)

    val rover: Rover = Rover(planet, initialPoint).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.West)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección S") {
    val point: Point = Point(4, 3)

    val rover: Rover = Rover(planet, initialPoint, Direction.South).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.East)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección E") {
    val point: Point = Point(3, 2)

    val rover: Rover = Rover(planet, initialPoint, Direction.East).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.North)
  }

  test("Validar que un Rover se puede mover hacia la izquierda estando en dirección W") {
    val point: Point = Point(3, 4)

    val rover: Rover = Rover(planet, initialPoint, Direction.West).turnLeft().moveForward()

    assertThat(rover.coordinates).isEqualTo(point)
    assertThat(rover.direction).isEqualTo(Direction.South)
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

  test("Si el Rover yendo hacia adelante llega al polo norte debe reaparecer en la cara opuesta del planeta") {
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

  test("Si el Rover yendo hacia adelante llega al polo norte de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el polo sur") {
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

  test("Si el Rover yendo hacia adelante llega al polo sur debe reaparecer en la cara opuesta del planeta") {
    val commands: Seq[Char] = Seq('f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint, Direction.South).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '↑', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia adelante llega a la cara opuesta por el polo sur, debe cambiar su dirección hacia el norte") {
    val commands: Seq[Char] = Seq('f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint, Direction.South).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '↑', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia adelante llega al polo sur de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el polo norte") {
    val commands: Seq[Char] = Seq('f', 'f', 'f', 'f', 'f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint, Direction.South).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '↑', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia adelante llega al extremo este debe reaparecer en la cara opuesta del planeta por el oeste") {
    val commands: Seq[Char] = Seq('f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint, Direction.East).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '→', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia adelante llega al extremo este de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el extremo oeste de la cara frontal") {
    val commands: Seq[Char] = Seq('f', 'f', 'f', 'f', 'f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint, Direction.East).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '→'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia adelante llega al extremo oeste debe reaparecer en la cara opuesta del planeta por el este") {
    val commands: Seq[Char] = Seq('f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint, Direction.West).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '←'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia adelante llega al extremo oeste de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el extremo este de la cara frontal") {
    val commands: Seq[Char] = Seq('f', 'f', 'f', 'f', 'f', 'f', 'f', 'f')

    val rover: Rover = Rover(planet, initialPoint, Direction.West).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '←', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia atrás llega a la cara opuesta por el polo norte, el Rover debe aparecer en la otra cara del planeta y cambiar su dirección hacia el Norte") {
    val commands: Seq[Char] = Seq('b', 'b', 'b')

    val rover: Rover = Rover(planet, initialPoint, Direction.South).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '↑', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia atrás llega al polo norte de la cara opuesta del planeta y se sigue moviendo hacia atrás debe poder alcanzar el polo sur") {
    val commands: Seq[Char] = Seq('b', 'b', 'b', 'b', 'b', 'b', 'b')

    val rover: Rover = Rover(planet, initialPoint, Direction.South).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '↑', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia atrás llega al polo sur debe reaparecer en la cara opuesta del planeta y cambiar su dirección hacia el sur") {
    val commands: Seq[Char] = Seq('b', 'b', 'b')

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

  test("Si el Rover yendo hacia atrás llega al polo sur de la cara opuesta del planeta y se sigue moviendo hacia atrás debe poder alcanzar el polo norte") {
    val commands: Seq[Char] = Seq('b', 'b', 'b', 'b', 'b', 'b', 'b')

    val rover: Rover = Rover(planet, initialPoint).processCommands(commands)

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

  test("Si el Rover yendo hacia atrás llega al extremo Este, debe reaparecer en la cara opuesta del planeta por el oeste") {
    val commands: Seq[Char] = Seq('b', 'b', 'b')

    val rover: Rover = Rover(planet, initialPoint, Direction.West).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '←', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia atrás llega al extremo Este de la cara opuesta del planeta y se sigue moviendo hacia atrás debe poder alcanzar el extremo oeste de la cara frontal") {
    val commands: Seq[Char] = Seq('b', 'b', 'b', 'b', 'b', 'b', 'b')

    val rover: Rover = Rover(planet, initialPoint, Direction.West).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '←'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia atrás llega al extremo Oeste debe reaparecer en la cara opuesta del planeta por el este") {
    val commands: Seq[Char] = Seq('b', 'b', 'b')

    val rover: Rover = Rover(planet, initialPoint, Direction.East).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '→'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("Si el Rover yendo hacia atrás llega al extremo Oeste de la cara opuesta del planeta y se sigue moviendo hacia atrás debe poder alcanzar el extremo este de la cara frontal") {
    val commands: Seq[Char] = Seq('b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')

    val rover: Rover = Rover(planet, initialPoint, Direction.East).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '→', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

  test("El Rover debe ser capaz de seguir un camino complejo") {
    val commands: Seq[Char] = Seq('f', 'f', 'f', 'f', 'r', 'f', 'f', 'f', 'l', 'b', 'b', 'l', 'b', 'b', 'b', 'r', 'r', 'f', 'f', 'l', 'b')

    val rover: Rover = Rover(planet, initialPoint).processCommands(commands)

    assertThat(rover.printMap).isEqualTo(
      Seq(
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('↑', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.'),
        Seq('.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.')
      )
    )
  }

}
