package com.ahad.leetcode;

import java.util.Arrays;

public class FirstAndLastPositionSorted {
	
	public static void main(String[] args) {
		int[] nums = {5,7,8,8,8,10};
		System.out.println(Arrays.toString(searchRange(nums, 8)));
	}
	
	public static int[] searchRange(int[] nums, int target) {
		
		int[] ans = {-1,-1};
		if(nums.length == 2) return ans;
		
		int start = 0;
		int end = nums.length - 1;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(nums[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		if(nums[start] != target) {
			return ans;
		}
		
		ans[0] = start;
		
		end = nums.length;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(nums[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		ans[1] = start - 1;
		
		return ans;

	}

}
