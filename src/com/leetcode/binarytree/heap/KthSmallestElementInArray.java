package com.leetcode.binarytree.heap;

import com.dsa.tree.binarytree.heap.MaxHeap;

public class KthSmallestElementInArray {

	public static int kSmallestElementInArray(int[] nums, int k) {
		MaxHeap heap = new MaxHeap();
		for (int i : nums) {
			heap.insert(i);
		}
		for (int i = 0; i < k; i++) {
			heap.remove();
		}
		return heap.remove();
	}

	public static void main(String[] args) {
		int[] nums = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		System.out.println(kSmallestElementInArray(nums, k) == 7);
	}

}
