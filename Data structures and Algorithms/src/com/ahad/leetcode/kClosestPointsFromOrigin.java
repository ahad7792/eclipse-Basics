package com.ahad.leetcode;

import java.util.PriorityQueue;

public class kClosestPointsFromOrigin {

	public int[][] kClosest(int[][] points, int k) {

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
		
		for (int i = 0; i < points.length; i++) {
			maxHeap.add(new Pair(distance(points[i]), points[i]));
			while(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		int[][] ans = new int[k][2];
		int index = 0;
		
		while(!maxHeap.isEmpty()) {
			ans[index++] = maxHeap.poll().point; 
		}
		
		return ans;

	}
	
	public int distance(int[] point) {
		return point[0]*point[0] + point[1]*point[1];
	}

}

class Pair implements Comparable<Pair>{
	int dis;
	int[] point;

	public Pair(int dis, int[] point) {
		this.dis = dis;
		this.point = point;
	}

	@Override
	public int compareTo(Pair o) {
		return o.dis - this.dis;
	}
}
