package com.dsa.tree.binarytree.heap;

public class MinHeap extends Heap {

	@Override
	public void insert(int data) {
		heapList.add(data);
		int current = heapList.size() - 1;
		while (true) {
			int parent = parent(current);
			if (heapList.get(parent) < heapList.get(current)) {
				swap(current, parent);
				current = parent;
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
		int data = heapList.get(0);
		heapList.set(0, heapList.get(heapList.size() - 1));
		sinkDown(0, (left, min) -> heapList.get(left) < heapList.get(min));
		return data;
	}

}
