package com.ahad.stringRecursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetWithIteration {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		List<List<Integer>> ansLists = subsets(arr);
		for(List<Integer> ans : ansLists) {
			System.out.println(ans);
		}
	}
	
	public static List<List<Integer>> subsets(int[] arr){
		List<List<Integer>> outer = new ArrayList<>();
		
		outer.add(new ArrayList<>());
		
		for(int num : arr) {
			int size = outer.size();
			for(int i = 0; i < size; i++) {
				List<Integer> internal = new ArrayList<>(outer.get(i));
				internal.add(num);
				outer.add(internal);
			}
		}
		return outer;
	}

}
