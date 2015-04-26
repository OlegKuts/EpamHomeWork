package linkedlist;

public class MyLinkedList<T> {
	private int size = 0;
	private Node<T> header = new Node<T>(null, null, null);

	private static class Node<T> {
		private T element;
		private Node<T> next;
		private Node<T> previous;

		public Node(T element, Node<T> next, Node<T> previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}

	public void add(T e) {
		Node<T> newNode = new Node(e, header, header.previous);
		newNode.next.previous = newNode;
		newNode.previous.next = newNode;
		++size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node<T> currentNode = header;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.element;
	}

	public boolean remove(Object e) {
		for (Node<T> currentNode = header.next; currentNode != header; currentNode = currentNode.next) {
			if (e.equals(currentNode.element)) {
				currentNode.next.previous = currentNode.previous;
				currentNode.previous.next = currentNode.next;
				currentNode.next = currentNode.previous = null;
				currentNode.element = null;
				--size;
				return true;
			}
		}
		return false;
	}

	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node<T> currentNode = header;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		T x = currentNode.element;
		currentNode.element = null;
		currentNode.next.previous = currentNode.previous;
		currentNode.previous.next = currentNode.next;
		currentNode.next = currentNode.previous = null;
		--size;
		return x;
	}

	public boolean contains(Object e) {
		for (Node<T> currentNode = header.next; currentNode != header; currentNode = currentNode.next) {
			if (e.equals(currentNode.element)) {
				return true;
			}
		}
		return false;
	}
}