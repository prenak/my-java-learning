package com.xps.java.ds.graphs;

import java.util.Map.Entry;
import java.util.Optional;

public class FloydWarshal {

	public static void main(String[] args) {
		// All pair shortest path - DP
		Graph g = buildGraph();
		int n = g.getNodes().size();
		Node[] nodeArr = g.getNodes().toArray(new Node[n]);
		
		int[][] arr = new int[n][n];
		
		for (int k=0; k<n; k++) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					
					if (i==j) {
						arr[i][j] = 0;
					}
					else {
						arr[i][j] = Math.min(
										getWeightBetweenNodes(nodeArr[i], nodeArr[j]), 
										(getWeightBetweenNodes(nodeArr[i], nodeArr[k]) + getWeightBetweenNodes(nodeArr[k], nodeArr[j]))
									);
					}
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(""+arr[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	private static int getWeightBetweenNodes(Node srcNode, Node destNode) {
		Optional<Entry<Node, Integer>> adNodeEntry = srcNode.getAdjacentNodes().entrySet().stream()
				.filter(e -> e.getKey().getName().equals(destNode.getName()))
				.findFirst();
		
		if (adNodeEntry.isPresent()) {
			return adNodeEntry.get().getValue();
		} else {
			return 100;
		}
	}
	
	private static Graph buildGraph() {
		Graph g = new Graph();
		
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		
		nodeA.addAdjacentNode(nodeD, 7);
		nodeA.addAdjacentNode(nodeB, 3);
		
		nodeB.addAdjacentNode(nodeA, 8);
		nodeB.addAdjacentNode(nodeC, 2);
		
		nodeC.addAdjacentNode(nodeA, 5);
		nodeC.addAdjacentNode(nodeD, 1);
		
		nodeD.addAdjacentNode(nodeA, 2);
		
		g.addNode(nodeA);
		g.addNode(nodeB);
		g.addNode(nodeC);
		g.addNode(nodeD);
		
		return g;
	}

}
