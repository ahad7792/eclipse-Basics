package com.ahad.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.PriorityQueue;

public class SortArrayByIncreasingFrequency {
	
	class Pair implements Comparable<Pair>{
		int key;
		int value;
		
		public Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			if(this.key == o.key) {
				return o.value - this.value;
			} else {
				return this.key - o.key;
			}
		}
	}

	public int[] frequencySort(int[] nums) {
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(freqMap.containsKey(nums[i])) {
				freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
			} else {
				freqMap.put(nums[i], 1);
			}
		}
		
		PriorityQueue<Pair> heap = new PriorityQueue<>();
		
		for(Entry<Integer, Integer> entry : freqMap.entrySet()) {
			heap.add(new Pair(entry.getValue(), entry.getKey()));
		}
		
		int[] ans = new int[nums.length];
		int index = 0;
		while(!heap.isEmpty()) {
			Pair currPair = heap.poll();
			int currFrequency = currPair.key;
			while(currFrequency > 0) {
				ans[index] = currPair.value;
				index++;
				currFrequency--;
				
			}
		}
		return ans;

	}

}
