package tda.grafos;

import java.util.ArrayList;

import tda.conjuntos.ConjuntoA;
import tda.conjuntos.ConjuntoTDA;
import tda.diccionarios.DiccionarioSimpleL;
import tda.diccionarios.DiccionarioSimpleTDA;
import arboles.abb.*;

public class MainGrafo {
	public static int[] OrdenarLista(int[] vector) {
		// ORDENAMIENTO POR BURBUJEO O INTERCAMBIO
		/*
		 * Se basa en comparar cada elemento con el que tiene a su derecha si es
		 * necesario, se los intercambia, luego se avanza a la siguiente pareja y se
		 * repite el proceso hasta que no haya ningun cambio
		 */

		boolean desordenado = true;
		while (desordenado) {
			desordenado = false;
			for (int i = 0; i < (vector.length - 1); i++) {
				if (vector[i] > vector[i + 1]) {
					int aux = vector[i];
					vector[i] = vector[i + 1];
					vector[i + 1] = aux;
					desordenado = true;
				}
			}
		}
		return vector;
	}

	// Realizar un metodo que cuente la cantidad de elementos de un conjunto
	public static int CantElemConj(ConjuntoTDA c) {
		int counter = 0;
		while (!c.ConjuntoVacio()) {
			counter += 1;
			c.Sacar(c.Elegir());
		}
		return counter;
	}

	// Realizar un metodo que imprima los vertices de un grafo ordenados de menor a
	// mayor
	public static void MostrarVerticesOrdenados(GrafoTDA grafo) {
		ConjuntoTDA c = grafo.Vertices();

		int cant = CantElemConj(grafo.Vertices());
		int[] vertices = new int[cant];
		int i = 0;
		while (!c.ConjuntoVacio()) {
			int aux = c.Elegir();
			vertices[i] = aux;
			c.Sacar(aux);
			i += 1;
		}
		vertices = OrdenarLista(vertices);

		for (int x = 0; x < vertices.length; x++) {
			System.out.println(vertices[x]);
		}

	}

	// Realizar un metodo que imprima los vertices de un grafo ordenados de menor a
	// mayor
	public static void MostrarVerticesOrdenadosConArboles(GrafoTDA grafo) {
		ConjuntoTDA c = grafo.Vertices();

		TDAABB t = new ABB();
		t.InicializarArbol();

		while (!c.ConjuntoVacio()) {
			int aux = c.Elegir();
			t.AgregarElem(aux);
			c.Sacar(aux);
		}
		inOrder(t);
	}

