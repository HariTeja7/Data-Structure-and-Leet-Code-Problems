package com.leetcode.linkedlist;

public class MyHashSet {

	public static void main(String[] args) {
		MyHashSetLinkedList mySet = new MyHashSetLinkedList();
		mySet.add(1);
		mySet.add(2);
		System.out.println(mySet.contains(1));
		System.out.println(mySet.contains(3));
		mySet.add(2);
		System.out.println(mySet.contains(2));
		mySet.remove(2);
		System.out.println(mySet.contains(2));
	}

}

class MyHashSetArray {

	private boolean[] values = new boolean[1000000 + 1];

	public MyHashSetArray() {

	}

	public void add(int key) {
		values[key] = true;
	}

	public void remove(int key) {
		values[key] = false;
	}

	public boolean contains(int key) {
		return values[key];
	}
}

class MyHashSetLinkedList {

	public class SetNode {

		public int data;
		public SetNode next;

		public SetNode(int data) {
			this.data = data;
			next = null;
		}
	}

	private int size;

	private SetNode[] hash;

	public MyHashSetLinkedList() {
		size = 9;
		hash = new SetNode[size];
	}

	private int getHashValue(int value) {
		return value % size;
	}

	public void add(int key) {
		int hashValue = getHashValue(key);
		SetNode temp = hash[hashValue];
		SetNode pre = null;
		while (temp != null) {
			if (temp.data == key) {
				return;
			}
			pre = temp;
			temp = temp.next;
		}
		if (pre == null) {
			hash[hashValue] = new SetNode(key);
		} else {
			pre.next = new SetNode(key);
		}
	}

	public void remove(int key) {
		int hashValue = getHashValue(key);
		if (hash[hashValue] != null) {
			SetNode temp = hash[hashValue];
			SetNode pre = null;
			while (temp != null) {
				if (temp.data == key) {
					if (pre==null) {
						hash[hashValue] = hash[hashValue].next;
						break;
					}
					else pre.next = temp.next;
				}
				pre = temp;
				temp = temp.next;
			}
		}
	}

	public boolean contains(int key) {
		int hashValue = getHashValue(key);
		if (hash[hashValue] != null) {
			SetNode temp = hash[hashValue];
			while (temp != null) {
				if (temp.data == key) {
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}

}
