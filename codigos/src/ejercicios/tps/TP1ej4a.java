package ejercicios.tps;

import tda.colas.ColaPU;
import tda.colas.ColaTDA;

public class TP1ej4a {
	
	public static void PasarCola(ColaTDA origen, ColaTDA destino) {
		while(!origen.ColaVacia()) {
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
	}

	public static void main(String[] args) {
		ColaTDA origen = new ColaPU();
		ColaTDA destino = new ColaPU();
		origen.InicializarCola();
		destino.InicializarCola();
		origen.Acolar(3);
		origen.Acolar(7);
		origen.Acolar(2);
		PasarCola(origen,destino);
		System.out.print(destino.Primero());

	}

}
