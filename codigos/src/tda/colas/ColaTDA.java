package tda.colas;

public interface ColaTDA {
	void InicializarCola();
	void Acolar(int x);
	void Desacolar();
	boolean ColaVacia();
	int Primero();

	// APARTE DEL TDA ORIGINAL
    String Mostrarcola(); // metodo extra para ver la cola
    void Multidesacolar(int n); // pre: cola inicializada y no vacia
}
