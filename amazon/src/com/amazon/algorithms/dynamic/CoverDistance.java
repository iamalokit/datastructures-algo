package com.amazon.algorithms.dynamic;

public class CoverDistance {
	public static void main(String[] args) {
		int dist = 4;
		System.out.println(printCountDp(dist));
	}

	private static int printCountDp(int dist) {
		int[] count = new int[dist+1];
		count[0] = 1;
		count[1] = 1;
		count[2] = 2;
		
		for(int i = 3; i <= dist; i++) {
			count[i] = count[i-1] + count[i-2] + count[i-3];
		}
		
		return count[dist];
	}
}
