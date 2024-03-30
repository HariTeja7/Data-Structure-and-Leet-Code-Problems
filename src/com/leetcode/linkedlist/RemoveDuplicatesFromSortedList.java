package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class RemoveDuplicatesFromSortedList {

	public static Node deleteDuplicates(Node head) {
		if (head == null) {
			return null;
		}
		Node temp = head;
		Node pre = null;
		Set<Integer> duplicates = new HashSet<>();
		while (temp != null) {
			if (duplicates.contains(temp.data)) {
				if (pre == null) {
					head = head.next;
				} else {
					pre.next = temp.next;
					temp = temp.next;
				}
			} else {
				duplicates.add(temp.data);
				pre = temp;
				temp = temp.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(0);
		list.append(0);
		list.append(1);
		list.append(2);
		list.append(2);
		list.append(3);
		list.printList();
		deleteDuplicates(list.head);
		list.printList();
	}

}
