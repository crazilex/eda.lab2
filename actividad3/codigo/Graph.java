public class Graph {
	
      HashMap<String, Integer> th;
      String[] keys;
      ArrayList<Integer>[] adjList;
	
	public void crearGrafo(ListaWebss lista){
		// Post: crea el grafo desde la lista de webs
		//       Los nodos son nombres de webs
		
		
            // Paso 1: llenar “th”
            // COMPLETAR CÓDIGO

            // Paso 2: llenar “keys”
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;

            // Paso 3: llenar “adjList”
            // COMPLETAR CÓDIGO
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
		
		return enc;

	}
}
