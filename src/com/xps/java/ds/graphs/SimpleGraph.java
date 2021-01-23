package com.xps.java.ds.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleGraph<T> {
	
	int noOfVertices;
	Map<T, Vertex<T>> 	allVeritces = new HashMap<T, Vertex<T>>();
	
	void addEdge(T t1, T t2, boolean isDirected) {
		addEdge(t1, t2, isDirected, 0);
	}
	
	void addEdge(T t1, T t2, boolean isDirected, int weight){
		Vertex<T> v1 = null;
		if (allVeritces.containsKey(t1)) {
			v1 = allVeritces.get(t1);
		} else {
			v1 = new Vertex<T>(t1);
		}
			
		
		Vertex<T> v2 = null;
		if (allVeritces.containsKey(t2)) {
			v2 = allVeritces.get(t2);
		} else {
			v2 = new Vertex<T>(t2);
		}
		
		Edge<T> e = new Edge<T>(weight, v1, v2);
		v1.adjacentNodes.add(v2);
		v1.edges.add(e);
		System.out.println("Adding edge " + v1 + " -> " + v2);
		
		if (!isDirected) {
			v2.adjacentNodes.add(v1);
			v2.edges.add(e);
			System.out.println("Adding edge " + v2 + " -> " + v1);
		}
		
		allVeritces.put(v1.data, v1);
		allVeritces.put(v2.data, v2);
		this.noOfVertices = allVeritces.size();
	}
	
	boolean ifReverseEdgeExists(T t1, T t2) {
		if (!allVeritces.containsKey(t1)) return false;
		if (!allVeritces.containsKey(t2)) return false;
		
		// We want to check for the reverse edge
		Vertex<T> src = allVeritces.get(t2);
		for (Edge<T> edge : src.edges) {
			if (t1.equals(edge.v2.data)) {
				return true;
			}
		}
		return false;
	}
	
	boolean ifEdgeExists(T t1, T t2) {
		if (!allVeritces.containsKey(t1)) return false;
		if (!allVeritces.containsKey(t2)) return false;
		
		// We want to check for the reverse edge
		Vertex<T> src = allVeritces.get(t1);
		for (Edge<T> edge : src.edges) {
			if (t2.equals(edge.v2.data)) {
				return true;
			}
		}
		return false;
	}
	

}

class Edge<T>{
	int 	weight;
	Vertex<T> 	v1;
	Vertex<T> 	v2;
	
	public Edge(Vertex<T> v1, Vertex<T> v2) {
		new Edge<T>(0, v1, v2);
	}

	public Edge(int weight, Vertex<T> v1, Vertex<T> v2) {
		super();
		this.weight = weight;
		this.v1 = v1;
		this.v2 = v2;
	}
}

class Vertex<T>{
	
	T data;
	List<Edge<T>> edges = new ArrayList<Edge<T>>();
	List<Vertex<T>> adjacentNodes = new ArrayList<Vertex<T>>();
	
	public Vertex(T data) {
		super();
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Vertex<T> other = (Vertex<T>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " " + data;
	}
}
