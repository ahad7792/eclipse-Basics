package com.ahad.leetcode;

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(search(nums, 0));
	}

	static int BinarySearch(int[] nums, int target, int start, int end) {
		int l = start, r = end;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	static int findMin(int[] nums, int start, int end) {

		if (start > end)
			return -1;

		int mid = start + (end - start) / 2;
		int next = (mid + 1) % nums.length;
		int prev = (mid + nums.length - 1) % nums.length;
		if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
			return mid;
		} else {
			if (nums[mid] <= nums[end]) {
				end = mid - 1;
				return findMin(nums, start, end);
			} else if (nums[start] <= nums[mid]) {
				start = mid + 1;
				return findMin(nums, start, end);
			}
		}
		
		return -1;

	}

	static int search(int[] nums, int target) {
		int n = nums.length;
		int min_index;
		min_index = findMin(nums, 0, n - 1);
		int a1 = BinarySearch(nums, target, 0, min_index - 1);
		int a2 = BinarySearch(nums, target, min_index, n - 1);
		if (a1 == -1)
			return a2;
		else
			return a1;
	}

}
