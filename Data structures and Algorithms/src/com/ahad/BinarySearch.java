package com.ahad;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] intArray = {-3, 0, 5, 9, 15, 18, 25};
		
		System.out.println(searchIndex(intArray, 5));
		
		System.out.println(recursiveBinarySearch(intArray, 18));

	}
	
	public static int searchIndex(int[] input, int value) {
		int start = 0;
		int end = input.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			System.out.println("midpoint = " + mid);
			if (input[mid] == value) {
				return mid;
			}
			else if (input[mid] > value) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static int recursiveBinarySearch(int[] input, int value) {
		return recursiveBinarySearch(input, 0, input.length, value);
	}

	private static int recursiveBinarySearch(int[] input, int start, int end, int value) {
		
		if (start >= end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		System.out.println("midpoint = " + mid);
		
		if (input[mid] == value) {
			return mid;
		}
		else if (input[mid] < value) {
			return recursiveBinarySearch(input, mid + 1, end, value);
		}
		else {
			return recursiveBinarySearch(input, start, mid, value);
		}
		
	}
	
	

}



















