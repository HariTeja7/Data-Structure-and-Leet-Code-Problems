package com.dsa.hash.hashtable;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class HashTable<K, V> {

	private int size;

	private Node<K, V>[] dataMap;

	@SuppressWarnings("unchecked")
	public HashTable() {
		this.size = 7;
		this.dataMap = (Node<K, V>[]) Array.newInstance(Node.class, size);
	}

	public void printTable() {
		for (Node<K, V> temp : dataMap) {
			while (temp != null) {
				System.out.print(temp.key + "=" + temp.value + ",");
				temp = temp.next;
			}
		}
		System.out.println();
	}

	public int hash(K key) {
		int value = key.hashCode() % size;
		if (value < 0) {
			value = -1 * value;
		}
		return value;
	}

	public void set(K key, V value) {
		Node<K, V> newNode = new Node<>(key, value);
		int hash = hash(key);
		if (dataMap[hash] != null) {
			Node<K, V> temp = dataMap[hash];
			while (temp.next != null) {
				if (temp.key.equals(key)) {
					temp.value = value;
					return;
				}
				temp = temp.next;
			}
			if (temp.key.equals(key)) {
				temp.value = value;
			} else {
				temp.next = newNode;
			}
		} else {
			dataMap[hash] = newNode;
		}
	}

	public V get(K key) {
		int hash = hash(key);
		Node<K, V> temp = dataMap[hash];
		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp.value;
			}
		}
		return null;
	}

	public Set<K> keys() {
		Set<K> set = new HashSet<>();
		for (Node<K, V> temp : dataMap) {
			while (temp != null) {
				set.add(temp.key);
				temp = temp.next;
			}
		}
		return set;
	}

	public Set<V> values() {
		Set<V> values = new HashSet<>();
		for (Node<K, V> temp : dataMap) {
			while (temp != null) {
				values.add(temp.value);
				temp = temp.next;
			}
		}
		return values;
	}

	public boolean containsKey(K key) {
		int hash = hash(key);
		Node<K, V> temp = dataMap[hash];
		while (temp != null) {
			if (temp.key.equals(key)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

}
