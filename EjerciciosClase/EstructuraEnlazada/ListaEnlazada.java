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
			Nodo<T> x = this.lista;
			Nodo<T> y = this.lista;
			boolean primero = false;
			while ( ( ( (Comparable<T> )x.getDato() ).compareTo( pDato ) ) > 0 && ( x.getSigiente() != null ) )
			{
				if ( primero ) { y = y.getSigiente(); } else { primero = true; }
				x = x.getSigiente(); 
			}
			if ( x.getSigiente() == null ) { this.anadirFinal( pDato ); }
			else 
			{
				y.setSigiente( nuevo );
				nuevo.setSigiente( x );
			}	
		}		
	}
	
	// IMPRIMIR
	public void imprimir()
	{
		Nodo<T> x = this.lista;
		while ( x.getSigiente() != null )
		{
			x = x.getSigiente(); 
			System.out.println( x.getDato().toString() ); 
		}
	}
	
	// METODOS
	public boolean esSublista ( ListaEnlazada<T> l1 )
	{
		boolean esSublista = true;
		Nodo<T> x = this.lista;
		Nodo<T> y = l1.lista;
		
		while ( y.getSigiente() != null && esSublista ) 
		{
			if ( x.getDato().equals( y.getDato() ) ) 
			{
				x = x.getSigiente();
				y = y.getSigiente();
			}
			else if ( ( (Comparable<T>)x.getDato() ).compareTo( y.getDato() ) > 0 ) { y = y.getSigiente(); }
			else { esSublista = false; }
		}
		if ( esSublista ) { System.out.println("l1 es Sublista de l2"); } else { System.out.println("l1 y l2 no son sublista"); }
		return esSublista;
		
	}
}
