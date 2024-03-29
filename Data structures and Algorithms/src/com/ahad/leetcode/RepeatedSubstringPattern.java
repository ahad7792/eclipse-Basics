package com.ahad.leetcode;

public class RepeatedSubstringPattern {
	
public boolean repeatedSubstringPattern(String s) {
        
        int n = s.length();
        
        for(int l = n/2; l > 0; l--){
            
            if(n % l == 0){ //pattern length must be a divisor of size
                int i = 0;
                while(i + l < n && s.charAt(i) == s.charAt(i + l)){
                    i++;
                }
                if(i + l == n) return true; 
            }
            
        }
        
        return false;
    }

}
