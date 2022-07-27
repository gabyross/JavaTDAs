package tda.abb;
import java.util.*;

import tda.conjuntos.ConjuntoA;
import tda.conjuntos.ConjuntoTDA;
import tda.listas.*;

public class MainABB {
	
	// ESTA NO FUNCIONA
	//  Se tiene un �rbol binario de b�squeda A. Se desea listar los nodos
	//que est�n desbalanceados
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
	
	// Devuelve si un arbol esta balanceado
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
	
	
	// funcion para determinar si un arbol binario es un arbol de busqueda (ABB) - Ejercicio Simulacro 1 Final ---------------
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
    
    // funcion para obtener el menor valor de un nodo de un arbol siempre que este no sea vacio
    public static int MenorValorEnArbol(TDAABB arbol) {
        if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {
            return arbol.Raiz();
        } else {
            return MenorValorEnArbol(arbol.HijoIzq());
        }
    }
    
    // funcion para obtener el mayor valor de un nodo de un arbol siempre que este no sea vacio
    public static int MayorValorEnArbol(TDAABB arbol) {
        if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) {
            return arbol.Raiz();
        } else {
            return MenorValorEnArbol(arbol.HijoDer());
        }
    }
    
    
    /* Se tienen dos objetos de A1 y A2, ambos del tipo ABBTDA que se
	vio en clase. Queremos un metodo que reciba ambos objetos y devuelva
	un numero entero x obtenido como sigue: x = x1 - x2, donde x1 es la
	diferencia del mayor elemento menos el menor elemento de A1 y x2 es la
	diferencia del mayor elemento menos el menor elemento de A2 */
    public static int operacionConDosArboles(TDAABB a1, TDAABB a2) {
    	
    	int x1;
    	int x2;
    	
    	if (a1.ArbolVacio()) {
    		x1 = 0;
    	} else {
    		x1 = MayorValorEnArbol(a1) - MenorValorEnArbol(a1);
    	}
    	
    	if (a2.ArbolVacio()) {
    		x2 = 0;
    	} else {
    		x2 = MayorValorEnArbol(a2) - MenorValorEnArbol(a2);
    	}
       
        int x = x1 - x2;
        return x;
    }
    
    
	// Dado un elemento de valor v (que est� presente en el ABB), obtener el elemento
	//del �rbol que es inmediatamente anterior (en valor).
	public static int InmediatoAnterior(TDAABB t, int v) {
		if(t.ArbolVacio() || t.Raiz() == v) { //si el arbol esta vac�o no lo encuentra y devuelve null
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

	// Contar la cantidad de elementos que est�n en un cierto nivel N.
	public static int ContarElementosEnNivel(TDAABB a, int n) {
		if (n == 0 && !a.ArbolVacio()) {
			return 1;
		} else if (!a.ArbolVacio()) {
			return (ContarElementosEnNivel(a.HijoIzq(), n -1) + ContarElementosEnNivel(a.HijoDer(), n -1));
		} else {
			return 0;
		}
	}
	
	
	// devuelve el valor del mayor elemento de un arbol
	public static int mayor(TDAABB a) {
		if (a.HijoDer().ArbolVacio())
			return a.Raiz();
		else
			return mayor(a.HijoDer());
	}
	
	// devuelve el valor del menor elemento de un arbol
	public static int menor(TDAABB a) {
		if (a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else
			return menor(a.HijoIzq());
	}
	
	//obtener peso de un arbol ej 6
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
	
	// Copiar un ABB
	public static void copiarArbol(TDAABB t1, TDAABB t2) {
		if (!t1.ArbolVacio()) {
			t2.AgregarElem(t1.Raiz());
			copiarArbol(t1.HijoIzq(), t2.HijoIzq());
			copiarArbol(t1.HijoDer(), t2.HijoDer());
		}
	}
	
	// Buscar arbol dado un elemento que queremos como raiz
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

	// Mostrar los decendientes de un subarbol (no muestra su raiz)
    public static void mostrarDescendientes(TDAABB t, int x) {
        TDAABB a = buscarArbolEnABB(t, x);
        if (!a.ArbolVacio()) {
            preOrder(a.HijoIzq());
            preOrder(a.HijoDer());
        }
    }
    
	// Saber si dos arboles son similares
	public static boolean sonSimilares(TDAABB t1, TDAABB t2) {
		if (t1.ArbolVacio() && t2.ArbolVacio()) {
            return true;
        }
		//else if ((!t1.ArbolVacio() && t2.ArbolVacio()) || (t1.ArbolVacio() && !t2.ArbolVacio())) {
		if (t1.ArbolVacio() || t2.ArbolVacio()) { // si alguno de los dos es vacio
			return false;
        }
        // Si los dos no son nulos, son similares si al sub�rbol derecho y el izquierdo son similares
        return sonSimilares(t1.HijoIzq(), t2.HijoIzq()) && (sonSimilares(t1.HijoDer(), t2.HijoDer()));
        
    }
	
	// Saber si dos arboles son reflejo del otro, es decir, la estructura de uno
	//se �refleja� como a trav�s de un espejo en la del otro, tienen forma opuesta.
	public static boolean sonReflejados(TDAABB t1, TDAABB t2) {
		if (t1.ArbolVacio() && t2.ArbolVacio()) {
            return true;
        }
		//else if ((!t1.ArbolVacio() && t2.ArbolVacio()) || (t1.ArbolVacio() && !t2.ArbolVacio())) {
		if (t1.ArbolVacio() || t2.ArbolVacio()) { // si alguno de los dos es vacio
			return false;
        }
        // Si los dos no son nulos, son reflejo si al sub�rbol derecho y el izquierdo son reflejo
        return (sonReflejados(t1.HijoIzq(), t2.HijoDer()) && (sonReflejados(t1.HijoDer(), t2.HijoIzq())));
        
    }
	
	// Saber si dos arboles son equivalentes
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
	
	//Dado un ABB de valores del tipo Entero, se quiere construir una funci�n que
	//sume todos los elementos de los nodos y lo retorne.
	public static int sumarNodos(TDAABB a){
        if(!a.ArbolVacio()){
            return(a.Raiz() + sumarNodos(a.HijoDer()) + sumarNodos(a.HijoIzq()) );
       }
        return 0;
    }
	
	// Contar hojas de un arbol
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
	
	// Eliminar hojas de un arbol
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
		
	// Devolver la altura del arbol
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
	
	// Contar la cantidad de nodos/elementos de un ABB
	public static int Contar(TDAABB a) {
		if (a.ArbolVacio()) {
			return 0;
		}
		else {
			return (1 + Contar(a.HijoIzq()) + Contar(a.HijoDer()));
		}
	}
		
	
	// Calcular la profundidad de un arbol dado un elemento y un ABB
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
		
	
	// dado un elemento, determinar si esta o no en un ABB
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
		
	// Dado un arbol, devolver un conjunto con todos los nodod pares
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
	
	// Dado un valor k, arme un conjunto con todos los elementos del ABB que son mayores que k
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
	
	// Se tiene almacenado en un �rbol binario de b�squeda una serie de n�meros ordenados de
	//menor a mayor. Dise�e un procedimiento que devuelva los n�meros pero ordenados de mayor a menor
	public static ArrayList<Integer> MenorAMayorInvertido(TDAABB a, ArrayList<Integer> lista) {
		if (!a.ArbolVacio()) {
			MenorAMayorInvertido(a.HijoDer(), lista);
			lista.add(a.Raiz());
			MenorAMayorInvertido(a.HijoIzq(), lista);
		}
		// estan de mayor a menor
		return lista;
	}
		
	// Se tiene almacenado en un �rbol binario de b�squeda una serie de n�meros ordenados. Dise�e un procedimiento que devuelva los n�meros pero ordenados de menor a mayor
	public static ArrayList<Integer> MayorAMenorInvertido(TDAABB a, ArrayList<Integer> lista) {
		if (!a.ArbolVacio()) {
			MayorAMenorInvertido(a.HijoIzq(), lista);
			lista.add(a.Raiz());
			MayorAMenorInvertido(a.HijoDer(), lista);
		}
		// estan de menor a mayor
		return lista;
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
			System.out.println("No hay un inmediato anterior a " + v + " en este �rbol.");*/
		
		ListaTDA lista = new Lista();
        lista.InicializarLista();
		lista = NodosDesbalanceados(tt, lista);
		lista.mostrar();
	}
	
}