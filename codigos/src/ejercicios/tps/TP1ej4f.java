package ejercicios.tps;
//Determinar si la Cola C1 es la inversa de la Cola C2. 

import tda.colas.ColaPU;
import tda.colas.ColaTDA;
import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;

public class TP1ej4f {
	
	public static boolean EsInversa(ColaTDA or1,ColaTDA or2) {
		PilaTDA aux = new PilaTF();
		ColaTDA aux2 = new ColaPU();
		PilaTDA aux3 = new PilaTF();
		boolean inversa = true;
		int cant1=0;
		int cant2=0;
		aux.InicializarPila();
		aux2.InicializarCola();
		aux3.InicializarPila();
		while(!or1.ColaVacia()) {         //or1 a aux
			aux.Apilar(or1.Primero());
			or1.Desacolar();
			cant1++;
			}
		while(!or2.ColaVacia()) {         //or2 a aux2
			aux2.Acolar(or2.Primero());
			or2.Desacolar();
			cant2++;
			}
		if (cant1==cant2){                              
			while(!aux.PilaVacia()) {                   //Al tener la cantidad de elementos, podría haber usado ciclos For
				if (aux.Tope()!=aux2.Primero()) {
					inversa=false;
					}
				aux3.Apilar(aux.Tope());                //aux a aux3
				aux.Desapilar();
				or2.Acolar(aux2.Primero());            //aux2 a or2
				aux2.Desacolar();
			}	
		}
		else {
			inversa=false;
			while(!aux.PilaVacia()) {
				aux3.Apilar(aux.Tope());                //aux a aux3      v2
				aux.Desapilar();
			}
			while(!aux2.ColaVacia()) {
				or2.Acolar(aux2.Primero());            //aux2 a or2       v2
				aux2.Desacolar();
			}
		}
		while (!aux3.PilaVacia()) {                //aux3 a or1
			or1.Acolar(aux3.Tope());
			aux3.Desapilar();
		}
		
		return inversa;
		
		
	
	}

	public static void main(String[] args) {
		ColaTDA or1 = new ColaPU();
		ColaTDA or2 = new ColaPU();
		or1.InicializarCola();
		or2.InicializarCola();
		or1.Acolar(1);
		or1.Acolar(2);
		or1.Acolar(3);
		or2.Acolar(1);
		or2.Acolar(2);
		or2.Acolar(3);
		if(EsInversa(or1,or2)) {
			System.out.print("Son inversas!");
		}else {
			System.out.print("No son inversas!");
		}
	}

}
