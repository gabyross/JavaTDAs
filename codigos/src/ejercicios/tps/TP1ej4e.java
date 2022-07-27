
//Determinar si una Cola es capicúa o no
package ejercicios.tps;

import tda.colas.ColaPU;
import tda.colas.ColaTDA;
import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej4e {
	
	public static boolean Capicua(ColaTDA origen) {
		PilaTDA aux = new PilaTF();
		ColaTDA aux2 = new ColaPU();
		aux.InicializarPila();
		aux2.InicializarCola();
		boolean capicua = false;
		while (!origen.ColaVacia()) {
			aux.Apilar(origen.Primero());
			aux2.Acolar(origen.Primero());
			origen.Desacolar();
		}
		while (!aux2.ColaVacia()) {
			if (aux.Tope()==aux2.Primero()) {
				capicua=true;
			}
			else {
				capicua=false;
			}
			aux.Desapilar();
			aux2.Desacolar();
		}
		while(!aux2.ColaVacia()) {
			origen.Acolar(aux2.Primero());
			aux2.Desacolar();
		}
		
		return capicua;
		
	}
	

	public static void main(String[] args) {
		ColaTDA origen = new ColaPU();
		origen.InicializarCola();
		origen.Acolar(3);
		origen.Acolar(2);
		origen.Acolar(0);
		origen.Acolar(2);
		origen.Acolar(3);
		if(Capicua(origen)) {
			System.out.print("Es capicúa!");
		} else {
			System.out.print("NO es capicúa!");
		}
		

	}

}
