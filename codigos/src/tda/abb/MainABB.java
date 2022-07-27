package tda.abb;

//----- IMPORTACIONES -----

import java.util.*;

import tda.conjuntos.ConjuntoA;
import tda.conjuntos.ConjuntoTDA;
import tda.listas.*;





//-----  APP  -----

public class MainABB {

	public static void main(String[] args) {
		// PROGRAMA
		/*TDAABB t = new ABB();
		t.InicializarArbol();
		t.AgregarElem(9);
		t.AgregarElem(2);
		t.AgregarElem(12);
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		System.out.println(MenorAMayorInvertido(t, lista));*/
		
		/*TDAABB t2 = new ABB();
		t2.InicializarArbol();
		t2.AgregarElem(9);
		t2.AgregarElem(2);
		t2.AgregarElem(12);
		t2.AgregarElem(4);
		t2.AgregarElem(10);
		t2.AgregarElem(6);
		t2.AgregarElem(1);
		
		TDAABB t3 = new ABB();
		t3.InicializarArbol();
		copiarArbol(t2, t3);
		System.out.println(sonEquivalentes(t2, t3)); // true */
		
		TDAABB t1 = new ABB();
		t1.InicializarArbol();
		t1.AgregarElem(6);
		t1.AgregarElem(5);
		t1.AgregarElem(4);
		t1.AgregarElem(7);
		t1.AgregarElem(8);
		t1.AgregarElem(9);
		t1.AgregarElem(10);
		
		TDAABB tt = new ABB();
		tt.InicializarArbol();
		tt.AgregarElem(6);
		tt.AgregarElem(4);
		tt.AgregarElem(5);
		tt.AgregarElem(3);
		tt.AgregarElem(2);
		tt.AgregarElem(1);
		tt.AgregarElem(8);
		
		//System.out.println(sonEquivalentes(t2, t1)); // false
		//int h = ObtenerAlturaABB(t1); //5
		//int h = Contar(t1); // 7
		//int h = calcularProfundidad(t1, 8); //2
		//boolean h = existeElementoEnABB(t1, 3); false
		/*ConjuntoTDA conjPares = nodosPares(t1);
		while(!conjPares.ConjuntoVacio()) {
			int x = conjPares.Elegir();
			System.out.println(x);
			conjPares.Sacar(x);
		}*/ // 10, 8, 4, 6
		//preOrder(t1); //6 5 4 7 8 9 10
		//inOrder(t1); //4 5 6 7 8 9 10
		//postOrder(t1); //4 5 10 9 8 7 6
		//int h = contarHojas(t1); //2
		
		//int h = obtenerPeso(t1); //2
		//System.out.println(h);
		//mostrarDescendientes(t2, 2);
		
		//eliminarHojas(t1);
		//mostrarDescendientes(t1, t1.Raiz());
		
		/*
		// De mayor a menor
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList = MenorAMayorInvertido(t1, myList);
		for (int i : myList){
            System.out.println(i);
        } */
		
		//de menor a mayor 
		/*ArrayList<Integer> vList = new ArrayList<Integer>();
		vList = MayorAMenorInvertido(t1, vList);
		for (int i : vList){
            System.out.println(i);
        }*/
		
		/*int v = 4;
		int ant = InmediatoAnterior(t1,v);
		if (ant != v)
			System.out.println("El inmediato anterior a " + v + " es " + ant);
		else
			System.out.println("No hay un inmediato anterior a " + v + " en este ï¿½rbol.");*/
		
		ListaTDA lista = new Lista();
        lista.InicializarLista();
		lista = NodosDesbalanceados(tt, lista);
		lista.mostrar();
		
		TDAABB arbol = new ABB();
        arbol.InicializarArbol();
        arbol.AgregarElem(5);
        arbol.AgregarElem(3);
        arbol.AgregarElem(4);
        arbol.AgregarElem(2);
        arbol.AgregarElem(1);

        TDAABB arbol2 = new ABB();
        arbol2.InicializarArbol();
        arbol2.AgregarElem(6);
        arbol2.AgregarElem(3);
        arbol2.AgregarElem(4);
        arbol2.AgregarElem(2);
        arbol2.AgregarElem(1);

        System.out.println(DiferenciaX(arbol, arbol2));

        /*TDAABB arbol2 = new ABB();
        arbol2.InicializarArbol();
        System.out.println("ARBOL1: ");
        ImprimirArbol(arbol);
        arbol2 = Copiar(arbol, arbol2);
        System.out.println("ARBOL1 POST: ");
        ImprimirArbol(arbol);
        System.out.println("ARBOL2: ");
        ImprimirArbol(arbol2);*/

        //System.out.print(Altura(arbol));
	}
	
	
	
	
	// ----- FUNCIONES -----
	
