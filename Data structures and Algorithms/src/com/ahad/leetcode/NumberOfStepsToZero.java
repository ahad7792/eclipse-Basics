package com.ahad.leetcode;

public class NumberOfStepsToZero {
	int ans = 0;
	public int numberOfSteps(int num) {
		return helper(num, ans); 
	}
	private int helper(int num, int ans) {
		if(num == 0) return ans;
		if(num % 2 == 0) return helper(num / 2, ans + 1);
		else return helper(num - 1, ans + 1);
	}
}
