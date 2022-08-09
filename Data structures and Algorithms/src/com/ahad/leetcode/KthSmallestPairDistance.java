package com.ahad.leetcode;

import java.util.Arrays;

public class KthSmallestPairDistance {
	
	public static void main(String[] args) {
		int[] nums = {1,6,1};
		System.out.println(smallestDistancePair(nums, 3));
	}

	public static int smallestDistancePair(int[] nums, int k) {
		
		Arrays.sort(nums);
		
		int size = nums.length;
		
		int high = nums[size - 1] - 1;
		int low = Integer.MAX_VALUE;
		
		for (int i = 1; i < size; i++) {
			if(nums[i] - nums[i - 1] < low) {
				low = nums[i] - nums[i - 1];
			}
		}
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			int pairsMinMid = slidingCount(nums, mid, size);
			
			if(pairsMinMid < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		
		return low;

	}

	private static int slidingCount(int[] nums, int mid, int size) {
		int count = 0;
		int j = 0;
		for (int i = 1; i < size; i++) {
			while(nums[i] - nums[j] > mid) {
				j++;
			}
			count += (i - j);
		}
		return count;
	}

}
