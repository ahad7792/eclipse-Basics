import java.util.Arrays;

public class BinarySearch2D {
	
	public static void main(String[] args) {
		
		int[][] arr = {
			{10, 20, 30, 40},
			{12, 21, 33, 42},
			{15, 24, 36, 45},
			{18, 27, 39, 48}
		};
		
		System.out.println(Arrays.toString(search(arr, 36)));
		
	}
	
	
	static int[] search(int[][] matrix, int target) {
		
		int row = 0;
		int column = matrix.length - 1;
		
		while (row < matrix.length - 1 && column >= 0) {
			
			if (matrix[row][column] == target) {
				return new int[] {row, column};
			}
			
			if (target > matrix[row][column]) {
				row++;
			}
			else {
				column--;
			}
		}
		
		return new int[] {-1, -1};
		
	}
	

}
