package com.amazon.algorithms.basic;

public class FibonacciFastDoubling {
	public static void main(String[] args) {
		int N = 6;
		int res[] = new int[2];
		FastDoubling(N, res);
		System.out.println(res[0]);
	}

	private static void FastDoubling(int n, int[] res) {
		int a, b, c, d;
		int MOD = 1000000007;
		if(n == 0) {
			res[0] = 0;
			res[1] = 1;
			return;
		}
		
		a = res[0];
		b = res[1];
		c = 2*b - a;
		
		if(c < 0)
			c += MOD;
		
		c = (a*c) % MOD;
		
		d = (a*a + b*b) % MOD;
		
		if(n % 2 == 0) {
			res[0] = c;
			res[1] = d;
		}else {
			res[0] = d;
			res[1] = c+d;
		}
	}
}
