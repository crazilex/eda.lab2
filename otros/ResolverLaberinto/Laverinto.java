package ResolverLaberinto;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class Laverinto 
{
	// ATRIBUTOS
	private Casilla inicio;
	private Casilla fin;
	private Casilla actual;
	
	private int[][] revisada;
	private int[][] laverinto;
	
	// CONSTRUCTORA
	public Laverinto ( int[][] matriz ) 
	{
		int i = 0;    // filas
		int j = 0;    // columnas
		
		this.laverinto = matriz;
		this.revisada = matriz;
		
		this.inicio = new Casilla ( 0 , 0 );
		this.actual = this.inicio;
		this.fin = new Casilla ( matriz.length , matriz[0].length );
	}
	
	// GETTERS y SETTERS
	public Casilla getInicio() { return inicio; }
	public void setInicio(Casilla inicio) { this.inicio = inicio; }
	
	public Casilla getFin() { return fin; }
	public void setFin(Casilla fin) { this.fin = fin; }
	
	public Casilla getActual() { return actual; }
	public void setActual(Casilla actual) { this.actual = actual; }

	public int[][] getRevisada() { return revisada; }
	public void setRevisada(int[][] revisada) { this.revisada = revisada; }
	
	// RESOLVER LABERINTO
	
	private boolean esAcessible (Casilla pCasilla)
	{
		/* dada una casilla comprueba si es posible pasar por ella, es decir que devolvera false
		 *     si esta dentro de los limites del laberinto 
	     *     si ya se ha pasado por ella  
		 */		
		boolean margenSup = false;
		if ( pCasilla.getFila() < 0 || pCasilla.getFila() > this.fin.getFila() ) { margenSup = true; }
		
		boolean margenInf = false;
		if ( pCasilla.getColumna() < 0 || pCasilla.getColumna() > this.fin.getColumna() ) { margenInf = true; }
		
		boolean revisada = false;
		if ( this.revisada[pCasilla.getFila()][pCasilla.getColumna()] != 0  ) { revisada = true; }
		
		boolean accesible = false;
		if ( !margenInf && !margenSup && !revisada) { accesible = true; }	
		
		return accesible;		
	}
	
	private Casilla movimientoPosible ( ) 
	{
		/* comprueba para la casilla actual si puede moverse a alguna de sus adyacentes devolviendo:
		 *    null si no puede moverse a ninguna
		 *    la casilla a la que se puede mover si puede moverse 
		 */
		Casilla movimientoPosible = null;
		
		Casilla arriba    = new Casilla( this.actual.getFila() + 1 , this.actual.getColumna()     );
		Casilla abajo     = new Casilla( this.actual.getFila() - 1 , this.actual.getColumna()     );
		Casilla derecha   = new Casilla( this.actual.getFila()     , this.actual.getColumna() + 1 );
		Casilla izquierda = new Casilla( this.actual.getFila()     , this.actual.getColumna() - 1 );
		
			 if ( this.esAcessible( arriba    ) ) { movimientoPosible = arriba; }
		else if ( this.esAcessible( abajo     ) ) { movimientoPosible = abajo; }
		else if ( this.esAcessible( derecha   ) ) { movimientoPosible = derecha; }
		else if ( this.esAcessible( izquierda ) ) { movimientoPosible = izquierda; }
	
		return movimientoPosible;
	}
	
	private Stack<Casilla> resolverLaberinto()
	{		
		Stack<Casilla> recorrido = new Stack<Casilla>();
		recorrido.push( this.inicio );
		
		boolean notieneSolucion = false;
		boolean llegamosAlFin = false;
		
		while ( !llegamosAlFin && !notieneSolucion )
		{
			     if ( this.movimientoPosible() == null && this.actual.equals(this.inicio) ) { notieneSolucion = true; }
			else if ( this.actual.equals(this.fin) ) { llegamosAlFin = true; }
			
			else if ( this.movimientoPosible() != null ) 
			{
				this.actual = this.movimientoPosible();
				recorrido.push( this.actual );
				this.revisada[this.actual.getFila()][this.actual.getColumna()] = 2; 
			}
			else { this.actual = recorrido.pop();}	
		}		
		return recorrido;	
	}
	
	// IMPRIMIR PANTALLA
	public void imprimirLaberinto() 
	{
		int i = 0;    // filas
		int j = 0;    // columnas
		
		String fila = "   ";
		while ( i != this.laverinto[0].length ) { fila = fila + i + " "; i++; } 	
		System.out.println( fila + "");	
		fila = " "; i = 0;	
		
		while ( i != this.laverinto[0].length ) 
		{			
			while ( j != this.laverinto.length ) 
			{
				fila = fila + this.laverinto[i][j] + " ";
				j++;
			}
			j = 0; i++;
			System.out.println( (i-1) + "-" + fila + " "); 
			fila = " ";	
		}
	}
	
	public void imprimirRecorrido() 
	{
		Stack<Casilla> recorrido = this.resolverLaberinto();
		while ( !recorrido.isEmpty() ) 
		{			
			System.out.println( "( " + this.actual.getFila() + " , " + this.actual.getColumna() + " )" ); 
			this.actual = recorrido.pop();
		}
	}

	
	
}
