package tda.listas;

import tda.listas.*;
import tda.listasDobles.NodoD;

public class Lista implements ListaTDA{
	Nodo origen = new Nodo();
	Nodo nodoFinal = new Nodo();
	

	public void InicializarLista() {
		origen = null;
		nodoFinal = origen;
	}
	
	public void MostrarLista(Nodo u) {
		Nodo aux = new Nodo();
		aux = u;
		System.out.print("[");
		while (aux != null) {
			System.out.print("aux.dato");
			aux = aux.sig;
			if (aux != null)
			{
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}

	public boolean ListaVacia() {
		return (origen != null);
	}

	public void AgregarAlFinal(int num) {
		Nodo nuevo = new Nodo();
        nuevo.dato = num;
        nuevo.sig = null; // el nuevo nodo apunta a null para que sea el ultimo
   
        if (this.origen == null) { // si la lista esta vacia, el nuevo nodo sera el origen

            this.origen = nuevo;

        } else {

            Nodo aux = this.origen;

            while (aux.sig != null) { // mientras el siguiente nodo no sea null, avanza

                aux = aux.sig;

            }

            aux.sig = nuevo; // el ultimo nodo apunta al nuevo nodo
        
            nodoFinal = nuevo;
        }
	}
	
	public Nodo AgregarF(Nodo u, int num) {
		Nodo nuevoNodo = new Nodo();
		nuevoNodo.dato = num;
		nuevoNodo.sig = null;
		
		if (u == null)
		{
			u = nuevoNodo;
		}
		else
		{
			Nodo aux = new Nodo();
			aux = u;
			while (aux.sig != null) {
				aux = aux.sig;
			}
			aux.sig = nuevoNodo;
		}
		
		return u;
	}
	
	public Nodo AgregarAlInicio(Nodo u, int num) {
		Nodo nuevoNodo = new Nodo();
		nuevoNodo.dato = num;
		nuevoNodo.sig = u;
		
		return nuevoNodo;
	}

	public void EliminarValor(int num) {
		if (origen.dato == num) 
		{
			origen = origen.sig;
		}
		else
		{
			Nodo aux = new Nodo();
			aux = origen;
			while (aux.sig != null && aux.sig.dato != num)
			{
				aux = aux.sig;
			}
			if (aux.sig != null)
				aux.sig = aux.sig.sig;
			else
				System.out.println("No se encuentra en la lista");
		}
		
	}

	public void eliminarPos(int pos) {

        // si la lista esta vacia, no se puede eliminar
        if (this.ListaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a
            // eliminar
            Nodo aux = new Nodo();
            aux = this.origen;

            if (pos == 0) { // si se quiere eliminar el primer nodo de la lista

                if (this.origen.sig == null) { // si  hay un solo elemento en la lista, eliminar origen

                    origen = null;
                
                } else { // si hay mas de un elemento en la lista, se cambia el origen por el siguiente

                    this.origen = aux.sig;
                }

            } else {

                for (int i = 0; i < pos - 1; i++) { // se recorre la lista hasta encontrar el nodo anterior al que se
                                                    // quiere eliminar
                    aux = aux.sig;
                }
                // se elimina el nodo
                aux.sig = aux.sig.sig; // el nodo anterior apunta al siguiente del nodo a eliminar

            }

        }
    }
	
	public int Obtener(int num) {
		int indice = -1;
		int counter = 0;
		if (origen.dato == num) 
		{
			indice = 0;
		}
		else
		{
			Nodo aux = new Nodo();
			aux = origen;
			while (aux.sig != null && aux.sig.dato != num)
			{
				aux = aux.sig;
				counter++;
			}
			if (aux.sig != null)
				indice = counter;
			else
				System.out.println("No se encuentra en la lista");
		}
		return indice;
	}

	public void Insertar(int num, int pos) {
		Nodo nuevoNodo = new Nodo();
		int counter = 0;
		if (origen.dato == num) 
		{
			origen = origen.sig;
		}
		else
		{
			Nodo aux = new Nodo();
			aux = origen;
			while (aux.sig != null && counter != pos)
			{
				aux = aux.sig;
			}
			if (aux.sig != null) {
				nuevoNodo = aux.sig;
				aux.sig = nuevoNodo;
			}
				
			else
				System.out.println("No se encuentra en la lista");
		}
		
	}

	public Nodo Buscar(int num) {
		Nodo aux = new Nodo();
		aux = origen;
		while (aux != null && aux.dato != num) {
			aux = aux.sig;
		}
		return aux;
	}
	
	public void mostrar() {

        // si la lista esta vacia, no se puede imprimir
        if (this.ListaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a
            // imprimir
            Nodo aux = new Nodo();
            aux = this.origen;
            System.out.print("[");
            while (aux.sig != null) {
                System.out.print(aux.dato + "-");
                aux = aux.sig;
            }
            System.out.print(aux.dato + "]");

        }

    }
	
	public void ordenar() {

        // ordenar lista por valor ascendente

        if (this.ListaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // ordenar elementos de la lista por valor ascendente (ord por metodo burbujeo) 
            Nodo aux = new Nodo();
            aux = this.origen;
            int aux2;
            boolean cambio = true;

            while (cambio) { // mientras haya cambios en el orden de los elementos

                cambio = false;
                while (aux.sig != null) { // recorre la lista hasta encontrar el ultimo elemento

                    if (aux.dato > aux.sig.dato) { // si el elemento actual es mayor que el siguiente

                        aux2 = aux.dato;  // se invierte el orden de los elementos
                        aux.dato = aux.sig.dato;    
                        aux.sig.dato = aux2;
                        cambio = true;  // se cambio el orden de los elementos

                    }
                    aux = aux.sig; // se avanza al siguiente nodo

                }
                aux = this.origen; // se vuelve al primer nodo de la lista
            }
        }
    }
}