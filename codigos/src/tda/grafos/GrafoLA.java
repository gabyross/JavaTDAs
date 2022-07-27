package tda.grafos;

import tda.conjuntos.ConjuntoLD;
import tda.conjuntos.ConjuntoTDA;

public class GrafoLA implements GrafoTDA{
	NodoGrafo origen;

	public void InicializarGrafo() {
		origen = null;
	}

	public void AgregarVertice(int v) {
		// El vertice de inserta al inicio de la lista de nodos
		NodoGrafo aux = new NodoGrafo();
		aux.nodo = v;
		aux.arista = null;
		aux.sigNodo = origen;
		origen = aux;
	}

	private NodoGrafo Vert2Nodo(int v) { // dado un valor busca el nodo correspondiente
		NodoGrafo aux = origen;
		while (aux != null && aux.nodo != v) {
			aux = aux.sigNodo;
		}
		return aux;
	}
	
	public void EliminarVertice(int v) {
		if (origen.nodo == v) { // si es el origen
			origen = origen.sigNodo; // chau origen
		}
		NodoGrafo aux = origen; // no es el origen, a buscarlo
		while (aux != null) {
			// eliminamos aristas hacia v
			this.EliminarAristaNodo(aux, v);
			if (aux.sigNodo != null && aux.sigNodo.nodo == v) {
				// si es el nodo, chau nodo
				aux.sigNodo = aux.sigNodo.sigNodo;
			}
			aux = aux.sigNodo; // sigue eliminando aristas
		}
		// basicamente eliminamos cualquier conexion al vertice q nos pasaron, y el vertice q nos pasaron
	}

	public void AgregarArista(int v1, int v2, int p) {
		NodoGrafo n1 = Vert2Nodo(v1); //Buscamos el nodo origen
		NodoGrafo n2 = Vert2Nodo(v2); //Buscamos el nodo destino
		NodoArista aux = new NodoArista(); // la arista va al inicio de la lista...
		aux.etiqueta = p; // ... de aristas salientes de v1
		aux.nodoDestino = n2; // p es igual a peso
		aux.sigArista = n1.arista;
		n1.arista = aux;
	}
	
	private void EliminarAristaNodo(NodoGrafo nodo, int v) {
		NodoArista aux = nodo.arista; // elimina del nodo las aristas hacia v
		if (aux != null) {
			if (aux.nodoDestino.nodo == v) {
				// hay que eliminar la primera arista
				nodo.arista = aux.sigArista;
			} else {
				// no es la primera, la buscamos 
				while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v) {
					aux = aux.sigArista;
				}
				if (aux.sigArista != null) {
					// eliminamos la arista
					aux.sigArista = aux.sigArista.sigArista;
				}
			}
		}
	}

	public void EliminarArista(int v1, int v2) {
		NodoGrafo n1 = Vert2Nodo(v1);
		EliminarAristaNodo(n1,v2); // listo
	}

	public int PesoArista(int v1, int v2) {
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux.nodoDestino.nodo != v2) {
			aux = aux.sigArista; // buscamos la arista
		}
		return aux.etiqueta;
	}

	@Override
	public ConjuntoTDA Vertices() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoGrafo aux = origen;
		while (aux != null) {
			c.Agregar(aux.nodo);
			aux = aux.sigNodo;
		}
		return c;
	}

	public boolean ExisteArista(int v1, int v2) {
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux != null && aux.nodoDestino.nodo != v2) {
			// buscamos la arista
			aux = aux.sigArista;
		}
		return (aux != null);
	}

}
