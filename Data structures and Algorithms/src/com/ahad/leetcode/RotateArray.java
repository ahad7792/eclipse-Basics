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
	
	public void rotateOptimized(int[] nums, int k) {
		int l = k % nums.length; //checking if the k is bigger than the nums.length
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, l - 1);
		reverse(nums, l, nums.length - 1);
	}

	private void reverse(int[] nums, int i, int j) {
		while(i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

}
