package tda.listas;


public interface ListaTDA {
	void InicializarLista(); // pre: lista creada
	void MostrarLista(Nodo u); // pre: lista creada
	boolean ListaVacia(); // pre: lista inicializada
	
	void AgregarAlFinal(int num);
	
	Nodo AgregarAlInicio(Nodo u, int num);
	
	Nodo AgregarF(Nodo u, int num); //pre: lista inicializada
	void eliminarPos(int pos); // pre: lista inicializada y no vacia
	void EliminarValor(int num); // pre: lista inicializada y no vacia
	int Obtener(int num); // pre: lista inicializada y no vacia
	void Insertar(int num, int pos); // pre: lista inicializada
	Nodo Buscar(int num); // pre: lista inicializada y no vacia
	void mostrar(); // pre: lista inicializada y no vacia
	void ordenar(); // pre: lista inicializada y no vacia
}
