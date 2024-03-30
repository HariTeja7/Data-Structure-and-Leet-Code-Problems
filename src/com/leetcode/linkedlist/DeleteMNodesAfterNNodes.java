package com.leetcode.linkedlist;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class DeleteMNodesAfterNNodes {

	public static void linkdelete(Node head, int M, int N) {
		if (head == null)
			return;
		int index = 1;
		Node temp = head;
		while (temp != null) {
			if (index % M == 0) {
				Node temp1 = temp;
				for (int i = 0; i < N; i++) {
					if (temp1 == null)
						break;
					temp1 = temp1.next;
				}
				if (temp1 != null) {
					temp.next = temp1.next;
				} else {
					temp.next = null;
				}
			}
			temp = temp.next;
			index++;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(9);
		list.append(1);
		list.append(3);
		list.append(5);
		list.append(9);
		list.append(4);
		list.append(10);
		list.append(1);
		list.printList();
		linkdelete(list.head, 2, 1);
		list.printList();
	}

}
