package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

	List<List<Integer>> ansList = new ArrayList<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		
		if (nums.length < 1) {
			return ansList;
		}
		
		Arrays.sort(nums);
		
		helper(0, nums, new ArrayList<>());
		return ansList;

	}

	private void helper(int i, int[] nums, List<Integer> temp) {
		
		if(i >= nums.length) {
			if(!ansList.contains(temp)) {
				ansList.add(new ArrayList<>(temp));	
			}
			return;
		}
		
		temp.add(nums[i]);
		helper(i + 1, nums, temp);
		temp.remove(temp.size() - 1);
		helper(i + 1, nums, temp);
		
	}

}
