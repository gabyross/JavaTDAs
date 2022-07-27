package tda.colasPrioridad;

// ----- IMPORTACIONES -----
import tda.colas.ColaTDA;
import tda.diccionariosMultiples.DiccionarioMultipleA;
import tda.diccionariosMultiples.DiccionarioMultipleTDA;




// ----- APP ------
public class ColaPrioridadMain {
	
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

	
	
	
	
	// ----- FUNCIONES ------
	
		// Mostrar la cola por pantalla
		public static void MostrarColaP(ColaPrioridadTDA cp) {
			while (!cp.ColaVacia()) {
				System.out.println("Num: " + cp.Primero());
				System.out.println("Pri: " + cp.Prioridad());
				cp.Desacolar();
			}
		}
		
		
		
		// funcion para imprimir la cola con prioridad usando ColaTDA (sin perder la cola original)
	    public static String mostrarCola(ColaPrioridadTDA cola) {
	        String resultado = "[ ";
	        ColaPrioridadTDA aux = new ColaPrioridadLD();   // crear una cola auxiliar
	        aux.InicializarCola();

	        while (!cola.ColaVacia()) { // mientras no este vacia la cola, acolar a la cola auxiliar
	            resultado += cola.Primero() + " ";  // imprimir el elemento de la cola
	            aux.AcolarPrioridad(cola.Primero(),cola.Prioridad());
	            cola.Desacolar();
	        }
	        resultado += "]";   // cerrar el string

	        while (!aux.ColaVacia()) { // mientras no este vacia la cola, acolar a la cola original
	            cola.AcolarPrioridad(aux.Primero(),aux.Prioridad());
	            aux.Desacolar();
	        }
	        return resultado;
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
		
		
		
		// Metodo para pasar una cola prioridad a otra cola prioridad
		public static void PasarColaP(ColaPrioridadTDA origen, ColaPrioridadTDA destino) {
			while (!origen.ColaVacia()) {
				destino.AcolarPrioridad(origen.Primero(), origen.Prioridad());
				origen.Desacolar();
			}

		}
		
		
		
		// Metodo para copiar una cola prioridad sin dejarla vacia
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
			
			//NOTA: Ante igual prioridad, se adelanta al primero que llego (Por eso la cola 2 esta abajo)
			
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
			
			if (cp1.ColaVacia() && !cp2.ColaVacia()) {
				sonIdenticas = false;
			}
			else if (!cp1.ColaVacia() && cp2.ColaVacia()) {
				sonIdenticas = false;
			}
			return sonIdenticas;
		}
		
		
		
		// funcion para generar un Diccionario Múltiple que permita, para cada valor presente en la ColaPrioridad C recuperar todas las ---------------
		// prioridades que tiene asociadas en C
		public static DiccionarioMultipleTDA generarDiccionarioColaPrioridad(ColaPrioridadTDA cola) {
			DiccionarioMultipleTDA dic = new DiccionarioMultipleA();
			dic.InicializarDiccionario();

			while (!cola.ColaVacia()) {	// acolar la cola en el diccionario multiple
				dic.Agregar(cola.Primero(), cola.Prioridad());	// agregar el elemento y la prioridad (si el elemento ya existe, se agrega la prioridad)
				cola.Desacolar();
			}
			return dic;
		}	
		
}
