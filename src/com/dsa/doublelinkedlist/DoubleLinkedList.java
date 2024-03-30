package com.dsa.doublelinkedlist;

public class DoubleLinkedList {

	private Node head;
	private Node tail;
	private int length;

	public DoubleLinkedList(int data) {
		Node newNode = new Node(data);
		head = newNode;
		tail = newNode;
		length = 1;
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
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void printReverseList() {
		Node temp = tail;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.println();
	}

	public void append(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		length++;
	}

	public Node removeLast() {
		if (head == null) {
			return null;
		}
		Node temp = tail;
		if (length == 1) {
			head = null;
			tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
			temp.prev = null;
		}
		length--;
		return temp;
	}

	public void prepend(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	public Node removeFirst() {
		if (head == null) {
			return null;
		}
		Node temp = head;
		if (length == 1) {
			tail = null;
			head = null;
		} else {
			head = head.next;
			tail.prev = null;
			temp.next = null;
		}
		length--;
		return temp;
	}

	public Node get(int index) {
		if (index < 0 || index >= length || head == null) {
			return null;
		}
		Node temp = head;
		if (index < length / 2) {
			for (int i = 0; i < index; i++)
				temp = temp.next;
		} else {
			temp = tail;
			for (int i = length - 1; i > index; i--) {
				temp = temp.prev;
			}
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
		} else if (index == length) {
			append(value);
		} else {
			Node newNode = new Node(value);
			Node before = get(index - 1);
			Node after = before.next;
			before.next = newNode;
			newNode.prev = before;
			newNode.next = after;
			after.prev = newNode;
		}
		return true;
	}

	public Node remove(int index) {
		if (index < 0 || index > length - 1) {
			return null;
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == length - 1) {
			return removeLast();
		}
		Node temp = get(index);
		Node before = temp.prev;
		Node after = temp.next;
		before.next = after;
		after.prev = before;
		temp.next = null;
		temp.prev = null;
		length--;
		return temp;
	}

}
