package arraylinkedlist;

public class ArrayLinkedList<T> {
	private int listSize = 0;
	private int n = 0;
	private Node<T> header = new Node<T>(null, null);

	public ArrayLinkedList(int n) {
		this.n = n;
		header.next = header.previous = header;
	}

	private class Node<T> {
		// private T element;
		private Node<T> next;
		private Node<T> previous;
		private T[] elementsArr;
		private boolean hasPlace;

		public Node(Node<T> next, Node<T> previous) {
			this.next = next;
			this.previous = previous;
			this.elementsArr = (T[]) new Object[n];
			this.hasPlace = true;
		}
	}

	public void add(T el) {
		Node<T> curNode = null;
		if (header.next == header) {
			curNode = new Node<T>(header, header);
			header.next = curNode;
			header.previous = curNode;
			listSize++;

		} else {
			curNode = header.next;
		}
		while (!curNode.hasPlace && curNode.next != header) {
			curNode = curNode.next;
		}
		if (curNode.hasPlace) {
			int placeCount = 0;
			for (int i = 0; i < curNode.elementsArr.length; i++) {
				if (curNode.elementsArr[i] == null && placeCount == 0) {
					curNode.elementsArr[i] = el;
					placeCount++;
				} else if (curNode.elementsArr[i] == null) {
					placeCount++;
				}
				if (placeCount < 1) {
					curNode.hasPlace = false;
				}
			}
		} else {
			Node<T> newNode = new Node<T>(header, curNode);
			curNode.next = newNode;
			header.previous = newNode;
			newNode.elementsArr[0] = el;
			listSize++;
		}

	}

	@Override
	public String toString() {
		String str = "";
		Node<T> current = header;
		while (current.next != header) {
			str += "	[";
			for (int i = 0; i < current.elementsArr.length; i++) {
				str += current.elementsArr[i];
				if (i == current.elementsArr.length - 1) {
					str += "]";
				}
			}
		}
		return str;
	}

}
