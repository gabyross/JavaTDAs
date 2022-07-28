package tda.pilas;

public class PilaTI implements PilaTDA {
	int[] arr;
	int inx;
	
	public void InicializarPila() {
		arr = new int[100];
		inx = 0;
	}
	public void Apilar(int x) {
		for(int i=inx-1;i>=0;i--) {
			arr[i+1]=arr[i];
		}
		arr[0]=x;
		inx++;
	}
	public void Desapilar() {
		for(int i = 0;i<inx;i++) {
			arr[i]=arr[i+1];
		}
		inx--;
	}
	public boolean PilaVacia() {
		return(inx==0);
	}
	public int Tope() {
		return arr[0];
	}

	// APARTE DEL TDA ORIGINAL
	public String Mostrarpila() {      // Metodo extra para ver los elementos de la pila
		
		String pila = ""; // string que contiene la pila
        for (int i = 0; i < inx; i++) {
            pila = pila + (arr[i] + ","); // concatena los elementos de la pila
        }
        pila = "[" + (pila.substring(0, pila.length() - 1)) + "]"; // quita la coma del final de la pila y lo muestra
                                                                     // como un array
        return pila; // Se muestra de izquierda a derecha [ultimo, medio, primero]
		
	}
}
