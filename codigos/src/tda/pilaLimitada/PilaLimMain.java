package tda.pilaLimitada;

public class PilaLimMain {
	
	// ------ APP -----
	public static void main(String[] args) {
		LimPilaTDA p = new PilaLimTF();
		p.InicializarPila(4);
		
		p.Apilar(1);
		p.Apilar(2);
		p.Apilar(3);
		p.Apilar(4);
		
		//MostrarPilaDejandolaVacia(p);
		
		System.out.println();
		
		p.Apilar(5);
		
		MostrarPilaDejandolaVacia(p);
		
		
		// -----------------------------
		
		/*
		 
		// crear pila limitada
        PilaLimitadaTF pila = new PilaLimitadaTF();
        pila.InicializarPila(4);

        // apilar elementos
        pila.Apilar(1);
        pila.Apilar(2);
        pila.Apilar(3);

        System.out.println(pila.PilaLlena());

        pila.Apilar(4);

        System.out.println(pila.PilaLlena());

        System.out.println(pila.Mostrarpila());

        System.out.println("holis");

        pila.Apilar(5);

        System.out.println(pila.Mostrarpila());

        pila.Apilar(6);

        System.out.println(pila.Mostrarpila());

        System.out.println(pila.Capacidad());

		 */
	}
	
	
	
	
	// ----- FUNCIONES ------
	// Mostar pila dejandola Vacia
		public static void MostrarPilaDejandolaVacia(LimPilaTDA origen) {
			while (!origen.PilaVacia())
			{
				System.out.println(origen.Tope());
				origen.Desapilar();
			}
		}
}
