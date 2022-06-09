package com.ahad.patternRecursion;

import java.util.Arrays;

public class BubbleSortRecursion {
	
	public static void main(String[] args) {
		int[] arr = {9, 6, 3, 2, 1};
		bubbleSort(arr, arr.length - 1, 0);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubbleSort(int[] arr, int r, int c) {
		if(r == 0) {
			return;
		}
		if(r > c) {
			if(arr[c] > arr[c + 1]) {
				//swap
				int temp = arr[c];
				arr[c] = arr[c+1];
				arr[c+1] = temp;
			}
			bubbleSort(arr, r, c+1);
		} else {
			bubbleSort(arr, r-1, 0);
		}
	}

}
