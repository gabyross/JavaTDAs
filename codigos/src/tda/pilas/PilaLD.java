package tda.pilas;

public class PilaLD implements PilaTDA {
	class Nodo{
		int info;
		Nodo sig;
	}
	
	Nodo primero;
	
	public void InicializarPila() {
		primero=null;
	}
	
	public void Apilar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = primero;
		primero = nuevo;
	}
	
	public void Desapilar() {
		primero = primero.sig;
	}
	
	public boolean PilaVacia() {
		return (primero==null);
	}
	
	public int Tope() {
		return primero.info;
	}

	
	// APARTE DEL TDA ORIGINAL
	 public String Mostrarpila() {	// Metodo extra para ver los elementos de la pila
			String pila = ""; // string que contiene la pila
			Nodo aux = primero;

			while (aux != null) {
				pila = pila + (aux.info + ","); // concatena los elementos de la pila
				aux = aux.sig;
			}
			pila = "[" + (pila.substring(0, pila.length() - 1)) + "]"; // quita la coma del final de la pila y lo muestra
																		// como un array
			return pila; // Se muestra de izquierda a derecha [ultimo, medio, primero]

		}
}
