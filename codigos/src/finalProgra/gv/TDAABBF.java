package finalProgra.gv;

public interface TDAABBF {
	// siempre que el arbol este inicializado y no este vacio
	int Raiz();

	// siempre que el arbol este inicializado y no este vacio
	TDAABBF HijoIzq();
	
	TDAABBF HijoIzq2(NodoABBF n);

	// siempre que el arbol este inicializado y no este vacio
	TDAABBF HijoDer();

	// siempre que el arbol este inicializado
	boolean ArbolVacio();

	void InicializarArbol();

	// siempre que el arbol este inicializado
	void AgregarElem(int x);
	
	// siempre que el arbol este inicializado
	void EliminarElem(int x);
	
	NodoABBF PadreInmediato(NodoABBF n);
	
	TDAABBF PadreInmediato2(TDAABBF n);

}
