package com.xps.java.ds.graphs;

public class AlienDictionary {
	
	public static void main(String[] args) {
		//String[] input = {"wrt", "wrf", "er", "ett", "rftt"};
		String[] input = {"z", "x", "z", "ett", "rftt"};
		
		// compare each pair letter by letter till we find a mismatch in the character.
		// if there is mismatch, form an edge with those chars and move to next words
		SimpleGraph<Character> graph = new SimpleGraph<Character>();
		for (int i=0; i<input.length-1; i++) {
			String w1 = input[i];
			for (int j=i+1; j<input.length; j++) {
				String w2 = input[j];
				formEdgeOnMismatchCharacter(graph, w1, w2);
			}
		}
		
		TopologicalSort<Character> t = new TopologicalSort<Character>();
		t.topologicalSort(graph);
	}
	
	private static void formEdgeOnMismatchCharacter(SimpleGraph<Character> graph, String w1, String w2) {
		int n = w1.length() < w2.length() ? w1.length() : w2.length();
		char[] wc1 = w1.toCharArray();
		char[] wc2 = w2.toCharArray();
		for (int c=0; c<n; c++) {
			if (wc1[c] != wc2[c]) {
				if (graph.ifEdgeExists(wc1[c], wc2[c])) {
					break;
				} else {
					if (graph.ifReverseEdgeExists(wc1[c], wc2[c])) {
						System.err.println("Loop exixts");
						System.exit(0);
					}
					graph.addEdge(wc1[c], wc2[c], true);
					break;
				}
				
			}
		}	
	}

}
