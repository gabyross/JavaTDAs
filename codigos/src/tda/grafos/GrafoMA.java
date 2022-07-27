package tda.grafos;

import tda.conjuntos.*;

public class GrafoMA implements GrafoTDA{
	
	static int n = 100; 
	int[][] MAdy; // Matriz de adyacencia
	int[] Etiqs; // Vector para mapeo de indices
	int cantNodos;
	
	public void InicializarGrafo() {
		MAdy = new int [n][n];
		Etiqs = new int [n];
		cantNodos = 0;
		
	}

	public void AgregarVertice(int v) {
		Etiqs[cantNodos] = v;
		for (int i = 0; i <= cantNodos; i++) {
			MAdy[cantNodos][i] = 0; // Nueva fila en 0
			MAdy[i][cantNodos] = 0; // Nueva columna en 0
		}
		cantNodos++;
	}
	
	private int Vert2Indice(int v) { // Mapeamos vertice e indice
		int i = cantNodos-1;
		while(i >= 0 && Etiqs[i] != v) {
			i--;
		}
		return i;
	}
	
	public void EliminarVertice(int v) {
		int ind = Vert2Indice(v); //indice del vertice por eliminar
		for (int i=0; i < cantNodos; i++) {
			// la columna a eliminar va a ser igual a la ultima columna de la matriz
			MAdy[i][ind] = MAdy[i][cantNodos - 1]; // se "pisa" la columna
		}
		for (int i=0; i < cantNodos; i++) {
			// la fila eliminar va a ser igual a la ultima fila de la matriz
			MAdy[ind][i] = Etiqs[cantNodos - 1]; // se "pisa" la fila
		}
		Etiqs[ind] = Etiqs[cantNodos - 1]; // se reemplaza el nodo a eliminar por el ultimo guardado
		cantNodos--; // decrementamos el contador de elementos
		// basicamente se igual al contenido del ultimon numero almacena y luego se recorta la matriz, los valores fueron reemplazados
		// y por lo tanto no importa perder ese contenido
	}

	public void AgregarArista(int v1, int v2, int p) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		MAdy[o][d] = p;
		
	}

	public void EliminarArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		MAdy[o][d] = 0;
		
	}

	public int PesoArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return MAdy[o][d];
		
	}

	public ConjuntoTDA Vertices() {
		ConjuntoTDA Vert = new ConjuntoLD();
		Vert.InicializarConjunto();
		for (int i=0; i < cantNodos; i++) {
			Vert.Agregar(Etiqs[i]);
		}
		return Vert;
	}

	
	public boolean ExisteArista(int v1, int v2) {
		int o = Vert2Indice(v1);
		int d = Vert2Indice(v2);
		return (MAdy[o][d] != 0);
	}

}
