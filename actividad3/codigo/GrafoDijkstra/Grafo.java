package GrafoDijkstra;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo 
{
	// ATRIBUTOS
	private HashMap<String, Integer> nombres;   
	private String[] identificadores;
	private ArrayList<Integer>[] direcciones;
    
    // CONSTRUCTORA : 
	// COSTE: lineal con respecto al numero de elementos de pLista
    public Grafo ( ListaWebs pLista ) 
    {
    	this.nombres = new HashMap<>();
    	
    	int i = 0; 
    	while (i != pLista.size() ) 
    	{
    		Web elemento = pLista.devolverPrimero();
    		pLista.eliminarPrimero();    		
    		nombres.put( elemento.getNombre() , elemento.getID() );
    		this.identificadores[i] = elemento.getNombre();
    		direcciones[i] = elemento.getEnlaces();
    		i++;
    	}
    }
    
    // GETTERS y SETTERS 
	public HashMap<String, Integer> getNombres() { return nombres; }
	public void setNombres(HashMap<String, Integer> nombres) { this.nombres = nombres; }
	
	public String[] getIdentificadores() { return identificadores; }
	public void setIdentificadores(String[] identificadores) { this.identificadores = identificadores; }

	public ArrayList<Integer> getDirecciones() { return direcciones; }
	public void setDirecciones(ArrayList<Integer> direcciones) { this.direcciones = direcciones; }
	
	// DETERMINAR SI EXISTE CONEXION
	public boolean estanConectados(String a, String b)
	{
		
		// TODO
		return false;
	}
	
	// OBTENER EL CAMINO
	 
	
		
	
	// IMPRIMIR GRAFO
	public void imprimirGrafo()
	{
		for (int i = 0; i < direcciones.length; i++){
			System.out.print("Element: " + i + " " + identificadores[i] + " --> ");
			for (int k: direcciones[i])  System.out.print(identificadores[k] + " ### ");		
			System.out.println();
		   }
		}	
}