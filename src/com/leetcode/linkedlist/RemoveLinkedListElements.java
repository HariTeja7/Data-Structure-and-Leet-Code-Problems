package com.leetcode.linkedlist;

import java.util.Arrays;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class RemoveLinkedListElements {

	public static Node removeElements(Node head, int val) {
		if (head == null)
			return null;
		while (head != null && head.data == val)
			head = head.next;
		Node temp = head;
		Node pre = null;
		while (temp != null) {
			if (temp.data == val) {
				if (pre == null) {
					head = head.next;
				} else {
					pre.next = temp.next;
					temp = temp.next;
				}
			} else {
				pre = temp;
				temp = temp.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(new int[] { 3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0 });
		list1.append(0);
		list1.append(1);
		list1.append(2);
		list1.append(2);
		list1.append(0);
		list1.append(3);
		list1.printList();
		Node head = removeElements(list1.head, 0);
		while (head != null) {
			System.out.print(head.data + ",");
			head = head.next;
		}
	}

}
