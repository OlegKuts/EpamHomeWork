package arraylinkedlist;

public class ArrayLinkedList<T> {
	private int listSize = 0;
	private int n;
	private Node<T> header = new Node<T>(null, null);

	public ArrayLinkedList(int n) {
		this.n = n;
		header.next = header.previous = header;
	}

	private class Node<T> {
		private Node<T> next;
		private Node<T> previous;
		private T[] elementsArr;
		private boolean hasPlace;

		@SuppressWarnings("unchecked")
		public Node(Node<T> next, Node<T> previous) {
			this.next = next;
			this.previous = previous;
			this.elementsArr = (T[]) new Object[n];
			this.hasPlace = true;
		}
	}

	public void add(T element) {
		Node<T> curNode = null;
		if (header.next == header) {
			curNode = new Node<T>(header, header.previous);
			header.previous = curNode;
			header.next = curNode;
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
					curNode.elementsArr[i] = element;
					placeCount++;
				} else if (curNode.elementsArr[i] == null) {
					placeCount++;
				}
			}
			if (placeCount == 1) {
				curNode.hasPlace = false;
			}
		} else {
			Node<T> newNode = new Node<T>(header, header.previous);
			newNode.next.previous = newNode;
			newNode.previous.next = newNode;
			newNode.elementsArr[0] = element;
			listSize++;
		}

	}

	public int getSize() {
		return listSize;
	}

	private Node<T> findElementsNode(T element) {
		Node<T> curNode = header;
		for (int i = 0; i < listSize; i++) {
			curNode = curNode.next;
			for (T curElement : curNode.elementsArr) {
				if (element.equals(curElement)) {
					return curNode;
				}
			}
		}
		return null;

	}

	public boolean contains(T element) {
		return findElementsNode(element) != null;
	}

	public T remove(T element) {
		T curElement = null;
		Node<T> curNode = findElementsNode(element);
		if (curNode != null) {
			int freeSpace = 0;
			for (int i = 0; i < curNode.elementsArr.length; i++) {
				if (element.equals(curNode.elementsArr[i])) {
					curElement = curNode.elementsArr[i];
					curNode.elementsArr[i] = null;
					curNode.hasPlace = true;
				}
				if (curNode.elementsArr[i] == null) {
					freeSpace++;
				}
			}
			if (freeSpace == curNode.elementsArr.length) {
				curNode.next.previous = curNode.previous;
				curNode.previous.next = curNode.next;
				curNode.next = curNode.previous = null;
				curNode.elementsArr = null;
				listSize--;
			}
		}
		return curElement;
	}

	@Override
	public String toString() {
		String str = "[ ";
		Node<T> current = header;
		while ((current = current.next) != header) {
			str += "{";
			for (int i = 0; i < current.elementsArr.length; i++) {
				if (i == current.elementsArr.length - 1) {
					str += current.elementsArr[i] + "} ";
				} else {
					str += current.elementsArr[i] + ", ";
				}
			}
		}
		str += "]";
		return str;
	}
}
