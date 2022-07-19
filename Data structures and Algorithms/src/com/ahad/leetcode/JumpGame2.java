package com.ahad.leetcode;

import java.util.Arrays;

public class JumpGame2 {
	
	public static void main(String[] args) {
		
		int[] nums = {0,2,3,0,1,4};
		System.out.println(jump(nums));
		System.out.println(jumpIterative(nums));
		System.out.println(jumpThreePointer(nums));
		
	}
	
	static Integer[] dp;
	public static int jump(int[] nums) {
		dp = new Integer[nums.length];
		return helper(nums, 0);
	}
	private static int helper(int[] nums, int position) {
		if(position >= nums.length - 1) {
			return 0;
		}
		
		if(nums[position] == 0) {
			return 100000;
		}
		
		if(dp[position] != null) {
			return dp[position];
		}
		
		int minJump = Integer.MAX_VALUE; //initializing the value before the loop
		for(int i = position + 1; i <= position + nums[position]; i++) {
			minJump = Math.min(minJump, 1 + helper(nums, i));
										//after every loop the it is counting how much time the helper function get called
		}
		dp[position] = minJump; //storing the minimum jump for every position
		return minJump;
	}
	
	private static int jumpIterative(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[n - 1] = 0;
		for(int i = n - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for(int j = i + 1; j <= Math.min(n - 1, i + nums[i]); j++) {
								//the loop continue till n-1 index
							   //in case of element 0 the loop won't work
				min = Math.min(min, dp[j]);
								//for every possible jumping count from a position taking the minimum of them
			}
			
			if(min != Integer.MAX_VALUE) dp[i] = min + 1;
			
		}
		return dp[0];
	}
	
	private static int jumpThreePointer(int[] nums) { 
		int end = 0; 
		int farthest = 0;
		int jump = 0;
		
		for(int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			
			if(i == end) {
				jump++;
				end = farthest;
			}
		}
		return jump;
	}

}
