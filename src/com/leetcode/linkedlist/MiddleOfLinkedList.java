package com.leetcode.linkedlist;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class MiddleOfLinkedList {

	public static Node middleNode(Node head) {
		if (head == null)
			return null;
		Node slow = head;
		Node fast = head;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next;
			} else
				break;
		}
		return slow;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		System.out.println(middleNode(list.head).data == 4);
		
		LinkedList list2 = new LinkedList(1);
		list2.append(2);
		list2.append(3);
		list2.append(4);
		list2.append(5);
		System.out.println(middleNode(list2.head).data == 3);

	}

}
