package eda;

import java.util.HashMap;

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
	public void anadirPalabra(String palabra){
		if (!this.palabras.containsKey(palabra)){
			UnorderedDoubleLinkedList<String> l = new UnorderedDoubleLinkedList<String>();
			this.palabras.put(palabra, l);
		}
	}

	//Metodo que se utilizara para introducir el nombre de una Web en las palabras del Diccionario.
	//pre: Un nombre no vacio de una web.
	//post: Annade el nombre de la web a todas las palabras que utiliza esa web.
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
}
