package com.leetcode.hash.hashtable;

import java.util.HashMap;

import com.dsa.hash.hashtable.HashTable;

public class TwoSums {

	public static int[] twoSums(int[] nums, int target) {
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (sumMap.containsKey(diff)) {
				return new int[] { sumMap.get(diff), i };
			}
			sumMap.put(nums[i], i);
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		for (int a : twoSums(new int[] { 1, 2, 3, 4, 5 }, 10))
			System.out.println(a);
	}

}
