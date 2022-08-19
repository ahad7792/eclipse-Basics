package com.ahad.sortingRecursion;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {4,2,5,37,4,2,5};
		sort(arr, arr.length - 1, 0);
		System.out.println(Arrays.toString(arr));
	}
	
	static void sort(int[] arr, int r, int c) {
		if(r == 0) {
			return;
		}
		
		if(r > c) {
			if(arr[c + 1] < arr[c]) {
				int temp = arr[c];
				arr[c] = arr[c + 1];
				arr[c + 1] = temp;
				sort(arr, r, c + 1);
			} else {
				sort(arr, r, c + 1);
			}
		} else {
			sort(arr, r - 1, 0);
		}
	}

}
