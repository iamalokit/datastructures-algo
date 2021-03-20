package com.amazon.simple;

// Input - K, X
// Output - N -> smallest number for which sum from K to N is atleast X
// k + k +1 + k+2 + ...N > X
// nK + 0 + 1 + 2 + 3 + 4
// eg. k = 5, x = 13
// 5 + 6 + 7
public class SmallestN {
	public static void main(String[] args) {
		int K = 5, X = 13;
		int N = findSmallestN(K, X);
		int binaryN = findSmallestNBinary(K, X);
		System.out.println(N);
		System.out.println(binaryN);
	}
	
	public static int sumN(int n) {
		return (n*(n+1)) / 2;
	}
	private static int findSmallestNBinary(int k, int x) {
		
		if(k > x) {
			return -1;
		}
		
		int res = -1;
		int low = k, high = x;
		while(low <= high) {
			int mid = low + (high - low) /2;
			if(isGreaterEqual(mid, k, x)) {
				res = mid;
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
		
		return res;
	}

	private static boolean isGreaterEqual(int n, int k, int x) {
		return sumN(n) - sumN(k-1) >= x;
	}

	private static int findSmallestN(int k, int x) {
		int sum = 0;
		for(int i = k ; i < x; i++) {
			sum += i;
			if(sum >= x) {
				return i;
			}
		}
		return -1;
	}
}
