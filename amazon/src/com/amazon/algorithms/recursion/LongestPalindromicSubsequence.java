package com.amazon.algorithms.recursion;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		int len = str.length();
		System.out.println(findLongestPalindromicSeq(str, 0, len-1));
	}

	private static int findLongestPalindromicSeq(String str, int start, int end) {
		if(start == end)
			return 1;
		if(start +1 == end && str.charAt(start) == str.charAt(end)) {
			return 2;
		}
		if(str.charAt(start) == str.charAt(end)) {
			return findLongestPalindromicSeq(str, start+1, end-1) + 2;
		}
		return Integer.max(findLongestPalindromicSeq(str, start+1, end), findLongestPalindromicSeq(str, start, end-1));
	}
}
