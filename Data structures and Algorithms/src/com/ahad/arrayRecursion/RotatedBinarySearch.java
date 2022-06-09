package com.ahad.arrayRecursion;

public class RotatedBinarySearch {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4};
		System.out.println(search(arr, 4, 0, arr.length - 1));
		
	}
	
	public static int search(int[] arr, int target, int start, int end) {
		if(end < start) {
			return -1;
		}
		int mid = start + (end - start)/2;
		if(arr[mid] == target) {
			return mid;
		}
		if(arr[start] <= arr[mid]) {
			if(arr[mid] >= target && arr[start] <= target) {
				return search(arr, target, start, mid - 1);
			}else {
				return search(arr, target, mid + 1, end);
			}
		}
		if(arr[mid] <= target && arr[end] >= target) {
			return search(arr, target, mid + 1, end);
		}
		return search(arr, target, start, mid - 1);
		
	}

}