	// ESTA NO FUNCIONA
	//  Se tiene un arbol binario de busqueda A. Se desea listar los nodos
	//  que estan desbalanceados
	public static ListaTDA NodosDesbalanceados(TDAABB a, ListaTDA l) {
		if (!a.ArbolVacio()) {
			if (!ArbolBalanceado(a)) {
				l.AgregarAlFinal(a.Raiz());
			}
			
			NodosDesbalanceados(a.HijoIzq(), l);
			
			
			//l.add(a.Raiz());
			NodosDesbalanceados(a.HijoDer(), l);
		}	
		return l;	
	}
		
	
	// Metodo que devuelve si un arbol esta balanceado
	public static boolean ArbolBalanceado(TDAABB arbol) {
        if (arbol.ArbolVacio()) {
            return true;
        } else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {
        	return true;
        } else if (ObtenerAlturaABB(arbol.HijoIzq()) - ObtenerAlturaABB(arbol.HijoDer()) < -1 || ObtenerAlturaABB(arbol.HijoIzq()) - ObtenerAlturaABB(arbol.HijoDer()) > 1) {
        	return false;
        } else {
        	return (ArbolBalanceado(arbol.HijoIzq()) && ArbolBalanceado(arbol.HijoDer()));
        }
    }
		
		
	// Metodo para determinar si un arbol binario es un arbol de busqueda (ABB) - Ejercicio Simulacro 1 Final ---------------
    public static boolean EsABB(TDAABB arbol) {
        if (arbol.ArbolVacio()) {
            return true;
        } else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {
            return true;
        } else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().Raiz() > arbol.Raiz()) {
            return EsABB(arbol.HijoDer());
        } else if (arbol.HijoIzq().Raiz() < arbol.Raiz() && arbol.HijoDer().ArbolVacio()) {
            return EsABB(arbol.HijoIzq());
        } else if (arbol.HijoIzq().Raiz() < arbol.Raiz() && arbol.HijoDer().Raiz() > arbol.Raiz()) {
            return EsABB(arbol.HijoIzq()) && EsABB(arbol.HijoDer());
        } else {
            return false;
        }
    }
    
    
    
    // Metodo para obtener el menor valor de un nodo de un arbol siempre que este no sea vacio
    public static int MenorValorEnArbol(TDAABB arbol) {
    	if (arbol.ArbolVacio()) {   // si el arbol está vacio, no existe.
            return 0;
    	} else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {
            return arbol.Raiz();
        } else {
            return MenorValorEnArbol(arbol.HijoIzq());
        }
    }
    
    
    
    // Metodo para obtener el mayor valor de un nodo de un arbol siempre que este no sea vacio
    public static int MayorValorEnArbol(TDAABB arbol) {
    	if (arbol.ArbolVacio()) {   // si el arbol está vacio, no existe.
            return 0;
        } else if (arbol.HijoDer().ArbolVacio()) {  // si el hijo derecho está vacio, el mayor es la raiz.
            return (arbol.Raiz());
        } else {    // si el hijo izquierdo no está vacio, se busca en el hijo derecho.
            return (MayorValorEnArbol(arbol.HijoDer()));
        }
    }
    
    
    
    /* Se tienen dos objetos de A1 y A2, ambos del tipo ABBTDA que se
	vio en clase. Queremos un metodo que reciba ambos objetos y devuelva
	un numero entero x obtenido como sigue: x = x1 - x2, donde x1 es la
	diferencia del mayor elemento menos el menor elemento de A1 y x2 es la
	diferencia del mayor elemento menos el menor elemento de A2 */
    
    // Metodo para hacer x = x1 - x2
    public static int DiferenciaX(TDAABB a1, TDAABB a2) {
    	int  x1 = MayorValorEnArbol(a1) - MenorValorEnArbol(a1);
    	int x2 = MayorValorEnArbol(a2) - MenorValorEnArbol(a2);
        int x = x1 - x2;
        return x;
    }
    
    
	// Metodo para que dado un elemento de valor v (que esta presente en el ABB), 
    // obtener el elemento del arbol que es inmediatamente anterior (en valor).
	public static int InmediatoAnterior(TDAABB t, int v) {
		if(t.ArbolVacio() || t.Raiz() == v) { //si el arbol esta vacï¿½o no lo encuentra y devuelve null
			return -1;
		} 
		// asumimos q v no es la raiz del arbol
		if (t.HijoDer().Raiz() == v || t.HijoIzq().Raiz() == v) {
			return t.Raiz();
		}
		else if (t.Raiz() > v){
			return InmediatoAnterior(t.HijoIzq(), v);
		}
		else {
			return InmediatoAnterior(t.HijoDer(), v);
		}
	}

	// Metodo para contar la cantidad de elementos que estan en un cierto nivel N.
	public static int ContarElementosEnNivel(TDAABB a, int n) {
		if (n == 0 && !a.ArbolVacio()) {
			return 1;
		} else if (!a.ArbolVacio()) {
			return (ContarElementosEnNivel(a.HijoIzq(), n -1) + ContarElementosEnNivel(a.HijoDer(), n -1));
		} else {
			return 0;
		}
	}
	
	// Metodo para calcular la cantidad de elementos que contiene un ABB
    public static int Elementos(TDAABB arbol) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no existe.
            return 0;

        } else {    
            return (1 + Elementos(arbol.HijoDer()) + Elementos(arbol.HijoIzq()));   // se suma 1 por la raiz y se suman la cant de elementos de los hijos.
        }
    }
	
	// Metodo que devuelve el valor del mayor elemento de un arbol
	public static int mayor(TDAABB a) {
		if (a.HijoDer().ArbolVacio())
			return a.Raiz();
		else
			return mayor(a.HijoDer());
	}
	
	// Metodo que devuelve el valor del menor elemento de un arbol
	public static int menor(TDAABB a) {
		if (a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else
			return menor(a.HijoIzq());
	}
	
	// Metodo para obtener peso de un arbol ej 6
	public static int obtenerPeso(TDAABB t){
		if (t.ArbolVacio()) {
			return 0;
		}
		else {
			if(t.HijoIzq().ArbolVacio() && t.HijoDer().ArbolVacio())
	        {
	            return 1;
	        } else
	        {
	            return (obtenerPeso(t.HijoIzq()) + obtenerPeso(t.HijoDer()));         
	        }
		}
	}
	
	
	
	// Metodo para copiar un ABB
	public static void copiarArbol(TDAABB t1, TDAABB t2) {
		if (!t1.ArbolVacio()) {
			t2.AgregarElem(t1.Raiz());
			copiarArbol(t1.HijoIzq(), t2.HijoIzq());
			copiarArbol(t1.HijoDer(), t2.HijoDer());
		}
	}
	
	
	
	// Metodo para copiar un ABB a otro retornando el arbol
    public static TDAABB Copiar(TDAABB arbol, TDAABB arbol2) {
        if (!arbol.ArbolVacio()) {  // si el arbol no está vacio, se copia la raiz.
            arbol2.AgregarElem(arbol.Raiz());
            Copiar(arbol.HijoDer(), arbol2.HijoDer());  // se copian los hijos.
            Copiar(arbol.HijoIzq(), arbol2.HijoIzq());  // se copian los hijos.
            return arbol;

        } else {    // si el arbol está vacio, no hace nada.
            return arbol;
        }
    }
	
	// Metodo para buscar arbol dado un elemento que queremos como raiz
	public static TDAABB buscarArbolEnABB(TDAABB t, int x) {
        if (t.ArbolVacio()) {
            return t;
        }
        else if (t.Raiz() == x) {
            return t;
        }
        else if (t.Raiz() > x) {
            return (buscarArbolEnABB(t.HijoIzq(), x));
        }
        else {
            return (buscarArbolEnABB(t.HijoDer(), x));
        }
    }

	// Metodo para mostrar los decendientes de un subarbol (no muestra su raiz)
    public static void mostrarDescendientes(TDAABB t, int x) {
        TDAABB a = buscarArbolEnABB(t, x);
        if (!a.ArbolVacio()) {
            preOrder(a.HijoIzq());
            preOrder(a.HijoDer());
        }
    }
    
	// Metodo para saber si dos arboles son similares
	public static boolean sonSimilares(TDAABB t1, TDAABB t2) {
		if (t1.ArbolVacio() && t2.ArbolVacio()) {
            return true;
        }
		//else if ((!t1.ArbolVacio() && t2.ArbolVacio()) || (t1.ArbolVacio() && !t2.ArbolVacio())) {
		if (t1.ArbolVacio() || t2.ArbolVacio()) { // si alguno de los dos es vacio
			return false;
        }
        // Si los dos no son nulos, son similares si al subï¿½rbol derecho y el izquierdo son similares
        return sonSimilares(t1.HijoIzq(), t2.HijoIzq()) && (sonSimilares(t1.HijoDer(), t2.HijoDer()));
        
    }
	
	
	
	// Metodo para saber si dos arboles son reflejo del otro, es decir, la estructura de uno
	//se mostraria como a traves de un espejo en la del otro, tienen forma opuesta.
	public static boolean sonReflejados(TDAABB t1, TDAABB t2) {
		if (t1.ArbolVacio() && t2.ArbolVacio()) {
            return true;
        }
		//else if ((!t1.ArbolVacio() && t2.ArbolVacio()) || (t1.ArbolVacio() && !t2.ArbolVacio())) {
		if (t1.ArbolVacio() || t2.ArbolVacio()) { // si alguno de los dos es vacio
			return false;
        }
        // Si los dos no son nulos, son reflejo si al subï¿½rbol derecho y el izquierdo son reflejo
        return (sonReflejados(t1.HijoIzq(), t2.HijoDer()) && (sonReflejados(t1.HijoDer(), t2.HijoIzq())));
        
    }
	
	// Metodo para saber si dos arboles son equivalentes
	public static boolean sonEquivalentes(TDAABB t1, TDAABB t2) {
        if ((!t1.ArbolVacio() && t2.ArbolVacio()) || (t1.ArbolVacio() && !t2.ArbolVacio())) {
            return false;
        } else if (t1.ArbolVacio() && t2.ArbolVacio()) {
            return true;
        } else if (t1.Raiz() != t2.Raiz()) {
            return false;
        } else if(sonEquivalentes(t1.HijoIzq(), t2.HijoIzq()) && (sonEquivalentes(t1.HijoDer(), t2.HijoDer()))) {
            return true;
        }
        return false;
    }
	
	
	
	/* Dado un ABB de valores del tipo Entero, se quiere construir una funcion que
	 * sume todos los elementos de los nodos y lo retorne. */
	
	// Metodo que sumas los elementos de los nodos
	public static int sumarNodos(TDAABB a){
        if(!a.ArbolVacio()){
            return(a.Raiz() + sumarNodos(a.HijoDer()) + sumarNodos(a.HijoIzq()) );
       }
        return 0;
    }
	
	
	
	// Metodo para contar hojas de un arbol
	public static int contarHojas(TDAABB t){
		int hojas = 0;
		if (t.ArbolVacio()) {
			return 0;
		}
		if(t.HijoIzq().ArbolVacio() && t.HijoDer().ArbolVacio())
        {
            hojas = 1;
        }
        else
        {
            hojas = (contarHojas(t.HijoIzq()) + contarHojas(t.HijoDer()));         
        }
        return hojas;
	}
	
	
	
	// Metodo para eliminar hojas de un arbol
	public static TDAABB eliminarHojas(TDAABB t){
		if (t.ArbolVacio()) {
			return t;
		}
		if(t.HijoIzq().ArbolVacio() && t.HijoDer().ArbolVacio())
        {
            t.EliminarElem(t.Raiz());;
        }
        else
        {
        	eliminarHojas(t.HijoIzq());
        	eliminarHojas(t.HijoDer());         
        }
        return t;
	}
		
	
	
	// Metodo para devolver la altura del arbol
	public static int ObtenerAlturaABB(TDAABB t)
	{
	    if (t.ArbolVacio())
	    {
	        return -1;
	    }
	    else
	    {
	        int nivelIzq = ObtenerAlturaABB(t.HijoIzq());
	        int nivelDer =  ObtenerAlturaABB(t.HijoDer());
	        
	        if (nivelIzq > nivelDer) {
	        	return (1 + nivelIzq);
	        }
	        else {
	        	return (1 + nivelDer);
	        }
	        
	    }
	}
	
	
	
	// Metodo para contar la cantidad de nodos/elementos de un ABB
	public static int Contar(TDAABB a) {
		if (a.ArbolVacio()) {
			return 0;
		}
		else {
			return (1 + Contar(a.HijoIzq()) + Contar(a.HijoDer()));
		}
	}
		
	
	
	// Metodo para calcular la profundidad de un arbol dado un elemento y un ABB
	public static int calcularProfundidad(TDAABB t, int x) {
		if (t.ArbolVacio()) {
			return 0;
		}
		else if (t.Raiz() == x) {
			return 0;
		}
		else if (t.Raiz() > x) {
			return (1 + calcularProfundidad(t.HijoIzq(), x));
		}
		else {
			return (1 + calcularProfundidad(t.HijoDer(), x));
		}
	}
		
	
	
	// Metodo que dado un elemento, determina si esta o no en un ABB
	public static boolean existeElementoEnABB(TDAABB t, int x) {
		if (t.ArbolVacio()) {
			return false;
		}
		else if (t.Raiz() == x) {
			return true;
		}
		else if (t.Raiz() > x) {
			return (existeElementoEnABB(t.HijoIzq(), x));
		}
		else {
			return (existeElementoEnABB(t.HijoDer(), x));
		}
	}
		
	
	
	// Metodo que dado un arbol, devuelve un conjunto con todos los nodos pares
	public static ConjuntoTDA nodosPares(TDAABB t) {
		ConjuntoTDA conj = new ConjuntoA();
		conj.InicializarConjunto();
		
		if (!t.ArbolVacio()) { // si el arbol es nulo, no se encuentra y devuelve nulo
			if(t.Raiz() % 2 == 0) {
				conj.Agregar(t.Raiz());;
			}
			
			ConjuntoTDA conjIzq = nodosPares(t.HijoIzq());
			ConjuntoTDA conjDer = nodosPares(t.HijoDer());
			
			while(!conjIzq.ConjuntoVacio()) {
				int x = conjIzq.Elegir();
				conj.Agregar(x);
				conjIzq.Sacar(x);
			}
			
			while(!conjDer.ConjuntoVacio()) {
				int x = conjDer.Elegir();
				conj.Agregar(x);
				conjDer.Sacar(x);
			}
		}
		return conj;
	}
	
	
	
	// Metodo para devolver todos los elementos pares de un ABB - Ejercicio PPT ---------------
    public static ConjuntoTDA Pares(TDAABB arbol, ConjuntoTDA c) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no tiene elementos.
            return c;

        } else if (arbol.Raiz() % 2 == 0) { // si la raiz es par, se agrega al conjunto y itera en los hijos.
            c.Agregar(arbol.Raiz());
            Pares(arbol.HijoDer(), c);
            Pares(arbol.HijoIzq(), c);
            return c;
        } else {    // si la raiz no es par, se itera en los hijos.
            Pares(arbol.HijoDer(), c);
            Pares(arbol.HijoIzq(), c);
            return c;
        }
    }
	
    
	
    // Metodo para devolver una lista enlazada con los nodos de un ABB ordenados de mayor a menor
    public static class Nodo{   // clase nodo
        int info;
        Nodo sig;
    }
    public static Nodo MenMay2(TDAABB arbol, Nodo origen) {    // ordenar de menor a mayor y devolver la lista enlazada

        if (!arbol.ArbolVacio()) {
            MenMay2(arbol.HijoIzq(),origen);
            origen = AgregarNodo(arbol.Raiz(),origen);
            if(!arbol.HijoDer().ArbolVacio()) {
                origen = MenMay2(arbol.HijoDer(),origen);
            }
        }
        return origen;
    }
    public static Nodo AgregarNodo(int x, Nodo origen) {    // agregar nodo al final de la lista enlazada
        Nodo aux = new Nodo();
        aux = origen;
        Nodo aux2 = new Nodo();
        aux2.info = x;
        aux2.sig = null;
        if (origen == null) {
            origen = aux2;
        } else {
            while(aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = aux2;
        }
        return origen;
    }
    public static void MostrarLista(Nodo origen) {    // mostrar la lista en pantalla
        Nodo aux = new Nodo();
        aux = origen;
        while (aux != null) {
            System.out.print("[" + aux.info + "] -> ");
            aux = aux.sig;
        }
        System.out.print("Null");
    }
    
    
    
	// Metodo que dado un valor k, arma un conjunto con todos los elementos del ABB que son mayores que k
	// num es k
	public static ConjuntoTDA nodosMayoresANum(TDAABB t, int num) {
		ConjuntoTDA conj = new ConjuntoA();
		conj.InicializarConjunto();
		
		if (!t.ArbolVacio()) { // si el arbol es nulo, no se encuentra y devuelve nulo
			if(t.Raiz() > num) {
				conj.Agregar(t.Raiz());;
			}
			
			ConjuntoTDA conjIzq = nodosMayoresANum(t.HijoIzq(), num);
			ConjuntoTDA conjDer = nodosMayoresANum(t.HijoDer(), num);
			
			while(!conjIzq.ConjuntoVacio()) {
				int x = conjIzq.Elegir();
				conj.Agregar(x);
				conjIzq.Sacar(x);
			}
			
			while(!conjDer.ConjuntoVacio()) {
				int x = conjDer.Elegir();
				conj.Agregar(x);
				conjDer.Sacar(x);
			}
		}
		return conj;
	}
	
	
	
	
	// Metodo para armar un conjunto con todos los elementos del ABB que son mayores que
    public static ConjuntoTDA Mayores(TDAABB arbol, int k, ConjuntoTDA c) {
        if (arbol.ArbolVacio()) {   // si el arbol está vacio, no tiene elementos.
            return c;

        } else if (arbol.Raiz() > k) {  // si la raiz es mayor que k, se agrega al conjunto y itera en los hijos.
            c.Agregar(arbol.Raiz());
            Mayores(arbol.HijoDer(), k, c); 
            Mayores(arbol.HijoIzq(), k, c);
            return c;
        } else {    // si la raiz no es mayor que k, se itera en los hijos.
            Mayores(arbol.HijoDer(), k, c);
            Mayores(arbol.HijoIzq(), k, c);
            return c;
        }
    }
	
	
	// Se tiene almacenado en un arbol binario de busqueda una serie de numeros ordenados de
	// menor a mayor. Disenie un procedimiento que devuelva los numeros pero ordenados de mayor a menor
	public static ArrayList<Integer> MenorAMayorInvertido(TDAABB a, ArrayList<Integer> lista) {
		if (!a.ArbolVacio()) {
			MenorAMayorInvertido(a.HijoDer(), lista);
			lista.add(a.Raiz());
			MenorAMayorInvertido(a.HijoIzq(), lista);
		}
		// estan de mayor a menor
		return lista;
	}
		
	
	
	// Se tiene almacenado en un arbol binario de busqueda una serie de numeros ordenados.
	// Disenie un procedimiento que devuelva los numeros pero ordenados de menor a mayor
	public static ArrayList<Integer> MayorAMenorInvertido(TDAABB a, ArrayList<Integer> lista) {
		if (!a.ArbolVacio()) {
			MayorAMenorInvertido(a.HijoIzq(), lista);
			lista.add(a.Raiz());
			MayorAMenorInvertido(a.HijoDer(), lista);
		}
		// estan de menor a mayor
		return lista;
	}
		
	
	
	// Metodo para mostrar los numeros de un arbol ABB ordenados de mayor a menor 
    public static void MayMen(TDAABB arbol) {
        if (!arbol.ArbolVacio()) {  // si el arbol no está vacio, se busca el hijo derecho.
            MayMen(arbol.HijoDer());    
            System.out.print(arbol.Raiz() + " ");   // cuando llega al más de la derecha, se imprime la raiz.
            if (!arbol.HijoIzq().ArbolVacio()) {    // pregunta si hay hijo izquierdo, si hay se imprime, y vuelve a iterar MayMen
                MayMen(arbol.HijoIzq());    
            }
        }
    }

    
    
    // Metodo para devolver los numeros de un arbol ABB ordenados de menor a mayor
    public static void MenMay(TDAABB arbol) {
        if (!arbol.ArbolVacio()) {  // si el arbol no está vacio, se busca el hijo izquierdo.
            MenMay(arbol.HijoIzq());    
            System.out.print(arbol.Raiz() + " ");   // cuando llega al más de la izquierda, se imprime la raiz.
            if (!arbol.HijoDer().ArbolVacio()) {    // pregunta si hay hijo derecho, si hay se imprime, y vuelve a iterar MenMay
                MenMay(arbol.HijoDer());    
            }
        }
    }
    
    
    
	public static void preOrder(TDAABB a) {
		if (!a.ArbolVacio()) {
			System.out.println(a.Raiz());
			preOrder(a.HijoIzq());
			preOrder(a.HijoDer());
		}
	}
	
	
	
	// va en orden creciente
	public static void inOrder(TDAABB a) {
		if (!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}
	
	
	
	public static void postOrder(TDAABB a) {
		if (!a.ArbolVacio()) {
			postOrder(a.HijoIzq());
			postOrder(a.HijoDer());
			System.out.println(a.Raiz());
		}
	}
	
		
		
}