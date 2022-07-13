package com.ahad.leetcode;

public class HouseRobber2 {
	
	public static void main(String[] args) {
		int[] nums = {1,3,1,3,100};
		System.out.println(rob(nums));
	}
	
	/*
	 * public static int rob(int[] nums) {
	 * 
	 * if (nums.length == 1) { return nums[0]; }
	 * 
	 * if (nums.length == 2) { return Math.max(nums[0], nums[1]); }
	 * 
	 * if (nums.length == 3) { return Math.max(Math.max(nums[0],nums[1]), nums[2]);
	 * }
	 * 
	 * int max1 = nums[0], max2 = nums[1];
	 * 
	 * for (int i = 0; i + 2 < nums.length - 1; i=i+2) { //if starts robbing from
	 * first house max1 = max1 + nums[2 + i]; }
	 * 
	 * for (int i = 1; i + 2 < nums.length; i=i+2) { //if starts robbing from second
	 * house max2 = max2 + nums[2 + i]; }
	 * 
	 * return Math.max(max1, max2);
	 * 
	 * }
	 */

	
	public static int rob(int[] nums) {
		
		int[] ans = new int[nums.length - 1];
		
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		
		ans[0] = nums[0];
		ans[1] = Math.max(nums[0], nums[1]);
		
		//starting from the first house
		for(int i = 2; i < nums.length - 1; i++) {
			ans[i] = Math.max(ans[i - 2] + nums[i], ans[i - 1]);
		}
		
		//starting from the second house
		int ans2[] = new int[nums.length];
		ans2[1] = nums[1];
		ans2[2] = Math.max(nums[1], nums[2]);
		
		for(int i = 3; i < nums.length; i++) {
			ans2[i] = Math.max(ans2[i - 2] + nums[i], ans2[i - 1]);
		}
		
		return Math.max(ans[ans.length - 1], ans2[ans2.length - 1]);

	}

}


