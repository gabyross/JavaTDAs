package finalProgra.gv;

//import tda.abb.TDAABB;

// ----- APP -----
public class ej3{
	

	public static void main(String[] args) {
		TDAABBF arbol = new ABBF();
        arbol.InicializarArbol();
        arbol.AgregarElem(6);
        arbol.AgregarElem(3);
        arbol.AgregarElem(4);
        arbol.AgregarElem(2);
        arbol.AgregarElem(1);
        arbol.AgregarElem(5);
        
        
        TDAABBF aIzq = new ABBF();
        aIzq.AgregarElem(2);
        aIzq.AgregarElem(1);
        finalProgra.gv.NodoABBF nodo = null;
        nodo.dato = 4;
        nodo.hijoIzq.InicializarArbol();
        nodo.hijoIzq = aIzq;
        
        TDAABBF aDer = new ABBF();
        aIzq.AgregarElem(5);
        nodo.hijoDer.InicializarArbol();
        nodo.hijoDer = aDer;
        
        //NodoABBF n = arbol.PadreInmediato(nodo);
        //TDAABBF n2 = arbol.PadreInmediato2(aIzq);
        //System.out.println(n.dato);
        //inOrder(n.hijoIzq);
        //inOrder(n.hijoDer);
        
        TDAABBF a = arbol.HijoIzq2(nodo);
        inOrder(a);
	}
	
	
	// ------ FUNCIONES ------
	// va en orden creciente
	public static void inOrder(TDAABBF a) {
		if (!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}
	
	public static class NodoABBF {
		int dato;
		TDAABBF hijoIzq;
		TDAABBF hijoDer;
	}
}
