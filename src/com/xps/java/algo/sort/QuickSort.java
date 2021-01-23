package com.xps.java.algo.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		//int[] arr = {4, 1, 8, 12, 15, 7, 9, 2, 6, 5, 10, 14};
		int[] arr = {4, 1, 8, 8, 12, 15, 15, 7, 9, 2, 6, 5, 10, 10, 14};
		//int[] arr = {2, 9, 7, 3, 5, 1, 4};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		// Base condition
		if (high < low) {
			return;
		}
		
		// Recursion logic
		int pi = partition(arr, low, high);

		quickSort(arr, low, pi-1);
		quickSort(arr, pi+1, high);
	}
	
	private static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		
		int i = low-1;
		
		for (int j=low; j<high; j++) {
			
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			
			} else {
				// Do nothing
			}
		}
		
		swap(arr, i+1, high);
		return (i+1);
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
