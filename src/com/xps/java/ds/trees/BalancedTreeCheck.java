package com.xps.java.ds.trees;

import com.xps.java.ds.trees.BinaryTree.Node;

// Given a binary tree, find if it is height balanced or not. 
// A tree is height balanced if difference between heights of 
// left and right subtrees is not more than one for all nodes of tree.

public class BalancedTreeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isBalanced(Node node) {
		
		if (node == null)
			return true;
		
		int leftHeight = checkHeight(node.left);
		int rightHeight = checkHeight(node.right);
		
		int diff = leftHeight - rightHeight;
		if (-1 > diff || diff > 1) {
			return false;
		}
		return isBalanced(node.left) && isBalanced(node.right);
	}
	
	private static int checkHeight(Node node) {
		if (node == null) {
			return 0;
		} 
		
		int leftHeight = checkHeight(node.left);
		int rightHeight = checkHeight(node.right);
		
		return Math.max(leftHeight, rightHeight)+1;
	}

}
