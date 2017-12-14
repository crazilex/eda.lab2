package cuartaFase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

//import java.util.Map;
//import java.util.Set;


public class Diccionario {
	//Atributos
	private static Diccionario miDiccionario = null;
	private HashMap<String, UnorderedDoubleLinkedList<String>> palabras = null;

	//Constructora
	private Diccionario(){
		this.palabras = new HashMap<String, UnorderedDoubleLinkedList<String>>();
	}

	public static Diccionario getDiccionario() {
		if(miDiccionario == null) {
			miDiccionario = new Diccionario();
		}
		return miDiccionario;
	}

	//Devuelve el hashmap.
	public HashMap<String, UnorderedDoubleLinkedList<String>> getPalabras(){
		return this.palabras;
	}

	//Esto sera para la constructora, para poder añadir las palabras al diccionario.
	//pre: Una palabra del diccionario no vacia.
	//post: Annade esa palabra como key en caso de no existir.
	//Coste: O(1)
	public void anadirPalabra(String palabra){
		if (!this.palabras.containsKey(palabra)){
			UnorderedDoubleLinkedList<String> l = new UnorderedDoubleLinkedList<String>();
			this.palabras.put(palabra, l);
		}
	}

	//Metodo que se utilizara para introducir el nombre de una Web en las palabras del Diccionario.
	//pre: Un nombre no vacio de una web.
	//post: Annade el nombre de la web a todas las palabras que utiliza esa web.
	//Coste: O(n), siendo n la longitud de la palabra entrante.
	public void añadirWeb(String web){
		String[] w = web.split("\\.");
		//String[] w2 = w[0].split("[0-9]+");
		String palabra = w[0];
		for (int l = 4; l<=palabra.length(); l++){
			for (int pos = 0; pos<=(palabra.length()-l); pos++) {
				String posible = palabra.substring(pos, pos+l);
				if(palabras.containsKey(posible)){
	        		palabras.get(posible).addToRear(web);
	        	}
	        }
		}

	}

	//Metodo que se utilizara para eliminar el nombre de una Web en las palabras del Diccionario.
	//pre: Un nombre no vacio de una web.
	//post: Elimina el nombre de la web en todas las palabras que utiliza esa web.
	//Coste: O(n), siendo n la longitud de la palabra entrante.
	public void eliminarWeb(String web){
		String[] w = web.split("\\.");
		//String[] w2 = w[0].split("[0-9]+");
		String palabra = w[0];
		for (int l = 4; l<=palabra.length(); l++){
			for (int pos = 0; pos<=(palabra.length()-l); pos++) {
				String posible = palabra.substring(pos, pos+l);
				if(palabras.containsKey(posible)){
	        		palabras.get(posible).remove(web);
				}
			}
		}
	}

	//pre: Recibe lo que ha sido escrito por teclado.
	//post: Devuelve la lista de paginas relacionadas con la palabra.
	//Coste: O(n*m*l), siendo n la longitud de la palabra entrante, y m la longitud de array, y l el numero de elmentos de la UnorderedDobleLinkedList.
	public void buscarWeb(String[] busca){
		boolean sinCoincidencias = true;
		for (int i = 0; i< busca.length; i++){
			for (int l = 4; l<=busca[i].length(); l++){
				for (int pos = 0; pos<=(busca[i].length()-l); pos++) {
					String posible = busca[i].substring(pos, pos+l);
					if(palabras.containsKey(posible)){
						System.out.println("PARA: "+ posible);
						palabras.get(posible).visualizarNodos();
						sinCoincidencias = false;
					}

				}
			}
		}
		if(sinCoincidencias){
			System.out.println("No se han encontrado ninguna coincidencia");
		}
	}
	
	public ArrayList<String> buscar(String palabraClave, HashMap<String,Double> pageRanks){
		TreeSet <WebPeso> arbol = new TreeSet<WebPeso>();
		UnorderedDoubleLinkedList<String> paginas = this.palabras.get(palabraClave);
		Iterator<String> it = paginas.iterator();
		while (it.hasNext()) {
			String pag = it.next();
			double pesoPag = pageRanks.get(pag);
			WebPeso act = new WebPeso(pag, pesoPag);
			arbol.add(act);
		}
		
		ArrayList<String> pagFinal = new ArrayList<String>();
		Iterator<WebPeso> itArbol = arbol.iterator();
		while (itArbol.hasNext()) {
			WebPeso web = itArbol.next();
			pagFinal.add(web.nombre);
		}
		
		return pagFinal;
	}
	
	public ArrayList<String> buscarOpcional(String palabraClave1, String palabraClave2, HashMap<String,Double> pageRanks){
		TreeSet <WebPeso> arbol1 = new TreeSet<WebPeso>();
		UnorderedDoubleLinkedList<String> paginas1 = this.palabras.get(palabraClave1);
		Iterator<String> it1 = paginas1.iterator();
		UnorderedDoubleLinkedList<String> paginas2 = this.palabras.get(palabraClave2);
		Iterator<String> it2 = paginas2.iterator();
		
		while (it1.hasNext()) {
			String pag = it1.next();
			double pesoPag = pageRanks.get(pag);
			WebPeso act = new WebPeso(pag, pesoPag);
			arbol1.add(act);
		}
		
		TreeSet <WebPeso> arbol2 = new TreeSet<WebPeso>();
		
		while (it2.hasNext()) {
			String pag = it2.next();
			double pesoPag = pageRanks.get(pag);
			WebPeso act = new WebPeso(pag, pesoPag);
			boolean added = arbol1.add(act);
			if (!added) {
				arbol2.add(act);
				arbol1.remove(act);
			}
		}
		
		ArrayList<String> pagFinal = new ArrayList<String>();
		Iterator<WebPeso> itArbol1 = arbol1.iterator();
		Iterator<WebPeso> itArbol2 = arbol2.iterator();
		
		while (itArbol2.hasNext()) {
			WebPeso web = itArbol2.next();
			pagFinal.add(web.nombre);
		}
		
		while (itArbol1.hasNext()) {
			WebPeso web = itArbol1.next();
			pagFinal.add(web.nombre);
		}
		
		return pagFinal;
	}



	//Imprime todas las keys y sus listas.
	public void imprimir(){
	    for(String key: palabras.keySet()){
	        System.out.println(key + " - " + palabras.get(key));
	    }

	}

	//Vacia el hashmap.
	public void reset(){
		this.palabras.clear();
	}
	
	private class WebPeso implements Comparable{
		//Atributos
		public String nombre;
		public double peso;
		
		//Constructora
		private WebPeso(String pNombre, double pPeso){
			this.nombre = pNombre;
			this.peso = pPeso;
		}
		
		@Override
	    public int compareTo(Object obj) {
	        if (obj instanceof WebPeso)
	        	return comparar(this, ((WebPeso) obj));
	        return 0;
		}
		
		private Integer comparar(WebPeso web1, WebPeso web2){
			//creamos nuevas variable string
			double pesoWeb1 = web1.peso;
			double pesoWeb2 = web2.peso;

			//las comparamos
			int resultado = 0;
			if (web1.nombre.equals(web2.nombre)) resultado = 0;
			else if (pesoWeb1 < pesoWeb2) resultado = 1;
			else resultado = (-1);
			
			
			return resultado;

		}
		
	}
}
