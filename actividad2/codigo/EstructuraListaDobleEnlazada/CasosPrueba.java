package EstructuraListaDobleEnlazada;

public class CasosPrueba 
{
	public static void main(String[] args)
	{
		Persona p1 = new Persona("AAA", "1");
		Persona p2 = new Persona("BBB", "2");
		Persona p3 = new Persona("EEE", "3");
		Persona p4 = new Persona("DDD", "4");
		Persona p5 = new Persona("CCC", "5");
		Persona p6 = new Persona("GGG", "6");
		Persona p7 = new Persona("HHH", "7");
		Persona p8 = new Persona("FFF", "8");
		Persona p9 = new Persona("III", "9");

		ListaDobleEnlazadaDesordenada<Persona> lista = new ListaDobleEnlazadaDesordenada<Persona> ();
		lista.setDescripcion("Lista de Personas");
		
		lista.anadirPrincipio(p1);
		lista.anadirPrincipio(p2);
		lista.anadirPrincipio(p3);
		lista.anadirPrincipio(p4);
		
		lista.imprimirListaCompleta();
	}
}
