package com.xps.java.ds.trees;

import com.xps.java.ds.trees.BinaryTree.Node;

public class HeightOfTree {
	
	public static void main(String[] args) {
		
	}
	
	private static int findHeight(Node node) {
		
		// Base case
		if (node == null)
			return 0;
		
		// Height of a tree = max of (height of left subtree, height of right subtree)
		int leftHeight = findHeight(node.left);
		int rightHeight = findHeight(node.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
