package com.dsa.hash.hashset;

import java.lang.reflect.Array;

public class HashSet<T> {

	private Node<T>[] dataSet;

	private int size;

	@SuppressWarnings("unchecked")
	public HashSet() {
		this.size = 7;
		this.dataSet = (Node<T>[]) Array.newInstance(Node.class, size);
	}

	public void printSet() {
		for (Node<T> temp : dataSet) {
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
	}

	private int hash(T data) {
		int value = data.hashCode() % size;
		if (value < 0) {
			value = -1 * value;
		}
		return value;
	}

	public void add(T data) {
		int hash = hash(data);
		Node<T> temp = dataSet[hash];
		if (temp == null) {
			dataSet[hash] = new Node<>(data);
		} else {
			if (!temp.data.equals(data)) {
				while (temp.next != null) {
					if (temp.next.data.equals(data)) {
						return;
					}
					temp = temp.next;
				}
				temp.next = new Node<>(data);
			}
		}
	}

	public boolean contains(T data) {
		int hash = hash(data);
		Node<T> temp = dataSet[hash];
		if (temp == null) {
			return false;
		} else {
			while (temp != null) {
				if (temp.data.equals(data)) {
					return true;
				}
				temp = temp.next;
			}
			return false;
		}

	}

	public void remove(T data) {
		int hash = hash(data);
		Node<T> temp = dataSet[hash];
		if (temp != null) {
			if (temp.equals(data)) {
				dataSet[hash] = temp.next;
			} else {
				Node<T> pre = temp;
				while (temp.next != null) {
					if (temp.data.equals(data)) {
						pre.next = temp.next;
						break;
					}
					pre = temp;
					temp = temp.next;
				}
			}
		}
	}

}
