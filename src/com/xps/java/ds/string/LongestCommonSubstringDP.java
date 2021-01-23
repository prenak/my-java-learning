package com.xps.java.ds.string;

public class LongestCommonSubstringDP {

	public static void main(String[] args) {
		
		String s1 = "ABCDGH", s2 = "ACDGHR";
		findLongestCommonSubstring(s1.toCharArray(), s2.toCharArray());
	}
	
	private static void findLongestCommonSubstring(char[] s1, char[] s2) {
		
		int m = s1.length, n = s2.length;
		int result = 0;
		// Table for DP of which 0th row and column will hold val 0
		int[][] lcs = new int[m+1][n+1];
		
		for (int i=0; i<=m; i++) {
			for (int j=0; j<=n; j++) {
				
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				}
				else if (s1[i-1] == s2[j-1]) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
					result = Math.max(result, lcs[i][j]);
				}
				else {
					lcs[i][j] = 0;
				}
			}
		}
		System.out.println("Longest substring: " + result);
	}

}
