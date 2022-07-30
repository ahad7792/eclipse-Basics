package com.ahad.leetcode;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		
		//we need two pointer two keep track of minimum height
		int area = 0;
		int left = 0, right = height.length - 1;
		
		while(left < right) {
			area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
			
			//move the pointer to the maximum height
			if(height[left] < height[right]) left++;
			else right--;
		}
		
		return area;

	}

}
