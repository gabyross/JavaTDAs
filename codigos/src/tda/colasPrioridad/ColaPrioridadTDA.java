package tda.colasPrioridad;

public interface ColaPrioridadTDA {
	void InicializarCola();
	void AcolarPrioridad(int x, int prioridad);
	void Desacolar();
	boolean ColaVacia();
	int Primero();
	int Prioridad();
	
	// APARTE DEL TDA ORIGINAL
	String MostrarcolaPrioridad(); // metodo extra para ver la cola
}
