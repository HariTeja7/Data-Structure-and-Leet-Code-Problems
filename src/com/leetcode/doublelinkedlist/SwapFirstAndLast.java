package com.leetcode.doublelinkedlist;

import com.dsa.doublelinkedlist.DoubleLinkedList;
import com.dsa.doublelinkedlist.Node;

public class SwapFirstAndLast {

	public static void swapFirstLast(Node head) {
		if (head != null) {
			Node tail = head;
			while (tail.next != null) {
				tail = tail.next;
			}
			if (!head.equals(tail)) {
				head.prev = tail.prev;
				tail.prev.next = head;
				tail.next = head.next;
				head.next.prev = tail;
				tail.prev = null;
				head.next = null;
			}
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList(5);
		dll.append(4);
		dll.append(3);
		dll.append(2);

		dll.printList();
		swapFirstLast(dll.getHead());
		Node temp = dll.getTail();
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
