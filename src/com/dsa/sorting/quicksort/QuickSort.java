package com.dsa.sorting.quicksort;

import com.dsa.linkedlist.Node;

public class QuickSort {

	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = pivot(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}

	private int pivot(int[] arr, int pivotIndex, int endIndex) {
		int swapIndex = pivotIndex;
		for (int i = pivotIndex + 1; i <= endIndex; i++) {
			if (arr[i] > arr[pivotIndex]) {
				swapIndex++;
				swap(arr, swapIndex, i);
			}
		}
		swap(arr, pivotIndex, swapIndex);
		return swapIndex;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private Node newHead;

	public Node quickSort(Node head) {
		newHead = head;
		quickSort(null, head, null);
		return newHead;
	}

	private void quickSort(Node preHead, Node head, Node tail) {
		if (head == null || head == tail || head.next.equals(tail)) {
			return;
		}
		Node prePivot = pivot(preHead, head, tail);
		quickSort(preHead, head, prePivot);
		quickSort(prePivot.next, prePivot.next.next, tail);
	}

	private Node pivot(Node preHead, Node head, Node tail) {
		if (head.equals(tail) || head.next == tail || head.next == null) {
			return head;
		}
		Node swapPointer = head;
		Node preSwapPointer = preHead;
		Node temp = head.next;
		Node pre = head;
		while (temp != null && temp != tail) {
			if (temp.data > head.data) {
				preSwapPointer = swapPointer;
				swapPointer = swapPointer.next;
				swap(preSwapPointer, swapPointer, pre, temp);
				temp = pre.next;
				swapPointer = preSwapPointer.next;
			}
			pre = temp;
			temp = temp.next;
		}
		swap(preHead, head, preSwapPointer, swapPointer);
		return preSwapPointer;
	}

	private void swap(Node preSwapPointer, Node swapPointer, Node pre, Node temp) {
		if (swapPointer != temp) {
			if (swapPointer.next == temp) {
				Node nextNode = temp.next;
				if (preSwapPointer == null) {
					newHead = temp;
				} else {
					preSwapPointer.next = temp;
				}
				temp.next = swapPointer;
				swapPointer.next = nextNode;
			} else {
				if (preSwapPointer == null) {
					newHead = temp;
				} else {
					preSwapPointer.next = temp;
				}
				if (pre == null) {
					newHead = swapPointer;
				} else {
					pre.next = swapPointer;
				}
				Node next = temp.next;
				temp.next = swapPointer.next;
				swapPointer.next = next;
			}
		}
	}

}
