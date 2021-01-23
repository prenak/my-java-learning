package com.xps.java.ds.trees;

public class BinaryTree<T> {
	
	public Node root;
	
	public class Node {
		T data;
		
		Node left;
		Node right;
		
		public Node(T data) {
			super();
			this.data = data;
		}
	}
	
	public void traverseInOrder(Node root) {
		if (root.left != null){
			traverseInOrder(root.left);
		} 
		System.out.print(root.data + ", ");
		
		if (root.right != null){
			traverseInOrder(root.right);
		}
	}
	
	public void traversePreOrder(Node root) {
		System.out.print(root.data + ", ");
		if (root.left != null){
			traversePreOrder(root.left);
		}
		if (root.right != null){
			traversePreOrder(root.right);
		}
	}
	
	public void traversePostOrder(Node root) {
		if (root.left != null){
			traversePostOrder(root.left);
		}
		if (root.right != null){
			traversePostOrder(root.right);
		}
		System.out.print(root.data + ", ");
	}

}
