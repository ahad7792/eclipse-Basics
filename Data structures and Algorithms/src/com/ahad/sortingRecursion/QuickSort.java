package com.ahad.sortingRecursion;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		
		int[] arr = {5, 4, 3, 2, 1};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr, int low, int high) {
		if(low >= high) {
			return;
		}
		int s = low;
		int e = high;
		int m = s + (e-s)/2;
		int pivot = arr[m];
		
		while(s <= e) {
			while(arr[s] < pivot) {
				s++;
			}
			while(arr[e] > pivot) {
				e--;
			}// when no violation loop will break
			//if violation found for both e and s
			if(s <= e) {
				//swap
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				s++;
				e--;
			}
		}
		//after the loop pivot will be at correct place
		sort(arr, low, e);
		sort(arr, s, high);
	}

}
