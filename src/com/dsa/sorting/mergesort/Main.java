package com.dsa.sorting.mergesort;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class Main {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 2, 3, 8, 10, 1 };
		LinkedList ll = new LinkedList(arr);
		print(arr);
		MergeSort ss = new MergeSort();
		int[] sortedArr = ss.mergeSort(arr);
		print(sortedArr);
		ll.printList();
		Node head = ss.mergeSort(ll.head);
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
