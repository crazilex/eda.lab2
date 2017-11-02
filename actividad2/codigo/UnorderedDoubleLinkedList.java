package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	public void addToFront(T elem) {
		// pre: -
		// post: anade un elemento al comienzo
		// coste: O(1)

		Node<T> n = new Node<T>(elem);
		if (super.count == 0){
			super.first = n;
			n.next = n;
			n.prev = n;
			this.count++;
		}else{
			n.next = super.first;
			n.prev = super.first.prev;
			super.first.prev.next = n;
			super.first.prev = n;
			this.first = n;
			this.count++;
		}
	}

	public void addToRear(T elem) {
		// pre: -
		// post: anade un elemento al final
		// coste: O(1)

		Node<T> n = new Node<T>(elem);
		if (super.count == 0){
			super.first = n;
			n.next = n;
			n.prev = n;
			this.count++;
		}else{
			n.next = super.first;
			n.prev = super.first.prev;
			super.first.prev.next = n;
			super.first.prev = n;
			this.count++;
		}
	}

	public void addAfter(T elem, T target){
			//pre: target se encuentra en la lista
			//post: se anade elem detras de target
			//coste: O(n) siendo n el numero de elementos de la lista

			boolean enc = false;
			Node<T> aux = first;
			Node<T> nuevo = new Node<T>(elem);

			while(!enc && (aux.next != first)) {
				if (aux.data.equals(target)) {
					enc = true;
					nuevo.prev = aux;
					nuevo.next = aux.next;
					aux.next.prev = nuevo;
					aux.next = nuevo;
					count++;
				}
				else {
					aux = aux.next;
				}
			}
			if (first.prev.data.equals(target) && !enc) {
				enc = true;
				nuevo.prev = aux;
				nuevo.next = aux.next;
				aux.next.prev = nuevo;
				aux.next = nuevo;
				count++;
			}
		}

}
