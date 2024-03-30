package com.dsa.tree.binarytree.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public abstract class Heap {

	protected List<Integer> heapList;

	protected Heap() {
		heapList = new ArrayList<>();
	}

	public void print() {
		System.out.println(heapList);
	}

	public List<Integer> getHeap() {
		return new ArrayList<>(heapList);
	}

	protected int parent(int child) {
		return (child - 1) / 2;
	}

	protected int left(int parent) {
		return 2 * parent + 1;
	}

	protected int right(int parent) {
		return 2 * parent + 2;
	}

	protected void swap(int parent, int currentIndex) {
		int temp = heapList.get(parent);
		heapList.set(parent, heapList.get(currentIndex));
		heapList.set(currentIndex, temp);
	}

	protected void sinkDown(int index, BiPredicate<Integer, Integer> comparator) {
		while (true) {
			int left = left(index);
			int right = right(index);
			int maxIndex = index;
			if (left < heapList.size() && Boolean.TRUE.equals(comparator.test(left, maxIndex))) {
				maxIndex = left;
			}
			if (right < heapList.size() && Boolean.TRUE.equals(comparator.test(right, maxIndex))) {
				maxIndex = right;
			}
			if (maxIndex != index) {
				swap(maxIndex, index);
				index = maxIndex;
			} else
				break;
		}
	}

	abstract void insert(int data);

	abstract Integer remove();

}
