package com.dsa.hash.hashtable;

public class Main {

	public static void main(String[] args) {
		HashTable<String,Integer> ht = new HashTable<>();
		ht.set("one", 1);
		ht.set("two", 2);
		ht.set("two", 3);
		ht.printTable();
		System.out.println(ht.get("two"));
		System.out.println(ht.get("three"));
		System.out.println(ht.keys());
		System.out.println(ht.containsKey("two"));
		System.out.println(ht.containsKey("tw"));
	}

}
