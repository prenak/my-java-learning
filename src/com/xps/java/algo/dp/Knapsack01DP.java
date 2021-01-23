package com.xps.java.algo.dp;

public class Knapsack01DP {

	public static void main(String[] args) {
		
		int sackWeight = 8;
		int[] profits = {1,2,5,6,4};
		int[] weights = {2,3,4,5,9};
		
		int maxProfit = getMaxProfit(sackWeight, profits, weights);
		System.out.println(maxProfit);
	}
	
	private static int getMaxProfit(int sackWeight, int[] profits, int[] weights) {
		
		// Number of items
		int n = profits.length;
		int[][] tab = new int[n+1][sackWeight+1];
		
		// Iterate through the number of items
		for (int i=0; i<=n; i++) {
			// Iterate through each value of weight until total weight of the sack
			for (int w=0; w<=sackWeight; w++) {
				
				// When the weight of the sack is 0
				if (i==0 || w==0) {
					tab[i][w] = 0;
					continue;
				}
				
				// When the weight of an item is greater than weight of the sack
				if (getWeightOfItem(weights, i) > w) {
					tab[i][w] = tab[i-1][w];
					
				} else {
					tab[i][w] = Math.max(
									tab[i-1][w-1],
									tab[i-1][w - getWeightOfItem(weights, i)] + getProfitOfItem(profits, i)
								);
				}
			}
		}
		printProducts(tab, n, sackWeight, weights);
		return tab[n][sackWeight];
	}
	
	private static void printProducts(int[][] tab, int n, int w, int[] weights) {
		while (n != 0 && w != 0) {
			
			if (tab[n][w] == tab[n-1][w]) {
				n--;
			} else {
				System.out.print(n + ", ");
				w -= getWeightOfItem(weights, n);
			}
		}
	}
	
	private static int getProfitOfItem(int[] profits, int index) {
		return profits[index-1];
	}
	
	private static int getWeightOfItem(int[] weights, int index) {
		return weights[index-1];
	}
}
