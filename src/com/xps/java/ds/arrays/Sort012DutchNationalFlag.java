package com.xps.java.ds.arrays;

import java.util.Arrays;

public class Sort012DutchNationalFlag {

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 0, 1, 2};
		sort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	private static void sort(int[] arr) {
		
		int low = 0, mid =0, high = arr.length-1;
		
		while (mid <= high) { // IMPORTANT
			
			switch(arr[mid]) {
			
			case 0: swap(arr, low, mid);
					low++;
					mid++;
					break;
					
			case 1: mid++;
					break;
					
			case 2: swap(arr, mid, high);
					high--;
					break;
			}
		}
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
