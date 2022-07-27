package tda.diccionariosSimples;

// ----- IMPORTACIONES -----
import tda.colas.ColaTDA;

//-----  IMPORTACIONES  -----

import tda.conjuntos.ConjuntoTDA;
import tda.pilas.PilaTDA;
import tda.pilas.PilaTF;





// -----  APP  -----

public class DiccionarioSimpleMain {

	public static void main(String[] args) {
		DiccionarioSimpleTDA d = new DiccionarioSimpleA();
		d.InicializarDiccionario();
		d.Agregar(1, 100);
		d.Agregar(2, 200);
		d.Agregar(4, 400);
		PilaTDA valores = new PilaTF();
		valores.InicializarPila();
		PasajeDicAPila(d, valores);
	}
	
	
	
	
	
	// -----  FUNCIONES  -----
	
	// Metodo para el pasaje de todos los valores de un diccionario simple dic a una pila valores.
	public static void PasajeDicAPila(DiccionarioSimpleTDA dic, PilaTDA valores) {
		ConjuntoTDA claves;
		claves = dic.Claves();
		
		while (!claves.ConjuntoVacio()) {
			int x = claves.Elegir();
			valores.Apilar(dic.Recuperar(x));
			claves.Sacar(x);
		}
	}
	
	
	
	// Metodo para pasar los valores de un diccionario simple a una cola
    public static ColaTDA PasajeCola(DiccionarioSimpleTDA dic, ColaTDA valores) {
        ConjuntoTDA claves = dic.Claves();
        
        while (!claves.ConjuntoVacio()) {
            int x = claves.Elegir();
            valores.Acolar(dic.Recuperar(x));
            claves.Sacar(x);
        }
        return valores;
    }
	
	
	
	// Metodo para obtener la cantidad de claves
    public static int cantidadClaves(DiccionarioSimpleTDA dicc) {
        int cantidad = 0;
        ConjuntoTDA claves = dicc.Claves();
        
        while (!claves.ConjuntoVacio()) {
            claves.Sacar(claves.Elegir());
            cantidad++;
        }
        
        return cantidad;
    }
	
    
    
    // Metodo para obtener la cantidad de valores
    public static int cantidadValores(DiccionarioSimpleTDA dicc) {
        int cantidad = 0;
        ConjuntoTDA valores = dicc.Valores();
        while (!valores.ConjuntoVacio()) {
            valores.Sacar(valores.Elegir());
            cantidad++;
        }
        return cantidad;
    }
    
    
    
	// Metodo que muestra un diccionario simple
	public static void MostrarDic(DiccionarioSimpleTDA dic) {
		ConjuntoTDA claves;
		claves = dic.Claves();
		while (!claves.ConjuntoVacio()) {
			int x = claves.Elegir();
			System.out.println("Clave: " + x + " Valor: " + dic.Recuperar(x));
			claves.Sacar(x);
		}
	}
	
	
	
	// Metodo para combinar 2 diccionarios simples, si una clave se repite, se pone el valor mas bajo
    public static DiccionarioSimpleTDA CombinarDiccionarios(DiccionarioSimpleTDA dic1, DiccionarioSimpleTDA dic2 ) {

        DiccionarioSimpleTDA dic3 = new DiccionarioSimpleA();
        dic3.InicializarDiccionario();

        ConjuntoTDA claves1 = dic1.Claves(); // creo un conjunto con las claves del diccionario 1
        ConjuntoTDA claves2 = dic2.Claves(); // creo un conjunto con las claves del diccionario 2


        while (!claves1.ConjuntoVacio()) {

            int clave = claves1.Elegir();

            if (claves2.Pertenece(clave)) { // si la clave pertenece a ambos conjuntos

                claves2.Sacar(clave); // sacar la clave del segundo conjunto

                int valor1 = dic1.Recuperar(clave);
                int valor2 = dic2.Recuperar(clave);
                

                if (valor1 >= valor2){  // si el valor de dic1 es mayor o igual que el valor de dic2
                    dic3.Agregar(clave, valor2);
                    System.out.println("se agregó clave del dicc2 - comparado");


                } else {             // si el valor de dic1 es menor que el valor de dic2
                    dic3.Agregar(clave, valor1);
                    System.out.println("se agregó clave del dicc1 - comparado");

                }

            } else {
                dic3.Agregar(clave, dic1.Recuperar(clave));
                System.out.println("se agregó clave del dicc1");
            }
            claves1.Sacar(clave);
            }

        while (!claves2.ConjuntoVacio()) {  // se agrega el valor del diccionario 2
            int clave = claves2.Elegir();

            dic3.Agregar(clave, dic2.Recuperar(clave));
            System.out.println("se agregó clave del dicc2");  
            claves2.Sacar(clave);
        }

        MostrarDic(dic3);
        return dic3;
    }
}
