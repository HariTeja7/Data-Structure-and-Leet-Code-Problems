package com.dsa.linkedlist;

import java.util.HashSet;

public class LinkedList {

	public Node head;

	private Node tail;

	private int length;

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public LinkedList(int[] array) {
		for (int i = 0; i < array.length; i++) {
			append(array[i]);
		}
	}

	public void getHead() {
		System.out.println(head.data);
	}
	
	public Node head() {
		return head;
	}

	public void gettail() {
		System.out.println(tail.data);
	}

	public void getLength() {
		System.out.println(length);
	}

	public void printList() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		StringBuilder list = new StringBuilder();
		if (head == null)
			return list.toString();
		Node temp = head;
		while (temp != null) {
			if (!temp.equals(head)) {
				list.append(",");
			}
			list.append(temp.data);
			temp = temp.next;
		}
		return list.toString();
	}

	public Node append(int data) {
		Node newNode = new Node(data);
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
		return newNode;
	}

	public Node removeLast() {
		if (length == 0)
			return null;
		Node temp = head;
		Node pre = head;
		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		temp = pre;
		temp.next = null;
		length--;
		if (length == 0) {
			head = null;
			tail = null;
		}
		return temp;
	}

	public void prepend(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	public Node removeFirst() {
		if (length == 0) {
			return null;
		}
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		if (length == 0) {
			tail = null;
		}
		return temp;
	}

	public Node get(int index) {
		if (index < 0 || index > length) {
			return null;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public boolean set(int index, int value) {
		Node temp = get(index);
		if (temp == null) {
			return false;
		}
		temp.data = value;
		return true;
	}

	public boolean insert(int index, int value) {
		if (index < 0 || index > length) {
			return false;
		}
		if (index == 0) {
			prepend(value);
		}
		if (index == length) {
			append(value);
		}
		Node newNode = new Node(value);
		Node temp = get(index - 1);
		temp.next = newNode.next;
		temp.next = newNode;
		length++;
		return true;
	}

	public Node remove(int index) {
		if (index < 0 || index >= length) {
			return null;
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == length - 1) {
			return removeLast();
		}
		Node prev = get(index - 1);
		Node newNode = prev.next;
		prev.next = newNode.next;
		newNode.next = null;
		length--;
		return newNode;
	}

	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;
		Node after;
		Node before = null;
		for (int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
	}

	/*
	 * Test for empty list, test for one element, test with even length and test
	 * with odd length
	 */
	public Node findMiddleNode() {
		if (head == null)
			return null;
		Node one = head;
		Node two = head;
		while (two.next != null) {
			one = one.next;
			two = two.next;
			if (two.next != null) {
				two = two.next;
			} else
				break;
		}
		return one;
	}

	/*
	 * Test for No loop, empty list, one element, has a loop
	 */
	public boolean hasLoop() {
		if (head == null)
			return false;
		Node slow = head;
		Node fast = head;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
				if (fast.equals(slow)) {
					return true;
				}
			} else
				break;
		}
		return false;
	}

	/*
	 * test with empty list, test for K values test for k out of bound test for k in
	 * range
	 */
	public Node findKthFromEnd(int k) {
		if (head == null || k == 0)
			return null;
		if (k == 1)
			return head;
		int len = 0;
		Node fast = head;
		Node slow = head;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			len++;
			if (fast.next != null) {
				fast = fast.next;
				len++;
			} else
				break;
		}
		len++;
		if (k > len)
			return null;
		int pos = (len / 2) + 1;
		int req = len - k + 1;
		if (req < pos) {
			slow = head;
			pos = 0;
		}
		for (int i = pos; i < req; i++) {
			slow = slow.next;
		}
		return slow;
	}

	public void partitionList(int x) {

		if (head == null)
			return;
		Node left = null;
		Node leftHead = null;
		Node right = null;
		Node rightHead = null;
		Node temp = head;
		while (temp != null) {
			if (temp.data < x) {
				if (left == null) {
					leftHead = new Node(temp.data);
					left = leftHead;
				} else {
					left.next = new Node(temp.data);
					left = left.next;
				}
			} else {
				if (right == null) {
					rightHead = new Node(temp.data);
					right = rightHead;
				} else {
					right.next = new Node(temp.data);
					right = right.next;
				}
			}
			temp = temp.next;
		}
		if (left != null) {
			left.next = rightHead;
		} else {
			leftHead = rightHead;
		}
		head = leftHead;

	}

	public void removeDuplicates() {
		if (head == null)
			return;
		Node temp = head;
		Node prev = null;
		HashSet<Integer> set = new HashSet<>();
		while (temp != null) {
			if (set.contains(temp.data) && prev != null) {
				prev.next = temp.next;
				temp = temp.next;
			} else {
				set.add(temp.data);
				prev = temp;
				temp = temp.next;
			}
		}
	}

	public int binaryToDecimal() {
		int num = 0;
		Node temp = head;
		int i = 0;
		while (temp != null) {
			num += temp.data * (int) Math.pow(2, length - 1 - i);
			temp = temp.next;
			i++;
		}
		return num;
	}

	public void reverseBetween(int m, int n) {
		if (head == null)
			return;
		if (m > n)
			return;
		int index = 0;
		Node temp = head;
		Node pre = null;
		while (temp != null) {
			if (index == m) {
				reverse(temp, temp.next, pre, m, n);
				break;
			}
			pre = temp;
			temp = temp.next;
			index++;
		}
	}

	public void reverse(Node before, Node temp, Node pre, int m, int n) {
		Node linkStart = before;
		for (int i = m; i < n; i++) {
			Node after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
		if (pre != null) {
			pre.next = before;
		} else {
			head = before;
		}
		linkStart.next = temp;
	}

	public void bubbleSort() {
		if (head == null || head.next == null) {
			return;
		}
		Node sortedUntil = null;
		while (!head.next.equals(sortedUntil)) {
			Node temp = head;
			while (temp.next!=null && !temp.next.equals(sortedUntil)) {
				if (temp.data > temp.next.data) {
					int val = temp.data;
					temp.data = temp.next.data;
					temp.next.data = val;
				}
				temp = temp.next;
			}
			sortedUntil = temp;
		}
	}

}
