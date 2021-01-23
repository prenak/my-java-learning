package com.xps.java.ds.arrays;

public class SpiralTraversalOfMatrix {

	public static void main(String[] args) {
		//int[][] a = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int[][] a = { {1,2,3,4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18} };
		traverseSpiral(a);
	}
	
	private static void traverseSpiral(int[][] a) {
		
		int n = a.length, i=0, j=0;
		int lt=-1, lb=-1, rt=a[0].length, rb=n;
		
		while(lt < rt && lb < rb) {
			while (j < rt) {
				print(a[i][j++]);
			}
			i++; j--; lt++;
			
			while (i < rb) {
				print(a[i++][j]);
			}
			i--; j--; rt--;
			
			while (j > lb) {
				print(a[i][j--]);
			}
			i--; j++; rb--;
			
			while (i > lt) {
				print(a[i--][j]);
			}
			 i++; j++; lb++;
		}
		
	}

	private static void print(int val) {
		System.out.print(""+ val + ", ");
	}
}
