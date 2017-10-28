package EstructuraListaDobleEnlazada;

public interface LDE<T> 
{
	public void setDescripcion(String nom);
	// Actualiza el nombre de la lista
	// COSTE: constante, no depende de los parametros de entrada
	
	public String getDescripcion();
	// Devuelve el nombre de la lista
	// COSTE: constante, no depende de los parametros de entrada

	public T eliminarPrimero();
	// Elimina el primer elemento de la lista
	// COSTE: constante, no depende de los parametros de entrada

	public T eliminarUltimo();
	// Elimina el último elemento de la lista
	// COSTE: constante, no depende de los parametros de entrada

	public T eliminar( T pElemento );
	// Elimina un elemento concreto de la lista
	// COSTE: lineal con respecto al nuemro de elementos de la lista en la que se busca

	public T Primero();
	// Devuelve el dato del primer elemento de la lista
	// COSTE: constante, no depende de los parametros de entrada

	public T Ultimo();
	// Devuelve el dato del último elemento de la lista
	// COSTE: constante, no depende de los parametros de entrada

	public boolean contiene( T pElemento );
	// Determina si la lista contiene un elemento concreto
	// COSTE: lineal con respecto al nuemro de elementos de la lista en la que se busca

	public Nodo<T> buscar(T pElemento );
	// Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esté
	// COSTE: lineal con respecto al nuemro de elementos de la lista en la que se busca

	public boolean esVacia();
	// Determina si la lista está vacía
	// COSTE: constante, no depende de los parametros de entrada

	public int size();
	// Determina el número de elementos de la lista
	// COSTE: constante, no depende de los parametros de entrada

	public Iterador<T> getIterador();
	// Devuelve el iterador de la lista
	// COSTE: constante, no depende de los parametros de entrada
}
