package com.ahad.leetcode;

public class WhereWillBallFall {

	public int[] findBall(int[][] grid) {
		
		int n = grid.length;
		int m = grid[0].length;
		
		int[] ans = new int[m];
		
		for(int col = 0; col < m; col++) {
			int cPos = col;
			
			for(int row = 0; row < n; row++) {
				int nCol = cPos + grid[row][cPos]; //next column in next row at down
				
				if(nCol < 0 || nCol >= m || grid[row][cPos] != grid[row][nCol]) {
					cPos = -1;
					break;
				}
				
				cPos = nCol;
			}
			
			ans[col] = cPos;
		}
		return ans;

	}

}
