package com.xps.java.ds.trees;

public class Driver {

	public static void main(String[] args) {
		
		BinaryTree<Integer> tree = createBasicTree();
		
		System.out.println("Inorder: ");
		tree.traverseInOrder(tree.root);
		
		System.out.println("\nPreorder: ");
		tree.traversePreOrder(tree.root);
		
		System.out.println("\nPostOrder: ");
		tree.traversePostOrder(tree.root);
	}
	
	private static BinaryTree<Integer> createBasicTree(){
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.root = tree.new Node(Integer.valueOf(10));
		
		tree.root.left  = tree.new Node(Integer.valueOf(2));
		tree.root.right = tree.new Node(Integer.valueOf(3));
		
		tree.root.left.left  = tree.new Node(Integer.valueOf(4));
		tree.root.left.right = tree.new Node(Integer.valueOf(5));
		
		return tree;
	}

}
