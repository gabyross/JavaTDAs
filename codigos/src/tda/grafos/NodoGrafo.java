package tda.grafos;

class NodoGrafo { // nodo verde
	int nodo;
	NodoArista arista; // flecha roja
	NodoGrafo sigNodo; // flecha verde
}

class NodoArista { //nodo rojo
	int etiqueta;
	NodoGrafo nodoDestino; // flecha verde de trazos
	NodoArista sigArista; // flecha roja de trazos
}