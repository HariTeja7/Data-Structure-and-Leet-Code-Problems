package com.leetcode.linkedlist;

import com.dsa.linkedlist.Node;

public class LinkedListCycle {

	public static boolean hasCycle(Node head) {
		if (head == null)
			return false;
		Node fast = head;
		Node slow = head;
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
			if (fast != null) {
				fast = fast.next;
				if (slow.equals(fast)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}

}
