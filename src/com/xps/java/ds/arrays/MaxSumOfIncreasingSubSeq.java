package com.xps.java.ds.arrays;

import java.util.Arrays;

public class MaxSumOfIncreasingSubSeq {

	public static void main(String[] args) {
		
		//int[] arr = {1,101,2,3,100,4,5};
		//int[] arr = {1,2,3,100};
		int[] arr = {3,4,5,10,9,2};
		//int[] arr = {10, 8, 7, 3, 4};
		System.out.println("Max sum: " + findMaxSumOfIncreasingSubSeq(arr));
	}
	
	private static int findMaxSumOfIncreasingSubSeq(int[] arr) {
		
		int n = arr.length;
		int[] maxSumArr = new int[n];
		
		for (int i=0; i< n-1; i++) {
			maxSumArr[i] = arr[i];
		}
		
		int max = arr[0];
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				
				if (arr[i] > arr[j]) {
					maxSumArr[i] = Math.max(maxSumArr[i], maxSumArr[j]+arr[i]);
				}
			}
			max = Math.max(maxSumArr[i], max);
		}
		System.out.println(Arrays.toString(maxSumArr));
		
		return max;
	}

}
