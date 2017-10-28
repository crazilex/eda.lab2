package EstructuraListaDobleEnlazada;

public class Persona implements Comparable<Persona> 
{	
	// ATRIBUTOS
	private String name;
    private String dni;
	
    // CONSTRUCTORA
	public Persona( String pName, String pDni) 
	{ 
		this.name = pName;
		this.dni = pDni;
	}
	
	// GETTERS y SETTERS
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getDni() { return dni; }

	public void setDni(String dni) { this.dni = dni; }

	// METODOS
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) { return true; }	
		if (obj == null)  { return false; }	
		if ( getClass() != obj.getClass() ) { return false; }
			
		Persona other = (Persona) obj;
		if (dni == null) { if (other.dni != null) { return false; }	} 
		else if ( !dni.equals(other.dni) ) { return false; }
			
		return true;
	}
			
	@Override
	public int compareTo(Persona arg0) { return name.compareToIgnoreCase(arg0.name); }

	@Override
	public String toString() { return name + " " + dni; }
	
}
