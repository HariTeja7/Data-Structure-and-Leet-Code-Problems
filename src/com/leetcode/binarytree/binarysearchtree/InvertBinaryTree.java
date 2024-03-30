package com.leetcode.binarytree.binarysearchtree;

import com.dsa.tree.binarytree.TreeNode;
import com.dsa.tree.binarytree.binarysearchtree.BinarySearchTree;

public class InvertBinaryTree {

	public static void invertBinaryTree(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		TreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int a : new int[] { 47, 21, 76, 18, 27, 52, 82 }) {
			bst.insert(a);
		}
		invertBinaryTree(bst.getRoot());
	}

}
