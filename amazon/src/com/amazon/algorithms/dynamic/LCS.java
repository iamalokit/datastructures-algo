package com.amazon.algorithms.dynamic;

public class LCS {
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;
		
		System.out.println("Length of lcs is " + lcs(X, Y, m, n));
		
		
	}
	
	private static int lcs(char[] x, char[] y, int m, int n) {
		int L[][] = new int[m+1][n+1];
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 || j == 0)
					L[i][j] = 0;
				else if(x[i-1] == y[j-1])
					L[i][j] = L[i-1][j-1] + 1;
				else
					L[i][j] = max(L[i-1][j], L[i][j-1]);
			}
		}
		
		return L[m][n];
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
