//Determinar si el final de la Cola C1 coincide o no con la Cola C2.

package ejercicios.tps;

import tda.colas.ColaPU;
import tda.colas.ColaTDA;

public class TP1ej4d {
	
	public static boolean ColasIguales(ColaTDA origen1,ColaTDA origen2) {
		int n1=0;
		int n2=0;
		
		while(!origen1.ColaVacia()) {
			n1=origen1.Primero();
			origen1.Desacolar();
		}
		while(!origen2.ColaVacia()) {
			n2=origen2.Primero();
			origen2.Desacolar();
		}
		
		return (n1==n2);
		}
	

	public static void main(String[] args) {
		ColaTDA origen1=new ColaPU();
		ColaTDA origen2=new ColaPU();
		origen1.InicializarCola();
		origen2.InicializarCola();
		origen1.Acolar(1);
		origen1.Acolar(7);
		origen2.Acolar(1);
		origen2.Acolar(1);
		origen2.Acolar(7);
		if (ColasIguales(origen1,origen2)) {
			System.out.print("Los finales coindicen");
		}else {
			System.out.print("Los finales no coindicen");
		}
		

	}

}
