package GrafoDijkstra;

import EstructuraListaDobleEnlazada.ListaDobleEnlazadaDesordenada;

public class ListaWebs 
{
	// ATRIBUTOS
	private ListaDobleEnlazadaDesordenada<Web> lista;
	
	
	// CONSTRUCTORA
	public ListaWebs(){ this.lista = new ListaDobleEnlazadaDesordenada<Web>(); }
	
	// Metodos	
	public void anadirPrimero ( Web pWeb ) { this.lista.anadirPrincipio(pWeb); }
	public void clear ( ) { this.lista = new ListaDobleEnlazadaDesordenada<Web>(); }
	public int size ( ) { return this.lista.size(); }
	public Web devolverPrimero ( ) { return this.lista.Primero(); }
	public void eliminarPrimero ( ) { this.lista.eliminarPrimero(); }
		
}
