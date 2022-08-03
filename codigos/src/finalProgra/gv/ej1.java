package finalProgra.gv;

import tda.conjuntos.ConjuntoTDA;
import tda.diccionariosMultiples.DiccionarioMultipleA;
import tda.diccionariosMultiples.DiccionarioMultipleL;
import tda.diccionariosMultiples.DiccionarioMultipleTDA;

// ----- APP -----
public class ej1{


	public static void main(String[] args) {
		
		DiccionarioMultipleTDA dic1 = new DiccionarioMultipleL();
        dic1.InicializarDiccionario();
        dic1.Agregar(1,10);
        dic1.Agregar(2,20);
        dic1.Agregar(2,21);
        dic1.Agregar(3,30);
        dic1.Agregar(4,40);
        
        
        DiccionarioMultipleTDA dic2 = new DiccionarioMultipleL();
        dic2.InicializarDiccionario();
        dic2.Agregar(1,10);
        dic2.Agregar(6,20);
        dic2.Agregar(8,21);
        dic2.Agregar(3,30);
        dic2.Agregar(9,40);
        
        DiccionarioMultipleTDA dicClavesComunes = clavesConValoresComunes(dic1, dic2);
        mostrarDiccionarioM(dicClavesComunes);
        
	}
	
	
	
	
	
	// ----- FUNCIONES -----
	// Metodo para mostrar un diccionario multiple
    public static void mostrarDiccionarioM(DiccionarioMultipleTDA DicMul) {
        ConjuntoTDA claves;
        claves = DicMul.Claves();   // obtener conjunto claves del diccionario multiple
        while (!claves.ConjuntoVacio()) {   // obtener clave y valor
            int clave = claves.Elegir();
            ConjuntoTDA valores = DicMul.Recuperar(clave);  // obtener conjunto valores de la clave
            System.out.print("Clave: " + clave + " Valores: "); 
            while (!valores.ConjuntoVacio()) {  // imprimir valores
                System.out.print(valores.Elegir() + " ");   
                valores.Sacar(valores.Elegir());    // sacar valor del conjunto
            }
            System.out.println();   
            claves.Sacar(clave);    
        }
    }
    
    
	// Metodo para generar un DiccionarioMultipleTDA que contenga: las claves presentes en D1 y D2,
    // con todos los elementos comunes a las claves de ambos
    public static DiccionarioMultipleTDA clavesConValoresComunes(DiccionarioMultipleTDA dic1, DiccionarioMultipleTDA dic2) {
        ConjuntoTDA conjClaves = dic1.Claves();   ;  
        
        ConjuntoTDA conjClaves2 = dic2.Claves();  


        while (!conjClaves2.ConjuntoVacio() ) { 
            int x = conjClaves2.Elegir();  

            conjClaves.Agregar(x); 
            conjClaves2.Sacar(x);
        }
        
        DiccionarioMultipleTDA dic = new DiccionarioMultipleA(); 
        dic.InicializarDiccionario();

        while (!conjClaves.ConjuntoVacio()) {  
            int clave = conjClaves.Elegir();  

            ConjuntoTDA valores1 = dic1.Recuperar(clave);
            ConjuntoTDA valores2 = dic2.Recuperar(clave); 
            
            while (!valores1.ConjuntoVacio() && !valores2.ConjuntoVacio()) { 
                int y = valores2.Elegir();  

                if (valores1.Pertenece(y)) {
                    dic.Agregar(clave, y);  
                }
                valores2.Sacar(y);    
            }
            conjClaves.Sacar(clave);
        }

    return dic;
    }

}




/*  ESTRATEGIA
 * crear conjunto claves2
 * obtener conjunto claves del diccionario 1
 * obtener conjunto claves del diccionario 2
 * mientras no este vacio el conjunto de claves 2, agrego todo a claves.
 * obtener clave
 * agregar clave al conjunto claves1
 * crear diccionario multiple de claves comunes
 * mientras no este vacio el conjunto, agrego las claves (agregar las claves y valores al dic nuevo)
 * obtener clave
 * obtener conjunto valores de la clave del dic1
 * obtener conjunto valores de la clave del dic1
 * mientras no este vacio el conjunto (agregar los valores comunes)
 * si los valores estan en ambos conjuntos
 * agregar valor al diccionario multiple
 * sacar valor del conjunto
 * 
 * /*  ESTRATEGIA
 * crear conjuntos con las claves de los diccionarios 1 y 2
* crear diccionario multiple de claves comunes
 * mientras no este vacio el conjunto de las claves del segundo diccionarios, agrego todo al * conjunto claves.
 * obtengo una clave del conjunto claves y recupero sus valores en ambos diccionarios
 * recorro los conjuntos de valores que acabo de obtener hasta que alguno de los dos se *acabe, y veo si los valores de una clave pertenecen al conjunto de valores de la otra *clave, de ser así, lo agrego al diccionario de claves comunes
 * es decir, mientras no este vacio el conjunto, agrego las claves (agregar las claves y *valores al dic nuevo), así sucesivamente hasta obtener todos los comunes

 * 
 * COSTO
 * el costo es 2(n^2) + 2(n^2) ya que se piden las claves de diccionrio multiple
 * el cual tiene un costo cuadratico, y tambien se pide recuperar que igualmente tiene
 * costo cuadratico
 * */
