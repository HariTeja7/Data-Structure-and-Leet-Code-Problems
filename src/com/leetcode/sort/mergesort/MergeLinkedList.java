package com.leetcode.sort.mergesort;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class MergeLinkedList {

	public static Node mergeList(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;
		while (temp1 != null && temp2 != null) {
			while (temp1 != null && temp1.next.data < temp2.data) {
				temp1 = temp1.next;
			}
			if (temp1 == null) {
				temp2.next = temp1;
				head1 = temp2;
				temp1 = temp2;
			} else {
				Node next2 = temp2.next;
				Node next1 = temp1.next;
				temp1.next = temp2;
				temp2.next = next1;
				temp1 = temp2;
				temp2 = next2;
			}
		}
		return head1;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList(0);
		ll1.removeLast();
		LinkedList ll2 = new LinkedList(0);
		ll1.removeLast();
		Node head = mergeList(ll1.head, ll2.head);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

}
