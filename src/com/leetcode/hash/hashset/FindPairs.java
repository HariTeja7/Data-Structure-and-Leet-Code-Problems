package com.leetcode.hash.hashset;

import java.util.ArrayList;
import java.util.List;

import com.dsa.hash.hashset.HashSet;

public class FindPairs {

	public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
		List<int[]> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i : arr2)
			set.add(i);
		for (int i : arr1) {
			int num = Math.abs(target - i);
			if (set.contains(num)) {
				list.add(new int[] { i, num });
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 2, 4, 6, 8, 10 };
		int target = 7;
		for (int[] arr : findPairs(arr1, arr2, target)) {
			for (int a : arr)
				System.out.print(a + ",");
			System.out.println();
		}
	}

}
