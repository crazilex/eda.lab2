package EstructuraListaDobleEnlazada;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDobleEnlazada<T> implements LDE<T> 
{
	// ATRIBUTOS
	protected Nodo<T> lista; 
	protected String descripcion; 
	protected int cuantos;

	// Constructor
	public ListaDobleEnlazada() 
	{
		this.lista = null;
		this.descripcion = "";
		this.cuantos = 0;
	}
	
	// GETTERS y SETTERS
	
	public void setDescripcion(String pNombre) { this.descripcion = pNombre; }

	public String getDescripcion() { return this.descripcion; }
	
	// ITERADOR 
	
	public Iterador<T> getIterador() { return new Iterador<T>( this.lista , this.cuantos ); }

	// ELIMINAR
	
	public T eliminarPrimero() 
	{
		Nodo<T> eliminado = this.lista;           // eliminamos el primero de la lista
		Nodo<T> ultimo = eliminado.getAnterior(); 
		this.cuantos--;
		
		if ( this.Primero() == this.Ultimo() ) { this.lista = null; }
		else 
		{
			this.lista = this.lista.getSiguiente();  // el primero pasa a ser el siguiente de la lista		
			this.lista.setAnterior( ultimo );        // el nuevo primer elemento pasa a apuntar al ultimo por detras
			ultimo.setSiguiente( this.lista );       // el ultimo elemento pasa a puntar al nuevo primero por delante	
		}
		
		return eliminado.getDato();         // devolvemos el dato del elemento eliminado
	}

	public T eliminarUltimo() 
	{
		Nodo<T> eliminado = this.lista.getAnterior(); // eliminamos el ultimo de la lista
		Nodo<T> ultimo = eliminado.getAnterior();     // el nuevo ultimo pasa a ser el penultimo		
		this.cuantos--;
		
		if ( this.Primero() == this.Ultimo() ) { this.lista = null; }
		else 
		{
			this.lista.setAnterior( ultimo );             // el primero pasa a apuntar al nuevo ultimo por detras
			ultimo.setSiguiente( this.lista );            // el nuevo ultimo pasa a apuntar al primero por delante
		}
		
		return eliminado.getDato();                   // devolvemos el dato del elemento eliminado
	}

	public T eliminar( T pElemento ) 
	{
		Nodo<T> eliminado = buscar(pElemento);
		this.cuantos--;
		
		     if ( eliminado.getDato().equals( this.Primero() ) ) { this.eliminarPrimero(); }
		else if ( eliminado.getDato().equals( this.Ultimo()  ) ) { this.eliminarUltimo();  } 
		else 
		{
			eliminado.getAnterior().setSiguiente( eliminado.getSiguiente() );
			eliminado.getSiguiente().setAnterior( eliminado.getAnterior()  );
		}
		return eliminado.getDato();
	}

	// DEVOLVER ELEMENTO	

	public boolean esVacia() { return this.lista == null; }

	public int size() { return this.cuantos; }
	
	public T Primero() { return this.lista.getDato(); }

	public T Ultimo() {	return this.lista.getAnterior().getDato(); }

	public boolean contiene( T pElemento ) 
	{
		boolean esta = false;
		Iterador<T> itr = this.getIterador();
		while ( itr.tieneSiguiente() && !esta ) { if ( itr.siguiente().equals( pElemento ) ) { esta = true; } }
		return esta;
	}

	public Nodo<T> buscar( T pElemento ) 
	{
		boolean esta = false;
		Nodo<T> buscado = null;
		if ( !this.esVacia() ) 
		{
			
			Iterador<T> itr = this.getIterador();
			int i = itr.getTamano();
			while ( itr.tieneSiguiente() && !esta && i>0 ) 
			{ 
				i--;
				itr.siguiente();
				if ( itr.getActual().getDato().equals( pElemento ) ) 
				{ 
					esta = true; 
					buscado = itr.getActual();
				}
			}
		}	
		return buscado;	
	}	
	
	// IMPRIMIR
	public void imprimirListaCompleta( ) 
	{
		Iterador<T> itr = this.getIterador();
		System.out.println(this.descripcion);
		int i = itr.getTamano();
				
		while ( i > 0 ) 
		{ 
			i--;
			System.out.println( (Comparable<T>)itr.getActual().getDato().toString() ); 
			itr.siguiente();
		}
	}	
}


