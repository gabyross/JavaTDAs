package finalProgra.gv;

import tda.abb.TDAABB;

public class ABBF implements TDAABBF{
	static NodoABBF raiz;
	
	public int Raiz() {
		return raiz.dato;
	}

	public TDAABBF HijoIzq() {
		return raiz.hijoIzq;
	}
	
	public TDAABBF HijoIzq2(NodoABBF n) {
		if (raiz == null) {
            return null;
        }
		else if (raiz.dato == n.dato && n.hijoIzq == null) {
            return null;
        }
        else if (raiz.dato == n.dato && n.hijoIzq != null) {
            return raiz.hijoIzq;
        }
        else if (raiz.dato > n.dato) {
            return raiz.hijoIzq.HijoIzq2(n);
        }
        else {
        	return raiz.hijoDer.HijoIzq2(n);
        }
	}
	
	/*
	 * ------ ESTRATEGIA ------
	 * dado un nodo quiero buscar su hijo iZquierdo en el arbol
	 * por lo tanto, primero veo si el arbol esta vacio, de ser asi devulevo null
	 * de ver que consegui el nodo quiero devolver el hijo iq si no es nulo, de lo contrario
	 * devuelvo null, si no o consegui devuelvo null
	 * si no lo consigo pero veo que es menor q mi raiz, llam recursivamente pero con el lado izquierdo
	 * de lo contrario quiere decir que es mayor y llamo reursivamente con el lado derecho del arbol
	 * debido a que el arbol tiene del lado izquierdo los valores menores de la raiz
	 * y del lado derecho los valores mayores que la raiz
	 * 
	 * 
	 * ------ COSTO -----
	 * el costo es logaritmico porque recorro partes del arbol pero no completo, es decir, es como
	 * si diera saltos al momento de recorrer para buscar e hijo izq del nodo
	 */
	
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

	public TDAABBF HijoDer() {
		return raiz.hijoDer;
	}

	public boolean ArbolVacio() {
		return raiz == null;
	}

	public void InicializarArbol() {
		raiz = null;
		
	}

	public void AgregarElem(int x) {
		if (raiz == null) {
			
			raiz = new NodoABBF();
			raiz.dato = x;
			
			raiz.hijoIzq = new ABBF();
			raiz.hijoIzq.InicializarArbol();
			
			raiz.hijoDer = new ABBF();
			raiz.hijoDer.InicializarArbol();
		}
		else if (raiz.dato > x)
			raiz.hijoIzq.AgregarElem(x);
		else if (raiz.dato < x)
			raiz.hijoDer.AgregarElem(x);
	}

	public void EliminarElem(int x) {
		if (raiz != null) {
			if (raiz.dato == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {
				raiz = null;
			}
			else if (raiz.dato == x && !raiz.hijoIzq.ArbolVacio()) {
				raiz.dato = this.mayor(raiz.hijoIzq);
				raiz.hijoIzq.EliminarElem(raiz.dato);
			}
			else if (raiz.dato == x && raiz.hijoIzq.ArbolVacio()) {
				raiz.dato = this.menor(raiz.hijoDer);
				raiz.hijoDer.EliminarElem(raiz.dato);
			}
			else if (raiz.dato < x) {
				raiz.hijoDer.EliminarElem(x);
			}
			else {
				raiz.hijoIzq.EliminarElem(x);
			}
		}
	}
	
	private int mayor(TDAABBF a) {
		if (a.HijoDer().ArbolVacio())
			return a.Raiz();
		else
			return mayor(a.HijoDer());
	}
	
	private int menor(TDAABBF a) {
		if (a.HijoIzq().ArbolVacio())
			return a.Raiz();
		else
			return menor(a.HijoIzq());
	}
	
	
	// Metodo para que dado un nodo (que esta presente en el ABB), 
    // se obtenga el padre de este.
	public NodoABBF PadreInmediato(NodoABBF n) {
		if(raiz == null || raiz == n) { //si esta vacio o no lo encuentra, devuelve null
			return null;
		} 
		// asumimos q no es la raiz del arbol
		if (raiz.hijoDer == n || raiz.hijoIzq == n) {
			return raiz;
		}
		else if (raiz.dato > n.dato){
			return raiz.hijoIzq.PadreInmediato(n);
		}
		else {
			return raiz.hijoDer.PadreInmediato(n);
		}
	}
	
	public TDAABBF PadreInmediato2(TDAABBF t) {
		if(t.ArbolVacio() || raiz.dato == t.Raiz()) { //si el arbol esta vacio no lo encuentra y devuelve null
			return null;
		} 
		// asumimos q no es la raiz del arbol
		if (raiz.hijoDer == t || raiz.hijoIzq == t) {
			return (TDAABBF) raiz;
		}
		else if (raiz.dato > t.Raiz()){
			return PadreInmediato2(raiz.hijoIzq);
		}
		else {
			return PadreInmediato2 (raiz.hijoDer);
		}
	}
	
	/*
	 * ESTRATEGIA
	 * primero verifico si la raiz del arbol es nula, esto quiere decir que esta vacio, o si raiz es igual al nodo, lo que
	 * quiere decir que no tiene padre, en este caso retorno null porque no existe el padre
	 * despues, si el hijo derecho o el hijo izquierdo es igual al nodo, entonces devuelvo la raiz que seria el padre
	 * de no ser asi, verifico si el valor del dato del nodo es menor que el valor de mi raiz,
	 * de ser asi llamo recursivamente a la funcion con el lado izquierdo del arbol debido a que de ese lado estan los menores
	 * de lo contrario, quiere decir que el dato del nodo es mayor al dato de la raiz, por lo tanto llamo  recursivamente a la funcion 
	 * con el lado derecho del arbol debido a que de ese lado estan los mayores, y asi hasta conseguir el padre o terminar de recorrer el arbol
	 * 
	 * 
	 * 
	 * 
	 * COSTO
	 * el costo es logaritmico porque recorro partes del arbol pero no completo, es decir, es como
	 * si diera saltos al momento de recorrer
	 */
	
		

}
