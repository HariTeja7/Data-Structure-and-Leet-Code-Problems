package com.dsa.sorting.bubblesort;

import com.dsa.linkedlist.Node;

public class BubbleSort {

	public void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swapped = true;
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	public Node bubbleSortByValue(Node head) {
		if (head == null) {
			return null;
		}
		Node tail = null;
		while (!head.equals(tail)) {
			Node temp = head;
			boolean swapped = false;
			while (temp.next != null && !temp.next.equals(tail)) {
				if (temp.data > temp.next.data) {
					swapByValue(temp, temp.next);
					swapped = true;
				}
				temp = temp.next;
			}
			tail = temp;
			if (!swapped) {
				break;
			}
		}
		return head;
	}

	public void swapByValue(Node temp, Node next) {
		int value = temp.data;
		temp.data = next.data;
		next.data = value;
	}

	public Node bubbleSortByNode(Node head) {
		if (head == null) {
			return null;
		}
		Node tail = null;
		while (!head.equals(tail)) {
			Node temp = head;
			Node pre = null;
			boolean swapped = false;
			while (temp.next != null && !temp.next.equals(tail)) {
				if (temp.data > temp.next.data) {
					swapped = true;
					Node second = temp.next;
					Node next = second.next;
					if (pre == null) {
						head = second;
					} else {
						pre.next = second;
					}
					second.next = temp;
					temp.next = next;
					pre = second;
				} else {
					pre = temp;
					temp = temp.next;
				}
			}
			tail = temp;
			if (!swapped) {
				break;
			}
		}
		return head;
	}

	public Node swapByNode(Node prevX, Node currX, Node prevY, Node currY, Node head) {
		if (prevX != null) {
			prevX.next = currY;
		} else {
			// Else make y as new head
			head = currY;
		}

		// If y is not head of linked list
		if (prevY != null) {
			prevY.next = currX;
		} else {
			// Else make x as new head
			head = currX;
		}

		// Swap next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
		return head;
	}

}
