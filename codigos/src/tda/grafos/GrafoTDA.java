
/*
 * InicializarGrafo, sirve para inicializar el tipo abstracto de datos.
 * AgregarVertice agrega un nuevo vertice al grafo, siempre que el grafo este inicializado y el vertice no exista.
 * EliminarVertice elimina un vertice del grafo, siempre que el grafo este inicializado y el vertice exista.
 * AgregarArista agrega una arista al grafo entre dos vertices dados y con un peso dado, siempre que existan ambos vertices y no exista una arista entre ambos.
 * EliminarArista elimina la arista entre los vertices dados, siempre que los vertices existan.
 * PesoArista devuelve el int peso de la arista entre los vertices dados, siempre que los vertices existan.
 * Vertices es de tipo ConjuntoTDA. Este metodo devuelve el conjunto de vertices de un grafo, siempre que el grafo este inicializado.
 * ExisteArista es de tipo boolean e indica si el grafo contiene una arista entre dos vertices dados, siempre que ambos vertices existan.
 */

package tda.grafos;
import tda.conjuntos.*;
public interface GrafoTDA {
	void InicializarGrafo(); // sin precondiciones
	void AgregarVertice(int v); // Grafo inicializado y no existe nodo v
	void EliminarVertice(int v); // Grafo inicializado y existe nodo v
	void AgregarArista(int v1, int v2, int p); // Grafo inicializado y no existe arista (v1, v2)
	void EliminarArista(int v1, int v2); // Grafo inicializado y existe arista (v1, v2)
	int PesoArista(int v1, int v2); // Grafo inicializado y existe arista (v1, v2)
	ConjuntoTDA Vertices(); // Grafo inicializado
	boolean ExisteArista(int v1, int v2); // Grafo inicializado y existen nodos v1, v2
}
