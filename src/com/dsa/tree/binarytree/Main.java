package com.dsa.tree.binarytree;

public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.inOrder();
		tree.insert(4);
		tree.insert(10);
		tree.inOrder();
		tree.delete(11);
		tree.inOrder();
		tree.delete(1);
		tree.inOrder();
		tree.delete(4);
		tree.inOrder();
	}

}
