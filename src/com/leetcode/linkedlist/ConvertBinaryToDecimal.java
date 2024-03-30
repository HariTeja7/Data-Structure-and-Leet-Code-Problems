package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.Node;

public class ConvertBinaryToDecimal {

	public static int getDecimalValue(Node head) {
		if (head == null)
			return 0;
		List<Integer> list = new ArrayList<>();
		Node temp = head;
		int value = 0;
		while (temp != null) {
			list.add(temp.data);
			temp = temp.next;
		}
		for (int i = 0; i < list.size(); i++) {
			value += list.get(i) * (int) Math.pow(2, list.size() - i - 1);
		}
		return value;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(1);
		list.append(0);
		list.append(1);
		System.out.println(getDecimalValue(list.head) == 5);
	}

}
