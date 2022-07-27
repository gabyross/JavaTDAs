package tda.diccionariosSimples;
import tda.conjuntos.ConjuntoTDA;

public interface DiccionarioSimpleTDA {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	int Recuperar(int clave);
	ConjuntoTDA Claves();
	
	// APARTE DEL TDA ORIGINAL
    ConjuntoTDA Valores(); // pre: diccionario inicializado 	// metodo extra para generar conjunto de valores
	String MostrarDiccionario(); // pre: diccionario inicializado y no vacio // metodo extra para mostrar el diccionario
}
