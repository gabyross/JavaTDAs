/*
 * public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
}
 */

// invertir el contenido de una Pila

package ejercicios.tps;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej2c {
	public static void InvertirPila(PilaTDA origen) {
		PilaTDA aux = new PilaTF();
		PilaTDA aux2 = new PilaTF();
		aux.InicializarPila();
		aux2.InicializarPila();
		while(!origen.PilaVacia()) {
			aux.Apilar(origen.Tope());
			origen.Desapilar();
		}
		while(!aux.PilaVacia()) {
			aux2.Apilar(aux.Tope());
			aux.Desapilar();
		}
		while(!aux2.PilaVacia()) {
			origen.Apilar(aux2.Tope());
			aux2.Desapilar();
		}
		
		
		
	}

	public static void main(String[] args) {
		PilaTDA origen = new PilaTF();
		origen.InicializarPila();
		origen.Apilar(1);
		origen.Apilar(2);
		origen.Apilar(3);
		InvertirPila(origen);
		System.out.print(origen.Tope());
		

	}

}
