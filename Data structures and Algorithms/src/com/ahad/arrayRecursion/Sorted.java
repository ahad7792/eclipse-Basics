package com.ahad.arrayRecursion;

public class Sorted {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 5, 6, 11, 10};
		System.out.println(sorted(arr, 0));
		
	}

	public static boolean sorted(int[] arr, int index) {
		//base case
		if(index == arr.length - 1) {
			return true;
		}
		return arr[index] < arr[index + 1] && sorted(arr, index + 1);
	}
}
