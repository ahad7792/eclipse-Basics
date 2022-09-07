package com.ahad.leetcode;

public class MinFallingPathSum {

	public int minFallingPathSum(int[][] matrix) {
		
		int n = matrix.length;
		int m = matrix[0].length;
		int dp[][] = new int[n][m];
		int min = Integer.MAX_VALUE - 100;
		for (int j = 0; j < m; j++) {
			min = Math.min(min, helper(n-1, j, matrix, dp));
		}
		return min;

	}
	
	int helper(int i, int j, int[][] matrix, int[][] dp) {
		if(j >= matrix[0].length || j < 0) return Integer.MAX_VALUE - 100;
		if(i == 0) return matrix[i][j];
		if(dp[i][j] != 0) return dp[i][j];
		int up = matrix[i][j] + helper(i-1, j, matrix, dp);
		int dr = matrix[i][j] + helper(i-1, j+1, matrix, dp);
		int dl = matrix[i][j] + helper(i-1, j-1, matrix, dp);
		return dp[i][j] = Math.min(up, Math.min(dr, dl));
	}

}
