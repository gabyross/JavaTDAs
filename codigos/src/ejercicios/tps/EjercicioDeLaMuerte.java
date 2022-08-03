package ejercicios.tps;

import tda.conjuntos.*;
import tda.abb.*;
import tda.grafos.*;

/*
 * escribir un algoritmo que reciba un grafo y un arboly verifique que para cada nodo del grafo que existe como valor
 * en el arbol la diferencia entre el peso de las aristas entrantes menos el peso las aristas salientes sea igual a la
 *  sumatoria de los val del hijo izq menos la sumatoria de lo hijos derehos del valor del nodo en el arbol
 */
public class EjercicioDeLaMuerte {
	
	public static TDAABB buscarElementoEnABB(TDAABB t, int x) {
		
		if (t.ArbolVacio()) { // Si el árbol el nulo, no se encuentra y devuelve nulo.
			return null;
		} else if (t.Raiz() == x) { // Si el elemento raíz coincide, devuelve el valor de a.
			return t;
		} else if (t.Raiz() > x) { // Si el elemento raíz - es mayor, control se busca - en el subárbol izquierdo.
			return buscarElementoEnABB(t.HijoIzq(), x);
		} else { // Si el elemento raíz es menor, se busca en el subárbol derecho.
			return buscarElementoEnABB(t.HijoDer(), x);
        
		}
	}
	
	
	public static int diferenciaAristasEntrantesSalientes(GrafoTDA g, int nodo) {
		
		int pesoAristasEntrantes = 0;
		int pesoAristasSalientes = 0;
		
		ConjuntoTDA vertices = g.Vertices();
		
		int x;
		
		while (!vertices.ConjuntoVacio()) {
			x = vertices.Elegir();
			vertices.Sacar(x);
			
			if(g.ExisteArista(nodo, x))
				pesoAristasSalientes += g.PesoArista(nodo, x);
			
			if(g.ExisteArista(x, nodo))
				pesoAristasEntrantes += g.PesoArista(x, nodo);
			
		}
		
		return pesoAristasEntrantes - pesoAristasSalientes;
	}
	
	public static int sumatoriaElementos(TDAABB a) {
		
		int sumatoria = 0;
		
		if(!a.ArbolVacio()) {
			
		
			sumatoria += a.Raiz();
		
			int rI = sumatoriaElementos(a.HijoIzq());
			int rD = sumatoriaElementos(a.HijoDer());
		
			sumatoria += rI + rD;
		}
		
		return sumatoria;
	}
	
	
	public static boolean pesoAristasIgualValoresSubarboles(GrafoTDA g, TDAABB a, int nodo) {
		
		
		if(diferenciaAristasEntrantesSalientes(g, nodo) == (sumatoriaElementos(buscarElementoEnABB(a, nodo).HijoIzq()) - sumatoriaElementos(buscarElementoEnABB(a, nodo).HijoDer())))
			return true;
		else
			return false;
	}
	
	
	

	public static void main(String[] args) {
		
		TDAABB arbol = new ABB();
		arbol.InicializarArbol();
		arbol.AgregarElem(5);
		arbol.AgregarElem(6);
		arbol.AgregarElem(3);
		arbol.AgregarElem(4);
		
		GrafoTDA g = new GrafoMA();
		g.InicializarGrafo();
		g.AgregarVertice(4);
		g.AgregarVertice(6);
		g.AgregarVertice(3);
		g.AgregarVertice(5);
		g.AgregarArista(4, 6, 1);
		g.AgregarArista(3, 6, 2);
		g.AgregarArista(3, 5, 2);
		g.AgregarArista(5, 4, 1);

		
		System.out.println(pesoAristasIgualValoresSubarboles(g, arbol, 4));
	}
}
