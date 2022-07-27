package tda.colas;

//-----  IMPORTACIONES  -----
import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;
import tda.conjuntos.*;





//-----  APP  -----

public class ColaMain{
	public static void main(String[] args) {
		ColaTDA c = new ColaPU();
		c.InicializarCola();
		
		ColaTDA c2 = new ColaPU();
		c2.InicializarCola();
		
		c.Acolar(1);
		c.Acolar(2);
		c.Acolar(1);
		
		c2.Acolar(1);
		c2.Acolar(4);
		c2.Acolar(3);
		
		
		
		ColaTDA c1 = new ColaPU();
		c1.InicializarCola();
		
		ColaTDA c3 = new ColaPU();
		c3.InicializarCola();
		
		c1.Acolar(1);
		c1.Acolar(7);
		c1.Acolar(5);
		c1.Acolar(9);
		c1.Acolar(1);
		c1.Acolar(2);
		c1.Acolar(8);
		
		c3.Acolar(5);
		c3.Acolar(10);
		c3.Acolar(3);
		c3.Acolar(3);
		
		//InvertirCola(c);
		//System.out.println(CoincideFinal(c, c2));
		//System.out.println(ColaCapicua(c));
		//MostrarColaDejandolaVacia(c);
		
		ColaTDA cola = new ColaPU();
		cola.InicializarCola();
		cola = ConcatenarColas(c1, c3);
		//MostrarCola(cola);
		
		ColaTDA col = new ColaPU();
		col.InicializarCola();
		col = IntercalarColas(c1, c3);
		MostrarCola(col);
		
		
		
		
		//--------------------------
		/*// crete a new ColaPU object
        ColaTDA cola = new ColaLD();
        // inicializar cola
        cola.InicializarCola();
        // Acolar los elementos 1 2 3 4 5 6 7 8 9 10
        cola.Acolar(1);
        cola.Acolar(2);
        cola.Acolar(3);
        cola.Acolar(4);
        cola.Acolar(5);
        cola.Desacolar();
        // mostrar cola
        System.out.println(cola.Mostrarcola());
        System.out.println(cola.Primero());
        System.out.println(mostrarCola(cola));
        System.out.println(cola.Primero());*/

		/*// simulacro
		ColaTDA origen = new ColaPI();
		origen.InicializarCola();
		origen.Acolar(1);
		origen.Acolar(2);
		origen.Acolar(2);
		origen.Acolar(2);
		origen.Acolar(3);
		origen.Acolar(1);
		origen.Acolar(3);
		origen.Acolar(5);
		origen.Acolar(3);
		origen.Acolar(3);
		origen.Acolar(2);
		origen.Multidesacolar(9);
		mostrarCola(origen);*/
		/*System.out.println("HOLA");
		EliminarRepetidosConcurrentes(origen);
		mostrarCola(origen);*/

		// simulacro 2 final
		ColaTDA cola1 = new ColaPI();
		cola1.InicializarCola();

		cola1.Acolar(1);
		cola1.Acolar(3);
		cola1.Acolar(2);
		cola1.Acolar(5);
		cola1.Acolar(4);
		cola1.Acolar(3);
		cola1.Acolar(4);
		cola1.Acolar(5);
		cola1.Acolar(7);

		System.out.println(MaxSec(cola1));
		//---------------------------
	}
	
	
	
	
	
	// ----- FUNCIONES -----

