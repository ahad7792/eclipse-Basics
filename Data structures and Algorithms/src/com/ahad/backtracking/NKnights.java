package com.ahad.backtracking;

public class NKnights {
	
	public static void main(String[] args) {
		int n = 4;
		boolean[][] board = new boolean[n][n];
		System.out.println(nKinights(board, 0, 0, n));
	}
	
	public static int nKinights(boolean[][] board, int row, int col, int targets) {
		if(targets == 0) {
			display(board);
			System.out.println();
			return 1;
		}
		int count = 0;
		
		if(col == board.length && row == board.length - 1) {
			return count;
		}
		
		if(col == board.length) {
			count += nKinights(board, row + 1, 0, targets);
			return count;
		}
		
		if(isSafe(board, row, col)) {
			board[row][col] = true;
			count += nKinights(board, row, col + 1, targets - 1);
			board[row][col] = false;
		}
		
		count += nKinights(board, row, col + 1, targets);
		
		return count;
	}
	
	private static boolean isSafe(boolean[][] board, int row, int col) {
		
		if(isValid(board, row - 2, col - 1)) {
			if(board[row  - 2][col - 1]) {
				return false;
			}
		}
		
		if(isValid(board, row - 2, col + 1)) {
			if(board[row - 2][col + 1]) {
				return false;
			}
		}
		
		if(isValid(board, row - 1, col + 2)) {
			if(board[row - 1][col + 2]) {
				return false;
			}
		}
		
		if(isValid(board, row - 1, col - 2)) {
			if(board[row - 1][col - 2]) {
				return false;
			}
		}
		
		return true;
	}
	
	

	private static boolean isValid(boolean[][] board, int row, int col) {
		
		if(row >= 0 && row < board.length && col >= 0 && col < board.length) {
			return true;
		}
		return false;
		
	}

	private static void display(boolean[][] board) {
		for(boolean[] row : board) {
			for(boolean element : row) {
				if(element == true) {
					System.out.print("K ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}

}
