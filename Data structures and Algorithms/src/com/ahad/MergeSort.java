package com.ahad;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] intArray = {65, 87, 9, 4, 3, -5, -6, -30, 12};
		
		intArray = mergeSort(intArray);
		
		for(int i = 0 ; i < intArray.length ; i++) {
			System.out.println(intArray[i]);
		}

	}
	
	public static int[] mergeSort(int[] array) {
		
		
		int mid = array.length/2;
		
		if (array.length <= 1) {
			return array;
		}
		
		int[] left = new int[mid];
		int[] right;
		
		if (array.length % 2 == 0) {
			right = new int[mid];
		}
		else {
			right = new int[mid + 1];
		}
		
		for(int i = 0 ; i < left.length ; i++) {
			
			left[i] = array[i];
			
		}
		for(int j = 0 ; j < right.length ; j++) {
			
			right[j] = array[mid + j];
			
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		int[] result = new int[array.length];
		
		result = merge(left , right);
		
		return result;
		
	}
	
	public static int[] merge (int[] left, int [] right){
		
		int[] result = new int[left.length + right.length];
		int resultPointer, leftPointer, rightPointer;
		resultPointer = leftPointer = rightPointer = 0;
		
		while (leftPointer < left.length || rightPointer < right.length) {
			
			if (leftPointer < left.length && rightPointer < right.length) {
				if(left[leftPointer] > right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];
				}
				else {
					result[resultPointer++] = right[rightPointer++];
				}
			}
			else if(leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			}
			else if(rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
			
		}
		
		return result;
		
	}

}
