package EstructuraEnlazada;

public class ListaEnlazada<T> 
{
	// ATRIBUTOS
	private Nodo<T> lista;
	
	// CONSRTRUCTORA
	public ListaEnlazada(){ this.setLista(null); }
	
	// GETTERS y SETTERS
	public Nodo<T> getLista() { return lista; }
	public void setLista(Nodo<T> lista) { this.lista = lista; }
	
	// AÑADIR ELEMENTOS
	public void anadirInicio ( T pDato ) 
	{
		Nodo<T> nuevo = new Nodo<T>( pDato );	
		if ( this.lista == null ) { this.lista = nuevo; }
		else 
		{ 
			nuevo.setSigiente( this.lista);
			this.lista = nuevo;
		}
	}
	
	public void anadirFinal ( T pDato ) 
	{
		Nodo<T> nuevo = new Nodo<T>( pDato );		
		if ( this.lista == null ) { this.lista = nuevo; }
		else 
		{ 
			ListaEnlazada<T> x = this;
			while ( x.getLista().getSigiente() != null ) { x.setLista( x.getLista().getSigiente() ); }
			x.getLista().setSigiente( nuevo );
		}
	}
	
	public void anadirOrdenado ( T pDato ) 
	{
		Nodo<T> nuevo = new Nodo<T>( pDato );
		if ( this.lista == null ) { this.lista = nuevo; }
		else 
		{
			ListaEnlazada<T> x = this;
			ListaEnlazada<T> y = this;
			boolean primero = false;
			while ( ( ( (Comparable<T> )x.getLista().getDato() ).compareTo( pDato ) ) > 0 && ( x.getLista().getSigiente() != null ) )
			{
				if ( primero ) { y.setLista( y.getLista().getSigiente() ); } else { primero = true; }
				x.setLista( x.getLista().getSigiente() ); 
			}
			if ( x.getLista().getSigiente() == null ) { this.anadirFinal( pDato ); }
			else 
			{
				y.getLista().setSigiente( nuevo );
				nuevo.setSigiente( x.getLista() );
			}	
		}		
	}
	
	// IMPRIMIR
	public void imprimir()
	{
		ListaEnlazada<T> x = this;
		while ( x.getLista().getSigiente() != null )
		{
			x.setLista( x.getLista().getSigiente() ); 
			System.out.println( x.getLista().getDato().toString() ); 
		}
	}
	
	// METODOS
	public boolean esSublista ( ListaEnlazada<T> l1 )
	{
		boolean esSublista = true;
		ListaEnlazada<T> x = this;
		ListaEnlazada<T> y = l1;
		
		while ( y.getLista().getSigiente() != null && esSublista ) 
		{
			if ( x.getLista().getDato().equals( y.getLista().getDato() ) ) 
			{
				x.setLista( x.getLista().getSigiente() );
				y.setLista( y.getLista().getSigiente() );
			}
			else if ( ( (Comparable<T>)x.getLista().getDato() ).compareTo( y.getLista().getDato() ) > 0 ) { y.setLista( y.getLista().getSigiente() ); }
			else { esSublista = false; }
		}
		if ( esSublista ) { System.out.println("l1 es Sublista de l2"); } else { System.out.println("l1 y l2 no son sublista"); }
		return esSublista;
		
	}
}
