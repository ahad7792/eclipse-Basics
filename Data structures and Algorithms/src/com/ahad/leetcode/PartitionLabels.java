package com.ahad.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public List<Integer> partitionLabels(String s) {
		
		int[] last_indices = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			last_indices[s.charAt(i) - 'a'] = i;
		}
		
		List<Integer> ans = new ArrayList<>();
		
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < s.length(); i++) {
			end = Math.max(last_indices[s.charAt(i) - 'a'], end);
			if(end == i) {
				ans.add(end - start + 1);
				start = end + 1;
			}
		}
		
		return ans;

	}

}
