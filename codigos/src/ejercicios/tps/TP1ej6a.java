package ejercicios.tps;
/*
 * Combinar dos colas con prioridades CP1 y CP2, generando una nueva 
cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1 
son más prioritarios que los de la CP2.

NOTA: Ante igual prioridad, se adelanta al último que llegó.
 */

import tda.colasPrioridad.ColaPrioridadDA;
import tda.colasPrioridad.ColaPrioridadTDA;

public class TP1ej6a {
	
	public static void CombinarColas(ColaPrioridadTDA origen1,ColaPrioridadTDA origen2, ColaPrioridadTDA destino) {
		while(!origen2.ColaVacia()) {
			destino.AcolarPrioridad(origen2.Primero(), origen2.Prioridad());
			origen2.Desacolar();
		}
		while(!origen1.ColaVacia()) {
			destino.AcolarPrioridad(origen1.Primero(), origen1.Prioridad());
			origen1.Desacolar();
	}
	}

	public static void main(String[] args) {
		ColaPrioridadTDA origen1 = new ColaPrioridadDA();
		ColaPrioridadTDA origen2 = new ColaPrioridadDA();
		ColaPrioridadTDA destino = new ColaPrioridadDA();
		origen1.InicializarCola();
		origen2.InicializarCola();
		destino.InicializarCola();
		origen2.AcolarPrioridad(2123213, 5);
		origen1.AcolarPrioridad(7, 5);
		CombinarColas(origen1,origen2,destino);
		System.out.print(destino.Primero());
	}

}
