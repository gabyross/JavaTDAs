package tda.colas;

public class ColaPU implements ColaTDA {
	int[] arr;
	int inx;
	
	public void InicializarCola() {
		arr = new int[100];
		inx = 0;
	}
	
	public void Acolar(int x) {
		for(int i=inx-1;i>=0;i--) {
			arr[i+1]=arr[i];
		}
		arr[0]=x;
		inx++;
	}
	
	public void Desacolar() {
		inx--;
	}
	
	public boolean ColaVacia() {
		return (inx==0);
	}
	
	public int Primero() {
		return arr[inx-1];
	}

	
	// APARTE DEL TDA ORIGINAL
	public String Mostrarcola() {   // Metodo extra para ver los elementos de la cola
        String cola = ""; // string que contiene la cola
        
        for (int i = 0; i < inx; i++) {
            cola = cola + (arr[i] + ","); // concatena los elementos de la cola
        }
        cola = "[" + (cola.substring(0, cola.length() - 1)) + "]"; // quita la coma del final de la cola y lo muestra como un array
        return cola;    // Se muestra de izquierda a derecha [ultimo, medio, primero]
    }

    public void Multidesacolar(int x) { // Metodo extra para desacolar x elementos

		while (!ColaVacia() && x > 0) {	// si la cola no esta vacia
			Desacolar();
			x--;
		}
	 }
}
