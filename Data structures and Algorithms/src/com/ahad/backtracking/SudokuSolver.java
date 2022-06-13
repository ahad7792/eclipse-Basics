package com.ahad.backtracking;

public class SudokuSolver {
	
	public static void main(String[] args) {
		int[][] board = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		         		  {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		         		  {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		         		  {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		         		  {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		         		  {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		         		  {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		         		  {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		         		  {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		if(solve(board)) {
			display(board);
		} else {
			System.out.println("Cannot be solved");
		}
	}
	
	static boolean solve(int[][] board) {
		
		int newRow = -1;
		int newCol = -1;
		
		boolean emptyLeft = true;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == 0) {
					newRow = i;
					newCol = j;
					//found an empty position now break
					emptyLeft = false;
					break;
				}
			}
			if(emptyLeft == false) {
				break;
			}
		}
		
		if(emptyLeft == true) {
			return true;
		}
		
		for(int num = 1; num <= 9; num++) {
			if(isSafe(board, newRow, newCol, num)) {
				board[newRow][newCol] = num;
				if(solve(board)) {
					return true;
				} else {
					board[newRow][newCol] = 0;
				}
			}
		}
		return false;
	}
	
	static boolean isSafe(int board[][], int row, int col, int num) {
		
		for(int i = 0; i < board.length; i++) {
			if(board[i][col] == num || board[row][i] == num) {
				//if the number already exist in the particular column or row
				return false;
			}
		}
		
		int sqrt = (int) Math.sqrt(board.length);
		int rowStart = row - (row % sqrt); //finding the starting row and column for the particular box of the number
		int colStart = col - (col % sqrt);
		
		for(int r = rowStart; r < sqrt; r++) {
			for(int c = colStart; c < sqrt; c++) {
				if(board[r][c] == num) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void display(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
