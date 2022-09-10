package com.ahad.leetcode;

public class PartitionEqualSubsetSum {
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 11, 5};
		System.out.println(canPartition(nums));
	}
	
	public static boolean canPartition(int[] nums) {
		
		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}
		if(totalSum % 2 != 0) return false;
		int target = totalSum/2;
		int[][] dp = new int[nums.length][target + 1];
		if(hasSubArrayTarget(nums.length - 1, target, nums, dp)) return true;
		else return false;

	}
	
	private static boolean hasSubArrayTarget(int index, int target, int[] arr, int[][] dp) {
		if(target == 0) return true;
		if(index == 0) return target == arr[index];
		
		if(dp[index][target] != 0) {
			if(dp[index][target] == 1) return true;
			else return false;
		}
		boolean notTake = hasSubArrayTarget(index - 1, target, arr, dp);
		boolean take = false;
		if(target >= arr[index]) {
			take = hasSubArrayTarget(index - 1, target - arr[index], arr, dp);
		}
		
		if(take || notTake) dp[index][target] = 1;
		else dp[index][target] = 2;
		
		return take || notTake;
	}
}
