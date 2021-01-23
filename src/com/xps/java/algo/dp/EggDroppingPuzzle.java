package com.xps.java.algo.dp;

import java.util.Arrays;

//Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break.
//You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.
//There are few rules given below.
//- An egg that survives a fall can be used again.
//- A broken egg must be discarded.
//- The effect of a fall is the same for all eggs.
//- If the egg doesn't break at a certain floor, it will not break at any floor below.
//- If the eggs breaks at a certain floor, it will break at any floor above.

public class EggDroppingPuzzle {

	public static void main(String[] args) {
		int numOfFloors = 10;
		int numOfEggs = 2;
		
		System.out.println(findMinAttempts(numOfEggs, numOfFloors));
	}
	
	private static int findMinAttempts(int numOfEggs, int numOfFloors) {
		
		int[][] tab = new int[numOfEggs+1][numOfFloors+1];
		for (int[] row : tab) {
			Arrays.fill(row, 0);
		}
		
		
		for (int e=1; e<=numOfEggs; e++) {
			for (int f=1; f<=numOfFloors; f++) {
				
				if (e == 1) {
					// When there is just one egg, then min number of attempts 
					// for each floor would be the floor number
					tab[1][f] = f;
					continue;
				}
				
				if (e > f) {
					tab[e][f] = tab[e-1][f];
				} else {
					tab[e][f] = 1 + getMinAttemptsForEachFloor(e, f, tab);
				}
			}
		}
		
		return tab[numOfEggs][numOfFloors];
	}
	
	private static int getMinAttemptsForEachFloor(int e, int f, int[][] tab) {
		int result = Integer.MAX_VALUE;
		for (int i=1; i<=f; i++) {
			// Having e number of eggs and dropping 1 of them from floor i
			// it will either break or not break
			int maxForFloor = Math.max( // If egg break, we are left with e-1 egg and i-1 floor to re-attempt from
										tab[e-1][i-1],
										// If egg doesn't break, we still have e eggs and f-i floors to try out from 
										tab[e][f-i]
									  );
			
			result = Math.min(result, maxForFloor);
		}
		return result;
	}

}
