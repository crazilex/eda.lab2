package EstructuraListaDobleEnlazada;

public class ListaDobleEnlazadaDesordenada<T> extends ListaDobleEnlazada<T> implements LDEDesordenada<T> 
{
	// AÑADIR
	
	public void anadirPrincipio( T pElemento ) 
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
			Nodo<T> ultimo = super.lista.getAnterior();			
			nuevo.setSiguiente( super.lista );  // el nuevo nodo apuntara al antiguo primero por delante
			nuevo.setAnterior( ultimo );	    // el nuevo nodo apuntara al ultimo por detras	
			super.lista.setAnterior( nuevo );   // el antiguo primero pasara a apuntar al nuevo por detras 
			ultimo.setSiguiente( nuevo );       // el ultimo pasara a apuntar al nuevo por delante
			super.lista = nuevo;                // el nuevo pasa a ser el primero de la lista
		}
	}

	public void anadirFinal( T pElemento ) 
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

	public void anadirDespues( T pElemento , T pTarget ) 
	{
		Nodo<T> targeted = buscar( pTarget );
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
