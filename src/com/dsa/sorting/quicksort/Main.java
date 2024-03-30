package com.dsa.sorting.quicksort;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class Main {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 0, 2, 3, 0, 0, 8, 10, 1, 0, 0, 0 };
		print(arr);
		LinkedList ll = new LinkedList(arr);
		print(arr);
		QuickSort ss = new QuickSort();
		ss.quickSort(arr);
		print(arr);
		ll.printList();
		Node head = ss.quickSort(ll.head);
		print(head);
	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}
