package com.ahad.stringRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetWithIteration {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2};
		List<List<Integer>> ansLists = subsetsDuplicate(arr);
		for(List<Integer> ans : ansLists) {
			System.out.println(ans);
		}
	}
	
	public static List<List<Integer>> subsets(int[] arr){
		List<List<Integer>> outer = new ArrayList<>();
		
		//added an empty list initially
		outer.add(new ArrayList<>());
		
		for(int num : arr) {
			int size = outer.size();
			for(int i = 0; i < size; i++) {
				List<Integer> internal = new ArrayList<>(outer.get(i));
				internal.add(num);
				//for every single outer array list the number is getting added in every iteration
				outer.add(internal);
			}
		}
		return outer;
	}
	
	public static List<List<Integer>> subsetsDuplicate(int[] arr){
		Arrays.sort(arr);
		List<List<Integer>> outer = new ArrayList<>();
		
		//added an empty list initially
		outer.add(new ArrayList<>());
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < arr.length; i++) {
			start = 0;
			//if current number is equal to the previous number then start = end + 1
			if(i > 0 && arr[i] == arr[i - 1]) {
				start = end + 1;
			}
			end = outer.size() - 1;
			for(int j = start; j <= end; j++) {
				//if the number got similar the lists in outer list is skipped for previous
				List<Integer> internal = new ArrayList<>(outer.get(j));
				internal.add(arr[i]);
				//for every single outer array list the number is getting added in every iteration
				outer.add(internal);
			}
		}
		return outer;
	}

}
