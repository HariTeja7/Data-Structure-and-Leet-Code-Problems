package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.dsa.linkedlist.Node;

public class IntersectionNode {

	public Node getIntersectionNode(Node headA, Node headB) {
		if (headA == null || headB == null)
			return null;
		List<Node> list = new ArrayList<>();
		Node temp = headA;
		while (temp != null) {
			list.add(temp);
			temp = temp.next;
		}
		temp = headB;
		while (temp != null) {
			if (list.contains(temp)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	public static void main(String[] args) {

	}

}
