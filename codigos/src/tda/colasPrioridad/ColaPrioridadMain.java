package tda.colasPrioridad;

import tda.colas.ColaTDA;

public class ColaPrioridadMain {
	
	// Mostrar la cola por pantalla
	public static void MostrarColaP(ColaPrioridadTDA cp) {
		while (!cp.ColaVacia()) {
			System.out.println("Num: " + cp.Primero());
			System.out.println("Pri: " + cp.Prioridad());
			cp.Desacolar();
		}
	}
	
	
	
	// pasar los valores de una cola con prioridad origen a una cola normal valores 
	// y de las prioridades correspondientes a una cola normal prioridades
	public static void PasarAColas(ColaPrioridadTDA origen, ColaTDA valores, ColaTDA prioridades) {
		while (!origen.ColaVacia()) {
			valores.Acolar(origen.Primero());
			prioridades.Acolar(origen.Prioridad());
			origen.Desacolar();
		}

	}
	
	public static void PasarColaP(ColaPrioridadTDA origen, ColaPrioridadTDA destino) {
		while (!origen.ColaVacia()) {
			destino.AcolarPrioridad(origen.Primero(), origen.Prioridad());
			origen.Desacolar();
		}

	}
	
	
	
	public static void CopiarColaPrioridad(ColaPrioridadTDA origen, ColaPrioridadTDA copia) {
		ColaPrioridadTDA aux = new ColaPrioridadAO();
		aux.InicializarCola();
		
		PasarColaP(origen, aux);
		while (!aux.ColaVacia()) {
			origen.AcolarPrioridad(aux.Primero(), aux.Prioridad());
			copia.AcolarPrioridad(aux.Primero(), aux.Prioridad());
			aux.Desacolar();
		}
	}
	
	
	
	/*
	 * Combinar dos colas con prioridades CP1 y CP2, generando una nueva
	 * cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1
	 * son más prioritarios que los de la CP2.
	 */
	public static ColaPrioridadTDA CombinarDosColas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
		ColaPrioridadTDA destino = new ColaPrioridadAO();
		destino.InicializarCola();
		
		while (!cp1.ColaVacia()) {
			destino.AcolarPrioridad(cp1.Primero(), cp1.Prioridad());
			cp1.Desacolar();
		}
		
		while (!cp2.ColaVacia()) {
			destino.AcolarPrioridad(cp2.Primero(), cp2.Prioridad());
			cp2.Desacolar();
		}
		
		return destino;
	}
	
	
	
	// Determinar si dos Colas con prioridad son idénticas.
	public static boolean ColasIdenticas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
		
		boolean sonIdenticas = true;
		
		while (!cp1.ColaVacia() && !cp2.ColaVacia() && sonIdenticas) {
			if (cp1.Primero() != cp2.Primero())
			{
				sonIdenticas = false;
			}
			cp1.Desacolar();
			cp2.Desacolar();
		}
		
		return sonIdenticas;
	}
	
	
	
	public static void main(String[] args) {
		ColaPrioridadTDA cp1 = new ColaPrioridadAO();
		cp1.InicializarCola();
		
		cp1.AcolarPrioridad(1, 2);
		cp1.AcolarPrioridad(3, 4);

		
		ColaPrioridadTDA cp2 = new ColaPrioridadAO();
		cp2.InicializarCola();
		
		cp2.AcolarPrioridad(1, 2);
		cp2.AcolarPrioridad(4, 4);
		
		ColaPrioridadTDA cp3 = new ColaPrioridadAO();
		cp3.InicializarCola();
		
		//cp3 = CombinarDosColas(cp1, cp2);
		
		//boolean iguales = ColasIdenticas(cp1, cp2);
		//System.out.println(iguales);
		MostrarColaP(cp2);
		
	}

}
