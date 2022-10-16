package com.ahad.leetcode;

import java.util.PriorityQueue;

public class KWeakestRows {
	
	class Pair implements Comparable<Pair>{
		int soldiers;
		int row;
		
		public Pair(int soldiers, int row) {
			this.soldiers = soldiers;
			this.row = row;
		}

		@Override
		public int compareTo(Pair o) {
			if(o.soldiers != this.soldiers) return o.soldiers - this.soldiers;
			else return o.row - this.row;
		}
	}
	
	public int[] kWeakestRows(int[][] mat, int k) {
		
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
		
		for(int i = 0; i < mat.length; i++) {
			int count = 0;
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1) count++;
			}
			maxHeap.add(new Pair(count, i));
			if(maxHeap.size() > k) maxHeap.poll();
		}
		
		int[] ans = new int[k];
		int i = k - 1;
		while(!maxHeap.isEmpty() && i >= 0) {
			ans[i] = maxHeap.poll().row;
			i--;
		}
		
		return ans;
		
	}

}
