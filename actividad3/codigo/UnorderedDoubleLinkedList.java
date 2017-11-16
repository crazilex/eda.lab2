package eda;

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
		//OPCIONAL
	}

}
