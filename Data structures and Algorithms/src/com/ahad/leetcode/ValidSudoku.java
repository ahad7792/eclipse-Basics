package com.ahad.leetcode;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] columns = new boolean[9][9];
		boolean[][] squares = new boolean[9][9];
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '.') {
					continue;
				}
				
				int num = board[i][j] - '1'; //0 based index
				if(rows[num][j]) {
					return false;
				}
				rows[num][j] = true;
				if(columns[i][num]) {
					return false;
				}
				columns[i][num] = true;
				if(squares[i/3 * 3 + j/3][num]) { //i/3 * 3 + j/3 gives 0 to 8 squares count
					return false;
				}
				squares[i/3 * 3 + j/3][num] = true;
				
			}
		}
		return true;
	}

}
