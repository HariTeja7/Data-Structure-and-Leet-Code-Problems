package com.leetcode.hash.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> group = new HashMap<>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if (!group.containsKey(key)) {
				group.put(key, new ArrayList<>());
			}
			group.get(key).add(str);
		}
		return new ArrayList<>(group.values());
	}

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "mod", "mop", "pip", "tug", "hop", "dog", "met", "zoe", "axe",
				"mug", "fdr", "for", "fro", "fdr", "pap", "ray", "lop", "nth", "old", "eva", "ell", "mci", "wee", "ind",
				"but", "all", "her", "lew", "ken", "awl", "law", "rim", "zit", "did", "yam", "not", "ref", "lao", "gab",
				"sax", "cup", "new", "job", "new", "del", "gap", "win", "pot", "lam", "mgm", "yup", "hon", "khz", "sop",
				"has", "era", "ark" }));
	}

}
