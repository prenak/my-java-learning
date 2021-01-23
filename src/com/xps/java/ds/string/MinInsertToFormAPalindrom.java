package com.xps.java.ds.string;

public class MinInsertToFormAPalindrom {

	public static void main(String[] args) {
		String str = "abcd";
		System.out.println(findMinInserts(str.toCharArray(), 0, str.length()-1));
	}
	
	private static int findMinInserts(char[] str, int l, int h) {
		
		// Base cases
		if (l > h) return Integer.MAX_VALUE;
		if (l == h) return 0;
		if (l == h-1) return str[l] == str[h] ? 0 : 1;
		
		if (str[l] == str[h]) {
			return findMinInserts(str, l+1, h-1);
		}
		else {
			return Math.min(findMinInserts(str, l, h-1), findMinInserts(str, l+1, h)) + 1;
		}
	}

}
