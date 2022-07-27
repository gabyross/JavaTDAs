package tda.listasDobles;


public class ListasDMain{
	

	public static void main(String[] args) {
		ListaDobleTDA lista = new ListaDoble();
        lista.InicializarLista();
        lista.AgregarAlFinal(2);
        lista.AgregarAlFinal(1);
        lista.AgregarAlFinal(4);
        lista.AgregarAlFinal(3);
        
        lista.mostrar();
	}

}
