package com.ahad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    static List<Integer> res;
    static int dp[];
    
    public static List<Integer> largestDivisibleSubset2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        res=new ArrayList<>();

        solve2(nums,0,1,ans);
        return res;
    }
    static void solve2(int nums[], int i, int prev,List<Integer> ans){
        
        if(i>=nums.length) {
            if(ans.size()>res.size()){
                res.clear();
                res.addAll(ans);
            }
            return;
        }
		 // conisdering into our list ...
		 
        if(nums[i]%prev==0 || prev%nums[i]==0){
            ans.add(nums[i]);
            solve2(nums,i+1,nums[i],ans);
            ans.remove(ans.size()-1);
        }
		//not considering into list......
		
        solve2(nums,i+1,prev,ans);
        
    }

    public static void main(String[] args) {
        int[] nums2 = {3,4,16,8};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + largestDivisibleSubset2(nums2));
    }
}
