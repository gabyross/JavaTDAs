package finalProgra.gv;

import tda.conjuntos.ConjuntoTDA;
import tda.grafos.GrafoLA;
import tda.grafos.GrafoTDA;

// ----- APP -----
public class ej2{
	

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

		System.out.println(MayorCostoArista(grafo, 1)); // 4
	}
	
	
	
	
	
	// ----- FUNCIONES -----
	// Metodo que dado un vertice v de un grafo, calcula el mayor de los costos de 
	// las aristas entrantes.
	public static int MayorCostoArista(GrafoTDA g, int v) {
		int mayorPeso = 0;
		ConjuntoTDA vertices = g.Vertices();
		while (!vertices.ConjuntoVacio()) {
			int vAux = vertices.Elegir();
			if (g.ExisteArista(vAux, v)) {
				if (g.PesoArista(vAux, v) > mayorPeso) {
					mayorPeso = g.PesoArista(vAux, v);
				}
			}
			vertices.Sacar(vAux);
		}
		return mayorPeso;
	}

	
	/* ESTRATEGIA 
	 * tengo una variable peso inicializada en cero,  un conjuntos con todos los vertices del grafo
	 * mientras que no termine de recorrer todo el conjunto de vertices
	 * elijo un vertice y veo si iene una arista que llega a mi vertice v,
	 * de ser asi veo si el peso de esa arista es mayor a mi mayor peso encontrado hasta el momento
	 * si es mayor ese es ahora mi nuevo mayor peso,
	 * sino, lo saco del conjuntos de vertices y continuo verificando
	 * una vez haya terminado de realizar este proceso con todos los vertices, devulvo el mayor peso que encontre,
	 * si no hubo una arista que llagara a este vertice, el peso retornante es cero.
	 * 
	 * COSTO
	 * el costo es cuadratico ya que al grafo de estrada le pido los vertices existentes,
	 * y Vertices() tiene costo cuadratico, de resto todo es lineal, pero almanejar mi entrada con costo cuadratico
	 * como es el costo mas alto, es el definitivo
	 */
}
