package com.dsa.circular.doublelinkedlist;

import com.dsa.doublelinkedlist.Node;

public class CircularDoublyLinkedList {

	public Node head;

	public Node tail;

	public int length;

	public CircularDoublyLinkedList(int data) {
		Node newNode = new Node(data);
		head = newNode;
		head.next = head;
		head.prev = newNode;
		tail = newNode;
		length++;
	}

	public void printList() {
		Node temp = head;
		if (temp != null) {
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (!temp.equals(head));
			System.out.println();
		}
	}

	public void append(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			newNode.next = head;
			newNode.prev = head;
			head = newNode;
			tail = newNode;
		} else if (head.next.equals(head)) {
			head.next = newNode;
			newNode.prev = head;
			newNode.next = head;
			head.prev = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = head;
			tail = newNode;
			head.prev = tail;
		}
		length++;
	}

	public void prepend(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			head.next = newNode;
			head.prev = newNode;
			tail = newNode;
		} else if (head.next.equals(head)) {
			newNode.next = head;
			head.prev = newNode;
			newNode.prev = head;
			head.next = newNode;
			tail = head;
			head = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			head.prev = tail;
			tail.next = head;
		}
		length++;
	}

	public Node removeLast() {
		if (head == null) {
			return null;
		}
		Node temp = tail;
		if (head.next.equals(head)) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next = head;
			head.prev = tail;
		}
		length--;
		return temp;
	}

	public Node removeFirst() {
		if (head == null) {
			return null;
		}
		Node temp = head;
		if (head.next.equals(head)) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			head.prev = tail;
			tail.next = head;
		}
		length--;
		return temp;
	}

	public Node get(int index) {
		if (head == null || index < 0 || index > length) {
			return null;
		}
		Node temp = head;
		if (index < length / 2) {
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			temp = tail;
			for (int i = length - 1; i > index; i--) {
				temp = temp.prev;
			}
		}
		return temp;
	}

	public boolean set(int index, int data) {
		Node temp = get(index);
		if (temp == null) {
			return false;
		} else {
			temp.data = data;
			return true;
		}
	}

	public boolean insert(int index, int data) {
		Node temp = get(index - 1);
		if (temp == null) {
			return false;
		} else if (index == 0) {
			prepend(data);
			return true;
		} else if (index == length) {
			append(data);
			return true;
		} else {
			Node newNode = new Node(data);
			newNode.next = temp.next;
			temp.next.prev = newNode;
			temp.next = newNode;
			newNode.prev = temp;
			return true;
		}
	}

	public Node remove(int index) {
		Node temp = get(index);
		if (temp == null) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == length) {
			return removeLast();
		} else {
			temp.next.prev = temp.prev;
			temp.prev.next = temp.next;
			return temp;
		}

	}

}
