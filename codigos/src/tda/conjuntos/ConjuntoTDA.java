package tda.conjuntos;

public interface ConjuntoTDA {
	void InicializarConjunto();
	void Agregar(int x);
	int Elegir();
	boolean ConjuntoVacio();
	void Sacar(int x);
	boolean Pertenece(int x);
	
	// APARTE DEL TDA ORIGINAL
	String Mostrarconjunto(); // metodo extra para ver la cola
    boolean TodosPertenecen(ConjuntoTDA origen); // metodo extra para verificar si un conjunto pertenece (simulacro)
    void SacarTodos(ConjuntoTDA origen); // metodo extra para sacar todos los elementos de un conjunto (simulacro)
}
