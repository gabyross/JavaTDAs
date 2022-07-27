package tda.listasDobles;


public class ListaDoble implements ListaDobleTDA{
	NodoD origen = new NodoD();
	NodoD nodoFinal = new NodoD();
	

	public void InicializarLista() {
		origen = null;
		nodoFinal = origen;
	}
	
	public void mostrar() {
		mostrarSig();
		mostrarPrev();
	}

	public boolean ListaVacia() {
		return origen == null;
	}

	public void AgregarAlFinal(int num) {
		NodoD nuevo = new NodoD();
        nuevo.dato = num;
        nuevo.sig = null; // el nuevo nodo apunta a null para que sea el ultimo
   
        if (this.origen == null) { // si la lista esta vacia, el nuevo nodo sera el origen

            this.origen = nuevo;

        } else {

            NodoD aux = this.origen;

            while (aux.sig != null) { // mientras el siguiente nodo no sea null, avanza

                aux = aux.sig;

            }

            aux.sig = nuevo; // el ultimo nodo apunta al nuevo nodo
            nuevo.prev = aux; // el nuevo nodo apunta al ultimo nodo
            
            nodoFinal = nuevo;
        }
	}
	
	public NodoD AgregarF(NodoD u, int num) {
		NodoD nuevoNodo = new NodoD();
		nuevoNodo.dato = num;
		nuevoNodo.sig = null;
		
		if (u == null)
		{
			u = nuevoNodo;
		}
		else
		{
			NodoD aux = new NodoD();
			aux = u;
			while (aux.sig != null) {
				aux = aux.sig;
			}
			nuevoNodo.prev = aux;
			aux.sig = nuevoNodo;
		}
		
		return u;
	}
	
	public NodoD AgregarAlInicio(NodoD u, int num) {
		NodoD nuevoNodo = new NodoD();
		nuevoNodo.dato = num;
		
		u.prev = nuevoNodo;
		
		nuevoNodo.sig = u;
		
		return nuevoNodo;
	}

	public void Eliminar(int num) {
		if (origen.dato == num) 
		{
			origen.sig.prev = null;
			origen = origen.sig;
		}
		else
		{
			NodoD aux = new NodoD();
			aux = origen;
			while (aux.sig != null && aux.sig.dato != num)
			{
				aux = aux.sig;
			}
			if (aux.sig != null) {
				aux.sig.sig.prev = aux;
				aux.sig = aux.sig.sig;
			}
			else
				System.out.println("No se encuentra en la lista");
		}
		
	}
	
	public void EliminarD(NodoD cabeza, NodoD cola, int num) {
		if (cabeza != origen || cola != nodoFinal) {
			System.out.println("Lista incorrecta");
		}
		else {
			if (origen.dato == num) 
			{
				origen.sig.prev = null;
				origen = origen.sig;
			}
			else
			{
				NodoD aux = new NodoD();
				aux = origen;
				while (aux.sig != null && aux.sig.dato != num)
				{
					aux = aux.sig;
				}
				if (aux.sig != null) {
					aux.sig.sig.prev = aux;
					aux.sig = aux.sig.sig;
				}
				else
					System.out.println("No se encuentra en la lista");
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
			NodoD aux = new NodoD();
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
		NodoD nuevoNodo = new NodoD();
		int counter = 0;
		if (origen.dato == num) 
		{
			origen = origen.sig;
		}
		else
		{
			NodoD aux = new NodoD();
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

	public NodoD Buscar(int num) {
		NodoD aux = new NodoD();
		aux = origen;
		while (aux != null && aux.dato != num) {
			aux = aux.sig;
		}
		return aux;
	}
	
	public void mostrarSig() {

        // si la lista esta vacia, no se puede imprimir
        if (this.ListaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a
            // imprimir
            NodoD aux = new NodoD();
            aux = this.origen;
            System.out.print("[");
            while (aux.sig != null) {
                System.out.print(aux.dato + "-");
                aux = aux.sig;
            }
            System.out.print(aux.dato + "]");

        }

    }
	
	public void mostrarPrev() {

        // si la lista esta vacia, no se puede imprimir
        if (this.ListaVacia()) {

            System.out.println("La lista esta vacia");

        } else {

            // si la lista no esta vacia, se recorre la lista hasta encontrar el nodo a
            // imprimir
            NodoD aux = new NodoD();
            aux = this.nodoFinal;
            System.out.print("[");
            while (aux.prev != null) {
                System.out.print(aux.dato + "-");
                aux = aux.prev;
            }
            System.out.print(aux.dato + "]");

        }

    }
}