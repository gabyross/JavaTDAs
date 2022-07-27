/*
 * public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
}
 */

// Copiar una Pila en otra (dejándola en el mismo orden que la original)

package ejercicios.tps;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej2b {
	public static void CopiarPila(PilaTDA origen, PilaTDA destino){
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		while(!origen.PilaVacia()) {
			aux.Apilar(origen.Tope());
			origen.Desapilar();
		}
		while(!aux.PilaVacia()) {
			destino.Apilar(aux.Tope());
			aux.Desapilar();
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
		CopiarPila(origen,destino);
		System.out.print(destino.Tope());
	}

}
