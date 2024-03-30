package com.dsa.tree.binarytree.binarysearchtree;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(4);
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.inorder();
		System.out.println();
		System.out.println(bst.contains(1));
		System.out.println(bst.contains(10));
		System.out.println(bst.rContains(1));
		System.out.println(bst.rContains(10));

	}

}
