package com.ahad.leetcode;

public class SortArrayByParity {

	public int[] sortArrayByParity(int[] nums) {

		int[] ans = new int[nums.length];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				ans[index++] = nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 1) {
				ans[index++] = nums[i];
			}
		}

		return ans;

	}

	public int[] sortArrayByParityQuickSort(int[] nums) {

		int i = 0;
		int j = nums.length - 1;
		
		while(i < j) {
			if(nums[i] % 2 > nums[j] % 2) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
			
			if(nums[i] % 2 == 0) i++;
			if(nums[j] % 2 == 1) j--;
		}
		
		return nums;

	}

}
