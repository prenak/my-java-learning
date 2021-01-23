package com.xps.java.ds.graphs;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	
	private Set<Node> nodes;

	public Graph() {
		super();
		this.nodes = new HashSet<>();
	}
	
	public void addNode(Node node) {
		this.nodes.add(node);
	}

	public Set<Node> getNodes() {
		return nodes;
	}
}
