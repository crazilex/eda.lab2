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
		PagWeb web;
		Iterator<PagWeb> it = webs.getIterador();
		while (it.hasNext()){
			web = it.next();
			String nombre = web.getNombre();
			int id = web.getId();
			th.put(nombre,id);
		}

		// Paso 2: llenar “keys”
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;

		// Paso 3: llenar “adjList”
		PagWeb webAux;
		int webID;
		int tamanoArbol = webs.tamano();
		adjList = new ArrayList<Integer>()[tamanoArbol+1000]; //el array tiene espacio para todas las webs del arbol y otras 1.000 mas

		Iterator<PagWeb> it2 = webs.getIterador();
		while (it2.hasNext()){
			web = it2.next();
			webID = web.getId();
			adjList[webID] = web.getListaRef(); //anade en el array de referencias en la posicion segun el id de la web
		}

	}

	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");

		System.out.println();
	   }
	}
	/*
	public boolean estanConectados(String a1, String a2){
		Queue<Integer> porExaminar = new LinkedList<Integer>();

		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean enc = false;
		boolean[] examinados = new boolean[th.size()];

                 // COMPLETAR CÓDIGO

		return enc;

	}
	*/
}
