package com.leetcode.hash.hashtable;

import com.dsa.hash.hashtable.HashTable;

public class FirstNonRepeatingCharacter {

	public static char firstNonRepeatingCharacter(String input) {
		HashTable<Character, Pair> ht = new HashTable<>();
		int index = input.length();
		char ans = ' ';
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ht.containsKey(ch)) {
				Pair p = ht.get(ch);
				p.count++;
			} else
				ht.set(ch, new Pair(i));
		}
		for (char ch : ht.keys()) {
			Pair p = ht.get(ch);
			if (p.count == 1 && index > p.index) {
				index = p.index;
				ans = ch;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(firstNonRepeatingCharacter("loveleetcode"));
	}

}

class Pair {
	int index;
	int count;

	public Pair(int index) {
		this.index = index;
		this.count = 1;
	}
}
