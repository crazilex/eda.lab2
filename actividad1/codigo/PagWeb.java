package eda;

import java.util.ArrayList;
import java.util.Iterator;

public class PagWeb implements Comparable{

// ATRIBUTOS

	private int id;
	private String nombre;
	private ArrayList<Integer> listaRef;

// METODOS

	//Constructora

	public PagWeb (int pId, String pNombre, ArrayList<Integer> pListaRef){
		this.id = pId;
		this.nombre = pNombre;
		this.listaRef = new ArrayList<Integer>();
	}

	private Iterator<Integer> getIterator(){ 
		return this.listaRef.iterator(); 
	}
	
	// getters
	public int getId() {
		return this.id;
	}	
	
	public String getNombre() {
		return this.nombre;
	}	
	public ArrayList<Integer> getListaRef() {
		return this.listaRef;
	}	
	public void printIdName()	{
		System.out.print("ID: " + this.id + "   Nombre: " + this.nombre);
	}
	
	public void imprimirDatos()	{
		System.out.println("ID: " + this.id + "/ Nombre: " + this.nombre + "/ Relacionados: " + this.listaRef + "\n");
	}
	
	//Metodos de la lista
	public void printList(){
		System.out.println(this.getListaRef().toString());
	}
	
	@Override
    public int compareTo(Object obj) {
        if (obj instanceof PagWeb)
            return Webs.comparar(this, ((PagWeb) obj));
        return 0;
	}
	
	
	public void anadirListaRef(ArrayList<Integer> pListaRef) {
		this.listaRef = pListaRef;
	}	
	
	public boolean esta(int pString){ 
		Iterator<Integer> itr = this.getIterator();
		int a;
		boolean esta = false;
		while(itr.hasNext() && !esta){
			a = itr.next();
			if (a == pString) {
				esta = true;
			}
		}
		return esta;
	}
	
	public int buscar(int pIdString){ 
		Iterator<Integer> itr = this.getIterator();
		int a = 0;
		boolean esta = false;
		while(itr.hasNext() && !esta){
			a = itr.next();
			if (a == pIdString) {
				esta = true;
			}
		}
		if (!esta){
			a = 0;
		}
		return a;
	}
	
	//Gestionar Lista int
	public void eliminarString(int pString){
		if(!this.esta(pString)) {
			System.out.println("Id no existente.");
		}
		else {
			this.listaRef.remove(pString);
		}
	}
	
	public void addElementListaRef(int pString){
		if(this.esta(pString)) {
			System.out.println("Referencia ya existente.");
		}
		else if (!(this.buscar(pString)==0)){
			System.out.println("Ya esta referenciada esta pagina.");
		} 
		else {
			this.listaRef.add(pString);
		}
	}
	
	
	public int getNum (){
		return this.listaRef.size();
	}
	
	public void resetear(){ 
		this.listaRef = new ArrayList<Integer>();  
	}
	
	@Override
	public String toString() {
	    return (this.getNombre()+" "+Integer.toString(this.getId()));
	}
	
}