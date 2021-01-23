package com.xps.java.ds.string;

import java.util.Arrays;

public class StringToIntegerATOI {
	
	private static char[] charArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	public static void main(String[] args) {
		System.out.println(convertToInt("231"));
		System.out.println(convertToInt("389761"));
		System.out.println(convertToInt("-451"));
		System.out.println(convertToInt("87Y900"));
	}
	
	private static int convertToInt(String str) {
		char[] s = str.toCharArray();
		int n = s.length, sign=1, i=0, sum=0;
		
		if (s[i] == '-') {
			sign = -1;
			i++;
		}
		
		for (; i<n; i++) {
			if (!isValidChar(s[i])) 
				return -1;
			
			sum = sum*10 + (s[i] - '0'); // IMPORTANT to subtract '0'
		}
		return sign*sum;
	}
	
	private static boolean isValidChar(char c) {
		return Arrays.binarySearch(charArr, c) < 0 ? false : true;
	}
}
