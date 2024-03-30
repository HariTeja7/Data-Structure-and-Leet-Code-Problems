package com.leetcode.linkedlist;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class ReverseLinkedList {

	public static Node reverseList(Node head) {
		if (head == null)
			return null;
		Node temp = head;
		Node before = null;
		while (temp != null) {
			Node after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
		return before;
	}

	public static Node reverseListUsingRecurrsion(Node head) {
		if (head == null)
			return null;
		return reverseListUsingRecurrsionUtil(head, null);
	}

	public static Node reverseListUsingRecurrsionUtil(Node temp, Node before) {
		if (temp == null)
			return before;
		Node after = temp.next;
		temp.next = before;
		return reverseListUsingRecurrsionUtil(after, temp);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.append(2);
		System.out.println(reverseList(list.head).data == 2);
		LinkedList list2 = new LinkedList(1);
		list2.append(2);
		System.out.println(reverseListUsingRecurrsion(list2.head).data == 2);

	}

}
