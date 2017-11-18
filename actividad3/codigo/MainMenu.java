package eda;

import eda.StopWatch;
import java.io.*;
import java.util.*;


public class MainMenu {


	//Esto es lo que se ejecutara mientras este encendido
	public static void main(String[] args) throws FileNotFoundException {

		// "Empieza" el programa
		MainMenu miMenu = MainMenu.getMenu();
		try{

			miMenu.cargarDeFichero(true);


			/*
			  	//TEST de que funciona el arbol binario
			 		Webs.websID.imprimirArbol(Webs.websID.getRaiz());

					System.out.println("+++++++++++++++++++++++++++++++++++++++++++\n");
			 		Webs.getWebs().imprimirArbol(Webs.getWebs().raiz);
			 		Webs.getWebs().encontrarWeb("redditcooty.com").printList();


					for(int k=0; k<2;k++){
						Webs.websID.encontrarWebPorID(k).printList();
					}
			*/

			miMenu.imprimirMenu();
			miMenu.seleccionarMenu();



		}catch(FileNotFoundException nSe){
			System.out.print("Agur no se ha encontrado los archivos de texto compruebe que ha introducido bien el nombre de los archivos\n");
			//nSe.printStackTrace();
			miMenu.imprimirMenu();
			miMenu.seleccionarMenu();
		}

	}

	//Constructora
		private MainMenu()
		{
		}
	/******************************************************************************************************************************************/

	//Atributos del Menu principal (Alex)

	private Scanner scan;	//Necesario para leer comandos de la consola, se utiliza en leer y para cargar el fichero
	private static MainMenu miMenu = null;

	/*----------------------------------------------------------------------------------------------------------------------------------------*/

	//Metodos del menu principal (Alex)
	public static MainMenu getMenu() {
		if(miMenu == null) {
			miMenu = new MainMenu();
		}
		return miMenu;
	}

	public void imprimirMenu(){
		System.out.print("Elija una opcion:\n");
		String[] opciones = {"Buscar una pagina web",
							"Buscar conexion entre dos webs",
							"Añadir nuevo elemento (web o palabra clave)",
							"Obtener la lista de webs ordenada (predeterminado alfabeticamente)",
							"Devolver las paginas web enlazadas desde una web dada",
							"Guardar la lista de webs en ficheros",
							"Cargar datos desde un fichero (se añadira ordenado)",
							"Salir"};

		for(int i=0; i<7; i++){
			System.out.print(i+1);
			System.out.println("- " + opciones[i]);
		}
	}

	public void seleccionarMenu() throws FileNotFoundException{
		boolean salir = false;
		while (!salir){
			String opcionElegida = miMenu.leer();
			String[] a = new String[] {"1","b","buscar","buscar pagina","buscar pagina web"};
			String[] b = new String[] {"2","conexion"};
			String[] c = new String[] {"3","a","añadir","anadir","cargar nuevo elemento","añadir nuevo elemento"};
			String[] d = new String[] {"4","o","Obtener","webs","lista ordenada","obtener la lista de webs ordenada"};
			String[] e = new String[] {"5","d","Devolver","devolver las paginas","lista webs","Devolver las paginas web enlazadas desde una web dada"};
			String[] f = new String[] {"6","g","guardar","guardar lista","guardar la lista webs","guardar fichero","save"};
			String[] g = new String[] {"7","c","cargar","load","cargar datos","cargardatos"};
			String[] h = new String[] {"8","q","salir","exit","quit","escape","leave"};

			//MODIFICAR
			if(miMenu.comparar(a, opcionElegida)){
				miMenu.buscarPagWeb();
			}
			else if(miMenu.comparar(b, opcionElegida)){
				miMenu.estanConectados();
			}
			else if(miMenu.comparar(c, opcionElegida)){
				miMenu.addElemento();
			}
			else if(miMenu.comparar(d, opcionElegida)){
				miMenu.obtenerWebs();
			}
			else if(miMenu.comparar(e, opcionElegida)){
				miMenu.pagWebReferenciadas();
			}
			else if(miMenu.comparar(f, opcionElegida)){
				miMenu.guardarWebsEnFichero();
			}
			else if(miMenu.comparar(g, opcionElegida)){
				miMenu.cargarDeFichero(false);
			}
			else if(miMenu.comparar(h, opcionElegida)){
				miMenu.salirApp();
				salir = true;
			}
			else{
				System.out.println("La opción escogida no es valida, comprueba que este bien escrito o se listo y utiliza los numeros\n");
			}
			if(!salir){
				System.out.println();
				imprimirMenu();
			}
		}

	}
	private void buscarPagWeb() {
		System.out.println("Introduzca lo que quiera buscar (pagina web o palabras clave): ");
		String strings = miMenu.leer();
		String[] sp = strings.split(" +");
		StopWatch timer = new StopWatch();
		if(strings.contains(".")){

			try{
				PagWeb pagina = Webs.getWebs().encontrarWeb(strings);
				pagina.printIdName();
				System.out.print("	Las paginas referenciadas son: ");
				System.out.println(Webs.getWebs().devolverWebsReferenciadas(pagina).toString());

			}catch(NullPointerException e){
				System.out.println("No se ha encontrado la pagina que busca en concreto. Pruebe a buscar por palabra clave sin la extension '.algo'\n(Si tiene un punto '.' intentara buscar la pagina web en concreto y devolver toda su informacion)\n");
				System.out.println("Estas son las paginas mas similares a la busqueda realizada: ");
				Diccionario.getDiccionario().buscarWeb(sp);
			}
		}
		else{
			Diccionario.getDiccionario().buscarWeb(sp);
		}
		System.out.println("Ha tardado: "+timer.elapsedTime()+"s en encontrar.");
	}

