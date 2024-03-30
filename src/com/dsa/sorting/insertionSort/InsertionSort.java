package com.dsa.sorting.insertionSort;

import com.dsa.linkedlist.Node;

public class InsertionSort {

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j >= 1 && arr[j - 1] < temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}

	public Node insertionSort(Node head) {
		Node result = null;
		while (head != null) {
			Node temp = head;
			head = head.next;
			temp.next = null;
			if (result == null) {
				result = temp;
			} else {
				Node temp2 = result;
				Node pre = null;
				while (temp2 != null && temp2.data > temp.data) {
					pre = temp2;
					temp2 = temp2.next;
				}
				if (pre == null) {
					temp.next = result;
					result = temp;
				} else {
					pre.next = temp;
					temp.next = temp2;
				}
			}
		}
		return result;
	}

}
