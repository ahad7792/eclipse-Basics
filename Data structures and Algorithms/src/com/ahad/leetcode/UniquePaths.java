package com.ahad.leetcode;

public class UniquePaths {

	public int uniquePaths(int m, int n) {

		int[][] dp = new int[m][n];
		return helper(m - 1, n - 1, dp);

	}

	private int helper(int i, int j, int[][] dp) {

		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != 0)
			return dp[i][j];

		int left = helper(i, j - 1, dp);
		int right = helper(i - 1, j, dp);

		return dp[i][j] = left + right;

	}

	public int uniquePaths2(int m, int n) {

		int[][] dp = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int left = 0, right = 0;
				if(i == 0 && j == 0) dp[i][j] = 1;
				else {
					if(j > 0) left = dp[i][j - 1];
					if(i > 0) right = dp[i - 1][j];
					dp[i][j] = left + right;
				}
			}
		}
		
		return dp[m - 1][n - 1];

	}

}
