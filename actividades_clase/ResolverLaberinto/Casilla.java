package ResolverLaberinto;

public class Casilla 
{
	// ATRIBUTOS	
	private int fila;
	private int columna;
		
	// CONSTRUCTORA
	public Casilla ( int pFila , int pColumna ) 
	{ 
		this.setFila(pFila);
		this.setColumna(pColumna);	
	}

	// GETTERS y SETTERS
	public int getFila() { return fila; }
	public void setFila(int fila) { this.fila = fila; }

	public int getColumna() { return columna; }
	public void setColumna(int columna) { this.columna = columna; }
	
	// METODOS
	
	public boolean equals( Casilla pCasilla ) { return ( this.fila == pCasilla.getFila() && this.columna == pCasilla.getColumna() ); }
	
}
