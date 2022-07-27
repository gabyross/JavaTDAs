package tda.listasDobles;


public interface ListaDobleTDA {
	void InicializarLista();
	boolean ListaVacia();
	void AgregarAlFinal(int num);
	NodoD AgregarF(NodoD u, int num);
	NodoD AgregarAlInicio(NodoD u, int num);
	void Eliminar(int num);
	void EliminarD(NodoD cabeza, NodoD cola, int num);
	int Obtener(int num);
	void Insertar(int num, int pos);
	NodoD Buscar(int num);
	void mostrar();
}
