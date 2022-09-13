package com.ahad.leetcode;

public class PartitionMiniSumDiff {
	
	public static void main(String[] args) {
		int[] nums = {3,9,7,3};
		System.out.println(minimumDifference(nums));
	}

	public static int minimumDifference(int[] nums) { //only for positive number
		
		int totalSum = 0;
		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}
		int ans = Integer.MAX_VALUE - 100;
		for (int i = 0; i < totalSum/2; i++) {
			if(hasSubArrayTarget(nums.length - 1, i, nums, new int[nums.length][i + 1])) {
				int sum1 = i;
				int sum2 = totalSum - i;
				int diff = Math.abs(sum1 - sum2);
				ans = Math.min(ans, diff);
			}
		}
		
		return ans;

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
