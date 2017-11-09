package GrafoDijkstra;

import java.util.ArrayList;

public class Web 
{
	// ATRIBUTOS
	private int ID;
	private String nombre;
	private ArrayList<Integer> enlaces;
	
	// CONSTRUCTORA
	public Web ( int pID, String pNombre ) { this.ID = pID; this.nombre = pNombre; enlaces = new ArrayList<>(); }
	
	// GETTERS y SETTERS
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	
	public int getID() { return ID; }
	public void setID(int iD) { ID = iD; }
	
	public ArrayList<Integer> getEnlaces() { return this.enlaces; }
	public void setEnlaces( ArrayList<Integer> pEnlaces ) { this.enlaces = pEnlaces; }
	
	// METODOS
	public void add ( Integer pEnlace ) { this.enlaces.add(pEnlace); }
	public void clear ( ) { this.enlaces.clear(); }
}
