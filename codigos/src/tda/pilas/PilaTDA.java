package tda.pilas;

public interface PilaTDA {
	void InicializarPila();
	void Apilar(int x);
	void Desapilar();
	boolean PilaVacia();
	int Tope();
	
	// APARTE DEL TDA ORIGINAL
	String Mostrarpila(); // metodo extra para ver la cola
}
