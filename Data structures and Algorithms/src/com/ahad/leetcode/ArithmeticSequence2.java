package com.ahad.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ArithmeticSequence2 {
	
	public static void main(String[] args) {
		int[] nums = {2,4,6,8};
		System.out.println(numberOfArithmeticSlicesDP(nums));
	}

	private static int n;
	private static int ans;

	private static void dfs(int dep, int[] A, List<Long> cur) {
		if (dep == n) {
			if (cur.size() < 3) {
				return;
			}
			long diff = cur.get(1) - cur.get(0);
			for (int i = 1; i < cur.size(); i++) {
				if (cur.get(i) - cur.get(i - 1) != diff) {
					return;
				}
			}
			ans++;
			return;
		}
		dfs(dep + 1, A, cur);
		cur.add((long) A[dep]);
		dfs(dep + 1, A, cur);
		cur.remove((long) A[dep]);
	}

	public static int numberOfArithmeticSlices(int[] A) {
		n = A.length;
		ans = 0;
		List<Long> cur = new ArrayList<Long>();
		dfs(0, A, cur);
		return (int) ans;
	}
	
	
	//Dp
	
	static class Pair{
		int last;
		long diff;
		
		Pair(int last, long diff){
			this.last = last;
			this.diff = diff;
		}
	}
	
	static HashMap<Pair, Integer> memo = new HashMap<>();
    public static int numberOfArithmeticSlicesDP(int[] A) {
        int n = A.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                total += dfs(j+1, j, (long)A[j]-A[i], A); //starting from 3rd element or sequence
                										  //checking the difference before
            }
        }
        return total;
    }
    
    static int dfs(int index, int last, long diff, int[] A){ //1st case last = 1
        if(index == A.length)
            return 0;
        
        Pair hash = new Pair(last, diff); //creating pair of the last index with its difference
        								  //if this pair can create subsequence with the same difference
        								  //the recursion will go on with memorizing it
        //the basic idea is how many sequences possible with particular difference of particular two element
        if(memo.get(hash) != null)
            return memo.get(hash);
        
        int local = 0;
        for(int next = index; next < A.length; next++){
            if((long)A[next]-A[last] == diff){ //if the difference from before matches the current 
            								   //difference, we got a slice or subsequence 
                local += dfs(next+1, next, diff, A) + 1; //if next element has the same diff recursion goes on
                										 //adding the count of subsequences
            }
        }
        memo.put(hash, local);
        return local;
    }

}
