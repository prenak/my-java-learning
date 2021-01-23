package com.xps.java.algo.dp;

import java.util.Arrays;

public class MaxNumOfRodCuts {
	public static void main(String[] args) {
		int sum = 6;
		int[] s = {2,4,3};
				
		int[] t = new int[sum+1];
		Arrays.fill(t, -1);
		t[0] = 0;
		
		Arrays.parallelSort(s);
		
		for (int j=0;j<s.length;j++) {
			for (int i=1;i<=sum;i++) {
				if (i < s[j]) {
					// do nothing
				} else {
					t[i] = Math.max(t[i], 1+t[i-s[j]]);
				}
			}
		}
		
		System.out.println(Arrays.toString(t));
	}

}
