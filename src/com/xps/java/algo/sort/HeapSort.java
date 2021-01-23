package com.xps.java.algo.sort;

import java.util.Arrays;

import com.xps.java.ds.trees.BinaryHeap;

public class HeapSort {

	public static void main(String[] args) {
		//int[] arr = {4, 1, 8, 12, 15, 7, 9, 2, 6, 5, 10, 14};
		int[] arr = {4, 1, 8, 8, 12, 15, 15, 7, 9, 2, 6, 5, 10, 10, 14};
		//int[] arr = {2, 9, 7, 3, 5};
		
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		for (int i : arr) {
			heap.add(i);
			heap.printHeap();
		}
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = heap.pop();
			heap.printHeap();
		}
		System.out.println(Arrays.toString(arr));
	}
}
