package com.dsa.sorting.bubblesort;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class Main {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 2, 3, 8, 10, 1 };
		LinkedList ll = new LinkedList(arr);
		LinkedList ll2 = new LinkedList(arr);
		print(arr);
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(arr);
		print(arr);
		bs.bubbleSortByValue(ll.head);
		ll.printList();
		Node head = bs.bubbleSortByNode(ll2.head);
		while (head != null) {
			System.out.print(head.data + ",");
			head = head.next;
		}
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
