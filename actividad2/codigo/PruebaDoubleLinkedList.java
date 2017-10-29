package segundaFase;

import java.util.Iterator;


public class PruebaDoubleLinkedList {
	
	public static void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
		
	public static void main(String[] args)  {
		
		UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(9);
		l.addToRear(0);
		l.addToRear(20);
		l.addToFront(8);
		l.remove(new Integer(7));

		
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println("Num elementos: " + l.size());
				
		
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		
		
		// CASOS DE PRUEBA NUESTROS
		
		UnorderedDoubleLinkedList<Integer> l2 = new UnorderedDoubleLinkedList<Integer>();
		int data;
		
		// PRUEBAS addToRear //
		
		// Anadir solo un elemento
		l2.addToRear(5);
		
		// Anadir dos veces el mismo elemento
		l2.addToRear(6);
		l2.addToRear(6);
		
		// PRUEBAS addToFront //
		
		// Anadir solo un elemento
		l2.addToFront(5);
		
		// Anadir dos elementos
		l2.addToFront(5);
		l2.addToFront(6);
		
		// Anadir dos veces el mismo elemento
		l2.addToFront(5);
		l2.addToFront(5);
		l2.addToFront(6);
		
		// Anadir mas de dos elementos
		l2.addToFront(5);
		l2.addToFront(7);
		l2.addToFront(6);
		
		// PRUEBAS removeFirst //
		
		// Eliminar primer elemento de una lista de solo un elemento
		l2.addToFront(10);
		l2.removeFirst();
		
		// Eliminar primer elemento de una lista de dos elementos
		l2.addToFront(10);
		l2.addToFront(12);
		l2.removeFirst();
		
		// Eliminar primer elemento de una lista de mas de dos elementos
		l2.addToFront(12);
		l2.addToFront(10);
		l2.addToFront(15);
		l2.removeFirst();
		
		// PRUEBAS removeLast //
		
		// Eliminar ultimo elemento de una lista de solo un elemento
		l2.addToFront(10);
		l2.removeLast();
		
		// Eliminar ultimo elemento de una lista de dos elementos
		l2.addToFront(10);
		l2.addToFront(12);
		l2.removeLast();
		
		// Eliminar primer elemento de una lista de mas de dos elementos
		l2.addToFront(12);
		l2.addToFront(10);
		l2.addToFront(15);
		l2.removeLast();
		
		// PRUEBAS remove //
		
		// Eliminar un elemento de una lista de solo un elemento (esta el elemento)
		l2.addToFront(10);
		l2.remove(10);
		
		// Eliminar un elemento de una lista de solo un elemento (no esta el elemento)
		l2.addToFront(10);
		l2.remove(12);
		
		// Eliminar un elemento (primero) de una lista de dos elementos (esta el elemento)
		l2.addToFront(10);
		l2.addToFront(12);
		l2.remove(12);
		
		// Eliminar un elemento (ultimo) de una lista de dos elementos (esta el elemento)
		l2.addToFront(10);
		l2.addToFront(12);
		l2.remove(10);
		
		// Eliminar un elemento de una lista de dos elementos (no esta el elemento)
		l2.addToFront(10);
		l2.addToFront(12);
		l2.remove(11);
		
		// Eliminar un elemento (primero) de una lista de mas de dos elementos
		l2.addToFront(12);
		l2.addToFront(10);
		l2.addToFront(15);
		l2.remove(15);
		
		// Eliminar un elemento (un elemento del medio) de una lista de mas de dos elementos
		l2.addToFront(12);
		l2.addToFront(10);
		l2.addToFront(15);
		l2.remove(10);
		
		// Eliminar un elemento (ultimo) de una lista de mas de dos elementos
		l2.addToFront(12);
		l2.addToFront(10);
		l2.addToFront(15);
		l2.remove(12);
		
		// PRUEBAS contains //
		
		// Lista vacia
		System.out.print(l2.contains(5));
		
		// Lista de un elemento
		l2.addToFront(2);
		System.out.print(l2.contains(2));
		System.out.print(l2.contains(1));
		
		// Lista de dos o mas elementos
		l2.addToFront(2);
		l2.addToFront(3);
		System.out.print(l2.contains(2));
		System.out.print(l2.contains(3));
		
		// PRUEBAS find //
		
		// Lista vacia
		data = l2.find(5);
		System.out.println(data);
		
		// Lista de un elemento
		l2.addToFront(5);
		data = l2.find(5);
		System.out.println(data);
		
		// Encontrar un elemento (primero) de una lista de dos elementos
		l2.addToFront(5);
		l2.addToFront(8);
		data = l2.find(8);
		System.out.println(data);
		
		// Encontrar un elemento (ultimo) de una lista de dos elementos
		l2.addToFront(5);
		l2.addToFront(8);
		data = l2.find(8);
		System.out.println(data);
		
		// Encontrar un elemento (primero) de una lista de dos o mas elementos
		l2.addToFront(5);
		l2.addToFront(8);
		l2.addToFront(12);
		data = l2.find(12);
		System.out.println(data);
		
		// Encontrar un elemento (un elemento del medio) de una lista de dos o mas elementos
		l2.addToFront(5);
		l2.addToFront(8);
		l2.addToFront(12);
		data = l2.find(8);
		System.out.println(data);
		
		// Encontrar un elemento (ultimo) de una lista de dos o mas elementos
		l2.addToFront(5);
		l2.addToFront(8);
		l2.addToFront(12);
		data = l2.find(5);
		System.out.println(data);
		
		visualizarNodos(l2);
	}
}