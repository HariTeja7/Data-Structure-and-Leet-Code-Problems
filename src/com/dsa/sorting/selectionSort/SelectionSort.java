package com.dsa.sorting.selectionSort;

import com.dsa.linkedlist.Node;

public class SelectionSort {

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = 0;
			int pos = arr.length - 1 - i;
			for (int j = 0; j <= pos; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[pos];
			arr[pos] = temp;
		}
	}

	public Node selectionSort(Node head) {
		Node dummy = new Node(0);
		Node ans = dummy;
		while (head != null) {
			Node min = head;
			Node temp = head;
			Node preMin = null;
			Node pre = null;
			while (temp != null) {
				if (temp.data > min.data) {
					preMin = pre;
					min = temp;
				}
				pre = temp;
				temp = temp.next;
			}
			if (preMin == null) {
				head = min.next;
			} else {
				preMin.next = min.next;
			}
			dummy.next = min;
			dummy = dummy.next;
		}
		return ans.next;
	}

}
