package com.ahad.leetcode;

public class RotateImage {
	
	public void rotate(int[][] matrix) {
		
		int n = matrix.length;
		
		//Transpose
		for(int i = 0; i < n; i++) {
			//only need to swap items before diagonal
			for(int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
			
		}
		
		//Reverse the column
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j -1];
				matrix[i][n - j - 1] = temp;
			}
		}

	}
	
	public void rotate2(int[][] matrix) {
		
		int n = matrix.length;
		int layers = n/2;
		
		for(int layer = 0; layer < layers; layer++) {
			
			int start = layer;
			int end = n - 1 - layer;
			
			for(int i = start; i < end; i++) {
				
				//top in temp
				int temp = matrix[start][i];
				//left in top
				matrix[start][i] = matrix[n - 1 - i][start];
				//bottom in left
				matrix[n - 1 - i][start] = matrix[end][n - i - 1];
				//right in bottom
				matrix[end][n - i - 1] = matrix[i][end];
				//top in right
				matrix[i][end] = temp;
				
			}
			
		}
		
	}

}
