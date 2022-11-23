package com.ahad.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitMaze {

	public int nearestExit(char[][] maze, int[] entrance) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(entrance);
		int ans = 0;
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		visited[entrance[0]][entrance[1]] = true;
		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		while (!queue.isEmpty()) {
			ans++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] arr = queue.poll();
				for (int j = 0; j < 4; j++) {
					int[] dir = dirs[j];
					int nextR = arr[0] + dir[0];
					int nextC = arr[1] + dir[1];
					if (nextR >= 0 && nextC >= 0 && nextR < maze.length && nextC < maze[0].length
					// need to check index out of bound because calculating the next move first
							&& maze[nextR][nextC] == '.' && !visited[nextR][nextC]) {
						if ((nextR == 0 || nextC == 0 || nextR == maze.length - 1 || nextC == maze[0].length - 1)) {
							return ans;
						}
						visited[nextR][nextC] = true;
						queue.offer(new int[] { nextR, nextC });
					}
				}
			}
		}
		return -1;
	}

}
