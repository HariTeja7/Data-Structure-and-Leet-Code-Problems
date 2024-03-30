package com.leetcode.binarytree.bst;

import com.dsa.tree.binarytree.TreeNode;
import com.dsa.tree.binarytree.binarysearchtree.BinarySearchTree;

public class ValidBinarySearchTree {

	public static boolean isValidBST(TreeNode<Integer> root) {
		return isValidBST(root, null, null);
	}

	public static boolean isValidBST(TreeNode<Integer> root, Integer min, Integer max) {
		if (root == null)
			return true;
		if ((min != null && root.data <= min) || (max != null && root.data >= max))
			return false;
		return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i : new int[] { 5, 4, 6, 3, 7 }) {
			bst.insert(i);
		}
		System.out.println(isValidBST(bst.getRoot()));
	}

}
