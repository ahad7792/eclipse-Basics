package com.ahad.leetcode;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		
		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
		
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
		int index2 = n - 1;
		int fIndex = m + n - 1;
		
		while(index1 >= 0 && index2 >= 0) {
			if(nums1[index1] >= nums2[index2]) {
				nums1[fIndex--] = nums1[index1--];
			} else {
				nums1[fIndex--] = nums2[index2--];
			}
		}
		
		while(index1 >= 0) {
			nums1[fIndex--] = nums1[index1--];
		}
		
		while(index2 >= 0) {
			nums1[fIndex--] = nums2[index2--];
		}

    }

}
