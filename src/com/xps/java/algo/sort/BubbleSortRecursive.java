package com.xps.java.algo.sort;

public class BubbleSortRecursive {
	
	public static void sort(int[] arr) {
		System.out.print("Input:   ");printArray(arr);
		
		int n = arr.length;
		sortRecursive(arr, n);
		printArray(arr);
		
	}
	
	private static void sortRecursive(int[] arr, int n) {
		
		if (n == 1)
			return;
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		sortRecursive(arr, n-1);
	}
	
	private static void printArray(int[] arr) {
		int n = arr.length;
		for (int i=0; i<n; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}
}
