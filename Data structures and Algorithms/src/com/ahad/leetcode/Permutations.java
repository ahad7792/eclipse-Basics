package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> ans = new ArrayList<>();
		ans = permute(nums);
		System.out.println(ans);
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		
		List<Integer> subList = new ArrayList<>();
		
		int[] marks = new int[nums.length];
		
		generate(nums, ans, marks, subList);
		return ans;
	}

	private static void generate(int[] nums, List<List<Integer>> ans, int[] marks, List<Integer> suList) {
		
		if(suList.size() == nums.length) {
			ans.add(new ArrayList<>(suList));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(marks[i] != 1) {
				marks[i] = 1;
				suList.add(nums[i]);
				generate(nums, ans, marks, suList);
				suList.remove(suList.size() - 1);
				marks[i] = 0;
			}
		}
		
	}

}
