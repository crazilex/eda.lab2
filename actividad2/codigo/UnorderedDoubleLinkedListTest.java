package segundaFase;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*Node<Integer> n = l2.first;
for(int i = 0; i<l2.count; i++){
	System.out.println(n.data);
	n = n.prev;
}*/

public class UnorderedDoubleLinkedListTest {
	public static void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
	
	UnorderedDoubleLinkedList<Integer> l;
	
	@Before
	public void setUp() throws Exception {
		l = new UnorderedDoubleLinkedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		l.first = null;
		l.count = 0;
	}

	@Test
	public void testAddToFront() {
		System.out.println("\n---------testAddToFront()");
		visualizarNodos(l);
		l.addToFront(1);
		visualizarNodos(l);
		l.addToFront(2);
		visualizarNodos(l);
	}

	@Test
	public void testAddToRear() {
		System.out.println("\n---------testAddToRear()");
		visualizarNodos(l);
		l.addToRear(1);
		visualizarNodos(l);
		l.addToRear(2);
		visualizarNodos(l);
	}

	@Test
	public void testRemoveFirst() {
		System.out.println("\n---------testRemoveFirst()");
		System.out.println("Un elemento:");
		l.addToRear(1);
		visualizarNodos(l);
		l.removeFirst();
		visualizarNodos(l);
		System.out.println("Varios elementos:");
		l.addToRear(2);
		l.addToRear(3);
		l.addToRear(4);
		l.addToRear(5);
		l.addToRear(6);
		visualizarNodos(l);
		l.removeFirst();
		visualizarNodos(l);
		l.removeFirst();
		visualizarNodos(l);
		
		System.out.println("\nInverso");
		Node<Integer> n = l.first.prev; 
		for(int i = 0; i<l.count; i++){
			System.out.println(n.data);
			n = n.prev;
		}
	}

	@Test
	public void testRemoveLast() {
		System.out.println("\n---------testRemoveLast()");
		System.out.println("Un elemento:");
		l.addToRear(1);
		visualizarNodos(l);
		l.removeLast();
		visualizarNodos(l);
		System.out.println("Varios elementos:");
		l.addToRear(2);
		l.addToRear(3);
		l.addToRear(4);
		l.addToRear(5);
		l.addToRear(6);
		visualizarNodos(l);
		l.removeLast();
		visualizarNodos(l);
		l.removeLast();
		visualizarNodos(l);
		
		System.out.println("\nInverso");
		Node<Integer> n = l.first.prev;
		for(int i = 0; i<l.count; i++){
			System.out.println(n.data);
			n = n.prev;
		}
	}

	@Test
	public void testRemove() {
		System.out.println("\n---------testRemove()");
		System.out.println("Vacio:");
		System.out.println(l.remove(1));
		System.out.println("Un elemento:");
		l.addToRear(1);
		visualizarNodos(l);
		l.remove(1);
		visualizarNodos(l);
		System.out.println("Varios elementos:");
		l.addToRear(2);
		l.addToRear(3);
		l.addToRear(4);
		l.addToRear(5);
		l.addToRear(6);
		visualizarNodos(l);
		l.remove(2);
		visualizarNodos(l);
		l.remove(5);
		visualizarNodos(l);
		System.out.println("Varios elementos (no esta):");
		l.remove(8);
		visualizarNodos(l);
		
		System.out.println("\nInverso");
		Node<Integer> n = l.first.prev;
		for(int i = 0; i<l.count; i++){
			System.out.println(n.data);
			n = n.prev;
		}
	}

	@Test
	public void testContains() {
		System.out.println("\n---------testContains()");
		System.out.println("Vacio:");
		System.out.println(l.contains(1));
		System.out.println("Un elemento:");
		l.addToRear(1);
		visualizarNodos(l);
		System.out.println(l.contains(1));
		System.out.println("Un elemento (no esta):");
		System.out.println(l.contains(2));
		System.out.println("Varios elementos:");
		l.addToRear(2);
		System.out.println(l.contains(2));
		System.out.println("Varios elementos (no esta):");
		System.out.println(l.contains(3));
	}

	@Test
	public void testFind() {
		System.out.println("\n---------testFind()");
		System.out.println("Vacio:");
		System.out.println(l.find(1));
		System.out.println("Un elemento:");
		l.addToRear(1);
		visualizarNodos(l);
		System.out.println(l.find(1));
		System.out.println("Un elemento (no esta):");
		System.out.println(l.find(2));
		System.out.println("Varios elementos:");
		l.addToRear(2);
		System.out.println(l.find(2));
		System.out.println("Varios elementos (no esta):");
		System.out.println(l.find(3));
	}

}
