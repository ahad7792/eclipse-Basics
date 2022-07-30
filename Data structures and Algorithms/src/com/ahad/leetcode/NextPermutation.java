package com.ahad.leetcode;

import java.util.Arrays;

public class NextPermutation {
	
	public static void main(String[] args) {
		int[] nums = {5,1,1};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void nextPermutation(int[] nums) {

		// at first need to find the point where descending from the end
		int descendingPoint = nums.length - 1;

		while (descendingPoint >= 1) {
			if (nums[descendingPoint] > nums[descendingPoint - 1]) {
				break;
			}
			descendingPoint--;
		}

		descendingPoint--;

		int j = nums.length - 1;
		if (descendingPoint >= 0) {
			while (j >= 0) {
				if (nums[descendingPoint] < nums[j]) {
					swap(nums, descendingPoint, j);
					break;
				}
				j--;
			}
		}

		// Now need to reverse the numsArray from the descending point
		reverse(nums, descendingPoint + 1);

	}

	private static void reverse(int[] nums, int descendingPoint) {

		int end = nums.length - 1;
		while (descendingPoint < end) {
			swap(nums, descendingPoint, end);
			end--;
			descendingPoint++;
		}

	}

	private static void swap(int[] nums, int j, int i) {

		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;

	}

}
