package com.ahad.stringRecursion;

import java.util.ArrayList;
import java.util.List;

public class NumberPadSolution {
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("78"));
	}
	
	public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            return  ans;
        }
        return phone("",digits);
    }
    
    static List<String> phone(String p , String up) {
		if(up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list ;
		}
		ArrayList<String> list = new ArrayList<>();
		int number = up.charAt(0) - '0' ;
		if(number < 7) {
			for(int i = (number-2)*3 ; i<(number-1)*3 ; i++) {
				char ch = (char)('a' +i) ;
				list.addAll(phone(p + ch,up.substring(1) ));
			}
		}
		if(number ==7) {
			for(int i = 15; i<19; i++) {
				char ch = (char)('a' +i) ;
				list.addAll(phone(p + ch,up.substring(1) ));
				
			}
		}
		if(number ==8) {
			for(int i = 19; i<22; i++) {
				char ch = (char)('a' +i) ;
				list.addAll(phone(p + ch,up.substring(1) ));
				
			}
		}
		if(number ==9) {
			for(int i = 22; i<26; i++) {
				char ch = (char)('a' +i) ;
				list.addAll(phone(p + ch,up.substring(1) ));
				
			}
		}
		return list ;
	}

}
