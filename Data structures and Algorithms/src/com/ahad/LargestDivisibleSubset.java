package com.ahad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        // Start the recursion for each element in the sorted array
        for (int i = 0; i < nums.length; i++) {
            List<Integer> subset = findSubset(nums, i);
            
            // Update the result if the current subset is larger
            if (subset.size() > result.size()) {
                result = subset;
            }
        }

        return result;
    }

    private static List<Integer> findSubset(int[] nums, int index) {
        List<Integer> subset = new ArrayList<>();
        subset.add(nums[index]);

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] % subset.get(subset.size() - 1) == 0) {
                List<Integer> nextSubset = findSubset(nums, i);
                if (nextSubset.size() > subset.size()) {
                    subset = nextSubset;
                }
            }
        }

        return subset;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println("Example 1: " + largestDivisibleSubset(nums1));

        int[] nums2 = {1, 2, 4, 8};
        System.out.println("Example 2: " + largestDivisibleSubset(nums2));
    }
}

