package com.ahad.leetcode;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		
		if(nums.length == 1) return;
		
		int left = 0;
		int right = 0;
		
		while(right < nums.length) {
			if(nums[right] == 0) {
				right++;
			}else {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				left++;
				right++;
			}
		}
		

	}

}
