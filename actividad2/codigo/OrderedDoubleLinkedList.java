package segundaFase;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		// pre: -
		// post: si la lista esta vacia anade el elemento el principio, sino lo anade en su posicion ordenada
		// coste: O(n) siendo n el numero de elementos de lista
		
		Node<T> nuevo = new Node<T>(elem);

		if (first == null) {
			nuevo.prev = nuevo;
			nuevo.next = nuevo;
            first = nuevo;
            count++;
		}else{
			Node<T> aux = first;
			boolean enc = false;
			int cont = 0;
			while ((cont < count) && !enc) {
				int comparacion = ((Comparable<T>) nuevo.data).compareTo(aux.data);
				if (comparacion < 0) {
					nuevo.prev = aux.prev;
					nuevo.next = aux;
					aux.prev.next = nuevo;
					aux.prev = nuevo;
					if (aux == first)
						first = nuevo;
					enc = true;
					count++;
				}
				else {
					cont++;
					aux = aux.next;
				}
			}
			if (!enc) { //si no ha sido encontrado un elemento menor se anade al final
				aux = aux.next;
				nuevo.prev = aux;
				nuevo.next = aux.next;
				aux.next.prev = nuevo;
				aux.next = nuevo;
				enc = true;
				count++;
			}
		}
	}


}