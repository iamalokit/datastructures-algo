package com.amazon.algorithms.recursion;

public class CoverDistance {
	public static void main(String[] args) {
		int dist = 4;
		System.out.println(printCountRec(dist));
	}

	private static int printCountRec(int dist) {
		if(dist < 0)
			return 0;
		if(dist == 0)
			return 1;
		return printCountRec(dist-1) + printCountRec(dist-2) + printCountRec(dist-3);
	}
}
