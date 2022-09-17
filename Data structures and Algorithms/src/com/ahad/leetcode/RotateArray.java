package com.ahad.leetcode;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		
		for (int i = 0; i < k; i++) {
			holdAndShift(nums);
		}

	}

	private void holdAndShift(int[] nums) {
		int temp = nums[nums.length - 1]; //storing the first element to put it into last after shifting
		for (int i = nums.length - 1; i > 0; i--) {
			nums[i] = nums[i - 1]; //shifting all the others to the left
		}
		nums[0]  = temp; //putting the temp at the last index
	}

}
