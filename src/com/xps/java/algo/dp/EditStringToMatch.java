package com.xps.java.algo.dp;

//Given two strings str1 and str2 and below operations that can performed on str1.
//Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
//Insert, Remove, Replace
//All of the above operations are of equal cost.
//Example:
//Input:   str1 = "sunday", str2 = "saturday"
//Output:  3
//Last three and first characters are same.  We basically need to convert "un" to "atur". 
//This can be done using below three operations. Replace 'n' with 'r', insert t, insert a

public class EditStringToMatch {
	
	public static void main(String[] args) {
		String str1 = "sunday", str2 = "saturday";
		int m = str1.length(), n = str2.length();
		System.out.println(findMinOps(str1, str2, m, n));
	}
	
	private static int findMinOps(String str1, String str2, int m, int n) {
		
		// Base cases -
		// If str1 is empty, we would need to insert all the characters in str2
		if (m == 0) return n;
		// If str2 is empty, we would need to remove all the characters from str1
		if (n == 0) return m;
		
		// If last characters of two strings are same, nothing 
	    // much to do. Ignore last characters and get count for 
	    // remaining strings.
		if (str1.charAt(m-1) == str2.charAt(n-1))
			return findMinOps(str1, str2, m-1, n-1);
		
		// If last characters are not same, consider all three 
	    // operations on last character of first string, recursively 
	    // compute minimum cost for all three operations and take 
	    // minimum of three values.
		return 1 + min(
						// MinOps after inserting an element at the end of str1
						findMinOps(str1, str2, m, n-1), 
						// MinOps after removing an element from the end of str1
						findMinOps(str1, str2, m-1, n),
						// MinOps after replacing an element at the end of str1
						findMinOps(str1, str2, m-1, n-1)
					  );
	}
	
	private static int min(int x, int y, int z) {
		if (x <= y && x <= z) return x;
		if (y <= x && y <= z) return y;
		return z;
	}

}
