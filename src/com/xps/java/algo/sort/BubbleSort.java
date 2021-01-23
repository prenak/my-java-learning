package com.xps.java.algo.sort;

public class BubbleSort {

	public static void sort(int[] arr) {
		System.out.print("Input:   ");printArray(arr);
		
		int n = arr.length;
		for (int i=0; i<n; i++) {
			System.out.print("Phase " + i + ": ");
			for (int j=0; j<n-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
			printArray(arr);
		}
	}
	
	private static void printArray(int[] arr) {
		int n = arr.length;
		for (int i=0; i<n; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println();
	}
}
