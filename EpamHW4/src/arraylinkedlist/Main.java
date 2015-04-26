package arraylinkedlist;

public class Main {

	public static void main(String[] args) {
		ArrayLinkedList<Integer> arrList = new ArrayLinkedList<Integer>(3);

		for(int i = 0; i < 11; i++){
			arrList.add(i);
		}

		System.out.println(arrList);
		System.out.println(arrList.contains(9));
		System.out.println(arrList.remove(9));
		System.out.println(arrList.contains(9));
		System.out.println(arrList);
		arrList.add(11);
		System.out.println(arrList);
		System.out.println(arrList.remove(10));
		System.out.println(arrList.remove(11));
		System.out.println(arrList);
		System.out.println(arrList.getSize());
	}

}
