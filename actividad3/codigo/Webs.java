package eda;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Webs {

	// ATRIBUTOS
	private TreeSet<PagWeb> arbol;
	private static Webs miArbol = null;
	private int lastID;

	// CONSTRUCTORA
	public Webs() {
	    this.arbol = new TreeSet<PagWeb>();
	}

	// PATRON SINGLETON
	public static Webs getWebs(){
		if(miArbol == null){
      miArbol = new Webs();
    }
		return miArbol;
	}

	//METODOS

	public void addWeb(PagWeb pPagina) {
		//pre: -
		//post: si el arbol original esta vacio crea uno nuevo con el parametro de entrada como raiz, sino lo anade al arbol existente
		//coste: O(log(n)) siendo n el numero de webs que contiene el arbol

		this.arbol.add(pPagina);
	}

	public void removeWeb(PagWeb pPagina) {
		//pre: -
		//post: elimina pPagina del arbol, si no se encuentra no hace nada al arbol
		//coste: O(log(n)) siendo n el numero de webs que contiene el arbol

		this.arbol.remove(pPagina);
	}
	
	public int tamano() {
		//pre: -
		//post: devuelve el numero de elementos del arbol
		//coste: O(n) siendo n el numero de webs que contiene el arbol

		return this.arbol.size();
	}

	public void imprimirArbol() {
		//pre:
		//pre: se imprimir el arbol
		//coste: O(n) siendo n el numero de webs que contiene el arbol

	    PagWeb web;

	    Iterator<PagWeb> it = this.getIterador();
	    while (it.hasNext()) {
	        web = it.next();
	        System.out.println(web.toString());
	    }
	}

	public PagWeb encontrarWeb(String pNombre) {
		//pre: -
		//post: devuelve la web que coincida con pNombre, si no esta devuelve null
		//coste: O(log(n)) siendo n el numero de webs que contiene el arbol

		PagWeb web = null;
		boolean enc = false;
		Iterator<PagWeb> it = this.getIterador();
		while (it.hasNext() && !enc) {
			web = it.next();
			if (web.getNombre().equals(pNombre)) { enc = true; }
		}
		if(!enc){ web = null; }
		return web;
	}

	public PagWeb encontrarWebPorID(int pID) {
		//pre: -
		//post: devuelve la web que coincida con pID, si no esta devuelve null
		//coste: O(log(n)) siendo n el numero de webs que contiene el arbol

		PagWeb web = null;
		boolean enc = false;
		Iterator<PagWeb> it = this.getIterador();

		while (it.hasNext() && !enc) {
		    web = it.next();
		    if (web.getId() == pID) { enc = true; }
		}
		if(!enc){ web = null; }
		return web;
	}

	private PagWeb buscarWebReferenciadas(PagWeb pPagina, int pPos){
		//pre: -
		//post: devuelve la PagWeb a la que pPagina referencia de su atributo listRef en la posicion pPos, si no hay ningun elemento en pPos devuelve null
		//coste: O(log(n)) siendo n el numero de webs que contiene el arbol

		if (pPos < pPagina.getListaRef().size()){
			int id = pPagina.getListaRef().get(pPos);
			PagWeb webEncontrada = encontrarWebPorID(id);
			return webEncontrada;
		}
		else{
			return null;
		}
	}

	public ArrayList<PagWeb> devolverWebsReferenciadas(PagWeb pPagina){
		//pre: -
		//post: devuelve un array list con objetos de clase PagWeb estando el array rellenado con las PagWeb a las que referencia pPagina
		//coste: O(m*log(n)) siendo n el numero de webs que contiene el arbol y siendo m el numero de webs a las que referencia pPagina

		ArrayList<PagWeb> listaRef = new ArrayList<>();

		for (int i = 0; i < pPagina.getListaRef().size(); i++){
			PagWeb aux = buscarWebReferenciadas(pPagina,i);
			if (aux != null && !listaRef.contains(aux)){ //solo la anade si la ha encontrado y no ha sido anadida previamente
				listaRef.add(buscarWebReferenciadas(pPagina,i));
			}
		}
		return listaRef;
	}
	
	public void guardar(PrintWriter w, String webs) throws FileNotFoundException
	{

	    PagWeb web;
	    Iterator<PagWeb> it = this.getIterador();
	    
	    //boolean top_call = false;  // Flag para salir de la recursion en el codigo anterior
	    if (w == null) {
	        FileOutputStream outputStream = new FileOutputStream("./"+webs);
	        w = new PrintWriter(outputStream);
	        //TOP CALL es un flag para el codigo anterior
	        //top_call = true;  // mark highest entry point to know when to close writer in recursive call
	    }
	    
	    while (it.hasNext()) {
	        web = it.next();
	        w.print(web+"\r\n");
	    }

	 
	    //if (top_call)  // don't close writer in recursive calls
	       
	    w.close();
	}

	/*
	public void guardar(Nodo mainNode, PrintWriter w, String webs) throws FileNotFoundException
	{

	    if (mainNode == null)  // base case to stop recursion
	        return;
	    boolean top_call = false;  // Flag needed later
	    if (w == null) {
	        FileOutputStream outputStream = new FileOutputStream("./"+webs);
	        w = new PrintWriter(outputStream);
	        top_call = true;  // mark highest entry point to know when to close writer
	    }
	    guardar(mainNode.getDer(), w, webs);
	    w.print(mainNode.getWeb()+"\r\n");
	    guardar(mainNode.getIzq(), w, webs);

	    if (top_call)  // don't close writer in recursive calls
	        w.close();
	}


	public int getLastID() {
		return lastID;
	}

	public void setLastID(int lastID) {
		this.lastID = lastID;
	}
	*/

	public Iterator<PagWeb> getIterador() {
		return this.arbol.iterator();
	}

	public void reset() {
		//pre: -
		//post: vacia el arbol
		//coste: O(1)

		this.arbol = new TreeSet<PagWeb>();
		//this.setLastID(0);
	}

	public int getLastID() {
		return lastID;
	}

	public void setLastID(int lastID) {
		this.lastID = lastID;
	}

	
	public static void main(String[] args) {

		Webs miArbol = new Webs();

		// Pruebas anadir webs

		ArrayList<Integer> l = new ArrayList<Integer>(); //les damos una lista vacia de refencias para los tests
		PagWeb pPagina1 = new PagWeb(1,"hola",l);
		PagWeb pPagina2 = new PagWeb(2,"test",l);
		PagWeb pPagina3 = new PagWeb(3,"waifu",l);
		PagWeb pPagina5 = new PagWeb(5,"pr0n",l);
		PagWeb pPagina0 = new PagWeb(0,"reddit",l);
		PagWeb pPagina25 = new PagWeb(25,"xkcd",l);
		
		pPagina2.anadirListaRef(l);
		pPagina3.anadirListaRef(l);

		miArbol.addWeb(pPagina1);
		miArbol.addWeb(pPagina2);
		miArbol.addWeb(pPagina5);
		miArbol.addWeb(pPagina0);
		miArbol.addWeb(pPagina25);
		miArbol.addWeb(pPagina3);
		miArbol.imprimirArbol();
		
		/*
		// Pruebas quitar webs

		miArbol.removeWeb(pPagina5);

		// Imprimir el arbol

		miArbol.imprimirArbol();

		// Devolver paginas a las que referencia
		ArrayList<PagWeb> listaTest = miArbol.devolverWebsReferenciadas(pPagina0);
		System.out.println("--------------- ");
		System.out.println("Webs referencidas: ");
		for (int i = 0; i < listaTest.size(); i++){
			PagWeb webTest = listaTest.get(i);
			System.out.println(webTest.toString());
		}

		System.out.println("--------------- ");
		System.out.println(miArbol.encontrarWeb("waifu").getListaRef().toString());
		System.out.print(miArbol.devolverWebsReferenciadas(pPagina2).toString());


		//Pruebas de encontrar una web
		// Por nombre

		PagWeb pagAux1 = miArbol.encontrarWeb("waifu");
		if (pagAux1 != null){
			System.out.println("Web encontrada por nombre: " + pagAux1.getNombre() + " (id: " + pagAux1.getId() + ")");
		}
		else{
			System.out.println("Web no encontrada");
		}

		// Por ID
		PagWeb pagAux2 = null;
		pagAux2 = miArbol.encontrarWebPorID(3);
		if (pagAux2 != null){
			System.out.println("Web encontrada por ID: " + pagAux2.getNombre() + " (id: " + pagAux2.getId() + ")");
		}
		else{
			System.out.println("Web no encontrada");
		}
		*/
	}
	
}
