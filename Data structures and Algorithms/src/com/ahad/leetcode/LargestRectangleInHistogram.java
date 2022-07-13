package com.ahad.leetcode;

public class LargestRectangleInHistogram {
	
	
	
	public int largestRectangleArea(int[] heights) {
		
		if(heights == null || heights.length == 0) return 0;
		
		//need to two array for knowing the left and right most border for area
		
		int n = heights.length;
		int[] left = new int[n];
		left[0] = -1;
		
		int[] right = new int[n];
		right[n -1] = n;
		
		for(int i = 1; i < n; i++) {
			int prev = i - 1;
			while(prev >= 0 && heights[prev] >= heights[i]) {
				//while previous has more value that means it has a wall on left side
				prev = left[prev];
			}
			left[i] = prev;
		}
		
		for(int i = n - 2; i >= 0; i--) {
			int prev = i + 1;
			while(prev < n && heights[prev] >= heights[i]) {
				//means have a wall on right side
				prev = right[prev];
			}
			right[i] = prev;
		}
		
		int maxArea = 0;
		for(int i = 0; i < n; i++) {
			maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
		}
		return maxArea;

	}

}
