package com.ahad.leetcode;

import java.util.Arrays;
import java.util.List;

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		
		int n = triangle.size();
		int m = triangle.get(n-1).size();
		int[][] dp = new int[n][m];
		
		for(int[] oned:dp){
            Arrays.fill(oned, 10001);
        }
		
		return helper(0, 0, triangle, dp);

	}

	private int helper(int i, int j, List<List<Integer>> triangle, int[][] dp) {
		if(i == triangle.size() - 1) return triangle.get(i).get(j);
		
		if(dp[i][j] != 10001) return dp[i][j];
		
		int down = triangle.get(i).get(j) + helper(i + 1, j, triangle, dp);
		int diagonal = triangle.get(i).get(j) + helper(i + 1, j + 1, triangle, dp);
		
		return dp[i][j] = Math.min(down, diagonal);
		
	}

}
