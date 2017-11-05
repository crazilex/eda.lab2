package EstructuraEnlazada;

public class Nodo<T> 
{
	// ATRIBUTOS
	private T dato;
	private Nodo<T> sigiente;
	
	// CONSTRUCTORA
	public Nodo ( T pDato )
	{
		this.setDato(pDato);
		setSigiente(null); 
	}
	
	// GETTERS y SETTERS
	public T getDato() { return dato; }
	public void setDato(T dato) { this.dato = dato; }

	public Nodo<T> getSigiente() { return sigiente; }
	public void setSigiente(Nodo<T> sigiente) { this.sigiente = sigiente; }


}
