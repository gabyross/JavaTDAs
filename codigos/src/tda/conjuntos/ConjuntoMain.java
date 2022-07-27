package tda.conjuntos;

import tda.colas.ColaPU;
import tda.colas.ColaTDA;

public class ConjuntoMain {
	//determinación de si un conjunto conj1 incluye a otro conjunto conj2.
	public static boolean Incluye(ConjuntoTDA conj1, ConjuntoTDA conj2) {
		boolean incluye = true;
		while (!conj2.ConjuntoVacio() && incluye) {
			int x = conj2.Elegir();
			if (!conj1.Pertenece(x))
			{
				incluye = false;
			}
			else
			{
				conj2.Sacar(x);
			}
		}
		return incluye;
	}
	
	public static void MostrarConjunto(ConjuntoTDA conj) {
		while(!conj.ConjuntoVacio()) {
	        int aux = conj.Elegir();
	        System.out.println(aux);
	        conj.Sacar(aux);
	    }
	}
	
	// Pasar conjunto sin dejar vacia el original
	public static void CopiarConjunto(ConjuntoTDA origen, ConjuntoTDA destino) {
		ConjuntoTDA aux = new ConjuntoA();
		aux.InicializarConjunto();
		
		while (!origen.ConjuntoVacio())
		{
			int x = origen.Elegir();
			aux.Agregar(x);
			origen.Sacar(x);
		}
		
		while (!aux.ConjuntoVacio())
		{
			int x = aux.Elegir();
			origen.Agregar(x);
			destino.Agregar(x);
			aux.Sacar(x);
		}
	}
	
	public static void SacarConjunto(ConjuntoTDA c1, ConjuntoTDA c2) {
		ConjuntoTDA aux2 = new ConjuntoA();
		aux2.InicializarConjunto();
		CopiarConjunto(c2, aux2);
		
		while(!aux2.ConjuntoVacio()) {
	        int x = aux2.Elegir();
	        if (c1.Pertenece(x)) {
	        	c1.Sacar(x);
	        }
	        aux2.Sacar(x);
	    }
	}
	
	public static ConjuntoTDA SacarConjuntoSinModificarOriginal(ConjuntoTDA c1, ConjuntoTDA c2) {
		ConjuntoTDA aux1 = new ConjuntoA();
		aux1.InicializarConjunto();
		CopiarConjunto(c1, aux1);
		
		ConjuntoTDA aux2 = new ConjuntoA();
		aux2.InicializarConjunto();
		CopiarConjunto(c2, aux2);
		
		while(!aux2.ConjuntoVacio()) {
	        int x = aux2.Elegir();
	        if (aux1.Pertenece(x)) {
	        	aux1.Sacar(x);
	        }
	        aux2.Sacar(x);
	    }
		return aux1;
	}
	
	// halla la interseccion entre dos conjuntos
	public static ConjuntoTDA CalcularDiferenciaSimetricaSinModificar(ConjuntoTDA c1, ConjuntoTDA c2) {
		ConjuntoTDA nuevoC1 = SacarConjuntoSinModificarOriginal(c1, c2); // A - B
		ConjuntoTDA nuevoC2 = SacarConjuntoSinModificarOriginal(c2, c1); // B - A
		
		ConjuntoTDA conj = new ConjuntoA();
		conj.InicializarConjunto();
		
		while (!nuevoC1.ConjuntoVacio())
		{
			int x = nuevoC1.Elegir();
			conj.Agregar(x);
			nuevoC1.Sacar(x);
		}
		
		while (!nuevoC2.ConjuntoVacio())
		{
			int x = nuevoC2.Elegir();
			conj.Agregar(x);
			nuevoC2.Sacar(x);
		}
		return conj;
	}
	
	public static void main(String[] args) {
		ConjuntoTDA c1 = new ConjuntoA();
		c1.InicializarConjunto();
		c1.Agregar(2);
		c1.Agregar(5);
		c1.Agregar(3);
		
		ConjuntoTDA c2 = new ConjuntoA();
		c2.InicializarConjunto();
		c2.Agregar(4);
		c2.Agregar(2);
		c2.Agregar(3);
		c2.Agregar(7);
		
		ConjuntoTDA c = CalcularDiferenciaSimetricaSinModificar(c1, c2); // 5, 4, 7
		MostrarConjunto(c);
		// si el profesor mandara a agregar imlementaciones en TDA podria ser vaciar conjunto, cola o pila, u obtener el tamaño de la misma

	}

}
