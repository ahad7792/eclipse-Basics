package com.ahad.leetcode;

import java.util.Arrays;

public class MaxProfitJobSchd {
	
	public static void main(String[] args) {
		// startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
		int[] startTime = {1,2,3,3};
		int[] endTime = {3,4,5,6};
		int[] profit = {50, 10, 40, 70};
		
		int ans = jobScheduling(startTime, endTime, profit);
		System.out.println(ans);
	}

	static int n;
	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		
		n = startTime.length;

		int[][] jobs = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			jobs[i][0] = startTime[i];
			jobs[i][1] = endTime[i];
			jobs[i][2] = profit[i];
		}
		
		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
		
		int[] dp = new int[n];
		
		return solve(jobs, 0, dp);
		
	}
	
	private static int solve(int[][] jobs, int index, int[] dp) {
		
		if(index >= n) return 0;
		
		if(dp[index] != 0) return dp[index];
		
		//not including current job
		int profitWithout = solve(jobs, index + 1, dp);
		
		//profit of the current job
		int profitWith = jobs[index][2];
		
		int nextJob = getNextJob(jobs, jobs[index][1], index);
		
		if(nextJob != -1) {
			profitWith += solve(jobs, nextJob, dp);
		}
		
		dp[index] = Math.max(profitWith, profitWithout);
		return dp[index];
		
	}

	private static int getNextJob(int[][] jobs, int currJobEnd, int currIndex) {
		
		int left = currIndex;
		int right = n - 1;
		int pos = -1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			int nextJobStart = jobs[mid][0];
			if(nextJobStart >= currJobEnd) {
				pos = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return pos;
	}

}
