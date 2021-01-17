package com.amazon.algorithms.dynamic;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String seq = "GEEKSFORGEEKS";
		int n = seq.length();
		System.out.println("The length of the LPS is " + lps(seq));
	}

	private static int lps(String seq) {
		int n = seq.length();
		int i, j, c1;
		int L[][] = new int[n][n];
		
		for(i = 0; i < n; i++) {
			L[i][i] = 1;
		}
		
		for(c1 = 2; c1 <= n; c1++) {
			for(i = 0; i < n-c1+1; i++) {
				j = i+c1-1;
				if(seq.charAt(i) == seq.charAt(j) && c1 == 2)
					L[i][j] = 2;
				else if(seq.charAt(i) == seq.charAt(j))
					L[i][j] = L[i+1][j-1] + 2;
				else
					L[i][j] = Integer.max(L[i][j-1], L[i+1][j]);
			}
		}
		
		return L[0][n-1];
	}
}
