package com.dsa.circular.linkedlist;

import com.dsa.linkedlist.Node;

public class CircularLinkedList {

	public Node head;

	public Node tail;

	public int length;

	public CircularLinkedList(int data) {
		Node newNode = new Node(data);
		head = newNode;
		head.next = head;
		tail = newNode;
		length++;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}

	public void printList() {
		Node temp = head;
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		} while (!head.equals(temp));
		System.out.println();
	}

	public void append(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.next = head;
			tail = newNode;
		}
		length++;
	}

	public void prepend(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			tail.next = newNode;
			head = newNode;
		}
		length++;
	}

	public Node removeLast() {
		if (head == null) {
			return null;
		}
		Node temp = tail;
		if (head.equals(tail)) {
			head = null;
			tail = null;
		} else {
			Node temp2 = head;
			while (!temp2.next.equals(tail)) {
				temp2 = temp2.next;
			}
			temp2.next = head;
			tail = temp2;
		}
		length--;
		return temp;
	}

	public Node removeFirst() {
		if (head == null) {
			return null;
		}
		Node temp = head;
		if (head.equals(tail)) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			tail.next = head;
		}
		length--;
		return temp;
	}

	public Node get(int index) {
		if (index < 0 || index >= length || head == null) {
			return null;
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public boolean set(int index, int data) {
		Node temp = get(index);
		if (temp == null) {
			return false;
		}
		temp.data = data;
		return true;
	}

	public boolean insert(int index, int data) {
		Node temp = get(index - 1);
		if (temp == null) {
			return false;
		}
		if (index == 0) {
			prepend(data);
			return true;
		}
		if (index == length) {
			append(data);
			return true;
		}
		Node newNode = new Node(data);
		temp.next = newNode;
		return true;
	}

	public Node remove(int index) {
		Node temp = get(index - 1);
		if (temp == null) {
			return null;
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == length - 1) {
			return removeLast();
		}
		Node curr = temp.next;
		temp.next = curr.next;
		return curr;
	}

	public void reverse() {
		Node temp = head;
		Node before = null;
		do {
			Node after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		} while (!temp.equals(head));
		head.next = before;
		head = before;
	}

}
