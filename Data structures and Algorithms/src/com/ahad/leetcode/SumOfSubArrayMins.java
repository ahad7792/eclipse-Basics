package com.ahad.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SumOfSubArrayMins {
	
	public static void main(String[] args) {
		int[] arr = {3,1,2,4};
		System.out.println(sumSubarrayMins2(arr));
	}
	
	public static int sumSubarrayMins(int[] arr) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        long mod = (long)1000000007;
        st.push(-1);
        for (int i= 0; i < arr.length+1; i++){
            int currVal = (i<=arr.length-1)? arr[i] : 0;
            while(st.peek() !=-1 && currVal<arr[st.peek()]){
                int index = st.pop();
                int j = st.peek();
                int left = index - j;
                int right = i - index;
                long add = (left * right * (long)arr[index]) % mod;
                ans += add ;
                ans %= mod;
            }
            st.push(i);
        }
        return ans;
    }
	
	//two directions
    //Runtime: 8 ms, faster than 100.00% of Java online submissions for Sum of Subarray Minimums.
    //Memory Usage: 48.2 MB, less than 99.42% of Java online submissions for Sum of Subarray Minimums.
    //Time: O(N + N + N); Space: O(N + N)
    //Time: O(N); Space: O(N)
    public static int sumSubarrayMins_1(int[] arr) {
        final int modulo = 1_000_000_007;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        right[arr.length - 1] = arr.length - 1;

        for (int i = 1; i < arr.length; i++){
            int idx = i - 1;
            while (idx >= 0 && arr[idx] > arr[i]) idx = left[idx] - 1;
            left[i] = idx + 1;

        }

        right[arr.length - 1] = arr.length - 1;
        for (int i = arr.length - 2; i >= 0; i--){
            int idx = i + 1;
            while (idx < arr.length && arr[i] <= arr[idx]) idx = right[idx] + 1;
            right[i] = idx - 1;
        }

        //result
        long res = 0;
        for (int i = 0; i < arr.length; i++)
            res = res + 1l *  arr[i] * (i - left[i] + 1)  * (right[i] - i + 1);

        return (int) (res % modulo);
    }
    
    static int MOD = (int)(1e9 + 7);
    public static int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        
        //leftCount[i] = number of element greater or equal than element at i 
        //till we find first smaller number
        int[] leftCount  = getLeftCounts(arr);
        
        //rightCount[i] = number of element greater than element at i 
        //till we find first smaller or equal number
        int[] rightCount = getRightCounts(arr);
        
        
        long totalSum = 0;
        for(int i = 0; i < n; i++){
            //consider each number as mininum number
            //using this number calculate total number of possible subarray
            totalSum = (totalSum +  (long)arr[i] * leftCount[i] * rightCount[i]) % MOD; 
        }
        
        return (int)totalSum;
    }
    
    private static int[] getLeftCounts(int[] arr){
        int n = arr.length;
        
        int[] counts = new int[n];
        
        Deque<Integer> stack = new LinkedList();
        
        for(int i = 0; i < n; i++){
            //remove all the index which value is greater or equal than current value
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            
            counts[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        
        return counts;
    }
    
    
    private static int[] getRightCounts(int[] arr){
        int n = arr.length;
        
        int[] counts = new int[n];
        
        Deque<Integer> stack = new LinkedList();
        
        for(int i = n - 1; i >= 0; i--){
            //remove all the index which value is greater or equal than current value
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            
            counts[i] = stack.isEmpty() ? n - i: stack.peek() - i;
            stack.push(i);
        }
        
        return counts;
    }

}
