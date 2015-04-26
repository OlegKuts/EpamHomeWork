package arraylinkedlist;

public class Main {

	public static void main(String[] args) {
		ArrayLinkedList<Integer> arrlist = new ArrayLinkedList<Integer>(3);
		
			arrlist.add(1);
			arrlist.add(2);
			arrlist.add(3);
			arrlist.add(4);
			arrlist.add(5);
			arrlist.add(6);
			arrlist.add(7);
			arrlist.add(8);
			arrlist.add(9);
			arrlist.add(10);
		
		System.out.println(arrlist);
		System.out.println(arrlist.getSize());
	}

}
