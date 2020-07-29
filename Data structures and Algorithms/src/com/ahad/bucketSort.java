package com.ahad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bucketSort {

	public static void main(String[] args) {
		
		int[] intArray = {3, 1, 54, 45, 36, 9, 10, 18};
		
		busketSort(intArray);
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}

	}

	private static void busketSort(int[] input) {
		
		List<Integer>[] buckets = new List[10];
		
		for (int i = 0; i < input.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < input.length; i ++) {
			buckets[hash(input[i])].add(input[i]);
		}
		
//		for (List bucket: buckets) {
//			Collections.sort(bucket);
//		}
//		
		int j = 0;
		for (int i = 0; i < input.length; i++) {
			for (int value: buckets[i]) {
				input[j++] = value;
			}
		}
		
	}
	
	private static int hash(int value) {
		return value / (int) 10;
	}

}











