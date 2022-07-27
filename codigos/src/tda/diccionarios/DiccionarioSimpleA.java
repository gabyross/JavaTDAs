package tda.diccionarios;
import tda.conjuntos.ConjuntoA;
import tda.conjuntos.ConjuntoTDA;

public class DiccionarioSimpleA implements DiccionarioSimpleTDA {
	private Elemento[] elementos;
	private int cant;
	
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cant = 0;
	}
	
	public void Agregar(int clave, int valor) {
		int pos = Clave2Ind(clave);
		if (pos==-1) {
			pos=cant;
			elementos[pos]=new Elemento();
			elementos[pos].clave = clave;
			cant++;
		}
		elementos[pos].valor=valor;
	}
	
	private int Clave2Ind(int clave) {
		int i = cant-1;
		while (i>=0 && elementos[i].clave != clave){
			i--;
		}
		return i;
	}
	
	public void Eliminar(int clave) {
		int pos = Clave2Ind(clave);
		if (pos!=-1) {
			elementos[pos]=elementos[cant-1];
			cant--;
		}
	}
	
	public int Recuperar(int clave) {
		int pos = Clave2Ind(clave);
		return elementos[pos].valor;
	}
	
	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoA();
		c.InicializarConjunto();
		for (int i=0; i<cant;i++) {
			c.Agregar(elementos[i].clave);
		}
		return c;
	}

}
