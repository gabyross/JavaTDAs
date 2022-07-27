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
	
	// metodo para mostrar un diccionario multiple
    public static void mostrarDiccionarioMul(DiccionarioMultipleTDA DicMul) {
        ConjuntoTDA claves;
        claves = DicMul.Claves();   // obtener conjunto claves del diccionario multiple
        while (!claves.ConjuntoVacio()) {   // obtener clave y valor
            int clave = claves.Elegir();
            ConjuntoTDA valores = DicMul.Recuperar(clave);  // obtener conjunto valores de la clave
            System.out.print("Clave: " + clave + " Valores: "); 
            while (!valores.ConjuntoVacio()) {  // imprimir valores
                System.out.print(valores.Elegir() + " ");   
                valores.Sacar(valores.Elegir());    // sacar valor del conjunto
            }
            System.out.println();   
            claves.Sacar(clave);    
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
