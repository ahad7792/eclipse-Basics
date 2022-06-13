package com.ahad.backtracking;

public class Maze {
	
	public static void main(String[] args) {
		System.out.println(ways(3, 3));
		path("", 3, 3);
		System.out.println();
		pathWithDiagonal("", 3, 3);
		System.out.println();
		Boolean[][] landMatrix = {
				{true, true, true},
				{true, false, true},
				{true, true, true}
		};
		pathRestriction("", landMatrix, 0, 0);
	}
	
	public static int ways(int r, int c) {
		if(r == 1 || c == 1) {
			return 1;
		}
		int left = ways(r - 1, c);
		int right = ways(r, c - 1);
		return left + right;
	}
	
	public static void path(String process, int r, int c) {
		if(r == 1 && c == 1) {
			System.out.println(process);
			return;
		}
		
		if(r > 1) {
			path(process + 'D', r - 1, c);
		}
		if(c > 1) {
			path(process + 'R', r, c - 1);
		}
	}
	
	public static void pathWithDiagonal(String process, int r, int c) {
		if(r == 1 && c == 1) {
			System.out.println(process);
			return;
		}
		if(r > 1 && c > 1) {
			pathWithDiagonal(process + 'D', r - 1, c - 1);
		}
		if(r > 1) {
			pathWithDiagonal(process + 'V', r - 1, c);
		}
		if(c > 1) {
			pathWithDiagonal(process + 'H', r, c - 1);
		}
	}
	
	public static void pathRestriction(String process, Boolean[][] landMatrix, int r, int c) {
		if(r == landMatrix.length - 1 && c == landMatrix[0].length - 1) {
			System.out.println(process);
			return;
		}
		if(!landMatrix[r][c]) {
			return;
		}
		if(r < landMatrix.length - 1) {
			pathRestriction(process + 'D', landMatrix, r + 1, c);
		}
		if(c < landMatrix[0].length - 1) {
			pathRestriction(process + 'R', landMatrix, r, c + 1);
		}
	}

}