	private void estanConectados() {
		
		System.out.println("Introduzca la primera pagina web: ");
		String string1 = miMenu.leer();
		System.out.println("Introduzca la segunda pagina web: ");
		String string2 = miMenu.leer();
		StopWatch timer = new StopWatch();
		Webs webs = Webs.getWebs();
		Graph grafo = Graph.getGraph();
		grafo.crearGrafo(webs);
		boolean conexion = grafo.estanConectados(string1,string2);
		if (conexion) {
			System.out.println("Las dos webs introducidas si estan conectadas.");
		}
		else {
			System.out.println("Las dos webs introducidas no estan conectadas.");
		}
		System.out.println("Ha tardado: "+timer.elapsedTime()+"s en encontrar la conexion.");
	}
	
	private void cargarDeFichero(boolean cargarTodo) throws FileNotFoundException {
		boolean cIndex=false, cLinks=false, cWords=false;
		boolean ok = false;

		System.out.print("¿Que desea cargar? ");

		if(!cargarTodo){
			System.out.print("(Elija una opcion:)\n");
			String[] opciones = {"Las paginas webs(Indice)",
								 "Los enlaces entre Webs(Links)",
								 "Diccionario (Nuevas palabras clave con las que buscar)",
								 "Aceptar"};

			for(int i=0; i<4; i++){
				System.out.print(i+1);
				System.out.println("- " + opciones[i]);
			}
		}

		while (!ok && !cargarTodo){
			String opcionElegida = miMenu.leer();
			String[] a = new String[] {"1","indice","index","page","pagina","pagina web","paginaweb","pag","webpage", "web"};
			String[] b = new String[] {"2","enlaces","link","links","en clave","word","key"};
			String[] c = new String[] {"3","base","datos","base de datos","pal","palabra","clave","palabra clave","word","key"};
			String[] d = new String[] {"4","ok","confirmar","aceptar","cargar"," ",""};
			if(miMenu.comparar(a, opcionElegida)){
				if(!cIndex)	cIndex = true;
				else 		cIndex = false;
			}
			else if(miMenu.comparar(b, opcionElegida)){
				if(!cLinks)	cLinks = true;
				else 		cLinks = false;
			}
			else if(miMenu.comparar(c, opcionElegida)){
				if(!cWords)	cWords = true;
				else 		cWords = false;
			}
			else if(miMenu.comparar(d, opcionElegida)){
				ok = true;
			}
			else{
				System.out.println("La opción escogida no es valida, comprueba que este bien escrito o se listo y utiliza los numeros\n");
			}
			if(!ok){
				System.out.print("Se cargaran los archivos seleccionados: ");
				if(cIndex){
					System.out.print(" Indice ");
				}
				if(cLinks){
					System.out.print(" Enlaces ");
				}
				if(cWords){
					System.out.print(" Diccionario ");
				}
				System.out.println("");
			}
		}

		if (cargarTodo||cIndex||cLinks||cWords){

			String index=null, links=null, words=null;
			if(cargarTodo||cIndex){
				System.out.println("NOTA: Escribir el nombre completo con la extension (Ej:'.txt')");
				System.out.print("¿Nombre del fichero de las paginas con su indice? (por defecto 'index')");
				index = miMenu.leer();
				if (index == null || index.isEmpty()){
					index = "index";
				}
				System.out.println("El nombre es: "+ index+"\n");
			}
			if(cargarTodo||cLinks){
				System.out.print("¿Nombre del fichero de las paginas con sus enlaces? (por defecto 'pld-arc')");
				links = miMenu.leer();
				if (links == null || links.isEmpty()){
					links = "pld-arc";
				}
				System.out.println("El nombre es: "+ links+"\n");
			}
			if(cargarTodo||cWords){
				System.out.print("¿Nombre del fichero con las palabras del diccionario? (por defecto 'words.txt')");
					words = miMenu.leer();
				if (words == null || words.isEmpty()){
					words = "words.txt";
				}
				System.out.println("El nombre es: "+ words+"\n");
				System.out.println("Cargando archivos...");
			}




			if(cargarTodo||cWords){
				Diccionario.getDiccionario().reset();
				StopWatch timer = new StopWatch();
				//Escanear palabras del diccionario para crear nuestro diccionario
				FileInputStream dicc = new FileInputStream("./"+words);
				scan = new Scanner(dicc);

				while (scan.hasNextLine())
				{
					String linea = scan.nextLine();
					String[] sp = linea.split(" +");

					String word = sp[0];
					Diccionario.getDiccionario().anadirPalabra(word);

				}
				scan.close();
				System.out.println("Ha tardado: "+timer.elapsedTime()+"s en cargar en el diccionario.");
			}


			if(cargarTodo||cIndex){
				Webs.getWebs().reset();
				StopWatch timer = new StopWatch();
				int indice = 0;
				//Mira las webs y separa las palabras y se crea el arbol binario que contiene todas las webs
				FileInputStream webs = new FileInputStream("./"+index);
				ArrayList<Integer> paginas = new ArrayList<>();
				PagWeb pag = new PagWeb(0, null, paginas);
				scan = new Scanner(webs);
				while (scan.hasNextLine())//Hasta que no haya mas lineas
				{

					String linea = scan.nextLine();		//Leer por linea
					String[] sp = linea.split(" +");	//Separar por /

					String nombre = sp[0];
					indice = Integer.parseInt(sp[1]);
					pag = new PagWeb(indice, nombre, paginas);
					Webs.getWebs().addWeb(pag);
					Diccionario.getDiccionario().añadirWeb(nombre);

				}
				scan.close();
				Webs.getWebs().setLastID(indice);
				System.out.println("Ha tardado: "+timer.elapsedTime()+"s en cargar total para cargar las webs");

			}

			if(cargarTodo||cLinks){
				//Escanear paginas que referencia
				StopWatch timer = new StopWatch();
				FileInputStream link = new FileInputStream("./"+links);
				scan = new Scanner(link);
				while (scan.hasNextLine())
				{
					String linea = scan.nextLine();
					String[] sp = linea.split(" +");

					int indice = Integer.parseInt(sp[0]);
					int idPagina = Integer.parseInt(sp[1]);
					Webs.getWebs().encontrarWebPorID(indice).addElementListaRef(idPagina);

				}
				scan.close();
				System.out.println("Ha tardado: "+timer.elapsedTime()+"s en cargar la lista de paginas que referencia una web (Links).");
			}
		}
		System.out.println("Operacion completada\n");
	}

