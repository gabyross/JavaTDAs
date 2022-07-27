package tda.colasPrioridad;

public class ColaPrioridadLD implements ColaPrioridadTDA {
	class NodoPrioridad {
		int info;
		int prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad primero;
	
	public void InicializarCola() {
		primero=null;
	}
	
	public void AcolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info=x;
		nuevo.prioridad=prioridad;
		if (primero == null || primero.prioridad<prioridad){
			nuevo.sig=primero;
			primero=nuevo;
		} else {
			NodoPrioridad aux = primero;
			while (aux.sig!=null && aux.sig.prioridad>prioridad) {
				aux=aux.sig;
			}
			nuevo.sig=aux.sig;
			aux.sig=nuevo;
		}
	}
	
	public void Desacolar() {
		primero=primero.sig;
	}
	public boolean ColaVacia() {
		return(primero==null);
	}
	public int Primero() {
		return primero.info;
	}
	public int Prioridad() {
		return primero.prioridad;
	}

	
	// APARTE DEL TDA ORIGINAL
	
	public String MostrarcolaPrioridad() {	// Metodo extra para ver los elementos de la cola
		String cola = ""; // string que contiene la cola
		NodoPrioridad aux = primero;
		
		while (aux != null) {
			cola = cola + (aux.info + ","); // concatena los elementos de la cola
			aux = aux.sig;
		}
		cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra omo un array
		return cola; // Se muestra de derecha a izquierda [primero, medio, ultimo]
	}
}
