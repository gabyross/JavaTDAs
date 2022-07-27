// Calcular el promedio de los elementos de una Pila
package ejercicios.tps;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej2f {
	
	public static float CalcularPromedio(PilaTDA origen) {
		float suma=0;
		float resultado;
		float cantidad=0;
		while(!origen.PilaVacia()) {
			suma+=origen.Tope();
			origen.Desapilar();
			cantidad++;
		}
		resultado=suma/cantidad;
		return resultado;
	}
	

	public static void main(String[] args) {
		PilaTDA origen=new PilaTF();
		origen.InicializarPila();
		origen.Apilar(34);
		origen.Apilar(4);
		origen.Apilar(0);
		System.out.print(CalcularPromedio(origen));

	}

}
