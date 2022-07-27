/*
 * En este ejercicio, usted va a definir un nuevo tipo de datos
abstracto. En este caso, hablamos de una pila de capacidad limitada, que
vamos a llamar LimPilaTDA. La idea es la siguiente: mientras no se llegue
a la capacidad de la pila, la pila se comportar� como cualquier PilaTDA.
Pero cuando se llegue a su capacidad, la inclusi�n de un nuevo elemento
har� que el elemento m�s antiguo (que yac�a en en fondo de la pila) sea
eliminado para hacer lugar para el nuevo elemento.
Ejemplo. Supongamos que tenemos una pila de capacidad limitada de longitud
4. Si apilamos 1, 2 y 3, la pila se comportar� como cualquier otra pila. Si apilamos
despu�s 4, seguiremos sin notar diferencias. La pila contendr� los valores [4, 3,
2, 1]. Pero si ahora apilamos 5, el comportamiento esperado es que el elemento
m�s antiguo (el 1) salga para hacer lugar para el nuevo elemento. Entonces la pila
quedar� con [5, 4, 3, 2].
 */

package tda.pilaLimitada;

public interface LimPilaTDA {
	void InicializarPila(int x);
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	boolean PilaLlena(); // nos devuelve true si la pila lleg� al l�mite de su capacidad y false en caso contrario.
	int Tope();
	int Capacidad(); // nos devuelve la capacidad de la pila.
}
