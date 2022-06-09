package com.ahad.sortingRecursion;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		
		int[] arr = {5, 4, 3, 2, 1};
		int[] arr1 = sort(arr);
		System.out.println(Arrays.toString(arr1));
		
		sortInPlace(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static int[] sort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}
		
		int mid = arr.length/2;
		int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length)); 
		//mid need to be included because it is exclusive till the last element
		
		return merge(left, right);
	}

	public static int[] merge(int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		int[] mix = new int[left.length + right.length];
		
		while(i < left.length && j < right.length) {
			if(left[i] < right[j]) {
				mix[k] = left[i];
				i++;
			} else if(left[i] > right[j]){
				mix[k] = right[j];
				j++;
			}
			k++;
		}//things need to be done to merge within same length
		
		while(i < left.length) {
			mix[k] = left[i];
			i++;
			k++;
		} 
		while(j < right.length) {
			mix[k] = right[j];
			j++;
			k++;
		}
		return mix;
	}
	
	public static void sortInPlace(int[] arr, int s, int e) {
		if(e - s == 1) {
			return;
		}
		
		int mid = (e + s)/2;
		sortInPlace(arr, s, mid);
		sortInPlace(arr, mid, e); 
		
		mergeInPlace(arr, s, mid, e);
	}

	public static void mergeInPlace(int[] arr, int s, int m, int e) {
		int i = s, j = m, k = 0;
		int[] mix = new int[e - s];
		
		while(i < m && j < e) {
			if(arr[i] < arr[j]) {
				mix[k] = arr[i];
				i++;
			} else if(arr[i] > arr[j]){
				mix[k] = arr[j];
				j++;
			}
			k++;
		}
		
		while(i < m) {
			mix[k] = arr[i];
			i++;
			k++;
		} 
		while(j < e) {
			mix[k] = arr[j];
			j++;
			k++;
		}
		for(int l = 0; l < mix.length; l++) {
			arr[s + l] = mix[l];
		}
	}

}
