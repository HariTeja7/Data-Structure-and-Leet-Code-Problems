package com.dsa.doublelinkedlist;

public class Main {

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList(0);
		dll.append(1);
		dll.append(3);
		dll.printList();

		dll.removeLast();
		dll.removeLast();
		dll.removeLast();
		dll.printList();

		dll.prepend(1);
		dll.prepend(2);
		dll.prepend(3);
		dll.printList();

		dll.removeFirst();
		dll.removeFirst();
		dll.printList();

		dll.removeFirst();
		dll.removeFirst();
		dll.printList();

		dll.append(1);
		dll.append(3);
		dll.append(2);
		dll.append(4);
		dll.append(5);

		System.out.println(dll.get(4).data);
		dll.printList();

		dll.set(0, 2);
		dll.printList();
		
		dll.remove(4);
		dll.printList();
	}

}
