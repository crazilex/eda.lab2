package EstructuraListaDobleEnlazada;
import java.util.NoSuchElementException;

public class Iterador<T> 
{
	// ATRIBUTOS
	public Nodo<T> actual;
	int tamano;
	
	// CONSTRUCTORA
	public Iterador ( Nodo<T> pActual , int pTamano) 
	{
		this.actual = pActual;
		this.tamano = pTamano;
	}
	// GETTERS y SETTERS
	public Nodo<T> getActual() { return this.actual; }
	public int getTamano() { return this.tamano; }
	
	// METODOS ITERADORES
	public boolean tieneSiguiente() { return (this.actual.getSiguiente() != null ); }
	
	public boolean tieneAnterior()  { return (this.actual.getAnterior()  != null ); }
	
	public T siguiente() 
	{
		if (! tieneSiguiente() ) { throw new NoSuchElementException(); }
		
		this.actual = this.actual.getSiguiente();
		return this.actual.getDato();
	}
	
	public T anterior() 
	{ 
		if (! tieneAnterior() ) { throw new NoSuchElementException(); }
		
		this.actual = this.actual.getAnterior();
		return this.actual.getDato();
	}
	
}
