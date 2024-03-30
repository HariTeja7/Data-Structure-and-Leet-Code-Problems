package com.leetcode.hash.hashtable;

import com.dsa.hash.hashtable.HashTable;

public class SubArraySum {

	public static int[] subArraySum(int[] arr, int target) {
		HashTable<Integer, Integer> ht = new HashTable<>();
		int preFix = 0;
		for (int i = 0; i < arr.length; i++) {
			preFix += arr[i];
			if (preFix == target) {
				return new int[] { 0, i };
			}
			int diff = preFix - target;
			if (ht.containsKey(diff)) {
				return new int[] { ht.get(diff) + 1, i };
			} else {
				ht.set(preFix, i);
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		for (int a : subArraySum(new int[] { 1, 2, 3, 4, 5 }, 9))
			System.out.println(a);
	}

}
