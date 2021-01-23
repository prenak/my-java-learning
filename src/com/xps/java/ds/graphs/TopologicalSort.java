package com.xps.java.ds.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;


public class TopologicalSort<T> {

	public static void main(String[] args) {
		
		SimpleGraph<String> g = new SimpleGraph<String>();
		g.addEdge("A", "C", true);
		g.addEdge("B", "C", true);
		g.addEdge("B", "D", true);
		g.addEdge("C", "E", true);
		g.addEdge("D", "F", true);
		g.addEdge("E", "F", true);
		g.addEdge("F", "G", true);
		g.addEdge("E", "H", true);
		
		TopologicalSort<String> t = new TopologicalSort<String>();
		t.topologicalSort(g);
	}
	
	public void topologicalSort(SimpleGraph<T> graph) {
		Deque<Vertex<T>> stack = new ArrayDeque<Vertex<T>>(graph.noOfVertices);
		Set<Vertex<T>> visited = new HashSet<>();
		
		// For each vertex in a graph, if not visited - 
		//  - mark it visited
		//  - explore its adjacent vertices using DFS until no adjacent vertex found
		graph.allVeritces.forEach((k,v)->{
			if (!visited.contains(v)) {
				visited.add(v);
				// DFS: Check if there are any unvisited child vertices for the current node recursively
				dfsUntilNoChildVertex(v, visited, stack);
			}
		});
		
		while (stack.size() != 0) {
			System.out.print(stack.pollLast());
		}
	}
	
	private void dfsUntilNoChildVertex(Vertex<T> currVertex, Set<Vertex<T>> visited, Deque<Vertex<T>> stack) {
		if (currVertex.adjacentNodes.size() == 0) {
			stack.addLast(currVertex);
			return;
		}
		
		for (Vertex<T> v : currVertex.adjacentNodes) {
			if (!visited.contains(v)) {
				// Mark current vertex as visited
				visited.add(v);
				dfsUntilNoChildVertex(v, visited, stack);
			}
		}
		stack.addLast(currVertex);
	}
}
