package edu.escuelaing.arep.linkedlistcalculator.linkedlist;

/**
 * Linked List is a representation of LinkedList's java class.
 * 
 * @author Eduard Jimenez
 *
 */
public class LinkedList {

	private Node head;
	private int size;

	public LinkedList() {
		size = 0;
	}

	/**
	 * Add a new element to the list in last position
	 * 
	 * @param element
	 */
	public void add(double element) {
		if (head != null) {
			Node actual = head;
			while (actual.next != null) {
				actual = actual.next;

			}
			actual.next = new Node(element);
			actual.next.head = actual;

		} else {
			head = new Node(element);
			head.head = null;
		}
		increment();
	}

	/**
	 * removes the last element on linkedlist if it's not empty
	 */
	public void remove() {
		if (head != null) {
			Node actual = head;
			while (actual.next != null) {
				actual = actual.next;

			}
			actual = null;
		}
		decrement();
	}

	/**
	 * Removes data element passed by parameter.
	 * 
	 * @param data
	 */
	public void remove(double data) {
		if (head == null)
			return;

		if (head.data == data) {
			head = head.next;
			return;
		}

		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}


	/**
	 * Gets the node in index position.
	 * 
	 * @param index
	 * @return
	 */
	public Node get(int index) {
		if (index < size()) {
			Node auxiliar = head;
			int cont = 0;
			while (auxiliar != null) {
				if (cont == index) {
					return auxiliar;
				}
				auxiliar = auxiliar.next;
				cont++;
			}
		}
		return null;
	}

	/**
	 * Gets linkedlist's head.
	 * 
	 * @return head
	 */
	public Node getHead() {
		return head;
	}

	public int size() {
		return size;
	}

	/**
	 * Increments linkedlist's size
	 */
	private void increment() {
		size++;
	}

	/**
	 * Decrements linkedlist's size
	 */
	private void decrement() {
		size--;
	}

}
