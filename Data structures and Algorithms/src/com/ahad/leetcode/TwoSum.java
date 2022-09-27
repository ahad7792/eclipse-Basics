package com.ahad.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		System.out.println(Arrays.toString(twoSum(nums, 6)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
		    if(map.containsKey(target - nums[i])) 
		        return new int[] {map.get(target - nums[i]), i};
		    else map.put(nums[i], i);
		   }
		return null;
	}

}
