package eda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Graph {

	HashMap<String, Integer> th;
	String[] keys;
	ArrayList<Integer>[] adjList;

	public void crearGrafo(Webs webs){
		// Post: crea el grafo desde la lista de webs
		//       Los nodos son nombres de webs

		// Paso 1: llenar “th”

		int tamanoArbol = webs.tamano();
		PagWeb web;
		adjList = new ArrayList<Integer>()[web.+1000]; //el array tiene espacio para todas las webs del arbol y otras 1.000 mas
		Iterator<PagWeb> it = webs.getIterador();
		while (it.hasNext()){
			web = it.next();
			String nombre = web.getNombre();
			int id = web.getId();
			th.put(nombre,id);
			// Paso 3: llenar “adjList”
			adjList[id] = web.getListaRef(); //anade en el array de referencias en la posicion segun el id de la web
		}

		// Paso 2: llenar “keys” wn un array
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
		boolean enc = false;
		boolean[] examinados = new boolean[th.size()];

            // COMPLETAR CÓDIGO
			if(a1.equals(a2)) enc = true;			
			else{
				examinados[pos1] = true;
				porExaminar.add(pos1);
				while(!enc && porExaminar.isEmpty()){
					int actual = porExaminar.poll();
					examinados[actual] = true;
					if(actual == pos2) enc = true;	
					else{
						for (int i = 0; i<adjList[actual].size();i++){
							porExaminar.add([actual].get(i));
						}
					}
				}
			}
		return enc;
}
