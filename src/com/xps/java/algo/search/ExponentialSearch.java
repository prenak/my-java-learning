package com.xps.java.algo.search;

public class ExponentialSearch {
	
	public static void main(String[] args) {
		ExponentialSearch es = new ExponentialSearch();
		int[] arr = {1, 3, 5, 6, 7, 9, 10, 13, 15, 16, 19, 20};
		int key = 20;
		
		System.out.println(es.search(arr,key));
	}
	
	private int search(int[] arr, int key) {
		int n = arr.length;
		
		int i = 0;
		if (key == arr[i]) {
			return i;
		}
		
		i = 1;
		while (i < n && arr[i] < key) {
			i = i * 2;
		}
		
		return BinarySearch.build().search(arr, i/2, Math.min(i, n-1), key);
	}
}
