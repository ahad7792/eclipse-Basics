package com.ahad.leetcode;

public class MinimumPathSum {
	
	public static void main(String[] args) {
		int[][] grid = 
				{{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];

		return helper(m - 1, n - 1, grid, dp);

	}

	private static int helper(int i, int j, int[][] grid, int[][] dp) {
		
        if(i == 0 && j == 0) return grid[i][j];
        
        if(i < 0 || j < 0) return Integer.MAX_VALUE - 100;
		
		
		if(dp[i][j] != 0) return dp[i][j];
		
		
		int left = grid[i][j] + helper(i, j - 1, grid, dp);
		int up = grid[i][j] + helper(i - 1, j, grid, dp);
		
		return dp[i][j] = Math.min(left, up);
		
		
	}

}
