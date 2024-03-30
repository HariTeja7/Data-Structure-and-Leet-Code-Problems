package com.leetcode.doublelinkedlist;

import com.dsa.doublelinkedlist.DoubleLinkedList;
import com.dsa.doublelinkedlist.Node;

public class SwapNodesInPairs {

	public Node swapNodes(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node temp = head;
		Node start = head.next;
		while (temp != null && temp.next != null) {
			Node next = temp.next;
			Node after = next.next;
			Node tempPrev = temp.prev;
			Node nextNext = next.next;
			temp.prev = next;
			next.next = temp;
			next.prev = tempPrev;
			if (tempPrev != null) {
				tempPrev.next = next;
			}
			temp.next = nextNext;
			nextNext.prev = temp;
			temp = after;
		}
		return start;
	}

	public static void main(String[] args) {
		SwapNodesInPairs snp = new SwapNodesInPairs();
		DoubleLinkedList dll = new DoubleLinkedList(0);
		dll.append(1);
		dll.append(2);
		dll.append(3);
		dll.append(4);
		dll.printList();
		Node swapNodeHead = snp.swapNodes(dll.getHead());
		while (swapNodeHead != null) {
			System.out.print(swapNodeHead.data + " ");
			swapNodeHead = swapNodeHead.next;
		}

	}

}
