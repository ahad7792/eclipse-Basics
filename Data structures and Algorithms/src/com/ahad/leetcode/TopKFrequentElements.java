package com.ahad.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {4,1,-1,2,-1,2,3,2 };
		System.out.println(Arrays.toString(topKFrequent(nums, 2)));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> mp = new HashMap<>();
		  
        // Traverse through array elements and
        // count frequencies
        for (int i = 0; i < nums.length; i++)
        {
            if (mp.containsKey(nums[i])) 
            {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } 
            else
            {
                mp.put(nums[i], 1);
            }
        }

		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> mp.get(a) - mp.get(b));
															//in a and b passing the keys
															//which is basically values of array
															//comparing them in minHeap corresponding frequencies
		for(int key : mp.keySet()) {
			minHeap.add(key);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		int[] ans = new int[k];
		for(int i = 0; i < k; i++) {
			ans[i] = minHeap.poll();
		}
		
		return ans;

	}
	

}

