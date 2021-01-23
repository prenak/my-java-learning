package com.xps.java.ds.arrays;

public class EquilibriumPoint {

	public static void main(String[] args) {
		
		//int[] arr = {1,3,5,2,2}; //Out: 3
		int[] arr = {1,5,0,2,2}; //Out: -1
		System.out.println(findEquillibriumPoint(arr));
	}
	
	public static int findEquillibriumPoint(int[] arr) {
		
		int n = arr.length;
		int i;
		
		int totalSum = 0;
		for(i=0; i<n; i++) {
			totalSum += arr[i];
		}
		
		int rightSum = 0;
		for (i=n-1; i>=0; i--) {
			totalSum -= arr[i];
			
			if (totalSum == rightSum) {
				return i+1;
			}
			rightSum += arr[i];
		}
		return -1;
	}

}
