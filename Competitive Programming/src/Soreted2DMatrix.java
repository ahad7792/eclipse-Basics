import java.util.Arrays;

public class Soreted2DMatrix {

	public static void main(String[] args) {
		
		int [][] arr = {
				{1, 3, 6},
				{9, 12, 15},
				{18, 21, 24}
		};
		System.out.println(Arrays.toString(search(arr, 21)));
	}
	
	static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
		while(cStart <= cEnd) {
			int mid = cStart + (cEnd - cStart) / 2;
			if (matrix[row][mid] == target) {
				return new int[] {row, mid};
			}
			if (matrix[row][mid] < target) {
				cStart = mid + 1;
			} else {
				cEnd = mid - 1;
			}
		}
		return new int[] {-1, -1};
	}
	
	static int[] search(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length; //matrix could be empty
		if (cols == 0) {
			return new int[] {-1, -1};
		}
		if (rows == 1) {
			return binarySearch(matrix, 0, 0, cols - 1, target);
		}
		
		int rStart = 0;
		int rEnd = rows - 1;
		int cMid = cols / 2;
		
		// need make the matrix short until there are two rows remaining
		while (rStart < (rEnd - 1)) { // this means there are more than least two rows
			int mid = rStart + (rEnd - rStart) / 2;
			if (matrix[mid][cMid] == target) {
				return new int[] {mid, cMid};
			}
			if (matrix[mid][cMid] < target) {
				rStart = mid;
			} else {
				rEnd = mid;
			}
			
		}
		
		//now we have two rows
		//check whether the target is in the columns of 2 rows
		if (matrix[rStart][cMid] == target) {
			return new int[] {rStart, cMid};
		}
		if (matrix[rStart + 1][cMid] == target) {
			return new int[] {rStart + 1, cMid};
		}
		
		//search in 1st half
		if (matrix[rStart][cMid - 1] >= target) {
			return binarySearch(matrix, rStart, 0, cMid - 1, target);
		}
		//search in 2nd half
		if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
			return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
		}
		//search in 3rd half
		if (target <= matrix[rStart + 1][cMid - 1]) {
			return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
		}
		//search in 4th half
		else {
			return binarySearch(matrix, rStart + 1, cMid - 1, cols - 1, target);
		}
	}

}
