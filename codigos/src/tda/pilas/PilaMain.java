package tda.pilas;
public class PilaMain {

	// Mostar pila dejandola Vacia
	public static void MostrarPilaDejandolaVacia(PilaTDA origen) {
		while (!origen.PilaVacia())
		{
			System.out.println(origen.Tope());
			origen.Desapilar();
		}
	}
	
	// Pasar una Pila a otra (dejándola en orden inverso)
	public static void PasarPilaAlRevez(PilaTDA origen, PilaTDA destino) {
		while (!origen.PilaVacia())
		{
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
	}
	
	
	
	// Pasar una Pila a otra (dejándola en orden)
	public static void PasarPilaOrdenada(PilaTDA origen, PilaTDA destino) {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		
		// Se pasa invertida a un auxiliar
		PasarPilaAlRevez(origen, aux);
		// Se pasa ordenada a la de destino
		PasarPilaAlRevez(aux, destino);
		
		/*
		 * while (!origen.PilaVacia()) { destinoAux.Apilar(origen.Tope());
		 * origen.Desapilar(); }
		 * 
		 * while (!destinoAux.PilaVacia()) { destino.Apilar(destinoAux.Tope());
		 * destinoAux.Desapilar(); }
		 */
	}
	
	
	
	// Copiar una Pila en otra (dejándola en el mismo orden que la original)
	public static void CopiarPilaOrdenada(PilaTDA origen, PilaTDA copia) {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		
		// Se pasa la pila invertida a un auxiliar
		while (!origen.PilaVacia())
		{
			aux.Apilar(origen.Tope());
			origen.Desapilar();
		}
		
		// Se pasa la pila ordenada a la original y copia
		while (!aux.PilaVacia())
		{
			origen.Apilar(aux.Tope());
			copia.Apilar(aux.Tope());
			aux.Desapilar();
		}
	}
	
	
	
	// Invertir el contenido de una Pila
	public static void InvertirPila(PilaTDA origen) {
		PilaTDA aux1 = new PilaTF();
		aux1.InicializarPila();
		
		PilaTDA aux2 = new PilaTF();
		aux2.InicializarPila();
		
		// Se invierte la pila en una nueva y queda vacia la origen
		PasarPilaAlRevez(origen, aux1);
		// queda ordenada la pila aux2
		PasarPilaAlRevez(aux1, aux2);
		// queda invertida la pila origen
		PasarPilaAlRevez(aux2, origen);
	}
	
	
	
	// Contar los elementos de una Pila (dejando la pila no vacia y en orden)
	public static int ContarElementos(PilaTDA origen) {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		
		PasarPilaAlRevez(origen, aux);
		
		int counter = 0;
		
		while (!aux.PilaVacia())
		{
			counter++;
			origen.Apilar(aux.Tope());
			aux.Desapilar();
		}
		
		return counter;
	}
	
	
	
	// Sumar los elementos de una Pila (sin dejarla vacia)
	public static int SumarElementos(PilaTDA origen) {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		
		PasarPilaAlRevez(origen, aux);
		
		int suma = 0;
		
		while (!aux.PilaVacia())
		{
			suma += aux.Tope();
			origen.Apilar(aux.Tope());
			aux.Desapilar();
		}
		
		return suma;
	}
	
	
	
	//Calcular el promedio de los elementos de una Pila
	public static int CalcularPromDeLosElem(PilaTDA origen) {
		PilaTDA aux = new PilaTF();
		aux.InicializarPila();
		
		int cantElem = ContarElementos(origen);
		int sumElem = SumarElementos(origen);
		
		int promedio = sumElem/cantElem;
		
		return promedio;
	}
	
	
	
	public static void main(String[] args) {
		PilaTDA p = new PilaTF();
		p.InicializarPila();
		
		PilaTDA p2 = new PilaTF();
		p2.InicializarPila();
		
		p.Apilar(1);
		p.Apilar(2);
		p.Apilar(3);
		
		
		//PasarPilaAlRevez(p, p2);
		
		//PasarPilaOrdenada(p, p2);
		
		//CopiarPilaOrdenada(p, p2);
		
		//InvertirPila(p);
		
		//int cantElem = ContarElementos(p);
		//System.out.println(cantElem);
		
		//int sumElem = SumarElementos(p);
		//System.out.println(sumElem);
		
		//int PromDeElem = CalcularPromDeLosElem(p);
		//System.out.println(PromDeElem);
		
		//MostrarPilaDejandolaVacia(p2);
		//MostrarPilaDejandolaVacia(p);
	}
}
