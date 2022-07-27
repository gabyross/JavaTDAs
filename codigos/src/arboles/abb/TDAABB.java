package arboles.abb;

public interface TDAABB {
	// siempre que el arbol este inicializado y no este vacio
	int Raiz();

	// siempre que el arbol este inicializado y no este vacio
	TDAABB HijoIzq();

	// siempre que el arbol este inicializado y no este vacio
	TDAABB HijoDer();

	// siempre que el arbol este inicializado
	boolean ArbolVacio();

	void InicializarArbol();

	// siempre que el arbol este inicializado
	void AgregarElem(int x);
	
	// siempre que el arbol este inicializado
	void EliminarElem(int x);

}
