package tda.listasDobles;

// ----- APP -----
public class ListasDMain{
	

	public static void main(String[] args) {
		ListaDobleTDA lista = new ListaDoble();
        lista.InicializarLista();
        lista.AgregarAlFinal(2);
        lista.AgregarAlFinal(1);
        lista.AgregarAlFinal(4);
        lista.AgregarAlFinal(3);
        
        lista.mostrar();
        
        
        /*listaDobleEnlazada lista = new listaDobleEnlazada();
        lista.inicializarListaDoble();
        lista.agregarF(2);
        lista.agregarF(1);
        lista.agregarF(4);
        lista.agregarF(3);
        listaDobleEnlazada lista2 = new listaDobleEnlazada();
        lista2.inicializarListaDoble();
        lista2.agregarF(2);
        lista2.agregarF(1);
        lista2.agregarF(4);
        lista2.agregarF(3);
        
        lista.mostrar();
        lista.ordenar();
        lista.mostrar(); */


        NodoD uno = new NodoD();
        NodoD dos = new NodoD();
        NodoD tres = new NodoD();
        NodoD cuatro = new NodoD();

        uno.dato = 1;
        uno.sig = dos;
        uno.prev = null;

        dos.dato = 2;
        dos.sig = tres;
        dos.prev = uno;

        tres.dato = 3;
        tres.sig = cuatro;
        tres.prev = dos;

        cuatro.dato = 4;
        cuatro.sig = null;
        cuatro.prev = tres;

        //agregarNodo(uno, cuatro, 1);

        //mostrar(uno);
        eliminarNodo(uno, cuatro, 4);
	}
	
	
	
	
	
	// ----- FUNCIONES -----
	// crear una funcion para imprimir lista tomando como parametro el nodo origen ---------------
    public static void mostrar(NodoD cabeza) {
        NodoD aux = new NodoD();
        aux = cabeza;
        System.out.println("-");
        while (aux != null) {   // mientras el nodo no sea null imprime el dato
            System.out.println(aux.dato);
            aux = aux.sig;
        }
        System.out.println("-");
    }

   
    // crear una funcion para agregar y otra para eliminar un elemento a una lista doblemente enlazada, ---------------
    // que tome como entrada los elementos cabeza y cola (Simulacro 1 Ej 1)
    public static NodoD agregarNodo(NodoD cabeza, NodoD cola, int valor) {
        NodoD nuevo = new NodoD();
        nuevo.dato = valor;
        nuevo.prev = null;  // se inicializa prev a null para que se agregue al inicio

        mostrar(cabeza); // mostrar la lista antes de agregar

        if (cabeza == null && cola == null) { // si la lista esta vacia
            nuevo.sig = null;
            cola = nuevo;

        }

        if (cabeza == cola){    // si la lista tiene un solo elemento
            nuevo.sig = cola;
            cola.prev = nuevo;

        } else {    // si la lista tiene mas de un elemento
            nuevo.sig = cabeza;
            cabeza.prev = nuevo;
            
        }

        cabeza = nuevo;
        
        mostrar(cabeza); // mostrar la lista
        return nuevo;
    }

    public static NodoD eliminarNodo(NodoD cabeza, NodoD cola, int valor) {
        NodoD aux = new NodoD();

        mostrar(cabeza); // mostrar la lista antes de eliminar

        if (cabeza == cola && cabeza != null) { // si la lista tiene un solo elemento
            cabeza = null;
            cola = null;

        } else if (cabeza.dato == valor) { // si el valor es el primero
            cabeza = cabeza.sig;
            cabeza.prev = null;

        } else {
            aux = cabeza;

            while (aux.sig != null && aux.dato != valor) { // mientras el siguiente nodo no sea null, y no se haya encontrado el dato avanza
                aux = aux.sig;
            }

            if (aux.dato == valor && aux.sig == null) { // si se encontro el dato en el ultimo nodo
                cola = aux.prev;
                cola.sig = null;

            } else if (aux.dato == valor && aux.sig != null) { // si se encontro el dato en un nodo intermedio
                (aux.prev).sig = aux.sig;
                (aux.sig).prev = aux.prev;

            } else { // si no se encontro el dato
                System.out.println("No se encontro el dato");
            }
        }

        mostrar(cabeza); // mostrar la lista
        return cabeza;
    }

    // crear una funcion para eliminar un nodo de una lista doblemente enlazada - Ejercicio 2 Simulacro 7 Parcial 1 ---------------
    public static NodoD EliminarNodo(NodoD origen, int x) {
        NodoD aux = new NodoD();    // nodo auxiliar para recorrer la lista
        aux = origen;

        if (origen == null) {   // si la lista esta vacia
            System.out.println("Lista vacia");
        } else {
            if (origen.dato == x) { // si el valor es el primero
                origen = origen.sig;
                origen.prev = null;
            } else {    // si el valor no es el primero
                while (aux.sig != null && aux.dato != x) {  // recorro la lista hasta encontrar el valor o hasta que llegue al final (parado en el nodo a eliminar) 
                    aux = aux.sig;
                }
                if (aux.dato == x) {    // si se encontro el valor
                    (aux.prev).sig = aux.sig; // se elimina el nodo
                    (aux.sig).prev = aux.prev;    // se elimina el nodo
                } else {
                    System.out.println("No se encontro el dato");   // si no se encontro el valor
                }
            }
        }
        return origen;
    }


}
