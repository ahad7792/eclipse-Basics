package com.ahad.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemoved {

	// Ans = # of stones – # of connected group of stone
	public int removeStones(int[][] stones) {
		Set<int[]> visited = new HashSet();
		int numCongrp = 0;
		for (int[] s1 : stones) {
			if (!visited.contains(s1)) {
				dfs(s1, visited, stones);
				numCongrp++;
			}
		}
		return stones.length - numCongrp;
	}

	private void dfs(int[] s1, Set<int[]> visited, int[][] stones) {
		visited.add(s1);
		for (int[] s2 : stones) {
			if (!visited.contains(s2)) {
				// stone with same row or column. group them
				if (s1[0] == s2[0] || s1[1] == s2[1])
					dfs(s2, visited, stones);
			}
		}
	}

}
