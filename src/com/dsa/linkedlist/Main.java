package com.dsa.linkedlist;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList(3);

//		list.getHead();
//		list.gettail();
//		list.getLength();

		list.append(4);
		list.append(1);
		list.append(6);
		list.append(2);
		list.append(5);

		list.printList();

//		list.reverseBetween(1, 3);
//
//		list.printList();
//
//		list.printList();
//
//		list.removeLast();
//
//		list.printList();

		list.bubbleSort();

		list.printList();
	}

}
