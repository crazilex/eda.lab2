package eda;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Webs {

	// INICIALIZACIONES
	Nodo raiz = null; // raiz del arbol al principio es null y a medida que se anaden nuevos nodos deja de serlo
	static WebsID websID = new WebsID();
	WebsID websIDaux = new WebsID();
	private static Webs miArbol = null;
	private int lastID = 0;

	// CONSTRUCTORA (para la MAE)
	private Webs(){}

	// PATRON SINGLETON
	public static Webs getWebs(){
		if(miArbol == null){
			miArbol = new Webs();
		}
		return miArbol;
	}

	// METODOS
	public void addWeb (PagWeb pPagina) {

		//pre: -
		//post: si el arbol original esta vacio crea uno nuevo con el parametro de entrada como raiz, sino anade el parametro de entrada en su posicion ordenada (en el caso de encontra un elemento igual lo anade a su derecha)

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

				int comparacion = comparar((nuevoNodo.getWeb()), (nodoAuxiliar.getWeb()));

				if (comparacion > 0){
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

	public void removeWeb (PagWeb pPagina){

		//pre: -
		//post: elimina la primera aparicion del parametro de entrada, si no ha sido encontrado no hace nada al arbol

		//posibles fallos?: tener que retirar a raiz principa del arbol

		if (raiz == null){
			return;
		}

		else{

			int compRaiz = comparar(raiz.getWeb(),pPagina);

			if(compRaiz == 0){
				raiz = sustitucion(raiz);
			}

			else{

			Nodo actual = raiz; // establece raiz como el nodo inicial a comparar
			Nodo padre = raiz;
			boolean borrado = false;

			int comparacion = comparar(pPagina,actual.getWeb());

			if (comparacion > 0){
				actual = actual.getIzq();
			}
			else{
				actual = actual.getDer();
			}

			while ( (actual != null) && (!borrado) ){
				int comp1 = comparar(pPagina, actual.getWeb());
				if (comp1 == 0){
					borrado = true;
					// hacemos una segunda comparacion para ver si al padre le tenemos que poner el subArbol derecho o izquierdo
					System.out.println("ENTRA");
					int comp2 = comparar(padre.getIzq().getWeb(), actual.getWeb());
					if (comp2 == 0){ // si la web esta repetida puede estar a la izquierda tambien
						padre.setIzq(sustitucion(actual));
					}
					else{
						padre.setDer(sustitucion(actual));
					}
				}
				else{
					padre = actual;
					int comp3 = comparar(pPagina, actual.getWeb());
					if (comp3 > 0){
						actual = actual.getIzq();
					}
					else{
						actual = actual.getDer();
					}
				}
			}

			if (!borrado){
				return;
			}
			}
		}
	}

	protected Nodo sustitucion (Nodo pNodo){

		//pre: -
		//post: devuelve la referencia a sustituir de pNodo, si tiene hijos (es decir, si es un subarbol) devuelve el subarbol de manera InOrder

		Nodo resultado = null;
		if ((pNodo.getIzq() == null)&&(pNodo.getDer()==null))
			resultado = null;
		else if ((pNodo.getIzq() != null)&&(pNodo.getDer()==null))
			resultado = pNodo.getIzq();
		else if ((pNodo.getIzq() == null)&&(pNodo.getDer() != null))
			resultado = pNodo.getDer();
		else{
			Nodo actual = pNodo.getDer();
			Nodo padre = pNodo;
			while (actual.getIzq() != null){
				padre = actual;
				actual = actual.getIzq();
			}

			int comp = comparar (pNodo.getDer().getWeb(), actual.getWeb());
			if (comp == 0)
				actual.setIzq(pNodo.getIzq());
			else{
				padre.setIzq(actual.getDer());
				actual.setDer(pNodo.getDer());
				actual.setIzq(pNodo.getIzq());
			}
			resultado = actual;
		}
		return resultado;
	}

	public PagWeb encontrarWeb (String pNombre){

		//pre: -
		//post: devuelve la web con nombre pNombre, si no esta devuelve null

		pNombre = pNombre.toLowerCase();

		Nodo nodoAuxiliar = raiz; // empezamos arriba del arbol

		while ( !(nodoAuxiliar.getWeb().getNombre()).equals((pNombre) )){
			if ( nodoAuxiliar.getNombre().toLowerCase().compareTo(pNombre.toLowerCase()) < 0) { //compara los nombres
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

	public void crearWebsID(Nodo pNodo){

		//pre: -
		//post: crea un arbol de busqueda identico al actual pero ordenado por ID en vez de alfabeticamente

		if (pNodo != null) {
			crearWebsID(pNodo.getIzq());
			crearWebsID(pNodo.getDer());
			websIDaux.addWeb(pNodo.getWeb());
		}

		websID = websIDaux;

	}

	private PagWeb buscarWebReferenciadas(PagWeb pPagina, int pPos){

		//pre: -
		//post: devuelve la PagWeb a la que pPagina referencia de su atributo listRef en la posicion pPos, si no hay ningun elemento en pPos devuelve null

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

		ArrayList<PagWeb> listaRef = new ArrayList<>();

		for (int i = 0; i < pPagina.getListaRef().size(); i++){
			PagWeb aux = buscarWebReferenciadas(pPagina,i);
			if (aux != null && !listaRef.contains(aux)){ //solo la anade si la ha encontrado y no ha sido anadida previamente
				listaRef.add(buscarWebReferenciadas(pPagina,i));
			}
		}

		return listaRef;

	}

	public PagWeb encontrarWebPorID (int pID){

		//pre: -
		//post: crea un arbol ordenado por ID y busca en ese arbol la web y la devuelve
		//coste: O(n*log(n)) siendo n el numero de webs


		PagWeb webEncontrada = null;
		webEncontrada = websID.encontrarWebPorID(pID);

		return webEncontrada;

	}

	public void imprimirArbol () {

		//pre:
		//pre: se imprimir el arbol de manera InOrder

		pNodo = this.raiz;

		if (pNodo != null) {
			imprimirArbol(pNodo.getDer());
			pNodo.print();
			imprimirArbol(pNodo.getIzq());

		}
	}

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


	private Integer comparar (PagWeb web1, PagWeb web2){

		//pre: recibe dos webs (utiles)
		//post: devuelve mediante un integer la compraracion alfabetica entre las dos webs, si web1 es mas pequena (a<z) devuelve un integer positivo, si son iguales 0 y sino negativo

		//creamos nuevas variable string
		String nombreWeb1 = new String();
		String nombreWeb2 = new String();

		//almacenamos el nombre las dos webs a comparar en minuscula
		nombreWeb1 = web1.getNombre().toLowerCase();
		nombreWeb2 = web2.getNombre().toLowerCase();

		//las comparamos
		int resultado = nombreWeb1.compareTo(nombreWeb2);

		return resultado;

	}

	public int getLastID() {
		return lastID;
	}

	public void setLastID(int lastID) {
		this.lastID = lastID;
	}
	public void reset() {
		this.raiz = null; // raiz del arbol al principio es null y a medida que se anaden nuevos nodos deja de serlo
		websID = new WebsID();
		this.websIDaux = new WebsID();
		miArbol = null;
		this.setLastID(0);
	}
	/*
	private Nodo encontrarNodo(Nodo pNodo){ //no lo necesitamos

		//pre: -
		//post: devuelve el nodo indicado, si no esta devuelve null

		Nodo nodoAuxiliar = raiz; // empezamos arriba del arbol

		int comparacion = comparar((pNodo.getWeb()), (nodoAuxiliar.getWeb()));

		while (comparacion != 0) { // seguir buscando mientras que no lo ha encontrado
			if (comparacion > 0) {
				nodoAuxiliar = nodoAuxiliar.getIzq();
			}
			else {
				nodoAuxiliar = nodoAuxiliar.getDer();
			}
			if (nodoAuxiliar == null) // el nodo no esta
				return null;
		}
		return nodoAuxiliar;
	}
	*/

/*
public static void main(String[] args) {

	Webs miArbol = new Webs();

	// Pruebas anadir webs

	ArrayList<Integer> l = new ArrayList<Integer>(); //les damos una lista vacia de refencias para los tests
	l.add(3);
	l.add(5);
	l.add(5);
	l.add(50);
	l.add(1);
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


	// Pruebas quitar webs

	miArbol.removeWeb(pPagina1);

	// Imprimir el arbol

	miArbol.imprimirArbol(miArbol.raiz);
	miArbol.crearWebsID(miArbol.raiz);
	//miArbol.websID.imprimirArbol(miArbol.websID.raiz);	//Imprime arbolñ ordenado

	// Devolver paginas a las que referencia
	ArrayList<PagWeb> listaTest = miArbol.devolverWebsReferenciadas(pPagina2);
	System.out.println("--------------- ");
	for (int i = 0; i < listaTest.size(); i++){
		PagWeb webTest = listaTest.get(i);
		webTest.imprimirDatos();
		System.out.println("estas ");
	}


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
}
	/*
	// Por ID
	PagWeb pagAux2 = null;
	pagAux2 = miArbol.encontrarWebPorID(2);
	if (pagAux2 != null){
		System.out.println("Web encontrada por ID: " + pagAux2.getNombre() + " (id: " + pagAux2.getId() + ")");
	}
	else{
		System.out.println("Web no encontrada");
	}

}
*/
}

class Nodo {

		// INICIALIZACIONES
		private int id; // el nodo recibe el mismo id que la pagina web que contiene
		private PagWeb pagina;
		private Nodo izq;
		private Nodo der;

		// CONSTRUCTORA
		Nodo(PagWeb pPagina) {
			this.id = pPagina.getId();
			this.pagina = pPagina;
		}

		public void print() {
			System.out.println(this.pagina.getNombre() + " (id: " + this.id + ")");
		}

		// GETTERS Y SETTERS
		public String getNombre(){
			return this.pagina.getNombre();
		}

		public int getId(){
			return this.id;
		}

		public PagWeb getWeb(){
			return this.pagina;
		}

		public Nodo getIzq(){
			return this.izq;
		}

		public Nodo getDer(){
			return this.der;
		}

		public void setIzq(Nodo pNodo){
			this.izq = pNodo;
		}

		public void setDer(Nodo pNodo){
			this.der = pNodo;
		}

		public String[] datos(){
			return new String[] {this.getWeb().getNombre(), Integer.toString(this.getWeb().getId())};
		}
}
