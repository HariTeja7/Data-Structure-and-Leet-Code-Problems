package com.leetcode.binarytree.binarysearchtree;

import com.dsa.tree.binarytree.TreeNode;

public class SortedArrayToBalancedBinaryTree {

	private static TreeNode<Integer> toBalancedTree(int[] arr) {
		return toBalancedTree(arr, 0, arr.length);
	}

	private static TreeNode<Integer> toBalancedTree(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode<Integer> root = new TreeNode<>(arr[mid]);
		root.left = toBalancedTree(arr, start, mid - 1);
		root.right = toBalancedTree(arr, mid + 1, end);
		return root;
	}

	private static void inorder(TreeNode<Integer> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		inorder(toBalancedTree(arr));
	}

}
