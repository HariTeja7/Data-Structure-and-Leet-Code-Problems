package com.leetcode.hash.hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {

	public static List<Integer> removeDuplicates(List<Integer> myList) {
		HashSet<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i : myList) {
			if (!set.contains(i)) {
				set.add(i);
				list.add(i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
		List<Integer> newList = removeDuplicates(myList);
		System.out.println(newList);

		/*
		 * EXPECTED OUTPUT: ---------------- [1, 2, 3, 4, 5, 6, 7, 8, 9]
		 * 
		 * (Order may be different as sets are unordered)
		 */
	}

}
