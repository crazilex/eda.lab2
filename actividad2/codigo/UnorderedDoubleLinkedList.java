package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

	public void addToFront(T elem) {
		//pre: -
		// post: anade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE: O(1)
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
	// a�ade un elemento al final
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE: O(1)
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

	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!

	}

}
