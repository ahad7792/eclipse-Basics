package com.ahad;

import java.util.Vector;

public class FindMissingNumber {
	
	public static void main(String[] args) {
		int[] nums = {1,4,5,2,3,6,8,9,10};
		
		System.out.println(missing(nums));
	}
	
	public static int missing(int[] nums) {
		Vector<Integer> ten = new Vector<>();
		for(int i = 1; i <= 10; i++) {
			ten.add(i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			ten.set(curr - 1, 0);
		}
		int i = 0;
		while(i < 10){
			if(ten.get(i) != 0) {
				return ten.get(i);
			}
			i++;
		}
		return -1;
	}

}
