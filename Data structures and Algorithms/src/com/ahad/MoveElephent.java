package com.ahad;

public class MoveElephent {
	
	public static void main(String[] args) {
		int n = 12;
		System.out.println(move(n));
	}
	
	public static int move(int destination) {
		
		int moves = 0;
		int start = destination;
		int[][] dp = new int[5][destination + 1];
		return helper(moves, start, dp);
	}

	static int ans = Integer.MAX_VALUE;
	private static int helper(int moves, int start, int[][] dp) {
		if(start < 0) return Integer.MAX_VALUE - 1000000;
		if(start == 0) {
			return moves;
		}
		
		if(dp[moves][start] != 0) return dp[moves][start];
		
		for(int i = 1; i <= 5; i++) {
			ans = Math.min(ans, moves + helper(1, start-i, dp));
		}
		
		return dp[moves][start] = ans;
	}

}
