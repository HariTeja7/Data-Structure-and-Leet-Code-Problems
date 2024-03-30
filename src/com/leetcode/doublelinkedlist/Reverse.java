package com.leetcode.doublelinkedlist;

import com.dsa.doublelinkedlist.DoubleLinkedList;
import com.dsa.doublelinkedlist.Node;

public class Reverse {

	public static void reverse(Node head) {
		if (head != null) {
			Node tail = head;
			while (tail.next != null) {
				tail = tail.next;
			}
			Node temp = head;
			while (temp != null) {
				Node after = temp.next;
				temp.next = temp.prev;
				temp.prev = after;
				temp = after;
			}
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList(0);
		dll.append(1);
		dll.append(2);
		dll.append(3);
		dll.append(4);
		dll.printList();
		reverse(dll.getHead());
		Node temp = dll.getTail();
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
