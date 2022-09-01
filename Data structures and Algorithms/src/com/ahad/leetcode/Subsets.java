package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(subsets(nums));
	}

	static List<List<Integer>> list =new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
            return list;
        subSequence(0,nums,new ArrayList<>());
        return list;
    }
    public static void subSequence(int index,int[] nums,List<Integer> temp)
    {
        if(index>nums.length-1)
        {
            list.add(new ArrayList<Integer>(temp));//java stores references of list so we have to add like this..
            return;
        }
        temp.add(nums[index]);
        subSequence(index+1,nums,temp);
        temp.remove(temp.size()-1);
        subSequence(index+1,nums,temp);    
    }

}
