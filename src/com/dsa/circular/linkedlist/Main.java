package com.dsa.circular.linkedlist;

public class Main {

	public static void main(String[] args) {

		CircularLinkedList cll = new CircularLinkedList(-15);
		cll.append(-10);
		cll.append(2);
		cll.append(5);
		cll.append(16);
		cll.printList();
		cll.reverse();
		cll.printList();
	}

}
