package com.xps.java.algo.dp;

//Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins.
//The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions:
//{1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
//For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

public class CoinChangeDP {
	
	public static void main(String[] args) {
//		int[] coins = {1, 2, 3};
//		int N = 4;
		
		int[] coins = {2, 5, 3, 6};
		int N = 10;
		
		System.out.println("No of ways: " + noOfWays(coins, N));
	}
	
	private static int noOfWays(int[] coins, int N) {
		int numOfCoins = coins.length;
		
		// Form a table array of size N+1
		int[] tab = new int[N+1];
		
		// Base case
		// When N=0, there can be only 1 solution
		tab[0] = 1;
		
		for (int i=0; i < numOfCoins; i++) {
			// For each coins
			int coin = coins[i];
			for (int amount=0; amount<=N; amount++) {
				if (amount >= coin) {
					tab[amount] = tab[amount] + tab[amount - coin];
				}
			}
		}
		return tab[N];
	}

}
