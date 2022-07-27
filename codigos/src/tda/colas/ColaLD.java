package tda.colas;

public class ColaLD implements ColaTDA{
	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	Nodo ultimo;
	
	public void InicializarCola() {
		primero=null;
		ultimo=null;
	}
	
	public void Acolar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig  = null;
		if (ultimo != null) {
			ultimo.sig=nuevo;
		}
		ultimo = nuevo;
		if (primero==null) {
			primero=ultimo;
		}
	}
	
	public void Desacolar() {
		primero = primero.sig;
		if (primero == null) {
			ultimo = null;
		}
	}
	public boolean ColaVacia() {
		return (ultimo==null);
	}
	
	public int Primero() {
		return primero.info;
	}

	
	// APARTE DEL TDA ORIGINAL
	public String Mostrarcola() {	// Metodo extra para ver los elementos de la cola
		 String cola = ""; // string que contiene la cola
		 Nodo aux = primero;

		 while (aux != null) {
			 cola = cola + (aux.info + ","); // concatena los elementos de la cola
			 aux = aux.sig;
		 }
		 cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra como un array
		 return cola; // Se muestra de derecha a izquierda [primero, medio, ultimo]
	 }


	 public void Multidesacolar(int x) { // Metodo extra para desacolar x elementos

		while (!ColaVacia() && x > 0) {	// si la cola no esta vacia
			Desacolar();
			x--;
		}
	 }
}
