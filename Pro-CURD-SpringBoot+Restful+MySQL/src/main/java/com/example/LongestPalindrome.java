package com.example;

/**
 * Palindrome Utils
 * @author Siyang Wu
 *
 */
public class LongestPalindrome {
	public static String findLongestPalindrome(String str) {
		if (str.isEmpty()) {
			return " ";
		}
		if (str.length() == 1) {
			return str;
		}
		int size = str.length();
		String longest = str.substring(0, 1); 
		for (int i = 0; i < size; i ++) {
			String temp = checkPalindrome(str, i, i);
			if (temp.length() > longest.length()) {
				longest = temp;
			}
			temp = checkPalindrome(str, i, i + 1);
			if (temp.length() > longest.length()) {
				longest = temp;
			}
		}
		return longest;
	}
	
	public static String checkPalindrome(String s, int start, int end) {
		while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
			start --;
			end ++;
		}
		return s.substring(start + 1, end);
	}
}
