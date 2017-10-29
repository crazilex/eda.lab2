package EstructuraListaDobleEnlazada;

public class Nodo<T>
{
	// ATRIBUTOS
	public T dato; 			    // dato del nodo
	public Nodo<T> anterior; 	// puntero al anterior nodo de la lista
	public Nodo<T> siguiente; 	// puntero al siguiente nodo de la lista
	
	//CONSTRUCTORA
	public Nodo( T pDato ) 		
	{
		this.dato = pDato;
		this.siguiente = null;
		this.anterior = null;
	}
	
	// METODOS
	public T getDato () { return this.dato; }
	public Nodo<T> getAnterior () { return this.anterior; }
	public Nodo<T> getSiguiente () { return this.siguiente; }
	
	public void setDato ( T pDato ) { this.dato = pDato; }
	public void setAnterior  ( Nodo<T> pNodo ) { this.anterior = pNodo;  }
	public void setSiguiente ( Nodo<T> pNodo ) { this.siguiente = pNodo; }
}
