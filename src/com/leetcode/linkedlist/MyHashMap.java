package com.leetcode.linkedlist;

public class MyHashMap {

	public class MapNode {

		public int data;
		public int value;
		public MapNode next;

		public MapNode(int data, int value) {
			this.data = data;
			this.value = value;
			next = null;
		}
	}

	private int size;

	private MapNode[] hash;

	public MyHashMap() {
		size = 9;
		hash = new MapNode[size];
	}

	private int getHashValue(int value) {
		return value % size;
	}

	public void put(int key, int value) {
		int hashValue = getHashValue(key);
		MapNode temp = hash[hashValue];
		MapNode pre = null;
		while (temp != null) {
			if (temp.data == key) {
				temp.value = value;
				return;
			}
			pre = temp;
			temp = temp.next;
		}
		if (pre == null) {
			hash[hashValue] = new MapNode(key, value);
		} else {
			pre.next = new MapNode(key, value);
		}
	}

	public void remove(int key) {
		int hashValue = getHashValue(key);
		if (hash[hashValue] != null) {
			MapNode temp = hash[hashValue];
			MapNode pre = null;
			while (temp != null) {
				if (temp.data == key) {
					if (pre == null) {
						hash[hashValue] = hash[hashValue].next;
						break;
					} else
						pre.next = temp.next;
				}
				pre = temp;
				temp = temp.next;
			}
		}
	}

	public int get(int key) {
		int hashValue = getHashValue(key);
		if (hash[hashValue] != null) {
			MapNode temp = hash[hashValue];
			while (temp != null) {
				if (temp.data == key) {
					return temp.value;
				}
				temp = temp.next;
			}
		}
		return -1;
	}

}
