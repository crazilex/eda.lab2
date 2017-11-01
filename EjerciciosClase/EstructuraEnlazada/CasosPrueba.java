package EstructuraEnlazada;

import EstructuraListaDobleEnlazada.Persona;

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
	
		// LISTA ORDENADA
		ListaEnlazada<Persona> l1 = new ListaEnlazada();
		l1.anadirInicio(p1);
		l1.anadirInicio(p2);

		l1.anadirInicio(p4);
		l1.anadirInicio(p5);	
		l1.imprimir();
		System.out.println("");
		
		ListaEnlazada<Persona> l2 = new ListaEnlazada();
		l2.anadirInicio(p1);
		l2.anadirInicio(p2);
		l2.anadirInicio(p3);
		l2.anadirInicio(p4);
		l2.anadirInicio(p5);	
		l2.imprimir();
		System.out.println("");
	
		l1.esSublista(l2);
	}
}
