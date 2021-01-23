package com.xps.java.ds.trees;

import com.xps.java.ds.trees.BinaryTree.Node;

// Check if the tree is a mirror image of itself
public class SymmetricTree {

	public static void main(String[] args) {
		

	}
	
	private static boolean isMirror(Node node1, Node node2) throws Exception {
		
		// Base case
		if (node1 == null && node2 == null) {
			return true;
		}
		
		// Recursive logic
		// For two trees to be mirror images, the following three conditions must be true 
        // 1 - Their root node's key must be same 
        // 2 - left subtree of left tree and right subtree of right tree have to be mirror images 
        // 3 - right subtree of left tree and left subtree of right tree have to be mirror images
		if (node1 != null && node2 != null && node1.data.equals(node2.data)) {
			return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
		}
		
		return false;
	}

}
