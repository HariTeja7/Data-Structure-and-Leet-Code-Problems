package com.dsa.queue;

public class Queue {

	private Node front;

	private Node rear;

	private int length = 0;

	public Queue(int data) {
		Node newNode = new Node(data);
		front = newNode;
		rear = newNode;
		length = 1;
	}

	public void add(int data) {
		Node newNode = new Node(data);
		if (rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		length++;
	}

	public void printQueue() {
		Node temp = front;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public Integer poll() {
		if (front == null) {
			return null;
		}
		Integer data = front.data;
		if (front.next == null) {
			front = null;
			rear = null;
		} else {
			front = front.next;
		}
		length--;
		return data;
	}

	public Integer peek() {
		if (front == null) {
			return null;
		}
		return front.data;
	}

	public void remove(int data) {
		if (front != null) {
			if (front.data == data) {
				front = front.next;
				if (front == null) {
					rear = null;
				}
			} else {
				Node pre = front;
				Node temp = front;
				while (temp != null && temp.data != data) {
					pre = temp;
					temp = temp.next;
				}
				if (temp != null) {
					pre.next = temp.next;
				}
			}
			length--;
		}
	}

	public boolean isEmpty() {
		return length == 0;
	}

}
