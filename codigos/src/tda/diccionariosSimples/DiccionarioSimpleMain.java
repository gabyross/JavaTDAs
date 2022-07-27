package tda.diccionariosSimples;

import tda.conjuntos.ConjuntoTDA;
import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class DiccionarioSimpleMain {
	// pasaje de todos los valores de un diccionario simple dic a una pila valores.
	public static void PasajeDicAPila(DiccionarioSimpleTDA dic, PilaTDA valores) {
		ConjuntoTDA claves;
		claves = dic.Claves();
		while (!claves.ConjuntoVacio()) {
			int x = claves.Elegir();
			valores.Apilar(dic.Recuperar(x));
			claves.Sacar(x);
		}
	}
	
	// Metodo que muestra un diccionario simple
	public static void MostrarDic(DiccionarioSimpleTDA dic) {
		ConjuntoTDA claves;
		claves = dic.Claves();
		while (!claves.ConjuntoVacio()) {
			int x = claves.Elegir();
			System.out.println("Clave: " + x + " Valor: " + dic.Recuperar(x));
			claves.Sacar(x);
		}
	}

	public static void main(String[] args) {
		DiccionarioSimpleTDA d = new DiccionarioSimpleA();
		d.InicializarDiccionario();
		d.Agregar(1, 100);
		d.Agregar(2, 200);
		d.Agregar(4, 400);
		PilaTDA valores = new PilaTF();
		valores.InicializarPila();
		PasajeDicAPila(d, valores);
	}
}
