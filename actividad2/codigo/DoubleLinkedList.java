package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// ATRIBUTOS
	protected Node<T> first; // apuntador al primero
	protected String descr;  // descripcion
	protected int count;

	// CONSTRUCTORA
	public DoubleLinkedList() {
		first = null;
		descr = "";
		count = 0;
	}

	public void setDescr(String nom) {
		descr = nom;
	}

	public String getDescr() {
		return descr;
	}

	public T removeFirst() {
		// pre: la lista tiene al menos un elemento
		// post: elimina y devuelve el primer elemento de la lista
		// coste: 0(1)

		T borrado = this.first.data;
		if (this.count == 1){
			this.first = null;
			this.count = this.count - 1;
		}else{
			this.first.prev.next = this.first.next;
			this.first.next.prev = this.first.prev;
			this.first = this.first.next;
			this.count = this.count - 1;
		}
		return borrado;
	}

	public T removeLast() {
		// pre: la lista tiene al menos un elemento
		// post: elimina y devuelve el primer elemento de la lista
		// coste: 0(1)

		T borrado = this.first.prev.data;
		if (this.count == 1){
			this.first = null;
			this.count = this.count - 1;

		}else{
			this.first.prev = this.first.prev.prev;
			this.first.prev.next = this.first;
			this.count = this.count - 1;
		}
		return borrado;
	}


	public T remove(T elem) {
		// pre: la lista tiene al menos un elemento
		// post: elimina y devuelve el elemento de la lista especificado, si no esta deja la lista como estaba y devuelve null
		// coste: O(n) siendo n el numero de elementos de la lista

		boolean enc = false;
		Node<T> aux = this.first;
		if (this.count == 1 && aux.data.equals(elem)){
			this.first = null;
			this.count = this.count - 1;
		}else{
			while (!enc && !aux.equals(this.first.prev)){
				if (aux.data.equals(elem)){
					enc = true;
					if (count == 2){
						first = aux.next;
						first.next = first;
						
					}else {
						aux.next.prev = aux.prev;
						aux.prev.next = aux.next;
					}
				}else{
					aux = aux.next;
				}
			}
		}
		if (aux.data.equals(elem) && !enc){
			aux.next.prev = aux.prev;
			aux.prev.next = aux.next;
			enc = true;
		}
		if (enc){
			this.count = this.count - 1;
			return aux.data;
		}

		return null;

	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	//Da acceso al ultimo elemento de la lista

	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto

		boolean enc = false;
		Node<T> aux = this.first;
		if (isEmpty())
			return false;
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE: O(n)
		else{
			while (!enc && !aux.equals(this.first.prev)){
				if (aux.data.equals(elem)){
					enc = true;
				}else{
					aux = aux.next;
				}
			}
		}
		if (aux.data.equals(elem) && !enc) enc = true;

		return enc;
	}

	public T find(T elem) {
		// pre: -
		// post: determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esta
		// coste: O(n) siendo n el numero de elementos de la lista

		boolean enc = false;
		Node<T> aux = this.first;
		if (isEmpty())
			return null;
		else{
			while (!enc && !aux.equals(this.first.prev)){
				if (aux.data.equals(elem)){
					enc = true;
				}else{
					aux = aux.next;
				}
			}
		}
		if (aux.data.equals(elem) && !enc) enc = true;

		if(enc) return aux.data;
		else return null;
	}

	public boolean isEmpty()
	//Determina si la lista esta vacia
	{ return first == null;};

	public int size()
	//Determina el numero de elementos de la lista
	{ return count;};

	/** Return an iterator to the stack that iterates through the items . */
	public Iterator<T> iterator() { return new ListIterator(); }

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator implements Iterator<T> {
	// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> act = first;
		boolean end = false;

		   @Override
		   public boolean hasNext() {  //O(1)
			   if (act == null) return false;
			   else if(this.act.equals(first) && end) return false;
			   else return true;
		   }

		   @Override
		   public T next() { //O(1)
			   if (!hasNext()) throw new NoSuchElementException("No hay mas elementos");
			   else{
				   T elem = act.data;
				   act = act.next;
				   if (act.equals(first)){
					   end = true;
				   }
				   return elem;
			   }
		   }


	} // private class


	public void visualizarNodos() {
	   System.out.println(this.toString());
	}

	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T elem = it.next();
			result = result + "[" + elem.toString() + "] \n";
		}

		return "SimpleLinkedList " + result + "]";
	}

}
