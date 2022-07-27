package tda.colasPrioridad;

public class ColaPrioridadAO implements ColaPrioridadTDA{
	Elemento[] elementos;
	int indice;
	
	public void InicializarCola() {
		elementos = new Elemento[100];
		indice = 0;
	}
	
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		while(j>0 && elementos[j-1].prioridad>prioridad) {
			elementos[j]=elementos[j-1];
			j--;
		}
		elementos[j]=new Elemento();
		elementos[j].valor=x;
		elementos[j].prioridad=prioridad;
		indice++;
	}
	
	public void Desacolar() {
		indice--;
	}
	
	public boolean ColaVacia() {
		return(indice==0);
	}
	
	public int Primero() {
		return elementos[indice-1].valor;
	}
	
	public int Prioridad() {
		return elementos[indice-1].prioridad;
	}

	
	// APARTE DEL TDA ORIGINAL
	public String MostrarcolaPrioridad() {  // Metodo extra para ver los elementos de la cola
        String cola = ""; // string que contiene la cola

        for (int i = 0; i < indice; i++) {
            cola = cola + (elementos[i].valor + ","); // concatena los elementos de la cola
        }
        cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra como un array
        return cola; // Se muestra de izquierda a derecha [ultimo, medio, primero]
    }
}
