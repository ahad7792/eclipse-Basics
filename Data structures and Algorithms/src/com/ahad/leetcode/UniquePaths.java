package com.ahad.leetcode;

public class UniquePaths {

	public int uniquePaths(int m, int n) {
		
		int[][] dp = new int[m][n];
		return helper(m-1, n-1, dp);

	}

	private int helper(int i, int j, int[][] dp) {
		
		if(i == 0 && j == 0) return 1;
		
		if(dp[i][j] != 0) return dp[i][j];
		
		if(i < 0 || j < 0) return 0;
		
		int left = helper(i, j-1, dp);
		int right = helper(i-1, j, dp);
		
		return dp[i][j] = left + right;
		
	}

}
