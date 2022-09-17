package com.ahad.leetcode;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		
		for (int i = 0; i < k; i++) {
			holdAndShift(nums);
		}

	}

	private void holdAndShift(int[] nums) {
		int temp = nums[nums.length - 1]; //storing the last element to put it into first after shifting
		for (int i = nums.length - 1; i > 0; i--) {
			nums[i] = nums[i - 1]; //shifting all the others to the right
		}
		nums[0]  = temp; //putting the temp at the first index
	}

}