	// Pasar una Pila a otra (dejándola en orden inverso)
	public static void PasarPilaAlRevez(PilaTDA origen, PilaTDA destino) {
		while (!origen.PilaVacia())
		{
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
	}
		
		
		
	// Mostrar Cola dejandola vacia
	public static void MostrarColaDejandolaVacia(ColaTDA origen) {
		while (!origen.ColaVacia())
		{
			System.out.print(origen.Primero() + " ");
			origen.Desacolar();
		}
	}
		
		
		
	// Pasar cola dejando vacia la original
	public static void PasarCola(ColaTDA origen, ColaTDA destino) {
		while (!origen.ColaVacia())
		{
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
	}
	
	
	
	// Pasar cola A CONJUNTO dejando vacia la original
	public static void PasarColaAConjunto(ColaTDA origen, ConjuntoTDA destino) {
		while (!origen.ColaVacia())
		{
			destino.Agregar(origen.Primero());
			origen.Desacolar();
		}
	}
	
	
	
	// Pasar cola sin dejar vacia la original
	public static void CopiarColaAConjunto(ColaTDA origen, ConjuntoTDA destino) {
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		
		while (!origen.ColaVacia())
		{
			aux.Acolar(origen.Primero());
			origen.Desacolar();
		}
		
		while (!aux.ColaVacia())
		{
			origen.Acolar(aux.Primero());
			destino.Agregar(aux.Primero());
			aux.Desacolar();
		}
	}
		
	
	
	// Pasar cola sin dejar vacia la original
	public static void CopiarCola(ColaTDA origen, ColaTDA destino) {
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		
		while (!origen.ColaVacia())
		{
			aux.Acolar(origen.Primero());
			origen.Desacolar();
		}
		
		while (!aux.ColaVacia())
		{
			origen.Acolar(aux.Primero());
			destino.Acolar(aux.Primero());
			aux.Desacolar();
		}
	}
	
	
	
	// Obtner el largo de una cola
	public static int ObtenerLargoCola(ColaTDA origen) {
		ColaTDA aux = new ColaPU();
		aux.InicializarCola();
		
		PasarCola(origen, aux);
		
		int largo = 0;
		
		while (!aux.ColaVacia())
		{
			largo++;
			origen.Acolar(aux.Primero());
			aux.Desacolar();
		}
		
		return largo;
	}
	
	
	
	// Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
		public static void InvertirCola (ColaTDA origen) {
			PilaTDA pAux = new PilaTF();
			pAux.InicializarPila();

			PilaTDA pAux2 = new PilaTF();
			pAux2.InicializarPila();
			
			int n = ObtenerLargoCola(origen);
			
			for (int i = 0; i < n; i++)
			{
				pAux.Apilar(origen.Primero());
				origen.Desacolar();
			}
			
			for (int i = 0; i < n; i++)
			{
				int num = pAux.Tope();
				origen.Acolar(num);
				pAux.Desapilar();
			}
		}
		
		
		
		// Invertir el contenido de una Cola (sin poder usarse Pilas auxiliares)
		public static void InvertirColaSinPila(ColaTDA origen) {
			ColaTDA aux = new ColaPU();
			aux.InicializarCola();
			
			ColaTDA aux2 = new ColaPU();
			aux2.InicializarCola();
			
			int n = ObtenerLargoCola(origen);
			//int lastNum = 0;

			int i = 0;
			int j = 0;
			
			while (i != n) {
				n = ObtenerLargoCola(origen);
				
				while (!aux2.ColaVacia())
				{
					
					if (j == n - 1)
					{
						aux.Acolar(origen.Primero());
					}
					else 
					{
						aux2.Acolar(origen.Primero());
						origen.Desacolar();
					}
				}
				PasarCola(aux2, origen);
				i++;
			}
			PasarCola(aux, origen);
		}
		
		
		
		//Determinar si el final de la Cola C1 coincide o no con la Cola C2. Sin dejarlas vacia
		public static boolean CoincideFinal(ColaTDA c1, ColaTDA c2) {
			boolean coincide = false;
			
			ColaTDA aux = new ColaPU();
			aux.InicializarCola();
			
			ColaTDA aux2 = new ColaPU();
			aux2.InicializarCola();
			
			CopiarCola(c1, aux);
			CopiarCola(c2, aux2);
			
			int n1 = ObtenerLargoCola(c1);
			int n2 = ObtenerLargoCola(c2);

			int i = 0;
			int j = 0;
			
			int lastNum1 = 1;
			int lastNum2 = -1;
			
			// consigo el ultimo numero de la primera cola
			while (i < n1) {

				if (i == ObtenerLargoCola(c1) - 1)
				{
					lastNum1 = aux.Primero();
				}
				else 
				{
					aux.Desacolar();
				}
				i++;
			}
			
			// consigo el ultimo numero de la segunda cola
			while (j < n2) {
				
				if (j == ObtenerLargoCola(c2) - 1)
				{
					lastNum2 = aux2.Primero();
				}
				else 
				{
					aux2.Desacolar();
				}
				j++;
			}
			
			if (lastNum1 == lastNum2)
			{
				coincide = true;
			}
			
			return coincide;
		}

		
		
		
		// Metodo para determinar si el final de la Cola C1 coincide o no con la Cola C2 -- MAS EFICIENTE
		public static boolean finalIguales(ColaTDA origen1, ColaTDA origen2) {
			int n1 = 0;
			int n2 = 0;

			while (!origen1.ColaVacia()) {		
				n1 = origen1.Primero();	// desacolo la cola origen1, y guardo el ultimo elemento en n1
				origen1.Desacolar();
			}

			while (!origen2.ColaVacia()) {
				n2 = origen2.Primero();	// desacolo la cola origen2, y guardo el ultimo elemento en n2
				origen2.Desacolar();
			}
			return (n1 == n2);	// retorna true si los elementos n1 y n2 son iguales
		}
		
		
		
		/*
		 * Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
		 * inversas, si tienen los mismos elementos pero en orden inverso
		 */
	
		//Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
		//que el primer elemento es igual al último, el segundo igual al penúltimo, etc
		public static boolean ColaCapicua(ColaTDA origen) {
			ColaTDA cInvertida = new ColaPU();
			cInvertida.InicializarCola();
			
			CopiarCola(origen, cInvertida);
			InvertirCola(cInvertida);
			
			boolean esCapicua = true;
			
			while (esCapicua && !origen.ColaVacia()) {
				if (origen.Primero() == cInvertida.Primero())
				{
					origen.Desacolar();
					cInvertida.Desacolar();}
				else 
				{
					esCapicua = false;
				}
			}
			
			return esCapicua;
		}
		
		
		// crear una funcion para determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir  ---------------
		// que el primer elemento es igual al último, el segundo igual al penúltimo, etc - TP1 Ejercicio 4e
		public static boolean esCapicua(ColaTDA origen) {
			PilaTDA aux = new PilaTF();		// crear una pila auxiliar
			ColaTDA aux2 = new ColaPU();	// crear una cola auxiliar
			aux.InicializarPila();
			aux2.InicializarCola();

			boolean capicua = false;

			while (!origen.ColaVacia()) {	
				aux.Apilar(origen.Primero());	// apilar en la pila auxiliar la cola origen (para invertir la cola)
				aux2.Acolar(origen.Primero());	// acolar en la cola auxiliar la cola origen (para comparar)
				origen.Desacolar();
			}

			while (!aux2.ColaVacia()) {
				if (aux.Tope() == aux2.Primero()) {	// si el tope de la pila auxiliar es igual al primer elemento de la cola auxiliar
					capicua = true;
				} else {
					capicua = false;
				}
				aux.Desapilar();
				aux2.Desacolar();
			}

			while (!aux2.ColaVacia()) {			// acolar en la cola auxiliar la cola origen (no perder el contenido)
				origen.Acolar(aux2.Primero());
				aux2.Desacolar();
			}
			return capicua;
		}
		
		
		
		//Escribir un método que devuelva la intercalación de dos colas (cola1 con cola2) de números enteros, 
		//respetando el orden original de cada una pero eliminando los valores repetidos. 
		//El método deberá generar una nueva cola y no se permite dejar las colas originales distintas a como se recibieron. 
		public static ColaTDA IntercalarColas(ColaTDA cola1, ColaTDA cola2) {
			ColaTDA c1 = new ColaPU();
			c1.InicializarCola();
			CopiarCola(cola1, c1);
			
			ColaTDA c2 = new ColaPU();
			c2.InicializarCola();
			CopiarCola(cola2, c2);
			
			ConjuntoTDA conj = new ConjuntoA();
			conj.InicializarConjunto();
			
			ColaTDA c = new ColaPU();
			c.InicializarCola();
			
			// me aseguro de intercalarlas hasta que una de las dos colas este vacia
			while (!c1.ColaVacia() && !c2.ColaVacia()) {
				boolean c1fueAgregado = false;
				
				while (!c1fueAgregado && !c1.ColaVacia()) {
					int x = c1.Primero();
					while (!conj.Pertenece(x)) {
						conj.Agregar(x);
						c.Acolar(x);
						c1fueAgregado = true;
					}
					c1.Desacolar();
				}
				
				boolean c2fueAgregado = false;
				while (!c2fueAgregado && !c2.ColaVacia()) {
					int y = c2.Primero();
					while (!conj.Pertenece(y)) {
						conj.Agregar(y);
						c.Acolar(y);
						c2fueAgregado = true;
					}
					c2.Desacolar();
				}
			}
			
			
			// si una cola se vacio pero la otra no, me aseguro de vaciarlas en orden
			while (!c1.ColaVacia()) {
				int x = c1.Primero();
				if (!conj.Pertenece(x)) {
					conj.Agregar(x);
					c.Acolar(x);
				}
				c1.Desacolar();
			}
			
			while (!c2.ColaVacia()) {
				int y = c2.Primero();
				if (!conj.Pertenece(y)) {
					conj.Agregar(y);
					c.Acolar(y);
				}
				c2.Desacolar();
			}
			
			return c;
		}
		
		
		// Escribir un método que devuelva la concatenación de dos colas (cola1 con cola2) de números enteros, 
		//respetando el orden original de cada una pero eliminando los valores repetidos. 
		//El método deberá generar una nueva cola y no se permite dejar las colas originales vacías.
		public static ColaTDA ConcatenarColas(ColaTDA cola1, ColaTDA cola2) {
			ColaTDA c1 = new ColaPU();
			c1.InicializarCola();
			CopiarCola(cola1, c1);
			
			ColaTDA c2 = new ColaPU();
			c2.InicializarCola();
			CopiarCola(cola2, c2);
			
			ConjuntoTDA conj = new ConjuntoA();
			conj.InicializarConjunto();
			
			//CopiarColaAConjunto(c1, conj);
			//CopiarColaAConjunto(c2, conj);
			
			ColaTDA c = new ColaPU();
			c.InicializarCola();
			
			while (!c1.ColaVacia()) {
				int x = c1.Primero();
				if (!conj.Pertenece(x)) {
					conj.Agregar(x);
					c.Acolar(x);
				}
				c1.Desacolar();
			}
			
			while (!c2.ColaVacia()) {
				int x = c2.Primero();
				if (!conj.Pertenece(x)) {
					conj.Agregar(x);
					c.Acolar(x);
				}
				c2.Desacolar();
			}
			
			return c;
		}
	
		
	private static void MostrarCola(ColaTDA c) {
		while(!c.ColaVacia()) {
			int aux = c.Primero();
		    System.out.println(aux);
		    c.Desacolar();
		}
				
	}
		
	
	
	private static void MostrarConjunto(ConjuntoTDA conj) {
		while(!conj.ConjuntoVacio()) {
	        int aux = conj.Elegir();
	        System.out.println(aux);
	        conj.Sacar(aux);
	    }
			
	}

	
	
	// crear una funcion para determinar si la Cola C1 es la inversa de la Cola C2 (sin perder las colas) - TP1 Ejercicio 4f ---------------
		public static boolean esInversa(ColaTDA or1, ColaTDA or2) {
			PilaTDA aux = new PilaTF();
			ColaTDA aux2 = new ColaPU();	// crear una cola auxiliar
			PilaTDA aux3 = new PilaTF();	// crear dos pilas auxiliares
			aux.InicializarPila();
			aux2.InicializarCola();
			aux3.InicializarPila();

			boolean inversa = true;

			int cant1 = 0;
			int cant2 = 0;

			while (!or1.ColaVacia()) { 	// apilar la cola 1 en la pila aux (invierte el orden)
				aux.Apilar(or1.Primero());
				or1.Desacolar();
				cant1++;				// contar la cantidad de elementos de la cola 1
			}

			while (!or2.ColaVacia()) { // acolar la cola 2 en la cola aux2 (NO invierte el orden)
				aux2.Acolar(or2.Primero());
				or2.Desacolar();
				cant2++;			// contar la cantidad de elementos de la cola 2
			}

			if (cant1 == cant2) {	// si ambas colas tienen la misma cantidad de elementos
				while (!aux.PilaVacia()) {
					if (aux.Tope() != aux2.Primero()) {	// si el tope de la pila aux es diferente al primer elemento de la cola aux2
						inversa = false;
					}
					aux3.Apilar(aux.Tope());		// apilar la pila aux en la pila aux3 (para invertir el orden de nuevo) - v1
					aux.Desapilar();				
					or2.Acolar(aux2.Primero());	// acolar la cola aux2 en la cola 2 (para no perder la cola origen) - v1
					aux2.Desacolar();
				}
			} else {
				inversa = false;

				while (!aux.PilaVacia()) {
					aux3.Apilar(aux.Tope());	// apilar la pila aux en la pila aux3 (para invertir el orden de nuevo) - v2
					aux.Desapilar();
				}

				while (!aux2.ColaVacia()) {
					or2.Acolar(aux2.Primero());	// acolar la cola aux2 en la cola 2 (para no perder la cola origen1) - v2
					aux2.Desacolar();
				}
			}

			while (!aux3.PilaVacia()) {	// acolar la pila aux3 en la cola 1 (para no perder la cola origen2)
				or1.Acolar(aux3.Tope());
				aux3.Desapilar();
			}
			return inversa;	// retorna true si ambas colas son inversas
		}

		
		
		// crear una funcion para eliminar todas las ocurrencias de números consecutivos iguales dejando sólo uno
		public static ColaTDA EliminarRepetidosConcurrentes(ColaTDA origen) {
			ColaTDA aux = new ColaLD();
			aux.InicializarCola();	// crear cola auxiliar
			int g;	// guardar el elemento anterior

			while(!origen.ColaVacia()) {	// mientras la cola origen no este vacia
				g = origen.Primero();
				aux.Acolar(g);

				while(!origen.ColaVacia() && origen.Primero() == g) {	// mientras la cola origen no este vacia y el primer elemento sea igual al anterior
					origen.Desacolar();
				}
			}

			while (!aux.ColaVacia()) {	// acolar la cola auxiliar en la cola origen
				origen.Acolar(aux.Primero());
				aux.Desacolar();
			}

			return origen;
		}
		
		// funcion para concatenar una cola y eliminar los repetidos
		public static ColaTDA ConcatenarColaRep(ColaTDA cola1, ColaTDA cola2) {
			
			ColaTDA destino = new ColaLD();		// crear cola destino
			destino.InicializarCola();
			ColaTDA colaaux = new ColaLD();		// crear cola auxiliar
			colaaux.InicializarCola();
			ColaTDA colaaux2 = new ColaLD();	// crear cola auxiliar2
			colaaux2.InicializarCola();		
			ConjuntoTDA aux = new ConjuntoA();	// crear conjunto auxiliar
			aux.InicializarConjunto();
			
			while (!cola1.ColaVacia()) {	// acolar la cola 1 en la cola auxiliar
				int x = cola1.Primero();
				aux.Agregar(x);
				colaaux.Acolar(x);
				cola1.Desacolar();
			}
			while (!cola2.ColaVacia()) {	// acolar la cola 2 en la cola auxiliar2
				int y = cola1.Primero();
				aux.Agregar(y);
				colaaux2.Acolar(y);
				cola1.Desacolar();
			}
			
			while (!colaaux.ColaVacia()) {	// acolar la cola auxiliar en la cola destino
				int z = colaaux.Primero();
				
				if (aux.Pertenece(z)) {	// si el elemento esta en el conjunto auxiliar, acolar en destino y origen
					destino.Acolar(z);
					cola1.Acolar(z);
					aux.Sacar(z);		// sacar el elemento del conjunto auxiliar
					
				} else {
					cola1.Acolar(z);	// si no esta en el conjunto auxiliar, acolar solo en origen
					colaaux.Desacolar();
				}
			}
			while (!colaaux2.ColaVacia()) {	// acolar la cola auxiliar2 en la cola destino
				int r = colaaux2.Primero();
				
				if (aux.Pertenece(r)) {	// si el elemento esta en el conjunto auxiliar, acolar en destino y origen
					destino.Acolar(r);
					cola2.Acolar(r);
					aux.Sacar(r);	// sacar el elemento del conjunto auxiliar
					
				} else {
					cola2.Acolar(r);	// si no esta en el conjunto auxiliar, acolar solo en origen2
					colaaux2.Desacolar();
				}
			}
			return destino;
		}
		
		
		
		// funcion para eliminar de una Cola C las repeticiones de elementos, dejando un representante de cada uno de los elementos 
		// presentes originalmente. Se deberá respetar el orden original de los elementos, y en el caso de los repetidos 
		// se conservará el primero que haya ingresado en C
		public static ColaTDA EliminarRepetidos(ColaTDA origen) {
			ColaTDA aux = new ColaLD();
			aux.InicializarCola();// crear cola auxiliar

			ConjuntoTDA elem = new ConjuntoA();
			elem.InicializarConjunto();	// crear conjunto elementos

			while (!origen.ColaVacia()) {	// acolar la cola origen en la cola auxiliar y agregar los elementos al conjunto
				int x = origen.Primero();
				elem.Agregar(x);
				aux.Acolar(x);
				origen.Desacolar();
			}

			while (!aux.ColaVacia()) {	// acolar la cola auxiliar en la cola origen
				int y = aux.Primero();

				if (elem.Pertenece(y)) {	// si el elemento esta en el conjunto elementos, acolar en origen y sacar del conjunto
					origen.Acolar(y);
					aux.Desacolar();
					elem.Sacar(y);
				} else {
					aux.Desacolar();	// si no esta en el conjunto elementos, no acolar
				}
			}
			return origen;
		}

		
		
		// funcion para repartir una Cola C en dos mitades M1 y M2 de elementos consecutivos, respetando el orden.
		// Asumir que la cantidad de elementos de C es par.
		public static void RepartirCola(ColaTDA origen, ColaTDA M1, ColaTDA M2) {
			ColaTDA aux = new ColaLD();
			aux.InicializarCola();	// crear cola auxiliar
			
			int cant = 0;	// cantidad de elementos

			while (!origen.ColaVacia()) {	// acolar la cola origen en la cola auxiliar y contar los elementos
				int x = origen.Primero();
				aux.Acolar(x);
				origen.Desacolar();
				cant++;
			}

			for (int i = 0; i < cant/2; i++) {	// acolar la mitad de la cola auxiliar en la cola M1
				int y = aux.Primero();
				M1.Acolar(y);
				aux.Desacolar();
			}

			while (!aux.ColaVacia()) {	// acolar el resto de la cola auxiliar en la cola M2
				int z = aux.Primero();
				M2.Acolar(z);
				aux.Desacolar();
			}
		}

		
		
		// funcion para generar el conjunto de elementos que se repiten en una Cola
		public static ConjuntoTDA ColaRepetidos(ColaTDA origen) {

			ConjuntoTDA aux = new ConjuntoA();	// crear conjunto aux
			aux.InicializarConjunto();

			ConjuntoTDA rep = new ConjuntoA();	// crear conjunto rep
			rep.InicializarConjunto();


			while (!origen.ColaVacia()) {	// acolar la cola origen en la cola auxiliar
				int x = origen.Primero();
				if (aux.Pertenece(x)) {	// si el elemento esta en el conjunto auxiliar, acolar en rep
					rep.Agregar(x);
				}
				aux.Agregar(x);
				origen.Desacolar();
			}

			return rep;
		}


		
		// funcion para generar un método que tome como entrada la cola Entrada y devuelva una cola Salida conformada como sigue:
		// Los valores que estén por encima del promedio general de las entradas se acolarán en la cola Salida.
		public static ColaTDA Separar(ColaTDA entrada) {
			ColaTDA aux = new ColaLD();
			aux.InicializarCola();	// crear cola auxiliar

			ColaTDA mayores = new ColaLD();	// crear cola mayores
			mayores.InicializarCola();

			ColaTDA menores = new ColaLD();	// crear cola menores
			menores.InicializarCola();

			ColaTDA iguales = new ColaLD();	// crear cola iguales
			iguales.InicializarCola();

			ColaTDA salida = new ColaLD();	// crear cola salida
			salida.InicializarCola();
			
			int cant = 0;	// cantidad de elementos
			int suma = 0;	// suma de elementos
			int prom = 0;	// promedio de elementos
			
			while (!entrada.ColaVacia()) {	// acolar la cola entrada en la cola auxiliar y contar los elementos, etc
				int x = entrada.Primero();
				aux.Acolar(x);
				entrada.Desacolar();
				cant++;
				suma += x;
			}
			
			prom = suma/cant;
			
			while (!aux.ColaVacia()) {	// acolar la cola auxiliar en las colas correspondientes y en entrada
				int y = aux.Primero();
				entrada.Acolar(y);

				if (y > prom) {	// si el elemento es mayor al promedio, acolar en salida
					mayores.Acolar(y);
				} else if (y < prom) {	// si el elemento es menor al promedio, acolar en menores
					mayores.Acolar(y);
				} else {	// si el elemento es igual al promedio, acolar en iguales
					iguales.Acolar(y);
				}
				aux.Desacolar();
			}

			while (!mayores.ColaVacia()) {	// acolar la cola mayores en la cola salida
				int z = mayores.Primero();
				salida.Acolar(z);
				mayores.Desacolar();
			}
			salida.Acolar(0);	// acolar el 0 (separador) en la cola salida

			while (!iguales.ColaVacia()) {	// acolar la cola iguales en la cola salida
				int z = iguales.Primero();
				salida.Acolar(z);
				iguales.Desacolar();
			}
			salida.Acolar(0);	// acolar el 0 (separador) en la cola salida

			while (!menores.ColaVacia()) {	// acolar la cola menores en la cola salida
				int z = menores.Primero();
				salida.Acolar(z);
				menores.Desacolar();
			}
			salida.Acolar(0);	// acolar el 0 (separador) en la cola salida

			return salida;
		}

		
		
		// funcion para calcular el promedio de los dos máximos elementos y los dos mínimos elementos de C
		public static float PromedioMaxMin(ColaTDA C, int max, int min) {		
			int suma = 0;	// suma de elementos
			float prom = 0;	// promedio de elementos
			
			int max1 = 0;	// máximo 1
			int max2 = 0;	// máximo 2
			int min1 = 0;	// mínimo 1
			int min2 = 0;	// mínimo 2
			
			while (!C.ColaVacia()) {	// agregar los elementos de la cola en las variables correspondientes
				int y = C.Primero();
				if (y > max1) {	// si el elemento es mayor al máximo 1, cambiar el máximo 1
					max2 = max1;
					max1 = y;
				} else if (y > max2) {	// si el elemento es mayor al máximo 2, cambiar el máximo 2
					max2 = y;
				}
				if (y < min1) {	// si el elemento es menor al mínimo 1, cambiar el mínimo 1
					min2 = min1;
					min1 = y;
				} else if (y < min2) {	// si el elemento es menor al mínimo 2, cambiar el mínimo 2
					min2 = y;
				}
				C.Desacolar();
			}

			suma = max1 + max2 + min1 + min2;	// sumar los 4 elementos

			prom = suma/4;	// calcular el promedio

			return prom;

		}

		
		
		// funcion para generar un método que tome como entrada una cola y devuelva la maxima secuencia ascendente
		public static int MaxSec(ColaTDA cola) {

			int max = 1;	// máximo

			// si la cola es 1,3,2,7 la max secuencia ascendente es 2
			// si la cola es 1,3,2,7,4,5,6,8 la max secuencia ascendente es 4
			// si la cola es 1,3,2,7,4,5,6,8,9 la max secuencia ascendente es 5
			// si la cola es 1,3,2,7,4,5,6,8,9,10 la max secuencia ascendente es 6

			int anterior = cola.Primero();
			cola.Desacolar();

			while (!cola.ColaVacia()) {	// agregar los elementos de la cola en las variables correspondientes
				int nuevo = cola.Primero();

				if (nuevo > anterior) {	// si el nuevo elemento es mayor al anterior, sumar 1 al máximo
					max++;
				} else {	// si el nuevo elemento es menor al anterior, reiniciar el máximo
					max = 1;
				}

				anterior = nuevo;
				cola.Desacolar();
			}

			return max;

		}
}
