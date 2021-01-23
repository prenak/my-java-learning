package com.xps.java.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.xps.java.ds.trees.BinaryTree.Node;

/* Given a binary tree and a key, insert the key into the binary tree 
 * at first position available in level order.
 * 
 * The idea is to do iterative level order traversal of the given tree using queue. 
 * If we find a node whose left child is empty, we make new key as left child of the node. 
 * Else if we find a node whose right child is empty, we make new key as right child. 
 * We keep traversing the tree until we find a node whose either left or right is empty.
 */
public class InsertInBTInLevelOrder {
	
	public static void main(String[] args) {
		
		BinaryTree<Integer> tree = createBasicTree();
		tree.traverseInOrder(tree.root);
		System.out.println();
		
		insertInLevelOrder(tree, 3);
		tree.traverseInOrder(tree.root);
		
		System.out.println();
		
		insertInLevelOrder(tree, 1);
		tree.traverseInOrder(tree.root);
		
		System.out.println();
		
		insertInLevelOrder(tree, 2);
		tree.traverseInOrder(tree.root);
		
		System.out.println();
		
		insertInLevelOrder(tree, 6);
		tree.traverseInOrder(tree.root);
		
	}
	
	private static void insertInLevelOrder(BinaryTree<Integer> tree, int key) {
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(tree.root);
		
		Node temp = null;
		while (!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
			
			if (temp.left == null) {
				temp.left = tree.new Node(key);
				break;
			} else {
				queue.add(temp.left);
			}
			
			if (temp.right == null) {
				temp.right = tree.new Node(key);
				break;
			} else {
				queue.add(temp.right);
			}
		}
	}
	
	private static BinaryTree<Integer> createBasicTree() {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.root = tree.new Node(Integer.valueOf(10));
		
		tree.root.left  = tree.new Node(Integer.valueOf(11));
		tree.root.right = tree.new Node(Integer.valueOf(9));
		
		tree.root.left.left  = tree.new Node(Integer.valueOf(7));
		
		tree.root.right.left = tree.new Node(Integer.valueOf(15));
		tree.root.right.right = tree.new Node(Integer.valueOf(8));
		return tree;
	}

}
