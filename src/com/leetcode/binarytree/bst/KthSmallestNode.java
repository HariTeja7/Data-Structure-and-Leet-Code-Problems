package com.leetcode.binarytree.bst;

import java.util.Stack;

import com.dsa.tree.binarytree.TreeNode;
import com.dsa.tree.binarytree.binarysearchtree.BinarySearchTree;

public class KthSmallestNode {

	public static Integer kThSmallestNode(TreeNode<Integer> root, int k) {
		Stack<TreeNode<Integer>> stack = new Stack<>();
		TreeNode<Integer> current = root;
		while (!stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			k--;
			if (k == 0) {
				return current.data;
			}
			current = current.right;
		}
		return null;
	}

	public static Integer kThSmallestNode2(TreeNode<Integer> root, int k) {
		Stack<TreeNode<Integer>> stack = new Stack<>();
		TreeNode<Integer> node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			k -= 1;
			if (k == 0) {
				return node.data;
			}
			node = node.right;
		}
		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(kThSmallestNode(bst.getRoot(), 3));
	}

}
