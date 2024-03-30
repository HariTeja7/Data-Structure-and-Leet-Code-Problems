package com.dsa.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

	private TreeNode<T> root;

	public void inOrder() {
		if (root != null) {
			Queue<TreeNode<T>> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				TreeNode<T> temp = q.poll();
				System.out.print(temp.data + ",");
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			System.out.println();
		}
	}

	public void insert(T data) {
		TreeNode<T> newNode = new TreeNode<>(data);
		if (root == null) {
			root = newNode;
		} else {
			Queue<TreeNode<T>> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				TreeNode<T> temp = q.poll();
				if (temp.left == null) {
					temp.left = newNode;
					break;
				} else {
					q.add(temp.left);
				}
				if (temp.right == null) {
					temp.right = newNode;
					break;
				} else {
					q.add(temp.right);
				}
			}

		}
	}

	public void delete(T data) {
		if (root != null) {
			TreeNode<T> temp = null;
			TreeNode<T> keyNode = null;
			Queue<TreeNode<T>> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				temp = q.poll();
				if (temp.data == data) {
					keyNode = temp;
				}
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			if (keyNode != null) {
				T key = temp.data;
				deleteDeepNode(temp);
				keyNode.data = key;
			}
		}
	}

	private void deleteDeepNode(TreeNode<T> key) {
		Queue<TreeNode<T>> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode<T> temp = q.poll();
			if (temp.left != null) {
				if (temp.left.equals(key)) {
					key.data = null;
					temp.left = null;
					break;
				} else {
					q.add(temp.left);
				}
			}
			if (temp.right != null) {
				if (temp.right.equals(key)) {
					key.data = null;
					temp.right = null;
					break;
				}
			} else {
				q.add(temp.right);
			}
		}
	}

}
