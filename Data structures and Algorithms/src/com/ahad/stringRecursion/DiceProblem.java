package com.ahad.stringRecursion;

public class DiceProblem {
	
	public static void main(String[] args) {
		dice("", 4);
	}
	
	public static void dice(String comb, int target) {
		if(target == 0) {
			System.out.println(comb);
		}
		for(int i = 1; i <= 6 && i <= target; i++) {
			dice(comb + i, target - i);
		}
	}

}
