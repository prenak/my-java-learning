package com.xps.java.ds.arrays;

public class SearchElementInSortedPivotedArray {

	public static void main(String[] args) {
		
		int[] ar = {  3, 4, 5, 6, 7, 1, 2 };
		int key =1;
		search (ar, key);
		
		

	}
	
	private static void search(int[] ar, int key) {
		int low = 0;
		int high = ar.length-1;
		
		int pivot = findPivotIndex(ar, low, high);
		System.out.println("Pivot index: " + pivot);
		
		if (pivot == -1) {
			System.out.println("The array is not rotated");
			pivot = high;
		}
		
		if (ar[low] <= key && key <= ar[pivot])
			System.out.println("Found key at index: " + binarySearch(ar, low, pivot, key));
		else
			System.out.println("Found key at index: " + binarySearch(ar, pivot+1, high, key));
	}
	
	
	private static int binarySearch(int[] ar, int low, int high, int key) {
		
		if (high < low) {
			System.out.println("Key not found");
			return -1;
		}
		
		int mid = (low+high)/2;
		
		if (key == ar[mid])
			return mid;
		
		if (key < ar[mid]) 
			return binarySearch(ar, low, mid-1, key);
		else
			return binarySearch(ar, mid+1, high, key);
		
	}
	
	
	private static int findPivotIndex(int[] ar, int low, int high) {
		
		if (high < low)
			return -1;
		if (high == low) {
			return low;
		}
		
		int mid = (low+high)/2;
		
		if (mid > low && ar[mid-1] > ar[mid]) 
			return mid-1;
		if (mid < high && ar[mid] > ar[mid+1])
			return mid;
		
		if (ar[low] >= ar[mid])
			return findPivotIndex(ar, low, mid-1);
		else 
			return findPivotIndex(ar, mid, high);
		
	}

}
