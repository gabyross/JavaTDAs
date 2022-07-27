package tda.grafos;

// -----  IMPORTACIONES  -----

import tda.conjuntos.ConjuntoA;
import tda.conjuntos.ConjuntoLD;
import tda.conjuntos.ConjuntoTDA;
import tda.diccionariosMultiples.DiccionarioMultipleA;
import tda.diccionariosMultiples.DiccionarioMultipleL;
import tda.diccionariosMultiples.DiccionarioMultipleTDA;
import tda.diccionariosSimples.DiccionarioSimpleA;
import tda.diccionariosSimples.DiccionarioSimpleL;
import tda.diccionariosSimples.DiccionarioSimpleTDA;
import tda.abb.*;





// -----  APP  -----

public class MainGrafo {

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

	
	
	
	
	// -----  FUNCIONES  -----
	
	// Metodo que ordena una lista
	public static int[] OrdenarLista(int[] vector) {
		/* ORDENAMIENTO POR BURBUJEO O INTERCAMBIO
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

	
	
	// Metodo que cuenta la cantidad de elementos de un conjunto
	public static int CantElemConj(ConjuntoTDA c) {
		int counter = 0;
		while (!c.ConjuntoVacio()) {
			counter += 1;
			c.Sacar(c.Elegir());
		}
		return counter;
	}

	
	
	// Metodo que imprime los vertices de un grafo ordenados de menor a mayor con OrdenarLista
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

	
	
	// Metodo que imprime los vertices de un grafo ordenados de menor a mayor con Arboles
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

	
	
	// Metodo que imprime un arbol en orden creciente
	public static void inOrder(TDAABB a) {
		if (!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}

	
	
	// Metodo que recibe un grafo y devuelve su matriz de adyacencia.
	// Por supuesto, tambien se debe devolver el vector que relacione nodos con
	// indices.
	public static int[][] Matriz(GrafoTDA grafo) {
		ConjuntoTDA vertices = grafo.Vertices();
		
		ConjuntoTDA c2 = new ConjuntoA();
		c2.InicializarConjunto();
		
		int x;
		int cant = 0;

		while (!vertices.ConjuntoVacio()) {
			x = vertices.Elegir();
			c2.Agregar(x); 
			vertices.Sacar(x);
			cant++;
		}
		
		int[][] matriz;
		matriz = new int[cant + 1][cant + 1];

		for (int i = 0; i < cant; i++) {
			x = c2.Elegir();
			matriz[0][i + 1] = x;
			matriz[i + 1][0] = x;
			c2.Sacar(x);
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

	
	// MATRIZ DE ADYACENCIA EXPLICADA
	// funcion para generar una matriz de adyacencia a partir de un grafo - Ejercicio Simulacro Final --------------
    public static class nodomatriz {    // clase para guardar matriz de adyacencia y vertices
    	int[][] ady;
    	int[] vertices;
    }
    
    public static nodomatriz MatrizAdyacencia(GrafoTDA grafo) {
    	
    	ConjuntoTDA vertices = grafo.Vertices();    // creo conjunto de vertices
    	
    	int cant = 0;
    	
    	while(!vertices.ConjuntoVacio()) {  // itero en los vertices para contar la cantidad de vertices
    		cant++;
    		vertices.Sacar(vertices.Elegir());
    	}
    	
    	nodomatriz matriz = new nodomatriz();   // creo nodo de matriz con la cantidad de vertices
    	matriz.ady = new int[cant][cant];
    	matriz.vertices = new int[cant];
    	
    	vertices = grafo.Vertices();    // vuelvo a rellenar el conjunto de vertices
    	
    	int x;
    	int y;
    	
    	for (int i = 0; i <= cant; i++) {   // itero en el conjunto de vertices
    		x = vertices.Elegir();
    		matriz.vertices[i] = x;   // guardo los vertices en el array de vertices
    		vertices.Sacar(x);
    	}
    	
    	for (int i = 0; i <= cant; i++) {   // itero en las filas de la matriz
    		
    		x = matriz.vertices[i];  // obtengo el vertice de la fila
  
        	for (int j = 0; j <= cant; j++) {   // itero en las columnas de la matriz
        		y = vertices.Elegir();  // obtengo el vertice de la columna
        		
        		if (grafo.ExisteArista(x, y)) { // pregunto si hay una arista que vaya de x a y
        			matriz.ady[i][j] = grafo.PesoArista(x, y);  // guardo el peso de la arista en la matriz
        		} else {
        			matriz.ady[i][j] = 0;   // si no hay una arista, guardo 0 en la matriz
        		} 	
        	}
    	}
    	return matriz;
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
	
	// metodo que muestra un diccionario multiple
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

	
	
	// Metodo que pasa un grafo a un diccionario simple
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
	
	
	
	static DiccionarioMultipleTDA GrafoADM(GrafoTDA a) {
        DiccionarioMultipleTDA dic = new DiccionarioMultipleL();
        dic.InicializarDiccionario();
        
        ConjuntoTDA c1 = a.Vertices();
        
        ConjuntoTDA coe = new ConjuntoLD();
        coe.InicializarConjunto();
        
        int v;
        int k;
        
        while(!c1.ConjuntoVacio()) {
            boolean e = false;
            
         // obtengo el primero del conjunto y lo saco
            v = c1.Elegir();
            c1.Sacar(v);
            
            ConjuntoTDA c2 = a.Vertices();
            while(!c2.ConjuntoVacio()) {
            	
                // obtengo el primero del conjunto y lo saco
            	k = c2.Elegir();
                c2.Sacar(k);
                
                // si existe una arista entre ambos vertices lo agrego al diccionario
                if(a.ExisteArista(v, k)) {
                    dic.Agregar(v, k); // v es la clave y k el valor
                    e = true;
                }
            }
            
            // si no existe una arista, lo agego al conj coe
            if(!e) {
                coe.Agregar(v);
            }
        }
        
        // para todos los valores que no tienen aristas con otros, los agrego con valor cero al dic
        while(!coe.ConjuntoVacio()) {
            v = coe.Elegir();
            coe.Sacar(v);
            dic.Agregar(v, 0);
        }
        return dic;
    }

	
	
	// Metodo para obtener los vecinos de un vertice, es decir, tods los que esta conectado por
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

	
	
	// Metodo para obtener la interseccion entre los vecinos de dos vertices
	public static ConjuntoTDA VerticesIntersVecinos(GrafoTDA g, int v1, int v2) {

		ConjuntoTDA vecinos1 = VerticesVecinos(g, v1);
		ConjuntoTDA vecinos2 = VerticesVecinos(g, v2);

		ConjuntoTDA interseccion = CalcularDiferenciaSimetricaSinModificar(vecinos1, vecinos2); //halla la interseccion
		
		return interseccion;
	}
	
	
	
	// Metodo para pasar conjunto sin dejar vacio el original
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
		
	
	
	// Metodo que devuelve el resultado de sacar un conjunto de otro 
	// sin modificar los conjuntos originales
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
	
	
	
	// Metodo que calcula la diferencia simetrica entre dos conjuntos o su interseccion
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
	 * Dado un Grafo G y un vertice v, calcular el conjunto de vertices
	 * AdyacentesDobles de v. Se define que un vertice w es adyacente doble de un
	 * vetice v, si existe otro vertice x y hay una arista que comienza en v y
	 * termina en x y otra que comienza en x y termina en w.
	 */
	
	// Metodo que devuelve un conjunto con los vertices adyantes dobles de un vertice
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

	
	
	
	// Metodo que dado un vertice v de un grafo, calcula el mayor de los costos de 
	// las aristas salientes.
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
	 * Dado un Grafo G y un vertice v, escribir un mï¿½todo que permita obtener el
	 * conjunto de los Predecesores del vertice v en G. Se define que un vertice o
	 * es predecesor de otro vertice d, si hay una arista que comienza en o y
	 * termina en d.
	 */
	
	// Metodo que devuelve un conjunto con los predececores de un vertice
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
	 * Dado un Grafo G escribir un metodo que permita obtener el conjunto de los
	 * vertices aislados en G. Se define que un vertice v es aislado si v no tiene
	 * aristas entrantes ni salientes.
	 */
	
	// Metodo que devuelve un conjunto con los vertices aislados de un grafo
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
	 * Dado un Grafo G y dos vertices v1 y v2, escribir un metodo que permita
	 * obtener el conjunto de todos los vertices puente entre v1 y v2. Se define que
	 * un vertice p es puente entre dos vertices o y d, si hay una arista que
	 * comienza en o y termina en p y otra que comienza en p y termina en d.
	 */
	
	// Metodo para obtener un conjunto con todos los vertices puente entre dos vertices
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
	 * Dado un Grafo G y un vertice v, calcular el grado de v. Se define el grado de
	 * un vertice v como el entero que es igual a la resta entre la cantidad de
	 * aristas que salen de v menos la cantidad de aristas que llegan a v.
	 */
	
	// Metodo para calcular el grado de un vertice de un grafo
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

	
	
	/* Escriba un metodo que reciba como entrada un grafo (o sea, un objeto
	 * de tipo GrafoTDA) y devuelva true si el grafo esta topologicamente
	 * ordenado y false en caso contrario.
	 * Un grafo esta topologicamente ordenado si toda arista se dirige
	 * siempre desde un vertice menor hacia otro mayor. */

	// Metodo que devuelve sin un grafo esta topologicamente ordenado o no
	public static boolean EstaTopologicamenteOrdenado(GrafoTDA grafo) {
		ConjuntoTDA conj = grafo.Vertices();
		boolean estaOrdenado = true;

		while (estaOrdenado && !conj.ConjuntoVacio()) {

			ConjuntoTDA auxConj = grafo.Vertices();
			int a = conj.Elegir();

			// itero con el conjunto de vertices y me fijo si los vertices que salen de un vertice llegan a otro vertice mayor
			while (estaOrdenado && !auxConj.ConjuntoVacio()) {

				int b = auxConj.Elegir();

				// si la arista que va de un lugar a otro es mayor que el que le sigue, no es topológico
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
	
	
	
	// Metodo para hacer un grafo bidireccional
    public static GrafoTDA Bidireccional(GrafoTDA grafo) {
        ConjuntoTDA conjVertices = grafo.Vertices();
        
        ConjuntoTDA c2 = new ConjuntoA();   // crear conjuntos aux de vertices
        c2.InicializarConjunto();

        int v1;   // vertice 1
        int v2;  // vertice 2
        int p;   // peso de la arista entre los vertices

        // itera sobre el primer conjunto de vertices
        while (!conjVertices.ConjuntoVacio()) {    
        	v1 = conjVertices.Elegir();
            c2 = grafo.Vertices(); // vuelve a rellenar c2
            
            // itera sobre el segundo conjunto
            while (!c2.ConjuntoVacio()) {   
                v2 = c2.Elegir();
                
                // si existe una arista de v1 a v2, pero no viceversa, agregar arista de v2 a v1
                if (grafo.ExisteArista(v1, v2) && !grafo.ExisteArista(v2, v1)) {
                    p = grafo.PesoArista(v1, v2);
                    grafo.AgregarArista(v2, v1, p);
                }
                c2.Sacar(v2);
            }
            conjVertices.Sacar(v1);
        }
        return grafo;
    }
    
    
    
    // Metodo para obtener un conjunto de vertices predecesores de v1 y v2 a la vez (que le llegan a v1 y v2, que son comunes)
    public static ConjuntoTDA PredecesoresComunes(GrafoTDA grafo, int v1, int v2) {
        ConjuntoTDA predecesoresComunes = new ConjuntoA();
        predecesoresComunes.InicializarConjunto();
        
        ConjuntoTDA aux = grafo.Vertices();   // conjunto auxiliar de vertices

     // itero en los vertices
        while (!aux.ConjuntoVacio()) {
            int x = aux.Elegir();
            
            // si existe una arista que va de x a v1, y de x a v2, entonces es un predecesor comun
            if (grafo.ExisteArista(x, v1) && grafo.ExisteArista(x, v2)) {
            	predecesoresComunes.Agregar(x);
            }
            aux.Sacar(x);

        }
        return predecesoresComunes;
    }
    
    
    
    // Metodo para obtener un conjunto de vertices que estan a distancia igual o menor a 2 del vertice v
    public static ConjuntoTDA VerticesADistanciaDos(GrafoTDA grafo, int v) {
        ConjuntoTDA c = new ConjuntoA();
        c.InicializarConjunto();
        
        // itero en los vertices
        ConjuntoTDA aux = grafo.Vertices();
        while (!aux.ConjuntoVacio()) { 
            int x = aux.Elegir();
        
            // si existe una arista que va de v a x, agrego x al conjunto
            if (grafo.ExisteArista(v, x)) { 
                c.Agregar(x);
                
                // itero en los vertices de nuevo
                ConjuntoTDA aux2 = grafo.Vertices();
                while (!aux2.ConjuntoVacio()) {
                    int y = aux2.Elegir();
                    
                    // si existe una arista que va de v a x, agrego y al conjunto
                    if (grafo.ExisteArista(x, y)) {
                        c.Agregar(y);
                    }
                    aux2.Sacar(y);
                }
                
            }
            aux.Sacar(x);
        }
        return c;
    }
    
    
    
    // Metodo que determina todos los vertices que salen de v1
    public static ConjuntoTDA verticesSalientes(GrafoTDA grafo, int v1) {

        ConjuntoTDA vertices = grafo.Vertices();    // creo conjunto de vertices
        vertices.Sacar(v1);

        ConjuntoTDA vertSalientes = new ConjuntoA();    // creo conjunto de vertices salientes
        vertSalientes.InicializarConjunto();

        // itero con el conjunto de vertices
        while (!vertices.ConjuntoVacio()) {
            int x = vertices.Elegir();
            
            // si existe una arista que sale de v1 lo agrego al conj de salientes
            if (grafo.ExisteArista(v1, x)) {
                vertSalientes.Agregar(x);
            }
            vertices.Sacar(x);
        }

        return vertSalientes;
    }
    
    
    
    // Metodo que determina todos los vertices que llegan a v2
    public static ConjuntoTDA verticesLlegando(GrafoTDA grafo, int v2) {
        
        ConjuntoTDA vertices = grafo.Vertices();    // creo conjunto de vertices
        vertices.Sacar(v2);

        ConjuntoTDA vertLlegando = new ConjuntoA();    // creo conjunto de vertices llegando
        vertLlegando.InicializarConjunto();
	
	    // itero con el conjunto de vertices
        while (!vertices.ConjuntoVacio()) {
            int x = vertices.Elegir();

            // si existe una arista que llega a v2 lo agrego al conj de los que llegan
            if (grafo.ExisteArista(x, v2)) {
                vertLlegando.Agregar(x);
            }
            vertices.Sacar(x);
        }

        return vertLlegando;
    }
    
    
    
    // Metodo para determinar si entre dos nodos de un grafo dirigido existe un camino
    public static boolean existeCamino(GrafoTDA grafo, int v1, int v2) {

        if (grafo.ExisteArista(v1, v2)) {
            return true;

        } else {

        	// obtengo todos los vertices que salen de v1
            ConjuntoTDA salientes = verticesSalientes(grafo, v1);

            // itero en los vertices salientes
            while (!salientes.ConjuntoVacio()) {
                int x = salientes.Elegir();
                
                // si existe una arista que va de x a v2 devuelvo true
                if (grafo.ExisteArista(x, v2)) {
                    return true;
                } else {
                    salientes.Sacar(x);
                }
            }

            // si no hay vertices que salen de v1 que llegan a v2
            if (salientes.ConjuntoVacio()) {    
                salientes = verticesSalientes(grafo, v1); 

                // itero en los vertices que salen de v1 preguntando si existe un camino entre x y v2
                while (!salientes.ConjuntoVacio()) {
                    int x = salientes.Elegir();
                    salientes.Sacar(x);
                    return existeCamino(grafo, x, v2); 
                }
                
            }

            return false;   
        }
    }
    
    
    
    /* Dado un grafo G (o sea, un objeto de tipo GrafoTDA) y un conjunto
     * de vértices V pertenecientes a G, queremos encontrar el complemento del
     * vecindario de V en el grafo G, es decir, el conjunto de nodos que no son
     * adyacentes a ninguno de los nodos de V en G. */
    
    // Metodo para determinar el vecindario del conjunto de nodos de un grafo (todos los que salen de esos nodos)
    public static ConjuntoTDA vecindario(GrafoTDA grafo, ConjuntoTDA conjunto) {

        ConjuntoTDA vecindario = new ConjuntoA();    // creo conjunto de vecindario
        vecindario.InicializarConjunto();

        ConjuntoTDA aux = new ConjuntoA();    // creo conjunto auxiliar para no perder conjunto original
        aux.InicializarConjunto();

        CopiarConjunto(conjunto, aux);

        while (!aux.ConjuntoVacio()) { // itero en los vertices del conjunto
            int x = aux.Elegir();

            ConjuntoTDA salientes = verticesSalientes(grafo, x); // para cada vertice obtengo los vertices que salen de x

            while (!salientes.ConjuntoVacio()) {    // itero en los vertices que salen de x
                int y = salientes.Elegir();

                if (!conjunto.Pertenece(y)) {    // si ya no pertenece al conjunto, agregar al vecindario
                    vecindario.Agregar(y);
                }
                salientes.Sacar(y);
            }
            aux.Sacar(x);
        }

        return vecindario;
    }
    
    
    
    // Metodo para determinar el complemento del vecindario del conjunto de nodos de un grafo (todos los que no salen de los vertices (no estan en el vecindario))
    public static ConjuntoTDA complementoVecindario(GrafoTDA grafo, ConjuntoTDA conjunto) {

        ConjuntoTDA complemento = new ConjuntoA();    // creo conjunto de complemento
        complemento.InicializarConjunto();

        ConjuntoTDA vecindario = vecindario(grafo, conjunto); // obtengo el vecindario del conjunto de nodos

        ConjuntoTDA vertices = grafo.Vertices();    // creo conjunto de vertices

        // itero en los vertices del conjunto
        while (!vertices.ConjuntoVacio()) { 
            int x = vertices.Elegir();
            vertices.Sacar(x);

            // si el vertice no pertenece al vecindario y no pertenece al conjunto, agregar al complemento
            if (!vecindario.Pertenece(x) && !conjunto.Pertenece(x)) {
                    complemento.Agregar(x);
            }
        }

        return complemento;
    }
    
    
    
    // Metodo para obtener los vertices iniciales de un grafo (vertices sin aristas entrantes)
    public static ConjuntoTDA verticesIniciales(GrafoTDA grafo) {

        ConjuntoTDA vertices = grafo.Vertices();    // creo conjunto de vertices

        ConjuntoTDA vertIniciales = new ConjuntoA();    // creo conjunto de vertices iniciales
        vertIniciales.InicializarConjunto();

        // itero en los vertices
        while (!vertices.ConjuntoVacio()) { 
            int x = vertices.Elegir();
            vertices.Sacar(x);

         // si el vertice no tiene aristas entrantes, lo agrego al conjunto de vertices iniciales
            if (verticesLlegando(grafo, x).ConjuntoVacio()) {    
                vertIniciales.Agregar(x);
            }
        }

        return vertIniciales;
    }
    
    
    
    // Metodo para obtener los vertices finales de un grafo (vertices sin aristas salientes)
    public static ConjuntoTDA verticesFinales(GrafoTDA grafo) {

        ConjuntoTDA vertices = grafo.Vertices();    // creo conjunto de vertices

        ConjuntoTDA vertFinales = new ConjuntoA();    // creo conjunto de vertices iniciales
        vertFinales.InicializarConjunto();

        // itero en los vertices
        while (!vertices.ConjuntoVacio()) {
            int x = vertices.Elegir();
            vertices.Sacar(x);

         // si el vertice no tiene aristas salientes, lo agrego al conjunto de vertices iniciales
            if (verticesSalientes(grafo, x).ConjuntoVacio()) {    
                vertFinales.Agregar(x);
            }
        }

        return vertFinales;
    }
    
    
    
    // Metodo para obterner un diccionario simple con la suma de los pesos de las aristas del vertice - Ejercicio Simulacro Parcial 2 --------------
    public static DiccionarioSimpleTDA SumaPesos(GrafoTDA grafo) {
        DiccionarioSimpleTDA d = new DiccionarioSimpleA();
        d.InicializarDiccionario();
        ConjuntoTDA aux = new ConjuntoA();
        ConjuntoTDA aux2 = new ConjuntoA(); // crear conjuntos auxiliares y diccionario
        aux.InicializarConjunto();
        aux = grafo.Vertices(); // obtener conjunto de vertices
        aux2.InicializarConjunto();
        aux2 = grafo.Vertices();

        int v;
        int v2;
        int suma;

        while (!aux.ConjuntoVacio()) {  // iterar sobre los vertices del conjunto auxiliar
            suma = 0;
            v = aux.Elegir();
            aux2 = grafo.Vertices();
            while (!aux2.ConjuntoVacio()) { // iterar sobre los vertices del conjunto auxiliar2
                v2 = aux2.Elegir();
                if (grafo.ExisteArista(v, v2)) {    // si existe arista entre v y v2, sumar el peso de la arista a la suma
                    suma += grafo.PesoArista(v, v2);
                }
                aux2.Sacar(v2);
            }
            d.Agregar(v, suma); // agregar suma y clave al diccionario
            aux.Sacar(v);
        }
        return d; 
    }
    
    
    
    // Metodo para obtener un diccionario multiple con los nodos adyacentes del vertice - Ejercicio Simulacro 5 Final --------------
    public static DiccionarioMultipleTDA AdyacentesEnDicc(GrafoTDA grafo) {
        DiccionarioMultipleTDA d = new DiccionarioMultipleA();
        d.InicializarDiccionario();
        ConjuntoTDA aux2 = grafo.Vertices(); // crear conjuntos auxiliares y diccionario
        ConjuntoTDA aux = grafo.Vertices(); // obtener conjunto de vertices

        int v;
        int v2;

        // iterar sobre los vertices del conjunto auxiliar
        while (!aux.ConjuntoVacio()) {  
            v = aux.Elegir();
            aux2 = grafo.Vertices();    // obtener conjunto de vertices

            // iterar sobre los vertices del conjunto auxiliar2
            while (!aux2.ConjuntoVacio()){ 
                v2 = aux2.Elegir(); 
                
                // si existe arista entre v y v2, agregar nodo adyacente a diccionario
                if (grafo.ExisteArista(v, v2) && (v != v2)) {
                    d.Agregar(v, v2);
                }
                aux2.Sacar(v2);
            }

            // si el diccionario no tiene nodos adyacentes, agregar nodo al diccionario con valor 0
            if ((d.Recuperar(v)).ConjuntoVacio()) {
                d.Agregar(v, 0);;
            }
            aux.Sacar(v);

        }
        return d; 
    }
}