	private void guardarWebsEnFichero() {
		System.out.println("NOTA:  Escribir el nombre completo con la extension (Ej:'.txt')");
		System.out.print("¿Nombre del fichero de las paginas con su indice? (por defecto 'listaWebs.txt')");
		String webs = miMenu.leer();
		if (webs == null || webs.isEmpty()){
			webs = "listaWebs.txt";

			StopWatch timer = new StopWatch();
			//Mirar SI HAY fichero, si no hay fichero crea uno vacio sino NO HARA NADA
			File websFich = new File("./"+webs);
			try {
				websFich.createNewFile();
				PrintWriter w = null;
				Webs.getWebs().guardar(w, webs);
				System.out.println("Exito, se han guardado los datos en el archivo ../" + webs);
				System.out.println("Ha tardado: "+timer.elapsedTime()+"s en guardar la lista de paginas.");

			} catch (IOException e) {
				System.out.println("Ha habido algun error para crear el archivo de texto para guardar las webs");
				e.printStackTrace();
			}

		}
	}

	private ArrayList<PagWeb> pagWebReferenciadas() {
		System.out.println("Introduzca el nombre o el ID de la pagina web que quiere saber que paginas tiene enlazadas: ");
		String strings = miMenu.leer();
		PagWeb pagina = null;
		ArrayList<PagWeb> listaRef = new ArrayList<>();
		listaRef = null;
		StopWatch timer = new StopWatch();
		if (strings != null && !strings.isEmpty()){
			String[] sp = strings.split(" +");
			boolean esInt = true;

			for(int i=0; i<strings.length();i++)
				if (!Character.isDigit(strings.charAt(i))){
					esInt = false;
				}
		//Buscar pagina por id(int)
			if(esInt){
				try{
					pagina = Webs.getWebs().encontrarWebPorID(Integer.parseInt(sp[0]));
					listaRef = Webs.getWebs().devolverWebsReferenciadas(pagina);
					System.out.println("Devuelve las paginas web enlazadas a -> "+ Webs.getWebs().encontrarWebPorID(Integer.parseInt(sp[0])) +":\n  (el enunciado es un poco ambiguo no sabiamos si devolvia el objeto pagina web \n   o imprimir una lista con el nombre pero por si acaso)");
					System.out.println(Webs.getWebs().devolverWebsReferenciadas(pagina).toString());
				}catch(NullPointerException ex){
					System.out.println("El ID de la web que ha introducido es incorrecta o no existe en nuestra base de datos.");
				}

			}
		//Buscar pagina por nombre(String)
			else{
					/*PRUEBAS
						ArrayList<Integer> l = new ArrayList<Integer>(); //les damos una lista vacia de refencias para los tests
						PagWeb pPagina1 = new PagWeb(1,"hola",l);
						System.out.println(sp[0]);
						System.out.println(pPagina1.getNombre());

						PagWeb pagina = Webs.websID.encontrarWeb(sp[0]);
						System.out.println("Las paginas que tiene "+ sp[0] + "enlazadas son: ");
						pagina.getListaRef();
						//pagina.imprimirDatos();
						//Webs.getWebs().devolverWebsReferenciadas(pagina).get(0).getId();		//Para comprobar que coge la lista de una pagina en concreto y no esta vacia
						//System.out.println(Webs.getWebs().devolverWebsReferenciadas(pagina).get(0).getId());	//Prueba como me temia se mete en el arbol binario ordenado y no en el de alfabetico
					*/
				try{
					pagina = Webs.getWebs().encontrarWeb(sp[0]);
					listaRef = Webs.getWebs().devolverWebsReferenciadas(pagina);
					System.out.println("Devuelve las paginas web enlazadas a ->"+ Webs.getWebs().encontrarWeb(sp[0])+":\n(el enunciado es un poco ambiguo no sabiamos si devolvia el objeto pagina web \n   o imprimir una lista asi que por si acaso)");
					System.out.println(Webs.getWebs().devolverWebsReferenciadas(pagina).toString());
				}catch(NullPointerException e){
					System.out.println("El nombre de la web que ha introducido es incorrecta o no existe en nuestra base de datos.");
				}


			}
			System.out.println("Ha tardado: "+timer.elapsedTime()+"s en encontrar la pagina web y devolver su lista de paginas referenciadas (Links).");
		}
		else{
			System.out.println("Error no se ha introducido nada. ");
			pagWebReferenciadas();

		}

		return listaRef;
	}

