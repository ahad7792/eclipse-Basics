package com.ahad.leetcode;

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {
		
		int n = nums.length;
		
		int[] leftProducts = new int[n];
		int[] rightProducts = new int[n];
		
		leftProducts[0] = 1;
		rightProducts[n - 1] = 1;
		
		for(int i = 1; i < n; i++) {
			leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
		}
		
		for(int i = n - 2; i >= 0; i--) {
			rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
		}
		
		int[] ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			ans[i] = rightProducts[i] * leftProducts[i];
		}
		
		return ans;

	}

}
