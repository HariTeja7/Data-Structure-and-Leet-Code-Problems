package com.dsa.tree.binarytree.heap;

public class Main {

	public static void main(String[] args) {
		Heap maxheap = new MaxHeap();
		maxheap.insert(99);
		maxheap.print();
		maxheap.insert(61);
		maxheap.print();
		maxheap.insert(100);
		maxheap.print();
		maxheap.insert(158);
		maxheap.print();
		maxheap.insert(72);
		maxheap.print();
		maxheap.remove();
		maxheap.print();
		maxheap.remove();
		maxheap.print();
		maxheap.remove();
		maxheap.print();
		maxheap.remove();
		maxheap.print();
	}

}
