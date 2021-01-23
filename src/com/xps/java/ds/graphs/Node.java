package com.xps.java.ds.graphs;

import java.util.HashMap;
import java.util.Map;

public class Node {
	
	private Map<Node, Integer>	adjacentNodes;
	private int 				distanceFromSourceNode = Integer.MAX_VALUE;
	private final String 		name;
	
	public Node(String name) {
		super();
		this.name = name;
		this.adjacentNodes = new HashMap<>();
	}

	public void addAdjacentNode(Node destinationNode, int edgeWeight) {
		this.adjacentNodes.put(destinationNode, edgeWeight);
	}

	public void setDistanceFromSourceNode(int distanceFromSourceNode) {
		this.distanceFromSourceNode = distanceFromSourceNode;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public int getDistanceFromSourceNode() {
		return distanceFromSourceNode;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", distanceFromSourceNode=" + distanceFromSourceNode + "]";
	}
}
