package tda.colas;

import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;
import tda.conjuntos.*;

public class ColaMain{
	
	// funcion para generar un método que tome como entrada una cola y devuelva la maxima secuencia ascendente - Ejercicio 4 Simulacro 2 Final ---------------
	public static int MaxSec(ColaTDA cola) {

		int max = 1;	// máximo

		// si la cola es 1,3,2,7 la max secuencia ascendente es 2
		// si la cola es 1,3,2,7,4,5,6,8 la max secuencia ascendente es 4
		// si la cola es 1,3,2,7,4,5,6,8,9 la max secuencia ascendente es 5
		// si la cola es 1,3,2,7,4,5,6,8,9,10 la max secuencia ascendente es 6

		int anterior = cola.Primero();
		cola.Desacolar();

		while (!cola.ColaVacia()) {	// agregar los elementos de la cola en las variables correspondientes
			int nuevo = cola.Primero();

			if (nuevo > anterior) {	// si el nuevo elemento es mayor al anterior, sumar 1 al máximo
				max++;
			} else {	// si el nuevo elemento es menor al anterior, reiniciar el máximo
				max = 1;
			}

			anterior = nuevo;
			cola.Desacolar();
		}

		return max;
	}
			
	// Pasar una Pila a otra (dejándola en orden inverso)
	public static void PasarPilaAlRevez(PilaTDA origen, PilaTDA destino) {
		while (!origen.PilaVacia())
		{
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
	}
		
		
		
	// Mostrar Cola dejandola vacia
	public static void MostrarColaDejandolaVacia(ColaTDA origen) {
		while (!origen.ColaVacia())
		{
			System.out.print(origen.Primero() + " ");
			origen.Desacolar();
		}
	}
		
		
		
	// Pasar cola dejando vacia la original
	public static void PasarCola(ColaTDA origen, ColaTDA destino) {
		while (!origen.ColaVacia())
		{
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
	}
	
	// Pasar cola dejando vacia la original
	public static void PasarColaAConjunto(ColaTDA origen, ConjuntoTDA destino) {
		while (!origen.ColaVacia())
		{
			destino.Agregar(origen.Primero());
			origen.Desacolar();
		}
	}
	
	// Pasar cola sin dejar vacia la original
	public static void CopiarColaAConjunto(ColaTDA origen, ConjuntoTDA destino) {
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		
		while (!origen.ColaVacia())
		{
			aux.Acolar(origen.Primero());
			origen.Desacolar();
		}
		
		while (!aux.ColaVacia())
		{
			origen.Acolar(aux.Primero());
			destino.Agregar(aux.Primero());
			aux.Desacolar();
		}
	}
		
	// Pasar cola sin dejar vacia la original
	public static void CopiarCola(ColaTDA origen, ColaTDA destino) {
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		
		while (!origen.ColaVacia())
		{
			aux.Acolar(origen.Primero());
			origen.Desacolar();
		}
		
		while (!aux.ColaVacia())
		{
			origen.Acolar(aux.Primero());
			destino.Acolar(aux.Primero());
			aux.Desacolar();
		}
	}
	
	
	// Obtner el largo de una cola
	public static int ObtenerLargoCola(ColaTDA origen) {
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		
		PasarCola(origen, aux);
		
		int largo = 0;
		
		while (!aux.ColaVacia())
		{
			largo++;
			origen.Acolar(aux.Primero());
			aux.Desacolar();
		}
		
		return largo;
	}
	
	
	
	// Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
		public static void InvertirCola (ColaTDA origen) {
			PilaTDA pAux = new PilaTF();
			pAux.InicializarPila();

			PilaTDA pAux2 = new PilaTF();
			pAux2.InicializarPila();
			
			int n = ObtenerLargoCola(origen);
			
			for (int i = 0; i < n; i++)
			{
				pAux.Apilar(origen.Primero());
				origen.Desacolar();
			}
			
			for (int i = 0; i < n; i++)
			{
				int num = pAux.Tope();
				origen.Acolar(num);
				pAux.Desapilar();
			}
		}
		
		// Invertir el contenido de una Cola (sin poder usarse Pilas auxiliares)
		public static void InvertirColaSinPila(ColaTDA origen) {
			ColaTDA aux = new ColaPU();
			aux.InicializarCola();
			
			ColaTDA aux2 = new ColaPU();
			aux2.InicializarCola();
			
			int n = ObtenerLargoCola(origen);
			//int lastNum = 0;

			int i = 0;
			int j = 0;
			
			while (i != n) {
				n = ObtenerLargoCola(origen);
				
				while (!aux2.ColaVacia())
				{
					
					if (j == n - 1)
					{
						aux.Acolar(origen.Primero());
					}
					else 
					{
						aux2.Acolar(origen.Primero());
						origen.Desacolar();
					}
				}
				PasarCola(aux2, origen);
				i++;
			}
			PasarCola(aux, origen);
		}
		
		//Determinar si el final de la Cola C1 coincide o no con la Cola C2. Sin dejarlas vacia
		public static boolean CoincideFinal(ColaTDA c1, ColaTDA c2) {
			boolean coincide = false;
			
			ColaTDA aux = new ColaPU();
			aux.InicializarCola();
			
			ColaTDA aux2 = new ColaPU();
			aux2.InicializarCola();
			
			CopiarCola(c1, aux);
			CopiarCola(c2, aux2);
			
			int n1 = ObtenerLargoCola(c1);
			int n2 = ObtenerLargoCola(c2);

			int i = 0;
			int j = 0;
			
			int lastNum1 = 1;
			int lastNum2 = -1;
			
			// consigo el ultimo numero de la primera cola
			while (i < n1) {

				if (i == ObtenerLargoCola(c1) - 1)
				{
					lastNum1 = aux.Primero();
				}
				else 
				{
					aux.Desacolar();
				}
				i++;
			}
			
			// consigo el ultimo numero de la segunda cola
			while (j < n2) {
				
				if (j == ObtenerLargoCola(c2) - 1)
				{
					lastNum2 = aux2.Primero();
				}
				else 
				{
					aux2.Desacolar();
				}
				j++;
			}
			
			if (lastNum1 == lastNum2)
			{
				coincide = true;
			}
			
			return coincide;
		}

		
		/*
		 * Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
		 * inversas, si tienen los mismos elementos pero en orden inverso
		 */
	
		//Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
		//que el primer elemento es igual al último, el segundo igual al penúltimo, etc
		public static boolean ColaCapicua(ColaTDA origen) {
			ColaTDA cInvertida = new ColaPU();
			cInvertida.InicializarCola();
			
			CopiarCola(origen, cInvertida);
			InvertirCola(cInvertida);
			
			boolean esCapicua = true;
			
			while (esCapicua && !origen.ColaVacia()) {
				if (origen.Primero() == cInvertida.Primero())
				{
					origen.Desacolar();
					cInvertida.Desacolar();}
				else 
				{
					esCapicua = false;
				}
			}
			
			return esCapicua;
		}
		
		
		//Escribir un método que devuelva la intercalación de dos colas (cola1 con cola2) de números enteros, 
		//respetando el orden original de cada una pero eliminando los valores repetidos. 
		//El método deberá generar una nueva cola y no se permite dejar las colas originales distintas a como se recibieron. 
		public static ColaTDA IntercalarColas(ColaTDA cola1, ColaTDA cola2) {
			ColaTDA c1 = new ColaPU();
			c1.InicializarCola();
			CopiarCola(cola1, c1);
			
			ColaTDA c2 = new ColaPU();
			c2.InicializarCola();
			CopiarCola(cola2, c2);
			
			ConjuntoTDA conj = new ConjuntoA();
			conj.InicializarConjunto();
			
			ColaTDA c = new ColaPU();
			c.InicializarCola();
			
			// me aseguro de intercalarlas hasta que una de las dos colas este vacia
			while (!c1.ColaVacia() && !c2.ColaVacia()) {
				boolean c1fueAgregado = false;
				
				while (!c1fueAgregado && !c1.ColaVacia()) {
					int x = c1.Primero();
					while (!conj.Pertenece(x)) {
						conj.Agregar(x);
						c.Acolar(x);
						c1fueAgregado = true;
					}
					c1.Desacolar();
				}
				
				boolean c2fueAgregado = false;
				while (!c2fueAgregado && !c2.ColaVacia()) {
					int y = c2.Primero();
					while (!conj.Pertenece(y)) {
						conj.Agregar(y);
						c.Acolar(y);
						c2fueAgregado = true;
					}
					c2.Desacolar();
				}
			}
			
			
			// si una cola se vacio pero la otra no, me aseguro de vaciarlas en orden
			while (!c1.ColaVacia()) {
				int x = c1.Primero();
				if (!conj.Pertenece(x)) {
					conj.Agregar(x);
					c.Acolar(x);
				}
				c1.Desacolar();
			}
			
			while (!c2.ColaVacia()) {
				int y = c2.Primero();
				if (!conj.Pertenece(y)) {
					conj.Agregar(y);
					c.Acolar(y);
				}
				c2.Desacolar();
			}
			
			return c;
		}
		
		
		// Escribir un método que devuelva la concatenación de dos colas (cola1 con cola2) de números enteros, 
		//respetando el orden original de cada una pero eliminando los valores repetidos. 
		//El método deberá generar una nueva cola y no se permite dejar las colas originales vacías.
		public static ColaTDA ConcatenarColas(ColaTDA cola1, ColaTDA cola2) {
			ColaTDA c1 = new ColaPU();
			c1.InicializarCola();
			CopiarCola(cola1, c1);
			
			ColaTDA c2 = new ColaPU();
			c2.InicializarCola();
			CopiarCola(cola2, c2);
			
			ConjuntoTDA conj = new ConjuntoA();
			conj.InicializarConjunto();
			
			//CopiarColaAConjunto(c1, conj);
			//CopiarColaAConjunto(c2, conj);
			
			ColaTDA c = new ColaPU();
			c.InicializarCola();
			
			while (!c1.ColaVacia()) {
				int x = c1.Primero();
				if (!conj.Pertenece(x)) {
					conj.Agregar(x);
					c.Acolar(x);
				}
				c1.Desacolar();
			}
			
			while (!c2.ColaVacia()) {
				int x = c2.Primero();
				if (!conj.Pertenece(x)) {
					conj.Agregar(x);
					c.Acolar(x);
				}
				c2.Desacolar();
			}
			
			return c;
		}
	
		
	private static void MostrarCola(ColaTDA c) {
		while(!c.ColaVacia()) {
			int aux = c.Primero();
		    System.out.println(aux);
		    c.Desacolar();
		}
				
	}
		
	private static void MostrarConjunto(ConjuntoTDA conj) {
		while(!conj.ConjuntoVacio()) {
	        int aux = conj.Elegir();
	        System.out.println(aux);
	        conj.Sacar(aux);
	    }
			
	}



	public static void main(String[] args) {
		ColaTDA c = new ColaPU();
		c.InicializarCola();
		
		ColaTDA c2 = new ColaPU();
		c2.InicializarCola();
		
		c.Acolar(1);
		c.Acolar(2);
		c.Acolar(1);
		
		c2.Acolar(1);
		c2.Acolar(4);
		c2.Acolar(3);
		
		
		
		ColaTDA c1 = new ColaPU();
		c1.InicializarCola();
		
		ColaTDA c3 = new ColaPU();
		c3.InicializarCola();
		
		c1.Acolar(1);
		c1.Acolar(7);
		c1.Acolar(5);
		c1.Acolar(9);
		c1.Acolar(1);
		c1.Acolar(2);
		c1.Acolar(8);
		
		c3.Acolar(5);
		c3.Acolar(10);
		c3.Acolar(3);
		c3.Acolar(3);
		
		//InvertirCola(c);
		//System.out.println(CoincideFinal(c, c2));
		//System.out.println(ColaCapicua(c));
		//MostrarColaDejandolaVacia(c);
		
		ColaTDA cola = new ColaPU();
		cola.InicializarCola();
		cola = ConcatenarColas(c1, c3);
		//MostrarCola(cola);
		
		ColaTDA col = new ColaPU();
		col.InicializarCola();
		col = IntercalarColas(c1, c3);
		MostrarCola(col);
	}

}
