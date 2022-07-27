package tda.diccionariosMultiples;

import tda.conjuntos.ConjuntoTDA;
import tda.diccionariosSimples.DiccionarioSimpleTDA;

public class DiccionarioMultipleMain {
	
	// pasaje de elementos de un diccionario simple dicSim a uno multiple dicMul.
	public void PasajeDeMaS(DiccionarioSimpleTDA DicSim, DiccionarioMultipleTDA DicMul) {
		ConjuntoTDA claves;
		claves = DicSim.Claves();
		while (!claves.ConjuntoVacio()) {
			int clave = claves.Elegir();
			int valor = DicSim.Recuperar(clave);
			DicMul.Agregar(clave,  valor);
			claves.Sacar(clave);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
