package com.ahad.backtracking;

import java.util.Arrays;

public class AllPaths {
	
	public static void main(String[] args) {
		boolean[][] landMatrix = {
				{true, true, true},
				{true, true, true},
				{true, true, true}
		};
		allPaths("", landMatrix, 0, 0);
		int[][] ans = new int[landMatrix.length][landMatrix[0].length];
		allPathsPrint("", landMatrix, 0, 0, ans , 1);
	}
	
	public static void allPaths(String possibleCombinations, boolean[][] landMatrix, int r, int c) {
		if(r == landMatrix.length - 1 && c == landMatrix[0].length - 1) {
			System.out.println(possibleCombinations);
			return;
		}
		
		if(!landMatrix[r][c]) {
			return;
		}
		
		landMatrix[r][c] = false;
		
		if(r < landMatrix.length - 1) {
			allPaths(possibleCombinations + 'D', landMatrix, r + 1, c);
		}
		if(c < landMatrix[0].length - 1) {
			allPaths(possibleCombinations + 'R', landMatrix, r, c + 1);
		}
		if(r > 0) {
			allPaths(possibleCombinations + 'U', landMatrix, r - 1, c);
		}
		if(c > 0) {
			allPaths(possibleCombinations + 'L', landMatrix, r, c - 1);
		}
		
		landMatrix[r][c] = true;
	}
	
	public static void allPathsPrint(String possibleCombinations, boolean[][] landMatrix, int r, int c, int[][] ans, int step) {
		if(r == landMatrix.length - 1 && c == landMatrix[0].length - 1) {
			ans[r][c] = step;
			System.out.println();
			System.out.println(possibleCombinations);
			for(int[] row : ans) {
				System.out.print(Arrays.toString(row));
				System.out.println();
			}
			return;
		}
		
		if(!landMatrix[r][c]) {
			return;
		}
		
		landMatrix[r][c] = false;
		ans[r][c] = step;
		
		if(r < landMatrix.length - 1) {
			allPathsPrint(possibleCombinations + 'D', landMatrix, r + 1, c, ans, step + 1);
		}
		if(c < landMatrix[0].length - 1) {
			allPathsPrint(possibleCombinations + 'R', landMatrix, r, c + 1, ans, step + 1);
		}
		if(r > 0) {
			allPathsPrint(possibleCombinations + 'U', landMatrix, r - 1, c, ans, step + 1);
		}
		if(c > 0) {
			allPathsPrint(possibleCombinations + 'L', landMatrix, r, c - 1, ans, step + 1);
		}
		
		landMatrix[r][c] = true;
		ans[r][c] = 0;
	}

}
