package tda.pilaLimitada;

import tda.pilas.*;

public class PilaLimTF implements LimPilaTDA {
	int[] arr;
	int inx;
	int capacidad; // en este caso la capacidad maxima de la pila es la que ingresen por teclado
	
	public void InicializarPila(int x) {
		capacidad = x;
		arr = new int[capacidad];
		inx = 0;
	}
	
	public void Apilar(int x) {
		if (inx != capacidad) {
			arr[inx] = x;
			inx++;
		} 
		
		else {
			//NuevaPilaLlena(x);
			PilaTDA pilaAux = new PilaTF();
			pilaAux.InicializarPila();
			
			while (!this.PilaVacia()) {
				pilaAux.Apilar(this.Tope());	
				this.Desapilar();
			}
			
			pilaAux.Desapilar();
			
			while (!pilaAux.PilaVacia()) {
				this.Apilar(pilaAux.Tope());	
				pilaAux.Desapilar();
			}
			
			this.Apilar(x);
		}
	}
	
	
	/*private void NuevaPilaLlena(int x) {
		int i = 0;
		int[] aux = new int[capacidad -1];
		while (i > (capacidad -1)) {
			aux[i] = this.Tope();
			this.Desapilar();
			i++;
		}
		
		this.Desapilar();
		
		while (inx < (capacidad - 1)) {
			this.Apilar(aux[i]);
			aux[i] = this.Tope();
			i--;
		}
		
		this.Apilar(x);
	}*/
	
	
	public void Desapilar() {
		inx--;
	}
	
	public boolean PilaVacia() {
		return (inx == 0);
	}
	
	public int Tope() {
		return (arr[inx - 1]);
	}

	public boolean PilaLlena() {
		return (inx == capacidad);
	}

	public int Capacidad() {
		return capacidad; // o retornar capacidad menos index
	}
	
	
	// APARTE DEL TDA ORIGINAL
	public String Mostrarpila() {    // Metodo extra para ver los elementos de la pila 
		
		String pila = ""; // string que contiene la pila
        for (int i = 0; i < inx; i++) {
            pila = pila + (arr[i] + ","); // concatena los elementos de la pila
        }
        pila = "[" + (pila.substring(0, pila.length() - 1)) + "]"; // quita la coma del final de la pila y lo muestra
                                                                    // como un array
        return pila; // Se muestra de derecha a izquierda [primero, medio, ultimo]
		
	}
}
