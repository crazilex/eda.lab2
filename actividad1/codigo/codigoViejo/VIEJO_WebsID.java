package eda;
import java.util.ArrayList;

public class WebsID {

	// INICIALIZACIONES
	Nodo raiz = null; // raiz del arbol al principio es null y a medida que se anaden nuevos nodos deja de serlo

	// METODOS
	public void addWeb (PagWeb pPagina) {

		//pre: -
		//post: si el arbol original esta vacio crea uno nuevo con el parametro de entrada como raiz, sino anade el parametro de entrada en su posicion ordenada por ID (en el caso de encontra un elemento igual lo anade a su derecha)

		// crea un nodo y lo inicializa
		Nodo nuevoNodo = new Nodo(pPagina);

		// si no hay raiz se convierte en raiz
		if (raiz == null) {
			raiz = nuevoNodo;
		}

		else{

			Nodo nodoAuxiliar = raiz; // establece raiz como el nodo inicial a comparar
			boolean anadido = false;

			while (!anadido) {

				if (nuevoNodo.getId() < nodoAuxiliar.getId()){
					if (nodoAuxiliar.getIzq() == null){
						nodoAuxiliar.setIzq(nuevoNodo);
						anadido = true;
					}
					else{
						nodoAuxiliar = nodoAuxiliar.getIzq();
					}
				} else { // lo mismo pero a la derecha
					if (nodoAuxiliar.getDer() == null){
						nodoAuxiliar.setDer(nuevoNodo);
						anadido = true;
					}
					else{
						nodoAuxiliar = nodoAuxiliar.getDer();
					}
				}
			}
		}
	}
	
	
	public PagWeb encontrarWebPorID (int pID){
		
		Nodo nodoAuxiliar = this.getRaiz(); // empezamos arriba del arbol
		
		while (nodoAuxiliar.getWeb().getId() != pID){
			if ( nodoAuxiliar.getWeb().getId() > pID) { //compara los ID
				nodoAuxiliar = nodoAuxiliar.getIzq();
			}
			else {
				nodoAuxiliar = nodoAuxiliar.getDer();
			}
			if (nodoAuxiliar == null) // el nodo no esta
				return null;
		}
		return nodoAuxiliar.getWeb();
	}

 	public Nodo getRaiz(){
		return this.raiz;
	}
	public void imprimirArbol (Nodo pNodo) {

		//pre: si se quiere imprimir el arbol entero pNodo debe ser la raiz
		//pre: se imprimir el arbol desde el pNodo dado de manera InOrder
		
		if (pNodo != null) {
			imprimirArbol(pNodo.getIzq());
			//System.out.println(pNodo);
			pNodo.print();
			imprimirArbol(pNodo.getDer());

		}

	}
	public int maxID(Nodo pNodo) {

		//pre: si se quiere imprimir el arbol entero pNodo debe ser la raiz
		//pre: se imprimir el arbol desde el pNodo dado de manera InOrder
		int id = 0;
		if (pNodo != null) {
			maxID(pNodo.getDer());
			if(pNodo.getDer() == null){
				id = pNodo.getWeb().getId()+1;
			}
		}
		return id;
	}
	
	

public static void main(String[] args) {

	WebsID miArbol2 = new WebsID();
	
	// Pruebas anadir webs
	
	ArrayList<Integer> l = new ArrayList<Integer>(); //les damos una lista vacia de refencias para los tests
	PagWeb pPagina1 = new PagWeb(1,"hola",l);
	PagWeb pPagina2 = new PagWeb(2,"test",l);
	PagWeb pPagina3 = new PagWeb(3,"waifu",l);
	PagWeb pPagina5 = new PagWeb(5,"pr0n",l);
	PagWeb pPagina0 = new PagWeb(0,"reddit",l);
	PagWeb pPagina25 = new PagWeb(25,"xkcd",l);

	miArbol2.addWeb(pPagina1);
	miArbol2.addWeb(pPagina2);
	miArbol2.addWeb(pPagina5);
	miArbol2.addWeb(pPagina0);
	miArbol2.addWeb(pPagina25);
	miArbol2.addWeb(pPagina3);
		
	// Pruebas quitar webs
	
	//miArbol.removeWeb(pPagina3);
	
	// Imprimir el arbol
	
	miArbol2.imprimirArbol(miArbol2.raiz);
		
	//Pruebas de encontrar una web
	
	// Por ID
	PagWeb pagAux2 = miArbol2.encontrarWebPorID(25);
	System.out.println("Web encontrada por ID: " + pagAux2.getNombre() + " (id: " + pagAux2.getId() + ")");

	System.out.println(miArbol2.maxID(miArbol2.raiz));
}

}
