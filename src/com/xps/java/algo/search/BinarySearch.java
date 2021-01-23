package com.xps.java.algo.search;

public class BinarySearch {
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		
		int[] arr = {1, 3, 5, 6, 7, 9, 10, 13, 15, 16, 19, 20};
		int key = 22;
		
		System.out.println(bs.search(arr, 0, arr.length-1, key));
	}
	
	public int search(int[] arr, int low, int high, int key) {
		
		if (low > high) {
			return -1;
		}
		
		int mid = (low + high)/2;
		if (key == arr[mid]) {
			return mid;
		}
		
		if (low < mid && key < arr[mid]) {
			return search(arr, low, mid-1, key);
		} else {
			return search(arr, mid+1, high, key);
		}
	}
	
	public static BinarySearch build() {
		return new BinarySearch();
	}

}
