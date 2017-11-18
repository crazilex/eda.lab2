package eda;

import java.util.*;

public class Graph {

	HashMap<String, Integer> th;
	String[] keys;
	ArrayList<Integer>[] adjList;
	private static Graph miGraph = null;

	private Graph(){
		this.th = new HashMap<String, Integer>();
	}
	
	public static Graph getGraph() {
		if(miGraph == null) {
			miGraph = new Graph();
		}
		return miGraph;
	}

	public void crearGrafo(Webs webs){
		// Post: crea el grafo desde la lista de webs
		//       Los nodos son nombres de webs

		// Paso 1: llenar “th”

		int tamanoArbol = webs.tamano();
		int tamanoArray = tamanoArbol+1000;
		PagWeb web;
		adjList = new ArrayList[tamanoArray]; //el array tiene espacio para todas las webs del arbol y otras 1.000 mas
		
		//Inicializar las el array de arraylist
		//Inicializar los arraylist del array
		for( int j=0; j < tamanoArray; j++ ){ 
			adjList[j] = new ArrayList<Integer>(); 
		}
			
		Iterator<PagWeb> it = webs.getIterador();
		while (it.hasNext()){
			web = it.next();
			String nombre = web.getNombre();
			int id = web.getId();
			th.put(nombre,id);
			// Paso 3: llenar “adjList”
			adjList[id] = web.getListaRef(); //anade en el array de referencias en la posicion segun el id de la web
		}

		// Paso 2: llenar “keys” en un array
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;

	}

	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		   System.out.print("Element: " + i + " " + keys[i] + " --> ");
		   for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		   System.out.println();
	   }
	}
	
	public boolean estanConectados(String a1, String a2){
		Queue<Integer> porExaminar = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		int actual = pos1;
		boolean enc = false;
		boolean[] examinados = new boolean[th.size()];

        // TODO: REVISAR
		if(a1.equals(a2)) enc = true;			
		else{
			examinados[pos1] = true;
			porExaminar.add(pos1);
			while(!enc && !porExaminar.isEmpty()){
				actual = porExaminar.poll();
				examinados[actual] = true;
				if(actual == pos2) enc = true;	
				else{
					for (int i = 0; i<adjList[actual].size();i++){
						porExaminar.add(adjList[actual].get(i));
					}
				}
			}
		}
		return enc;
	}
	
	public LinkedList<Integer> caminoConectado(String a1, String a2){
		//metodo que busca el camino y almacena los ids en un array
		Queue<Integer> porExaminar = new LinkedList<Integer>();
		int[] conexiones = new int[th.size()];
		LinkedList<Integer> camino = new LinkedList<Integer>();
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		int actual = pos1;
		int anterior = actual;
		boolean enc = false;
		boolean[] examinados = new boolean[th.size()];
		
        // TODO: COMPLETAR
		if (estanConectados(a1, a2)) {
			if(a1.equals(a2)) enc = true;			
			else{
				examinados[pos1] = true;
				porExaminar.add(pos1);
				while(!enc && porExaminar.isEmpty()){
					if (!examinados[actual]) {
						actual = porExaminar.poll();
						conexiones[actual] = anterior;
						examinados[actual] = true;
						if(actual == pos2) enc = true;	
						else{
							for (int i = 0; i<adjList[actual].size();i++){
								porExaminar.add(adjList[actual].get(i));
							}
						}
					}
					else{
						actual = porExaminar.poll();
					}
					anterior = actual;
				}
			}
		}
		actual = pos1;
		while(conexiones[actual] != pos2) {
			camino.add(conexiones[actual]);
			actual= conexiones[actual];
		}
		return camino;
	}
	
	public ArrayList<String> estanConectadosOpcional(String a1, String a2){
		//metodo opcional que dada la lista de ids del camino devuelve el nombre de las webs que conectan de a1 a a2
		LinkedList<Integer> enlacesID =  caminoConectado(a1, a2);
		ArrayList<String> enlacesDeWebs = new ArrayList<String>();
		ListIterator<Integer> listIterator = enlacesID.listIterator();
		
		while(listIterator.hasNext()) {
			enlacesDeWebs.add(keys[enlacesID.poll()]);
		}
		return enlacesDeWebs;
	}
	
	public void printCamino(String a1, String a2){
		ArrayList<String> lista = new ArrayList<String>(); 
		lista = estanConectadosOpcional(a1, a2);
		ListIterator<String> listIterator = lista.listIterator();
		while(listIterator.hasNext()) {
			listIterator.next();
			System.out.print(listIterator.next() + " --> ");
		}
	}

	//TODO: Falta la prueba random
	/*	PSEUDOCODIGO
    import java.util.Random;
	Random rand = new Random();
	int  n = rand.nextInt(50) + 1;


    int probar (int nPruebas)\bar{
    	post: el resultado es el tiempo(ms)
        
        int t = tactual;
        int cont = 0;
        
        while (cont<n){
        	v1 = naleatorio(Max);
            v2 = naleatorio(Max);
            if v1 != v2 {
            	conectados(v1,v2)
                cont++;
        }
    }
    */
}
