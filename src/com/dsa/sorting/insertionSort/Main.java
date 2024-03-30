package com.dsa.sorting.insertionSort;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class Main {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 2, 3, 8, 10, 1 };
		LinkedList ll = new LinkedList(arr);
		print(arr);
		InsertionSort ss = new InsertionSort();
		ss.insertionSort(arr);
		print(arr);
		ll.printList();
		Node head = ss.insertionSort(ll.head);
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
