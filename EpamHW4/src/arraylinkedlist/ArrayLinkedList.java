package arraylinkedlist;

public class ArrayLinkedList<T> {
	private int listSize = 0;
	private int n = 0;
	private Node<T> header = new Node<T>(null, null, null);

	public ArrayLinkedList(int n) {
		this.n = n;
	}

	private class Node<T> {
		private T element;
		private Node<T> next;
		private Node<T> previous;
		private T[] elementsArr;

		public Node(T element, Node<T> next, Node<T> previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
			this.elementsArr = (T[]) new Object[n];
		}
	}
	
	//public void add 

}
