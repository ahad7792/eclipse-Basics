package com.ahad.backtracking;

public class Maze {
	
	public static void main(String[] args) {
		System.out.println(ways(3, 3));
		path("", 3, 3);
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

}
