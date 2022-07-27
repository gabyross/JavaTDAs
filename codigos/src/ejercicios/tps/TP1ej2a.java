/*
 * public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
}
 */

// Pasar una Pila a otra (dejándola en orden inverso)

package ejercicios.tps;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej2a {
	
	
	public static void PasarPila(PilaTDA origen, PilaTDA destino) {
		while(!origen.PilaVacia()){
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
		
	}

	public static void main(String[] args) {
		PilaTDA origen = new PilaTF();
		PilaTDA destino = new PilaTF();
		origen.InicializarPila();
		destino.InicializarPila();
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		PasarPila(origen, destino);
	}

}
