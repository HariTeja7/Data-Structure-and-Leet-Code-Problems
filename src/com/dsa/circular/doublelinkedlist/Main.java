package com.dsa.circular.doublelinkedlist;

public class Main {

	public static void main(String[] args) {
		CircularDoublyLinkedList cdll = new CircularDoublyLinkedList(0);
		cdll.printList();
		cdll.prepend(1);
		cdll.printList();
		cdll.append(2);
		cdll.printList();
		cdll.prepend(3);
		cdll.append(3);
		cdll.printList();
		cdll.set(2, 1);
		cdll.printList();
		cdll.insert(2, 2);
		cdll.printList();
		cdll.remove(0);
		cdll.printList();
		cdll.removeLast();
		cdll.printList();
		cdll.removeFirst();
		cdll.printList();
		cdll.removeFirst();
		cdll.printList();
	}

}