	private void obtenerWebs() {
		System.out.print("¿Quiere obtener la lista ordenada alfabeticamente(por defecto) o numericamente por id?");
		System.out.print("Elija una opcion:\n");
		String[] opciones = {"Por NOMBRE (Alfabeticamente)",
							 /*"Por ID (Numericamente)",*/
							 "Volver al menu anterior"};

		for(int i=0; i<2; i++){
			System.out.print(i+1);
			System.out.println("- " + opciones[i]);
		}
		boolean atras = false;
		while (!atras){
			String opcionElegida = miMenu.leer();
			String[] a = new String[] {"1","alfa","alfabeticamente", "por nombre","nombre"};
					/*
					String[] b = new String[] {"2","por id","id","numericamente","num"};
					*/
			String[] c = new String[] {"3","back","volver","cancel","atras"," ",""};
			if(miMenu.comparar(a, opcionElegida)){
				StopWatch timer = new StopWatch();
				Webs.getWebs().imprimirArbol();
				atras = true;
				System.out.println("Ha tardado: "+timer.elapsedTime()+"s en imprimir por Nombre (alfabeticamente).");
			}
					/*
					else if(miMenu.comparar(b, opcionElegida)){
						StopWatch timer = new StopWatch();
						Webs.websID.imprimirArbol(Webs.websID.raiz);
						atras = true;
						System.out.println("Ha tardado: "+timer.elapsedTime()+"s en imprimir por ID (numericamente).");
					}
					*/
			else if(miMenu.comparar(c, opcionElegida)){
				atras = true;
			}
			else{
				System.out.println("La opción escogida no es valida, comprueba que este bien escrito o se listo y utiliza los numeros\n");
			}
			if(!atras){
				System.out.println();
			}
		}

	}

