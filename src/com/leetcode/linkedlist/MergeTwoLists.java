package com.leetcode.linkedlist;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class MergeTwoLists {

	public static Node merge(Node list1, Node list2) {
		Node dummy = new Node(0);
		Node temp = dummy;
		while (true) {
			if (list1 == null) {
				temp.next = list1;
				break;
			}
			if (list2 == null) {
				temp.next = list2;
				break;
			}
			if (list1.data <= list2.data) {
				temp.next = list1;
				list1 = list1.next;
			} else {
				temp.next = list2;
				list2 = list2.next;
			}
			temp = temp.next;
		}
		return dummy.next;
	}

	public static Node mergeR(Node list1, Node list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.data <= list2.data) {
			list1.next = mergeR(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeR(list1, list2.next);
			return list2;
		}
	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(1);
		list1.append(2);
		list1.append(4);
		list1.printList();

		LinkedList list2 = new LinkedList(1);
		list2.append(3);
		list2.append(4);
		list2.printList();

		mergeR(list1.head, list2.head);
		list1.printList();
	}

}
