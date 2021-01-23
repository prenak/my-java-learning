package com.xps.java.ds.arrays;

import java.util.Arrays;

public class ReverseArray2Approches {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8};
		reverseIterative(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
		reverseRecursive(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
	
	private static void reverseIterative(int[] arr, int l, int h) {
		while (l < h) {
			int temp = arr[h];
			arr[h] = arr[l];
			arr[l] = temp;
			l++;
			h--;
		}
	}
	
	private static void reverseRecursive(int[] arr, int l, int h) {
		
		if (l > h) return;
		
		int temp = arr[h];
		arr[h] = arr[l];
		arr[l] = temp;
		
		reverseRecursive(arr, l+1, h-1);
	}

}
