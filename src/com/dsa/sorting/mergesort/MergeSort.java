package com.dsa.sorting.mergesort;

import java.util.Arrays;

import com.dsa.linkedlist.Node;

public class MergeSort {

	public int[] mergeSort(int[] arr) {
		if (arr.length < 2) {
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		return merge(left, right);
	}

	private int[] merge(int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int index = 0;
		int[] com = new int[left.length + right.length];
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				com[index++] = left[i++];
			} else {
				com[index++] = right[j++];
			}
		}
		while (i < left.length) {
			com[index++] = left[i++];
		}
		while (j < right.length) {
			com[index++] = right[j++];
		}
		return com;
	}

	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node mid = getMiddle(head);
		Node next = mid.next;
		mid.next = null;
		Node left = mergeSort(head);
		Node right = mergeSort(next);
		return merge(left, right);
	}

	private Node merge(Node left, Node right) {
		Node dummy = new Node(0);
		Node head = dummy;
		while (left != null && right != null) {
			if (left.data < right.data) {
				head.next = new Node(left.data);
				head = head.next;
				left = left.next;
			} else {
				head.next = new Node(right.data);
				head = head.next;
				right = right.next;
			}
		}
		while (left != null) {
			head.next = new Node(left.data);
			head = head.next;
			left = left.next;
		}
		while (right != null) {
			head.next = new Node(right.data);
			head = head.next;
			right = right.next;
		}
		return dummy.next;
	}

	private Node getMiddle(Node head) {
		if (head.next == null || head.next.next == null) {
			return head;
		}
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

}
