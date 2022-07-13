package com.ahad.leetcode;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {5,4,3,2,6,0,0};
		System.out.println(canJump(nums));
	}

	static int lastPosition = 0;
	static boolean ans;

	public static boolean canJump(int[] nums) {

//		for (int i = 0, potential = 0; i < nums.length; i++, potential--) {
//			potential = Math.max(nums[i], potential);
//			if (potential == 0)
//				return i == nums.length - 1;
//		}
//		return true;

		if (nums.length <= 1) {
			return true;
		}
		return canJump(nums, nums.length - 2, nums.length - 1);

//		boolean[] visited = new boolean[nums.length];
//		for (int i = 0; i < visited.length; i++) {
//			visited[i] = false;
//		}
//		
//		return jump(0, nums[0], nums, visited);

	}

	static boolean canJump(int[] nums, int i, int target) {
		if (i == 0) {
			if (nums[0] >= target) {
				return true;
			} else {
				return false;
			}
		}

		if (nums[i] + i >= target) {
			return canJump(nums, i - 1, i);
		} else {
			return canJump(nums, i - 1, target);
		}

	}

//	public static boolean jump(int position, int num, int[] nums, boolean[] visited) {
//
//		if (nums.length == 1)
//			return true;
//		
//		
//		if(num == 0) {
//			return false;
//		}
//		
//		if(visited[position] == true) {
//			return false;
//		}
//		
//		position = num + position;
//		
//		if (position >= nums.length - 1) {
//			return true;
//		}
//		
//		visited[position] = true;
//		
//		ans = jump(position, nums[position], nums, visited);
//		
//		visited[position] = false;
//		
//		while(lastPosition < nums.length - 2) {
//			if(ans == false) {
//				ans = jump(++lastPosition, nums[lastPosition], nums, visited);
//			} else {
//				break;
//			}
//		}
//		
//		return ans;
//		
//	}

}
