package EstructuraListaDobleEnlazada;

public class ListaDobleEnlazadaOrdenada<T> extends ListaDobleEnlazada<T> implements LDEOrdenada<T>
{

	public void anadirOrdenado( T pElemento )
	{
		Nodo<T> nuevo = new Nodo( pElemento );
		super.cuantos++;
		
		if ( super.esVacia() ) 
		{ 
			super.lista = nuevo; 
			super.lista.setAnterior ( nuevo );
			super.lista.setSiguiente( nuevo );
		}
		else 
		{
			Nodo<T> targeted = buscarPosicion( pElemento );
			
			if ( targeted == null ) 
			{
				Nodo<T> ultimo = super.lista.getAnterior(); 			
				nuevo.setSiguiente( super.lista );  // el nuevo nodo apuntara al antiguo primero por delante
				nuevo.setAnterior( ultimo );	    // el nuevo nodo apuntara al ultimo por detras	
				super.lista.setAnterior( nuevo );   // el antiguo primero pasara a apuntar al nuevo por detras 
				ultimo.setSiguiente( nuevo );       // el ultimo pasara a apuntar al nuevo por delante   
			}
			else
			{
				Nodo<T> anterior = targeted.getAnterior();			
				nuevo.setSiguiente( targeted );
				nuevo.setAnterior( anterior );			
				targeted.setAnterior( nuevo );
				anterior.setSiguiente( nuevo );
			}
		}
		
		
	}

	
	private Nodo<T> buscarPosicion( T pElemento ) 
	{
		boolean esta = false;
		Nodo<T> buscado = null;
		if ( !this.esVacia() ) 
		{			
			Iterador<T> itr = this.getIterador();
			int i = itr.getTamano();
			while ( itr.tieneSiguiente() && !esta && i>1 ) 
			{ 
				i--;
				itr.siguiente();
				if ( ( (Comparable<T>)itr.getActual().getDato() ).compareTo( pElemento ) > 0 ) 
				{ 
					esta = true; 
					buscado = itr.getActual();
				}
			}
		}	
		return buscado;	
	}	
}
