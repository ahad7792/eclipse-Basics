package com.ahad.leetcode;

public class ValidMatrixRowAndColumnSums {

	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

		int n = rowSum.length;
		int m = colSum.length;

		int[][] ans = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (rowSum[i] > 0 && colSum[j] > 0) {
					int x = Math.min(rowSum[i], colSum[j]);
					ans[i][j] = x;
					rowSum[i] -= x;
					colSum[j] -= x;
				}

			}
		}

		return ans;

	}

}
