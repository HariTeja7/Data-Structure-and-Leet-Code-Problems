package com.dsa.hash.hashset;

public class Main {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(3);
		set.add(4);
		set.printSet();
		System.out.println();
		set.add(5);
		set.printSet();
		System.out.println();
		set.remove(3);
		set.printSet();
	}

}
