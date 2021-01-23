package com.xps.java.ds.arrays;

import java.util.LinkedList;

public class LongestIncreasingSubSeq {

	public static void main(String[] args) {
		int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
		//int[] arr = {1,101,2,3,100,4,5};
		//int[] arr = {1,2,3,100};
		//int[] arr = {3,4,5,10,1,2};
		//int[] arr = {10, 8, 7, 3, 4};
		findLongestIncreasingSubSeq(arr);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void findLongestIncreasingSubSeq(int[] arr) {
		
		int n = arr.length;
		LinkedList[] listArr = new LinkedList[n];
		
		for (int i=0; i<n; i++) {
			listArr[i] = new LinkedList();
		}
		
		listArr[0].add(arr[0]);
		
		for (int i=1; i<n; i++) {
			int maxTillNow = -1;
			for (int j=0; j<i; j++) {
				if (arr[j] < arr[i] && arr[j] > maxTillNow) {
					listArr[i].add(arr[j]);
					maxTillNow = arr[j];
				}
			}
			listArr[i].add(arr[i]);
		}
		
		printSubsequences(listArr, n);
	}
	
	private static void printSubsequences(LinkedList[] listArr, int n) {
		for (int i=0; i<n; i++) {
			System.out.println();
			System.out.print(""+i+" -> ");
			listArr[i].forEach(num -> {
				System.out.print(num + ", ");
			});
		}
	}
}
