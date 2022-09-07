package com.ahad.leetcode;

public class UniquePaths2 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int left = 0, up = 0;
				if (obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else if (i == 0 && j == 0)
					dp[i][j] = 1;
				else {
					if (i > 0)
						up = dp[i - 1][j];
					if (j > 0)
						left = dp[i][j - 1];
					dp[i][j] = left + up;
				}
			}
		}

		return dp[m - 1][n - 1];

	}

	public int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];

		return helper(m - 1, n - 1, obstacleGrid, dp);

	}

	private int helper(int i, int j, int[][] obstacleGrid, int[][] dp) {
		
		if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        
        if(i < 0 || j < 0) return 0;
		
		
		if(dp[i][j] != 0) return dp[i][j];
		
		
		int left = helper(i, j - 1, obstacleGrid, dp);
		int up = helper(i - 1, j, obstacleGrid, dp);
		
		return dp[i][j] = left + up;
		
		
	}

}
