package com.xps.java.algo.sort;

import java.util.Arrays;

/**
 * Merge Sort: Divide and Conquer
 * 1. Divide the array into sub-arrays of size 1 
 * 2. Merge the sub-arrays based on the comparison to be made
 */

public class MergeSort {

	public static void main(String[] args) {
		
		int[] arr = {4, 1, 8, 12, 15, 7, 9, 2, 6, 5, 10, 14};
		//int[] arr = {4, 1, 8, 8, 12, 15, 15, 7, 9, 2, 6, 5, 10, 10, 14};
		//int[] arr = {2, 9, 7, 3, 5, 1, 4};
		System.out.println(Arrays.toString(arr));
		sort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void sort(int[] arr, int n) {
		// Base condition
		if (n < 2) return;
		
		// Recursion logic
		int mid = n/2;
		
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for (int i=0; i<mid; i++) {
			left[i] = arr[i];
		}
		for (int i=mid; i<n; i++) {
			right[i-mid] = arr[i];
		}
		
		sort(left, mid);
		sort(right, n-mid);
		
		merge(arr, left, mid, right, n-mid);
	}
	
	private static void merge(int[] arr, int[] left, int ln, int[] right, int rn) {
		
		int i=0, j=0, k=0;
		
		while (i < ln && j < rn) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];

			} else {
				arr[k++] = right[j++];
			}
		}
		
		// Copy rest of the elements in the sub-arrays to main array
		while (i < ln) {
			arr[k++] = left[i++];
		}
		while (j < rn) {
			arr[k++] = right[j++];
		}
	}
}
