package ejercicios.tps;

import tda.colasPrioridad.ColaPrioridadDA;
import tda.colasPrioridad.ColaPrioridadTDA;

//Determinar si dos Colas con prioridad son idénticas.

public class TP1ej6b {
	
	public static boolean SonIdenticas(ColaPrioridadTDA origen1,ColaPrioridadTDA origen2) {
		ColaPrioridadTDA aux = new ColaPrioridadDA();
		ColaPrioridadTDA aux2 = new ColaPrioridadDA();
		aux.InicializarCola();
		aux2.InicializarCola();
		boolean identicas=true;
		int cant1=0;
		int cant2=0;
		while(!origen1.ColaVacia()) {
			aux.AcolarPrioridad(origen1.Primero(), origen1.Prioridad());
			origen1.Desacolar();
			cant1++;
		}
		while(!origen2.ColaVacia()) {
			aux2.AcolarPrioridad(origen2.Primero(), origen2.Prioridad());
			origen2.Desacolar();
			cant2++;
		}
		
		if (cant1==cant2) {
		while(!aux.ColaVacia() && !aux2.ColaVacia()) {
			if (aux.Primero()!=aux2.Primero() || aux.Prioridad()!=aux2.Prioridad()) {
				identicas=false;
			}
			origen1.AcolarPrioridad(aux.Primero(), aux.Prioridad());
			origen2.AcolarPrioridad(aux2.Primero(), aux2.Prioridad());
			aux.Desacolar();
			aux2.Desacolar();
		}
		} else {
			identicas=false;
			while(!aux.ColaVacia()) {
				origen1.AcolarPrioridad(aux.Primero(), aux.Prioridad());
				aux.Desacolar();
			}
			while(!aux.ColaVacia()) {
				origen2.AcolarPrioridad(aux2.Primero(), aux2.Prioridad());
				aux2.Desacolar();
			}
			
		}
		return identicas;
	}

	public static void main(String[] args) {
		ColaPrioridadTDA origen1 = new ColaPrioridadDA();
		ColaPrioridadTDA origen2 = new ColaPrioridadDA();
		origen1.InicializarCola();
		origen2.InicializarCola();
		origen1.AcolarPrioridad(1, 3);
		origen1.AcolarPrioridad(1, 1);
		origen2.AcolarPrioridad(1, 1);
		origen2.AcolarPrioridad(1, 3);
		if (SonIdenticas(origen1,origen2)) {
			System.out.print("Son idénticas!");
		}else {
			System.out.print("NO son idénticas!");
		}
	}

}
