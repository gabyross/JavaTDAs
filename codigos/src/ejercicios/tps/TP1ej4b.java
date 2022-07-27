package ejercicios.tps;

import tda.colas.ColaPU;
import tda.colas.ColaTDA;
import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej4b {
	
	public static void InvertirColaConAUX(ColaTDA origen) {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		while(!origen.ColaVacia()) {
			aux.Apilar(origen.Primero());
			origen.Desacolar();
		}
		while(!aux.PilaVacia()) {
			origen.Acolar(aux.Tope());
			aux.Desapilar();
		}
		
		
		
	}

	public static void main(String[] args) {
		ColaTDA origen = new ColaPU();
		origen.InicializarCola();
		origen.Acolar(3);
		origen.Acolar(7);
		origen.Acolar(2);
		InvertirColaConAUX(origen);
		System.out.print(origen.Primero());
		

	}

}
