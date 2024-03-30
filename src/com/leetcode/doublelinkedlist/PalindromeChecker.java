package com.leetcode.doublelinkedlist;

import com.dsa.doublelinkedlist.DoubleLinkedList;
import com.dsa.doublelinkedlist.Node;

public class PalindromeChecker {

	public boolean isPalindrome(Node head) {
		if (head == null) {
			return false;
		}
		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		Node temp = head;
		while (true) {
			if (temp.data != tail.data) {
				return false;
			}
			tail = tail.prev;
			temp = temp.next;
			if (tail.next.equals(temp) || tail.equals(temp)) {
				break;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeChecker pc = new PalindromeChecker();
		DoubleLinkedList dll = new DoubleLinkedList(0);
		dll.append(1);
		dll.append(2);
		dll.append(1);
		dll.append(0);
		System.out.println(pc.isPalindrome(dll.getHead()));
		
	}

}
