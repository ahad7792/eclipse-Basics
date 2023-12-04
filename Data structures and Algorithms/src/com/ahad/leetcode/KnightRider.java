package com.ahad.leetcode;

public class KnightRider {
	public static void main(String[] args) {
		System.out.println(knightDialer(3));
	}
	
	static int result = 0;
	
	public static int knightDialer(int n) {
        for(int row = 0; row < 3; row++){
            for (int col = 0; col < 3; col++){
                calculate(row, col, n, 1);
            }
        }
        calculate(3, 1, n, 1);
        return result;
    }

    public static void calculate(int row, int col, int n, int digits){

        if((col != 1 && (row > 2 || col > 2 || row < 0 || col < 0)) 
            || (col == 1 && (row > 3 || row < 0))){
            return;
        }
        
        if(digits == n){
        	result++;
            return;
        }
        
        calculate(row + 2, col + 1, n, digits + 1);
        calculate(row - 2, col + 1, n, digits + 1);
        calculate(row + 1, col + 2, n, digits + 1);
        calculate(row + 1, col - 2, n, digits + 1);
        calculate(row + 2, col - 1, n, digits + 1);
        calculate(row - 2, col - 1, n, digits + 1);
        calculate(row - 1, col + 2, n, digits + 1);
        calculate(row - 1, col - 2, n, digits + 1);

    }
}
