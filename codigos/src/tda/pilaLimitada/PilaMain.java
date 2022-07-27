package tda.pilaLimitada;
public class PilaMain {

	// Mostar pila dejandola Vacia
	public static void MostrarPilaDejandolaVacia(LimPilaTDA origen) {
		while (!origen.PilaVacia())
		{
			System.out.println(origen.Tope());
			origen.Desapilar();
		}
	}
	
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
	}
}
