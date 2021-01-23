package com.xps.java.ds.arrays;

import java.util.Arrays;

public class RotateArrayUsingJugglingAlgorithm {

	public static void main(String[] args) {
		
		int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int n = ar.length;
		// Number of times to left-rotate per index
		int d = 4;
		System.out.println(Arrays.toString(ar));
		rotateByJuggling(ar, n, d);
		System.out.println(Arrays.toString(ar));
	}
	
	private static void rotateByJuggling(int[] ar, int n, int d) {
		
		int gcd = getGCD(n, d);
		
		int temp, j, k;
		for (int i=0; i<gcd; i++) {
			
			temp = ar[i];
			j = i;
			while(true) {
				k = j+d;
				
				if (k >= n)
					k = k-n;
				
				if (k == i)
					break;
				
				ar[j] = ar[k];
				j = k;
			}
			ar[j] = temp;
		}
	}
	
	// Find GDC of 2 numbers
	private static int getGCD(int a, int b) {
		if (b == 0)
			return a;
		else 
			return getGCD(b, a%b);
	}

}
