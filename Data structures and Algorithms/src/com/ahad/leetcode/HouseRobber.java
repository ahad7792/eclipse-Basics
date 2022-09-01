package com.ahad.leetcode;

public class HouseRobber {

	public static void main(String[] args) {

	}

	public int rob(int[] nums) {
		int[] ans = new int[nums.length];
		ans[0] = nums[0];

		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		ans[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			ans[i] = Math.max(ans[i - 2] + nums[i], ans[i - 1]);
		}
		return ans[ans.length - 1];
	}

	public int robOptimized(int[] nums) {

		if (nums.length == 0)
			return 0;
		int prev1 = 0;
		int prev2 = 0;
		for (int num : nums) {
			int temp = prev1;
			prev1 = Math.max(prev2 + num, prev1);
			prev2 = temp;
		}
		return prev1;

	}

}
