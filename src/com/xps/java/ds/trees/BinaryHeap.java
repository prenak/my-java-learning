package com.xps.java.ds.trees;

/**
 * Baeldung: https://www.baeldung.com/java-heap-sort
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>>{

	private List<T> elements = new ArrayList<>();
	private int rootIndex = 0;
	
	
	public void add(T element) {
		elements.add(element);
		
		// Heapify
		int elementIndex = elements.size() - 1;
		while (!isRootIndex(elementIndex) && !isCorrectChild(elementIndex)) {
			int parentIndex = getParentIndex(elementIndex);
			swapElements(parentIndex, elementIndex);
			elementIndex = parentIndex;
		}
	}
	
	public T pop() {
		T elementToPop = elementAt(rootIndex);
		
		// Heapify
		T rightMostElement = elementAt(elements.size()-1);
		elements.set(rootIndex, rightMostElement);
		elements.remove(elements.size()-1);
		
		int elementIndex = rootIndex;
		while (!isLeaf(elementIndex) && !isCorrectParent(elementIndex)) {
			int smallestChildIndex = getSmallestChildIndex(elementIndex);
			swapElements(elementIndex, smallestChildIndex);
			elementIndex = smallestChildIndex;
		}
		
		return elementToPop;
	}
	
	private void swapElements(int index1, int index2) {
		T elementAtIndex1 = elementAt(index1);
		T elementAtIndex2 = elementAt(index2);
		elements.set(index1, elementAtIndex2);
		elements.set(index2, elementAtIndex1);
	}
	
	private boolean isLeaf(int elementIndex) {
		return getLeftChildIndex(elementIndex) >= elements.size();
	}

	private boolean isCorrectChild(int elementIndex) {
		return isCorrect(getParentIndex(elementIndex), elementIndex);
	}
	
	private boolean isCorrectParent(int elementIndex) {
		return isCorrect(elementIndex, getLeftChildIndex(elementIndex)) 
				&& isCorrect(elementIndex, getRightChildIndex(elementIndex));
	}
	
	private boolean isCorrect(int index1, int index2) {
		if (!isValidIndex(index1) || !isValidIndex(index2)) {
			return true;
		}
		return elementAt(index1).compareTo(elementAt(index2)) < 0;
	}
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}
	
	private T elementAt(int index) {
		System.out.println(elements);
		return elements.get(index);
	}
	
	private int getParentIndex(int elementIndex) {
		return (elementIndex - 1)/2;
	}
	
	private int getLeftChildIndex(int elementIndex) {
		return (2 * elementIndex) + 1;
	}
	
	private int getRightChildIndex(int elementIndex) {
		return (2 * elementIndex) + 2;
	}
	
	private int getSmallestChildIndex(int parentIndex) {
		
		int leftChildIndex = getLeftChildIndex(parentIndex);
		int rightChildIndex = getRightChildIndex(parentIndex);
		
		if (isValidIndex(leftChildIndex) && isValidIndex(rightChildIndex)) {
			return elementAt(leftChildIndex).compareTo(elementAt(rightChildIndex)) < 0
					? leftChildIndex : rightChildIndex;
		}
		
		if (isValidIndex(leftChildIndex) && !isValidIndex(rightChildIndex)) {
			return leftChildIndex;
		}
		if (!isValidIndex(leftChildIndex) && isValidIndex(rightChildIndex)) {
			return rightChildIndex;
		}
		
		// This condition can never occur
		return parentIndex;
	}
	
	private boolean isRootIndex(int elementIndex) {
		return elementIndex == rootIndex;
	}
	
	private boolean isValidIndex(int elementIndex) {
		return elementIndex < elements.size();
	}
	
	public void printHeap() {
		System.out.print("\nHeap:");
		elements.forEach(e -> System.out.print(e.toString() + ", "));
	}
}