	// va en orden creciente
	public static void inOrder(TDAABB a) {
		if (!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}

	// método que recibe un grafo y devuelva su matriz de adyacencia.
	// Por supuesto, también se debe devolver el vector que relacione nodos con
	// índices.
	public static int[][] Matriz(GrafoTDA grafo) {
		ConjuntoTDA c = new ConjuntoA();
		c.InicializarConjunto();
		ConjuntoTDA c2 = new ConjuntoA();
		c2.InicializarConjunto();
		c = grafo.Vertices();
		int g;
		int cant = 0;

		while (!c.ConjuntoVacio()) {
			g = c.Elegir();
			c2.Agregar(g);
			c.Sacar(g);
			cant++;
		}
		int[][] matriz;
		matriz = new int[cant + 1][cant + 1];

		for (int i = 0; i < cant; i++) {
			g = c2.Elegir();
			matriz[0][i + 1] = g;
			matriz[i + 1][0] = g;
			c2.Sacar(g);
		}

		for (int i = 0; i < cant - 1; i++) {
			for (int j = 0; j < cant - 1; j++) {
				if (grafo.ExisteArista(matriz[0][i + 1], matriz[j + 1][0])) {
					matriz[i + 1][j + 1] = grafo.PesoArista(matriz[0][i + 1], matriz[j + 1][0]);
				} else {
					matriz[i + 1][j + 1] = 0;
				}
			}
		}
		return matriz;
	}

	// mostrar diccionario
	public static void MostrarDic(DiccionarioSimpleTDA dic) {
		ConjuntoTDA claves;
		claves = dic.Claves();
		while (!claves.ConjuntoVacio()) {
			int x = claves.Elegir();
			System.out.println("Clave: " + x + " Valor: " + dic.Recuperar(x));
			claves.Sacar(x);
		}
	}

	// pasar un grafo a un diccionario simple
	public static DiccionarioSimpleTDA GrafoADS(GrafoTDA g) {
		ConjuntoTDA conjVertices = g.Vertices();

		DiccionarioSimpleTDA DicG = new DiccionarioSimpleL();
		DicG.InicializarDiccionario();

		while (!conjVertices.ConjuntoVacio()) {
			int pesoTotal = 0;
			ConjuntoTDA vAux = g.Vertices(); // conjunto auxiliar de vertices
			int x = conjVertices.Elegir();

			while (!vAux.ConjuntoVacio()) {
				int y = vAux.Elegir();
				if (g.ExisteArista(x, y)) {
					pesoTotal += g.PesoArista(x, y);
				}
				vAux.Sacar(y);

			}
			DicG.Agregar(x, pesoTotal); // la clave es el nodo y su valor la suma de los pesos de sus aristas
			conjVertices.Sacar(x);

		}
		return DicG;
	}

	// obtengo los vecinos de un vertice, es decir, tods los que esta conectado por
	// una arista
	public static ConjuntoTDA VerticesVecinos(GrafoTDA g, int v) {
		ConjuntoTDA conjVertices = g.Vertices();

		ConjuntoTDA verticesVecinos = new ConjuntoA();
		verticesVecinos.InicializarConjunto();

		while (!conjVertices.ConjuntoVacio()) {

			int vAux1 = conjVertices.Elegir();
			if (g.ExisteArista(v, vAux1)) {
				verticesVecinos.Agregar(vAux1);
			}

			conjVertices.Sacar(vAux1);
		}
		return verticesVecinos;
	}

	public static ConjuntoTDA VerticesIntersVecinos(GrafoTDA g, int v1, int v2) {

		ConjuntoTDA vecinos1 = VerticesVecinos(g, v1);
		ConjuntoTDA vecinos2 = VerticesVecinos(g, v2);

		ConjuntoTDA interseccion = CalcularDiferenciaSimetricaSinModificar(vecinos1, vecinos2); //halla la interseccion
		
		return interseccion;
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

	/*
	 * Dado un Grafo G y un vértice v, calcular el conjunto de vértices
	 * AdyacentesDobles de v. Se define que un vértice w es adyacente doble de un
	 * vértice v, si existe otro vértice x y hay una arista que comienza en v y
	 * termina en x y otra que comienza en x y termina en w.
	 */
	public static ConjuntoTDA VerticesAdyacentesDobles(GrafoTDA g, int v) {
		ConjuntoTDA verticesAdyDobles = new ConjuntoA();
		verticesAdyDobles.InicializarConjunto();

		ConjuntoTDA primVecinos = VerticesVecinos(g, v);

		while (!primVecinos.ConjuntoVacio()) {
			int vecino = primVecinos.Elegir();
			ConjuntoTDA segundVecinos = VerticesVecinos(g, vecino);

			while (!segundVecinos.ConjuntoVacio()) {
				int aux = segundVecinos.Elegir();
				verticesAdyDobles.Agregar(aux);
				;
				segundVecinos.Sacar(aux);
			}
			primVecinos.Sacar(vecino);
		}

		return verticesAdyDobles;
	}

	// Dado un vértice v de un grafo, calcular el mayor de los costos de las aristas
	// salientes.
	public static int MayorCostoArista(GrafoTDA g, int v) {
		int peso = 0;
		ConjuntoTDA vertices = g.Vertices();
		while (!vertices.ConjuntoVacio()) {
			int vAux = vertices.Elegir();
			if (g.ExisteArista(v, vAux)) {
				if (g.PesoArista(v, vAux) > peso) {
					peso = g.PesoArista(v, vAux);
				}
			}
			vertices.Sacar(vAux);
		}
		return peso;
	}

	/*
	 * Dado un Grafo G y un vértice v, escribir un método que permita obtener el
	 * conjunto de los Predecesores del vértice v en G. Se define que un vértice o
	 * es predecesor de otro vértice d, si hay una arista que comienza en o y
	 * termina en d.
	 */
	public static ConjuntoTDA PredecesoresDeV(GrafoTDA g, int v) {
		ConjuntoTDA vertices = g.Vertices();
		ConjuntoTDA predecesores = new ConjuntoA();
		predecesores.InicializarConjunto();
		while (!vertices.ConjuntoVacio()) {
			int vAux = vertices.Elegir();
			if (g.ExisteArista(vAux, v)) {
				predecesores.Agregar(vAux);
			}
			vertices.Sacar(vAux);
		}
		return predecesores;
	}

	/*
	 * Dado un Grafo G escribir un método que permita obtener el conjunto de los
	 * vértices aislados en G. Se define que un vértice v es aislado si v no tiene
	 * aristas entrantes ni salientes.
	 */
	public static ConjuntoTDA VerticesAislados(GrafoTDA g) {
		ConjuntoTDA conjVertices = g.Vertices();

		ConjuntoTDA verticesAislados = new ConjuntoA();
		verticesAislados.InicializarConjunto();

		while (!conjVertices.ConjuntoVacio()) {
			ConjuntoTDA conjAux = g.Vertices();
			int vAux1 = conjVertices.Elegir();
			boolean esAislado = true;

			while (esAislado && !conjAux.ConjuntoVacio()) {
				int vAux2 = conjAux.Elegir();

				if (g.ExisteArista(vAux1, vAux2) || g.ExisteArista(vAux2, vAux1)) {
					esAislado = false;
				}

				conjAux.Sacar(vAux2);
			}

			if (esAislado) {
				verticesAislados.Agregar(vAux1);
			}
			conjVertices.Sacar(vAux1);
		}
		return verticesAislados;
	}

	/*
	 * Dado un Grafo G y dos vértices v1 y v2, escribir un método que permita
	 * obtener el conjunto de todos los vértices puente entre v1 y v2. Se define que
	 * un vértice p es puente entre dos vértices o y d, si hay una arista que
	 * comienza en o y termina en p y otra que comienza en p y termina en d.
	 */
	public static ConjuntoTDA VerticesPuentes(GrafoTDA g, int o, int d) {
		ConjuntoTDA conjVertices = g.Vertices();

		ConjuntoTDA VerticesPuentes = new ConjuntoA();
		VerticesPuentes.InicializarConjunto();

		while (!conjVertices.ConjuntoVacio()) {

			int vAux1 = conjVertices.Elegir();
			if (g.ExisteArista(o, vAux1) && g.ExisteArista(vAux1, d)) {
				VerticesPuentes.Agregar(vAux1);
			}

			conjVertices.Sacar(vAux1);
		}
		return VerticesPuentes;
	}

	/*
	 * Dado un Grafo G y un vértice v, calcular el grado de v. Se define el grado de
	 * un vértice v como el entero que es igual a la resta entre la cantidad de
	 * aristas que salen de v menos la cantidad de aristas que llegan a v.
	 */
	public static int CalcularGrado(GrafoTDA g, int v) {
		ConjuntoTDA conjVertices = g.Vertices();

		int aristasSalientes = 0;
		int aristasEntrantes = 0;

		while (!conjVertices.ConjuntoVacio()) {

			int vAux1 = conjVertices.Elegir();

			if (g.ExisteArista(v, vAux1)) {
				aristasSalientes += 1;
			}

			if (g.ExisteArista(vAux1, v)) {
				aristasEntrantes += 1;
			}

			conjVertices.Sacar(vAux1);
		}
		return (aristasSalientes - aristasEntrantes);
	}

	// Escriba un método que reciba como entrada un grafo (o sea, un objeto
	// de tipo GrafoTDA) y devuelva true si el grafo está topológicamente
	// ordenado y false en caso contrario.
	// Un grafo está topológicamente ordenado si toda arista se dirige
	// siempre desde un vértice menor hacia otro mayor.

	public static boolean EstaTopologicamenteOrdenado(GrafoTDA grafo) {
		ConjuntoTDA conj = grafo.Vertices();
		boolean estaOrdenado = true;

		while (estaOrdenado && !conj.ConjuntoVacio()) {

			ConjuntoTDA auxConj = grafo.Vertices();
			int a = conj.Elegir();

			while (estaOrdenado && !auxConj.ConjuntoVacio()) {

				int b = auxConj.Elegir();

				if (grafo.ExisteArista(a, b) && (b <= a)) {
					estaOrdenado = false;
				} else if (grafo.ExisteArista(b, a) && (a <= b)) {
					estaOrdenado = false;
				}

				auxConj.Sacar(b);
			}

			conj.Sacar(a);
		}
		return estaOrdenado;
	}

	public static void main(String[] args) {
		GrafoTDA grafo = new GrafoLA();
		grafo.AgregarVertice(1);
		grafo.AgregarVertice(3);
		grafo.AgregarVertice(5);
		grafo.AgregarVertice(7);
		grafo.AgregarVertice(9);
		grafo.AgregarVertice(10);
		grafo.AgregarVertice(35);
		grafo.AgregarVertice(40);

		grafo.AgregarArista(1, 5, 8);
		grafo.AgregarArista(1, 3, 6);
		grafo.AgregarArista(3, 9, 2);
		grafo.AgregarArista(5, 1, 2);
		grafo.AgregarArista(5, 7, 4);
		grafo.AgregarArista(5, 9, 1);
		grafo.AgregarArista(7, 1, 4);
		grafo.AgregarArista(7, 5, 6);
		grafo.AgregarArista(7, 9, 6);
		grafo.AgregarArista(9, 3, 4);
		grafo.AgregarArista(9, 7, 8);
		grafo.AgregarArista(9, 9, 2);

		// System.out.println(MayorCostoArista(grafo, 1)); // 8
		/*
		 * ConjuntoTDA p = PredecesoresDeV(grafo, 9); // 9, 7, 3
		 * while(!p.ConjuntoVacio()) { int aux = p.Elegir(); System.out.println(aux);
		 * p.Sacar(aux); }
		 */

		/*
		 * ConjuntoTDA aislados = VerticesAislados(grafo); // 40, 35, 10
		 * while(!aislados.ConjuntoVacio()) { int aux = aislados.Elegir();
		 * System.out.println(aux); aislados.Sacar(aux); }
		 */

		/*
		 * ConjuntoTDA puentes = VerticesPuentes(grafo, 1, 9); // 5, 3
		 * while(!puentes.ConjuntoVacio()) { int aux = puentes.Elegir();
		 * System.out.println(aux); puentes.Sacar(aux); }
		 */

		// System.out.println(CalcularGrado(grafo, 9)); // 3 - 4 = -1

		/*
		 * ConjuntoTDA adyacentesDobles = VerticesAdyacentesDobles(grafo, 1); // 1, 7, 9
		 * while(!adyacentesDobles.ConjuntoVacio()) { int aux =
		 * adyacentesDobles.Elegir(); System.out.println(aux);
		 * adyacentesDobles.Sacar(aux); }
		 */

		GrafoTDA g = new GrafoMA();
		g.InicializarGrafo();
		g.AgregarVertice(1);
		g.AgregarVertice(2);
		g.AgregarVertice(3);
		g.AgregarVertice(4);
		g.AgregarVertice(5);
		g.AgregarVertice(6);
		g.AgregarArista(1, 2, 5);

		/*
		 * int[][] matriz;
		 * 
		 * 
		 * matriz = Matriz(g);
		 * 
		 * for (int x=0; x < matriz.length; x++) { System.out.print("|"); for (int y=0;
		 * y < matriz[x].length; y++) { System.out.print (matriz[x][y]); if
		 * (y!=matriz[x].length-1) System.out.print("\t"); } System.out.println("|"); }
		 */

		// MostrarVerticesOrdenados(grafo);
		// MostrarVerticesOrdenadosConArboles(grafo);

		GrafoTDA gOrd = new GrafoMA();
		gOrd.InicializarGrafo();
		gOrd.AgregarVertice(1);
		gOrd.AgregarVertice(2);
		gOrd.AgregarVertice(3);
		gOrd.AgregarVertice(4);
		gOrd.AgregarVertice(5);
		gOrd.AgregarVertice(6);

		gOrd.AgregarArista(1, 2, 10);
		gOrd.AgregarArista(1, 3, 10);
		gOrd.AgregarArista(2, 3, 10);
		gOrd.AgregarArista(2, 5, 10);
		gOrd.AgregarArista(3, 4, 10);
		gOrd.AgregarArista(3, 6, 10);
		gOrd.AgregarArista(4, 5, 10);
		gOrd.AgregarArista(5, 6, 10);

		System.out.println(EstaTopologicamenteOrdenado(gOrd)); // true

		GrafoTDA gDes = new GrafoMA();
		gDes.InicializarGrafo();
		gDes.AgregarVertice(1);
		gDes.AgregarVertice(2);
		gDes.AgregarVertice(3);
		gDes.AgregarVertice(4);

		gDes.AgregarArista(1, 2, 10);
		gDes.AgregarArista(1, 4, 10);
		gDes.AgregarArista(2, 4, 10);
		gDes.AgregarArista(2, 3, 10);
		gDes.AgregarArista(3, 2, 10);
		gDes.AgregarArista(3, 4, 10);

		System.out.println(EstaTopologicamenteOrdenado(gDes)); // false
	}

}
