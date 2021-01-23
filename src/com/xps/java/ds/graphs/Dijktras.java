package com.xps.java.ds.graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Dijktras {

	public static void main(String[] args) {
		
		//Graph g = buildGraph();
		
		Graph g = buildGajuGraph();
		findShortestRouteFromSourceNode(g, "C");
	}
	
	private static void findShortestRouteFromSourceNode(Graph g, String sourceNodeName) {
		
		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unSettledNodes = new HashSet<>();

		Node sourceNode = g.getNodes().stream().filter(n -> n.getName().equals(sourceNodeName)).findFirst().get();
		sourceNode.setDistanceFromSourceNode(0);
		unSettledNodes.add(sourceNode);
		
		while (!unSettledNodes.isEmpty()) {
			Node currNode = getNearestNode(unSettledNodes);
			unSettledNodes.remove(currNode);
			
			if (settledNodes.contains(currNode)) {
				continue;
			}
			
			currNode.getAdjacentNodes().entrySet().forEach(e ->{
				Node adNode = e.getKey();
				adNode.setDistanceFromSourceNode(
						Math.min(adNode.getDistanceFromSourceNode(), (currNode.getDistanceFromSourceNode() + e.getValue()))
				);
				unSettledNodes.add(adNode);
			});
			
			settledNodes.add(currNode);
		}
		
		settledNodes.forEach(n->{
			System.out.print(n.getName()+"[" + n.getDistanceFromSourceNode() + "] -> ");
		});
	}
	
	private static Node getNearestNode(Set<Node> unSettledNodes) {
		return unSettledNodes.stream()
				.sorted(Comparator.comparingInt(Node::getDistanceFromSourceNode))
				.findFirst().get();
	}
	
	private static Graph buildGajuGraph() {
		Graph g = new Graph();
		
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		
		nodeA.addAdjacentNode(nodeE, 30);
		nodeA.addAdjacentNode(nodeB, 5);
		nodeA.addAdjacentNode(nodeC, 9);
		
		nodeB.addAdjacentNode(nodeD, 8);
		
		nodeC.addAdjacentNode(nodeB, 1);
		nodeC.addAdjacentNode(nodeF, 20);
		
		nodeD.addAdjacentNode(nodeE, 7);
		nodeD.addAdjacentNode(nodeF, 5);
		
		nodeE.addAdjacentNode(nodeF, 6);
		
		g.addNode(nodeA);
		g.addNode(nodeB);
		g.addNode(nodeC);
		g.addNode(nodeD);
		g.addNode(nodeE);
		g.addNode(nodeF);
		
		return g;
	}
	
	private static Graph buildGraph() {
		Graph g = new Graph();
		
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		
		nodeA.addAdjacentNode(nodeB, 9);
		nodeA.addAdjacentNode(nodeC, 4);
		
		nodeB.addAdjacentNode(nodeD, 2);
		
		nodeC.addAdjacentNode(nodeB, 1);
		
		nodeD.addAdjacentNode(nodeE, 3);
		nodeD.addAdjacentNode(nodeC, 5);
		
		g.addNode(nodeA);
		g.addNode(nodeB);
		g.addNode(nodeC);
		g.addNode(nodeD);
		g.addNode(nodeE);
		
		return g;
	}
}
