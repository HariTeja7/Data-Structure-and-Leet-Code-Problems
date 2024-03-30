package com.dsa.tree.binarytree.binarysearchtree;

import com.dsa.tree.binarytree.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public BinarySearchTree() {

	}

	public BinarySearchTree(T[] array) {
		for (T t : array) {
			insert(t);
		}
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(TreeNode<T> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public boolean insert(T data) {
		if (root == null) {
			root = new TreeNode<>(data);
			return true;
		}
		TreeNode<T> newNode = new TreeNode<>(data);
		TreeNode<T> temp = root;
		while (true) {
			if (temp.data.equals(data)) {
				return false;
			}
			if (data.compareTo(temp.data) < 0) {
				if (temp.left == null) {
					temp.left = newNode;
				} else {
					temp = temp.left;
				}
			} else {
				if (temp.right == null) {
					temp.right = newNode;
				} else {
					temp = temp.right;
				}
			}
		}
	}

	public boolean contains(T data) {
		if (root == null) {
			return false;
		}
		TreeNode<T> temp = root;
		while (temp != null) {
			if (temp.data.equals(data)) {
				return true;
			}
			if (data.compareTo(temp.data) < 0) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return false;
	}

	public boolean rContains(T data) {
		return rContains(root, data);
	}

	private boolean rContains(TreeNode<T> root, T data) {
		if (root == null) {
			return false;
		}
		if (root.data.equals(data)) {
			return true;
		}
		if (data.compareTo(root.data) < 0) {
			return rContains(root.left, data);
		} else if (data.compareTo(root.data) > 0) {
			return rContains(root.right, data);
		}
		return false;
	}

}
