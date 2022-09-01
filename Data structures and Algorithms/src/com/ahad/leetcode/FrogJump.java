package com.ahad.leetcode;

public class FrogJump {
	
	public static void main(String[] args) {
		int[] stones = {0,1,3,5,6,8,12,17};
		System.out.println(canCross(stones));
	}

	static boolean[][] dp;
	public static boolean canCross(int[] stones) {
		
		if(stones[1] != 1) return false;
		int n = stones.length;
		dp = new boolean[n][n];
		return jump(stones, 0, 1);

	}

	private static boolean jump(int[] stones, int lastIndex, int currIndex) {
		
		if(currIndex == stones.length - 1) return true;
		
		if(dp[lastIndex][currIndex]) return false;
		
		int lastJump = stones[currIndex] - stones[lastIndex];
		
		int nextIndex = currIndex + 1;
		
		while(nextIndex < stones.length && stones[nextIndex] <= stones[currIndex] + lastJump + 1) {
			int nextJump = stones[nextIndex] - stones[currIndex];
			int jump = nextJump - lastJump;
			
			if(jump >= -1 && jump <= 1) {
				if(jump(stones, currIndex, nextIndex)) {
					return true;
				}
			}
			nextIndex++;
		}
		dp[lastIndex][currIndex] = true;
		return false;
	}

}
