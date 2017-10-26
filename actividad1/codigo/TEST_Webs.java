package eda;

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
