package com.leetcode.hash.hashset;

import java.util.HashSet;
import java.util.Set;

public class HasUniqueChars {

	public static boolean hasUniqueChars(String string) {
		Set<Character> set = new HashSet<>();
		for (char ch : string.toCharArray()) {
			if (set.contains(ch)) {
				return true;
			} else
				set.add(ch);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(hasUniqueChars("abcdefg"));
		System.out.println(hasUniqueChars("aabhefiu"));
	}

}
