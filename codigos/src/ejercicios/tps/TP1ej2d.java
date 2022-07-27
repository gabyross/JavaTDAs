/*
 * public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
}
 */

// Contar los elementos de una pila

package ejercicios.tps;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej2d {
	
	public static int ContarElementos(PilaTDA origen) {
		int i=0;
		while(!origen.PilaVacia()) {
			i++;
			origen.Desapilar();
		}
		return i;
		
	}

	public static void main(String[] args) {
		PilaTDA origen=new PilaTF();
		origen.InicializarPila();
		origen.Apilar(1);
		origen.Apilar(0);
		origen.Apilar(4);
		origen.Apilar(7);
		origen.Apilar(8);
		System.out.print(ContarElementos(origen));
		

	}

}