	private void addElemento() {

		System.out.print("¿Que quiere anadir una pagina o palabra clave?");
			System.out.print("Elija una opcion:\n");
			String[] opciones = {"Una pagina web",
								 "Una palabra clave",
								 "Volver al menu anterior"};

			for(int i=0; i<2; i++){
				System.out.print(i+1);
				System.out.println("- " + opciones[i]);
			}
		boolean atras = false;
		while (!atras){
			String opcionElegida = miMenu.leer();
			String[] a = new String[] {"1","page","pagina","pagina web","paginaweb","pag","webpage", "web"};
			String[] b = new String[] {"2","pal","palabra","clave","palabra clave","word","key"};
			String[] c = new String[] {"3","back","volver","cancel","atras"," ",""};
			StopWatch timer = new StopWatch();
			if(miMenu.comparar(a, opcionElegida)){
				miMenu.addPagWeb();
				atras = true;
				System.out.println("Ha tardado: "+timer.elapsedTime()+"s en anadir una pagina web.");
			}
			else if(miMenu.comparar(b, opcionElegida)){
				miMenu.addWord();
				atras = true;
				System.out.println("Ha tardado: "+timer.elapsedTime()+"s en anadir una palabra al diccionario.");
			}
			else if(miMenu.comparar(c, opcionElegida)){
				atras = true;
			}
			else{
				System.out.println("La opción escogida no es valida, comprueba que este bien escrito o se listo y utiliza los numeros\n");
			}
			if(!atras){
				System.out.println();
			}
		}
	}

	private void addWord() {

		System.out.print("Introduzca la palabra clave que desea anadir para que el buscador la reconozca\n");
		String word = miMenu.leer();
		Diccionario.getDiccionario().anadirPalabra(word);
		System.out.println("Se a anadido la palabra clave al diccionario\n");
		System.out.println("(Para que el buscador encuentre por esta nueva palabra clave tiene que cargar el indice de las paginas web. NOTA: Si carga las webs no tendran la lista de paginas enlazadas.)\n");
	}

	@SuppressWarnings("null")
	private void addPagWeb() {

		ArrayList<Integer> refs = new ArrayList<Integer>();  ;
		System.out.print("¿Cual es el nombre de la nueva pagina que va a ser anadida?\n");
		String nombre = miMenu.leer();
		int indice = Webs.getWebs().getLastID()+1;

		System.out.println("¿A que paginas web esta enlazadas? (Introducir IDs, para finalizar presionar enter)\n");

		try{
			String ins = "ww";
			while (ins != null || !ins.isEmpty()){
				ins = miMenu.leer();
				if(ins != null || !ins.isEmpty()){
					refs.add(Integer.parseInt(ins));
				}

			}
		}catch(NumberFormatException ex){ // handle your exception

			PagWeb newpag = new PagWeb(indice, nombre, refs);
			newpag.anadirListaRef(refs);
			Webs.getWebs().addWeb(newpag);
			Diccionario.getDiccionario().añadirWeb(nombre);

		}
		Webs.getWebs().setLastID(indice);
		System.out.println("Se ha anadido la pagina web a la base de datos (arbol))\n");
	}

	//NO TOCAR MAS ABAJO
	
	private void salirApp(){
		scan.close();
		System.out.println("Hasta la próxima gracias por utilizar nuestro buscador");
	}

	public String leer(){
		scan = new Scanner(System.in);
		String input = scan.nextLine();
		return input.toLowerCase();
	}

	public boolean comparar(String a[], String opcionElegida){
		boolean igual = false;
		int i=0;
		while(i<a.length && !igual){
			if(opcionElegida.equals(a[i])){
				igual = true;
			}
			i++;
		}
		return igual;
	}

}
