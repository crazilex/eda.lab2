package EstructuraListaDobleEnlazada;

public class ListaDobleEnlazadaOrdenada<T> extends ListaDobleEnlazada<T> implements LDEOrdenada<T>
{

	private void anadirFinal( T pElemento ) 
	{
		Nodo<T> nuevo = new Nodo( pElemento );
		super.cuantos++;
		
		if ( super.esVacia() ) { super.lista = nuevo; }
		else 
		{
			Nodo<T> ultimo = super.lista.getAnterior(); 			
			nuevo.setSiguiente( super.lista );  // el nuevo nodo apuntara al antiguo primero por delante
			nuevo.setAnterior( ultimo );	    // el nuevo nodo apuntara al ultimo por detras	
			super.lista.setAnterior( nuevo );   // el antiguo primero pasara a apuntar al nuevo por detras 
			ultimo.setSiguiente( nuevo );       // el ultimo pasara a apuntar al nuevo por delante            			
		}
	}
	
	private Nodo<T> buscarPosicion( T pElemento ) 
	{
		boolean esta = false;
		Nodo<T> targeted = null;
		Iterador<T> itr = this.getIterador();
		while ( itr.tieneSiguiente() && !esta ) 
		{ 
			itr.siguiente();
			if ( ( (Comparable<T>)itr.getActual().getDato() ).compareTo( pElemento) > 0 )
			{
				esta = true; 
				targeted = itr.getActual();
			} 
		}
		return targeted;
	}
	
	public void anadirOrdenado( T pElemento )
	{
		Nodo<T> targeted = buscarPosicion( pElemento );
		super.cuantos++;
		
		if ( targeted == null || targeted.getDato().equals( this.Ultimo() ) ) { this.anadirFinal( pElemento ); }
		else
		{
			Nodo<T> nuevo = new Nodo( pElemento );
			Nodo<T> siguiente = targeted.getSiguiente();			
			nuevo.setAnterior( targeted );
			nuevo.setSiguiente( siguiente );			
			targeted.setSiguiente( nuevo );
			siguiente.setAnterior( nuevo );
		}
		
	}

}
