package com.dsa.tree.binarytree.heap;

public class MaxHeap extends Heap {

	@Override
	public void insert(int data) {
		heapList.add(data);
		int currentIndex = heapList.size() - 1;
		while (true) {
			int parent = parent(currentIndex);
			if (heapList.get(parent) < heapList.get(currentIndex)) {
				swap(parent, currentIndex);
				currentIndex = parent;
			} else {
				break;
			}
		}
	}

	@Override
	public Integer remove() {
		if (heapList.isEmpty()) {
			return null;
		}
		if (heapList.size() == 1) {
			return heapList.remove(0);
		}
		int result = heapList.get(0);
		heapList.set(0, heapList.remove(heapList.size() - 1));
		sinkDown(0, (left, min) -> heapList.get(left) > heapList.get(min));
		return result;
	}

}
