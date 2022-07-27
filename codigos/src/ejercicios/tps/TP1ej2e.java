/*
 * public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
}
 */

// Sumar los elementos de una Pila

package ejercicios.tps;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej2e {
	
	public static int SumarElementos(PilaTDA origen) {
		int n=0;
		while(!origen.PilaVacia()) {
			n+=origen.Tope();
			origen.Desapilar();
		}
		return n;
	}

	public static void main(String[] args) {
		PilaTDA origen = new PilaTF();
		origen.InicializarPila();
		origen.Apilar(3);
		origen.Apilar(5);
		origen.Apilar(3463);
		System.out.print(SumarElementos(origen));

	}

}
