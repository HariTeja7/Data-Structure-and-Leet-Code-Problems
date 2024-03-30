package com.dsa.stack;

public class Stack {

	public Node top;

	public int height;

	public Stack() {
	}

	public Stack(int data) {
		Node newNode = new Node(data);
		top = newNode;
		height = 1;
	}

	public Node getTop() {
		return top;
	}

	public int getHeight() {
		return height;
	}

	public int pop() {
		if (top == null) {
			return -1;
		}
		Node temp = top;
		top = top.next;
		height--;
		return temp.data;
	}

	public int peek() {
		if (top == null) {
			return -1;
		}
		return top.data;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		height++;
	}

	public boolean isEmpty() {
		return height == 0;
	}

	public void printStack() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}
