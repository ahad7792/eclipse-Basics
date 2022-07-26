package com.ahad.leetcode;

import java.util.Arrays;

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		
		int[] dp = new int[amount + 1]; 
		Arrays.fill(dp, amount + 1); 
		//array to fill the required coin
		//initially filling with amount more than required 
		dp[0] = 0;
		
		for(int coin : coins) {
			for(int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		
		return dp[amount] <= amount ? dp[amount] : -1;

	}

}
