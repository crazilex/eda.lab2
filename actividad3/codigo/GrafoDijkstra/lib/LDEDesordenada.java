package EstructuraListaDobleEnlazada;

public interface LDEDesordenada<T> extends LDE<T>
{
	public void anadirPrincipio( T pElemento );
	// añade un elemento al comienzo
	// COSTE: constante, no depende de los parametros de entrada

	public void anadirFinal( T pElemento );
	// añade un elemento al final
	// COSTE: constante, no depende de los parametros de entrada
	
	public void anadirDespues( T pElemento , T target );
	// Añade elem detrás de otro elemento concreto, target,  que ya se encuentra en la lista
	// COSTE: lineal con respecto al nuemro de elementos de la lista en la que se quiere añadir
	
}
