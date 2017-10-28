package eda;

import java.util.ArrayList;
//import java.util.Iterator;

public class PalabraClave {
// ATRIBUTOS

	private String palabra;
	private ArrayList<String> paginasConPalabra = new ArrayList<String>();

// METODOS

	//Constructora

	public PalabraClave (String pPalabra){
		this.palabra = pPalabra;
		this.paginasConPalabra = new ArrayList<String>();
	}

	// getters
	public String getPalabra() {
		return this.palabra;
	}	
		
	public ArrayList<String> getPaginasConPalabra() {
		return this.paginasConPalabra;
	}
		
	public void imprimirDatos()	{
		System.out.println("Palabra: " + this.palabra + " Paginas: " + this.paginasConPalabra + "\n");
	}
	
	//inserta una palabra real en la lista despues de buscar en el hash map (diccionario)
	public void addPaginaLista(String web){
		this.paginasConPalabra.add(web);
	}
		
	/*public void buscarPagina(String web){
		
			
	}*/
	
	//no creo que necesitemos borrar algo de la lista pero por si acaso
	public boolean borrarPaginaLista(String web){
		return this.paginasConPalabra.remove(web);
			
	}
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paginasConPalabra == null) ? 0 : paginasConPalabra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.palabra == obj)
			return true;
		if (obj == null)
			return false;
		if (this.palabra != obj)
			return false;
		return true;
	}
	*/
}
