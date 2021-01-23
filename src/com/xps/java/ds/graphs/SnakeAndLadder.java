package com.xps.java.ds.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class SnakeAndLadder {
	
	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner(System.in)){
			int testCases = Integer.parseInt(scan.nextLine());
			for (int i=0; i<testCases; i++) {
				int noOfLnS = Integer.parseInt(scan.nextLine());
				Map<Integer, Integer> ladderOrSnake = new HashMap<Integer, Integer>();
				String[] values = scan.nextLine().split(" ");
				for (int ls=0; ls<2*noOfLnS;) {
					ladderOrSnake.put(Integer.parseInt(values[ls++]), Integer.parseInt(values[ls++]));
				}
				System.out.println(findNumberOfChances(ladderOrSnake));
			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	
	private static int findNumberOfChances(Map<Integer, Integer> ladderOrSnake) {
		boolean[] visited = new boolean[30+1]; // we deal with positions from 1,2,3...30
		
		LinkedList<Data> q = new LinkedList<Data>();
		q.offer(new Data(1, 0));
		visited[1] = true;
		
		while (!q.isEmpty()) {
			Data d = q.poll();
			for (int i=1; i<=6; i++) {
				int newPos = getPosValue(ladderOrSnake, d.pos+i);
				if (visited[newPos]) {
					continue;
				}
				
				Data newData = new Data(newPos, d.chance+1);
				if (newData.pos == 30) {
					return newData.chance;
				} 
				q.offer(newData);
				visited[newPos] = true;
			}
		}
		return -1;
	}
	
	private static int getPosValue(Map<Integer, Integer> ladderOrSnake, int pos) {
		if (ladderOrSnake.containsKey(pos)) {
			return ladderOrSnake.get(pos);
		}
		return pos;
	}
	
	
}

class Data {
	int pos;
	int chance;
	
	public Data(int pos, int chance) {
		super();
		this.pos = pos;
		this.chance = chance;
	}

	@Override
	public String toString() {
		return "Data [pos=" + pos + ", chance=" + chance + "]";
	}
}
