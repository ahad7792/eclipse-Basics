package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

	class Pair implements Comparable<Pair> {
		int gap, val;

		Pair() {
		}

		Pair(int val, int gap) {
			this.gap = gap;
			this.val = val;
		}

		public int compareTo(Pair o) {  //implementing maxHeap from here
			if (this.gap == o.gap)
				return this.val > o.val ? 1 : -1; //if distance is same return add lower value
			else
				return this.gap < o.gap ? 1 : -1; //else add max value
		}
	}

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> ans = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			if (pq.size() < k)
				pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
			else {
				if (pq.peek().gap > Math.abs(arr[i] - x)) {
					pq.remove();
					pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
				}
			}
		}

		while (pq.size() > 0) {
			Pair rem = pq.remove();
			ans.add(rem.val);
		}
		Collections.sort(ans);
		return ans;
	}
	
	public List<Integer> findClosestElementsBinarySearch(int[] arr, int k, int x) {
		
		int left = 0;
		int right = arr.length - k;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = left; i < left + k; i++) {
			ans.add(arr[i]);
		}
		return ans;
	}

}
