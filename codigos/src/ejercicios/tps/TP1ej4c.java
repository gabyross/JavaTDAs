package ejercicios.tps;

import tda.colas.ColaPU;
import tda.colas.ColaTDA;

public class TP1ej4c {
	
	public static void InvertirColaSinAux(ColaTDA origen){
		ColaTDA aux=new ColaPU();
		ColaTDA destino = new ColaPU();
		aux.InicializarCola();
		destino.InicializarCola();
		int cantidad=0;
		while(!origen.ColaVacia()) {
			aux.Acolar(origen.Primero());
			origen.Desacolar();
			cantidad++;
		}
		for (int i=0;i<(cantidad/2);i++){
			for (int j=cantidad-(i*2);j>1;j--) {
			origen.Acolar(aux.Primero());
			aux.Desacolar();
				}
			destino.Acolar(aux.Primero());
			aux.Desacolar();
			for (int j=cantidad-(i*2)-1;j>1;j--) {
				aux.Acolar(origen.Primero());
				origen.Desacolar();
				}
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
		
		while(!destino.ColaVacia()) {
			origen.Acolar(destino.Primero());
			destino.Desacolar();
		}
	}

	public static void main(String[] args) {
		ColaTDA origen = new ColaPU();
		origen.InicializarCola();
		origen.Acolar(1);
		origen.Acolar(2);
		origen.Acolar(3);
		origen.Acolar(4);
		origen.Acolar(5);
		InvertirColaSinAux(origen);
		System.out.print(origen.Primero());

	}

}
