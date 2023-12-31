# MARS ROVER KATA

Your Task
You’re part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet. Develop an API that translates the commands sent from earth to instructions that are understood by the rover.

# Requirements
You are given the initial starting point (x,y) of a rover and the direction (N,S,E,W) it is facing.
The rover receives a character array of commands.
Implement commands that move the rover forward/backward (f,b).
Implement commands that turn the rover left/right (l,r).
Implement wrapping at edges. But be careful, planets are spheres.
Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle.

# Rules
Hardcore TDD. No Excuses!
Change roles (driver, navigator) after each TDD cycle.
No red phases while refactoring.
Be careful about edge cases and exceptions. We can not afford to lose a mars rover, just because the developers overlooked a null pointer.

Testea para probar el comportamiento, no para probar la implementación


# Casos pendientes

# Casos completados
- Validar que un Rover se crea por defecto en el centro del plano en dirección norte
- Validar que un Rover se puede crear con posición y dirección
- Validar que dirección sólo admite los siguientes valores: N,S,E,W
- Validar que un Rover se puede mover hacia adelante en dirección N
- Validar que un Rover se puede mover hacia adelante en dirección S
- Validar que un Rover se puede mover hacia adelante en dirección E
- Validar que un Rover se puede mover hacia adelante en dirección W
- Validar que un Rover se puede mover hacia atrás estando en dirección N
- Validar que un Rover se puede mover hacia atrás estando en dirección S
- Validar que un Rover se puede mover hacia atrás estando en dirección E
- Validar que un Rover se puede mover hacia atrás estando en dirección W
- Validar que un Rover se puede mover hacia la derecha estando en dirección N
- Validar que un Rover se puede mover hacia la derecha estando en dirección S
- Validar que un Rover se puede mover hacia la derecha estando en dirección E
- Validar que un Rover se puede mover hacia la derecha estando en dirección W
- Validar que un Rover se puede mover hacia la izquierda estando en dirección N
- Validar que un Rover se puede mover hacia la izquierda estando en dirección S
- Validar que un Rover se puede mover hacia la izquierda estando en dirección E
- Validar que un Rover se puede mover hacia la izquierda estando en dirección W
- Imprimir un mapa de ubicación y dirección del Rover
- Un Rover debe poder reaccionar a una serie de comandos (f,b,l,r)
- Un Rover debe lanzar una excepción si recibe un comando desconocido
- Un Rover debe abortar una serie de comandos al reconocer un obstáculo
- El mapa debe incluir dos caras para representar el recorrido del Rover en ambas caras de un planeta
- Un punto nunca puede contener coordenadas negativas
- Si el Rover yendo hacia adelante llega al polo norte debe reaparecer en la cara opuesta del planeta
- Si el Rover yendo hacia adelante llega a la cara opuesta por el polo norte, el Rover debe cambiar su dirección hacia el sur
- Si el Rover yendo hacia adelante llega al polo norte de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el polo sur
- Si el Rover yendo hacia adelante llega al polo sur debe reaparecer en la cara opuesta del planeta
- Si el Rover yendo hacia adelante llega a la cara opuesta por el polo sur, debe cambiar su dirección hacia el norte
- Si el Rover yendo hacia adelante llega al polo sur de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el polo norte
- Si el Rover yendo hacia adelante llega al extremo este debe reaparecer en la cara opuesta del planeta por el oeste
- Si el Rover yendo hacia adelante llega al extremo este de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el extremo oeste de la cara frontal
- Si el Rover yendo hacia adelante llega al extremo oeste debe reaparecer en la cara opuesta del planeta por el este
- Si el Rover yendo hacia adelante llega al extremo oeste de la cara opuesta del planeta y se sigue moviendo hacia adelante debe poder alcanzar el extremo este de la cara frontal
- Si el Rover yendo hacia atrás llega a la cara opuesta por el polo norte, el Rover debe aparecer en la otra cara del planeta y cambiar su dirección hacia el Norte
- Si el Rover yendo hacia atrás llega al polo norte de la cara opuesta del planeta y se sigue moviendo hacia atrás debe poder alcanzar el polo sur
- Si el Rover yendo hacia atrás llega al polo sur debe reaparecer en la cara opuesta del planeta y cambiar su dirección hacia el sur
- Si el Rover yendo hacia atrás llega al polo sur de la cara opuesta del planeta y se sigue moviendo hacia atrás debe poder alcanzar el polo norte
- Si el Rover yendo hacia atrás llega al extremo Este, debe reaparecer en la cara opuesta del planeta por el oeste
- Si el Rover yendo hacia atrás llega al extremo Este de la cara opuesta del planeta y se sigue moviendo hacia atrás debe poder alcanzar el extremo oeste de la cara frontal
- Si el Rover yendo hacia atrás llega al extremo Oeste debe reaparecer en la cara opuesta del planeta por el este
- Si el Rover yendo hacia atrás llega al extremo Oeste de la cara opuesta del planeta y se sigue moviendo hacia atrás debe poder alcanzar el extremo este de la cara frontal
- El Rover debe ser capaz de seguir un camino complejo

# Notas
- Tiene sentido hasta cierto punto mantener la navegación tipo grilla porque aunque en un globo terráqueo los segmentos de posición en los polos no tienen 4 aristas sino 3 estos no es más que casos de un cuadrado especial en el que una de sus aristas tiende a tener una longitud cercana a cero, es cuestión de percepción (como la percepción del espacio/tiempo en la teoría de la relatividad)
- Los movimientos dentro de este esquema tendrían sentido si al llegar a un polo automáticamente se cambia la dirección, por ende los siguientes movimientos sucederían en la otra cara del planeta
- La grilla tendrá dos caras para simular los movimientos del Rover en el lado opuesto del planeta
- En el lado opuesto del planeta los movimientos son opuestos y se mantendrán así hasta alcanzar nuevamente un borde de la grilla

# Dudas
- Cambio de dirección al llegar al polo norte?
- Cambio de dirección en sentido este/oeste? existen dichos puntos extremos?
- Cómo plantear la existencia de dichos movimientos en la otra cara del planeta?
