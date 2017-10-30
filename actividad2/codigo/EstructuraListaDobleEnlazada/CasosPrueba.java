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
		/*
		// PRUEBAS LISTA DESORDENADA
		ListaDobleEnlazadaDesordenada<Persona> lista = new ListaDobleEnlazadaDesordenada<Persona> ();
		lista.setDescripcion("Lista de Personas");
		
		System.out.println("Añadir elementos al principio");
		lista.anadirPrincipio(p1);
		lista.anadirPrincipio(p2);
		lista.anadirPrincipio(p3);
		lista.anadirPrincipio(p4);
		lista.imprimirListaCompleta();
		System.out.println(" ");
		
		System.out.println("Eliminar el primero ");
		lista.eliminarPrimero();
		lista.eliminarPrimero();
		lista.eliminarPrimero();
		lista.imprimirListaCompleta();
		System.out.println(" ");
		
		System.out.println("Eliminar el primero si solo queda 1");
		lista.eliminarPrimero();
		lista.imprimirListaCompleta();
		System.out.println(" ");
		
		System.out.println("Añadir elementos al final");
		lista.anadirFinal(p9);
		lista.anadirFinal(p8);
		lista.anadirFinal(p7);
		lista.anadirFinal(p6);
		lista.imprimirListaCompleta();
		System.out.println(" ");
		
		System.out.println("Eliminar el ultimo");
		lista.eliminarUltimo();
		lista.eliminarUltimo();
		lista.eliminarUltimo();	
		lista.imprimirListaCompleta();
		System.out.println(" ");
		
		System.out.println("Eliminar el ultimo si solo queda 1");
		lista.eliminarUltimo();
		lista.imprimirListaCompleta();
		System.out.println(" ");
		
		System.out.println("añadir despues de un elementos siendo el primero q se añade");
		lista.anadirDespues(p8, p1);
		lista.imprimirListaCompleta();
		System.out.println(" ");
		
		System.out.println("añadir despues de un elemento que no esta");
		lista.anadirDespues(p2, p1);
		lista.anadirDespues(p3, p1);
		lista.anadirDespues(p4, p1);
		lista.imprimirListaCompleta();
		System.out.println(" ");
		
		System.out.println("añadir despues de un elementos que si esta");
		lista.anadirDespues(p1, p8);
		lista.anadirDespues(p1, p3);
		lista.imprimirListaCompleta();
		System.out.println(" ");
		*/
		// PRUEBAS LISTA ORDENADA
		ListaDobleEnlazadaOrdenada<Persona> lista2 = new ListaDobleEnlazadaOrdenada<Persona>();
		lista2.setDescripcion("Lista de Personas");
				
		System.out.println("Añadir elementos ordenadamente");
		lista2.anadirOrdenado(p1);
		lista2.anadirOrdenado(p2);
		lista2.anadirOrdenado(p3);
		lista2.anadirOrdenado(p4);
		lista2.anadirOrdenado(p5);
		lista2.anadirOrdenado(p6);
		lista2.anadirOrdenado(p7);
		lista2.anadirOrdenado(p8);
		lista2.anadirOrdenado(p9);
		lista2.imprimirListaCompleta();
		System.out.println(" ");
		
	}
}
