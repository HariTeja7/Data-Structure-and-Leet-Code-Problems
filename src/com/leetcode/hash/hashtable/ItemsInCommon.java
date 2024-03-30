package com.leetcode.hash.hashtable;

import com.dsa.hash.hashtable.HashTable;

public class ItemsInCommon {

	public static boolean itemsInCommon(int[] arr1, int[] arr2) {
		if (arr1.length == 0 && arr2.length == 0) {
			return false;
		}
		if (arr1.length == 0 || arr2.length == 0) {
			return false;
		}
		HashTable<Integer, Boolean> ht = new HashTable<>();
		for (int i : arr1) {
			ht.set(i, Boolean.TRUE);
		}
		for (int i : arr2) {
			if (ht.containsKey(i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(itemsInCommon(new int[] {1,2,3}, new int[] {4,5,6}));
		System.out.println(itemsInCommon(new int[] {1,2,3}, new int[] {3,4,5}));
		System.out.println(itemsInCommon(new int[] {}, new int[] {}));
		System.out.println(itemsInCommon(new int[] {}, new int[] {3,4,5}));
	}
}
