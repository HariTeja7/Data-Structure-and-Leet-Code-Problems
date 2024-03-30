package com.leetcode.linkedlist;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class PalindromeLinkedList {

	public static boolean isPalindrome(Node head) {
		if (head == null)
			return false;
		Node fast = head;
		Node slow = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		fast = null;
		while (slow != null) {
			Node after = slow.next;
			slow.next = fast;
			fast = slow;
			slow = after;
		}
		slow = head;
		while (fast != null) {
			if (fast.data != slow.data) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(0);
		list1.append(1);
		list1.append(2);
		list1.append(1);
		list1.append(0);
		list1.printList();
		System.out.println(isPalindrome(list1.head));
	}

}
