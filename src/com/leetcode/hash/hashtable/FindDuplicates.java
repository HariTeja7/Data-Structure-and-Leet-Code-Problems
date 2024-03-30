package com.leetcode.hash.hashtable;

import java.util.ArrayList;
import java.util.List;

import com.dsa.hash.hashtable.HashTable;

public class FindDuplicates {

	public static List<Integer> findDuplicates(int[] arr) {
		HashTable<Integer, Boolean> ht = new HashTable<>();
		List<Integer> dupList = new ArrayList<>();
		for (int i : arr) {
			if (ht.containsKey(i)) {
				dupList.add(i);
			} else {
				ht.set(i, Boolean.TRUE);
			}
		}
		return dupList;
	}

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] { 1, 2, 2, 3, 4, 5, 5, 6, 7, 10, 10 }));
	}

}
