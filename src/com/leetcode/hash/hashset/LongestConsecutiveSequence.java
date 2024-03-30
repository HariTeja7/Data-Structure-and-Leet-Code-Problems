package com.leetcode.hash.hashset;

import java.util.Arrays;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {
		if (nums.length == 1) {
			return 1;
		}
		Arrays.sort(nums);
		int ans = 0;
		int count = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			while (i + 1 < nums.length) {
				if (nums[i] + 1 == nums[i + 1]) {
					count++;
					i++;
				} else if (nums[i] == nums[i + 1]) {
					i++;
				} else
					break;
			}
			ans = Math.max(ans, count);
			count = 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 0 }));
	}

}
