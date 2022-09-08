package com.ahad.leetcode;

import java.util.Arrays;

public class CherryPickup2 {

public int cherryPickup(int[][] grid) {
		
		int n = grid.length;
		int m = grid[0].length;
		int[][][] dp = new int[n][m][m];
        
        for(int[][] arr : dp) {
			for(int[] a : arr) {
				Arrays.fill(a, -1);
			}
		}
        
		return helper(0, 0, m-1, n, m, grid, dp);

	}

	
	private int helper(int i, int j, int j2, int rows, int columns, int[][] grid, int[][][] dp) {
		
		if(j < 0 || j >= columns | j2 < 0 || j2 >= columns) return (int) -1e9;
		
		if(i == rows - 1) {
			if(j == j2) return grid[i][j];
			else {
				return grid[i][j] + grid[i][j2];
			}
		}
		
		if(dp[i][j][j2] != -1) return dp[i][j][j2];
		
        int maximum = (int) -1e9; // the maximum need to be calculated for every recursion call
		for(int m1 = -1; m1 <= 1; m1++) {
			for(int m2 = -1; m2 <= 1; m2++) {
				int value = 0;
				if(j == j2) value = grid[i][j]; // if they are both on the same cell
				else value = grid[i][j] + grid[i][j2];
				value += helper(i + 1, j + m1, j2 + m2, rows, columns, grid, dp);
				maximum = Math.max(maximum, value);
			}
		}
		
		return dp[i][j][j2] = maximum;
		
	}

}
