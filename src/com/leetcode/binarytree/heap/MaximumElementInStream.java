package com.leetcode.binarytree.heap;

import java.util.ArrayList;
import java.util.List;

import com.dsa.tree.binarytree.heap.MaxHeap;

public class MaximumElementInStream {

	public static List<Integer> maximumElementInStream(int[] nums) {
		List<Integer> list = new ArrayList<>();
		MaxHeap heap = new MaxHeap();
		for (int i : nums) {
			heap.insert(i);
			list.add(heap.getHeap().get(0));
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 5, 2, 9, 3, 6, 8 };
		System.out.println("Actual : " + maximumElementInStream(nums));
		System.out.println("Expected : " + List.of(1, 5, 5, 9, 9, 9, 9));
	}

}
