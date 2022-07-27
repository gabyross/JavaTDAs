package tda.diccionariosSimples;
import tda.conjuntos.ConjuntoTDA;
import tda.conjuntos.ConjuntoLD;

public class DiccionarioSimpleL implements DiccionarioSimpleTDA {
	private class NodoClave{
		int clave;
		int valor;
		NodoClave sigClave;
	}
	private NodoClave origen;
	public void InicializarDiccionario() {
		origen=null;
	}
	public void Agregar(int clave,int valor) {
		NodoClave nc = Clave2NodoClave(clave);
		if (nc == null) {
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		nc.valor = valor;
	}
	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while (aux!= null && aux.clave!=clave) {
			aux=aux.sigClave;
		}
		return aux;
	}
	public void Eliminar(int clave) {
		if(origen!=null) {
			if (origen.clave == clave) {
				origen = origen.sigClave;
			} else {
				NodoClave aux = origen;
				while (aux.sigClave!=null && aux.sigClave.clave != clave) {
					aux=aux.sigClave;
				}
				if (aux.sigClave!=null) {
					aux.sigClave=aux.sigClave.sigClave;
				}
			}
		}
	}
	
	public int Recuperar(int clave) {
		NodoClave nc = Clave2NodoClave(clave);
		return nc.valor;
	}
	
	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoClave aux = origen;
		while (aux!=null) {
			c.Agregar(aux.clave);
			aux=aux.sigClave;
		}
		return c;
	}

	
	// APARTE DEL TDA ORIGINAL
	public ConjuntoTDA Valores() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoClave aux = origen;
		while (aux != null) {
			c.Agregar(aux.valor);
			aux = aux.sigClave;
		}
		return c;	// devuelve un conjunto con los valores del diccionario
	}

	public String MostrarDiccionario() {

		String s = "";
		NodoClave aux = origen;
		while (aux != null) {
			s += "(" + aux.clave + "," + aux.valor + ") ";
			aux = aux.sigClave;
		}
		return s;	// devuelve un string con el diccionario
	}
	
	
}
