package com.amazon.algorithms.recursion;

/**
 * Check if sum of array can be made equal to X by removing either the first or last digits of every array element
 * @author alokitjindal
 *
 */

public class SumArray {
	public static void main(String[] args) {
		int arr[] = {545, 433, 654, 23};
		int X = 134;
		check(arr, X);
	}

	private static void check(int[] arr, int x) {
		if(makeSumX(arr, x, 0, 0))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static boolean makeSumX(int[] arr, int x, int s, int i) {
		if(i == arr.length) {
			return s==x;
		}
		
		String a = Integer.toString(arr[i]);
		
		// remove last digit
		int l = Integer.parseInt(a.substring(0, a.length() - 1));
		
		// remove first digit
		int r = Integer.parseInt(a.substring(1));
		
		boolean b1 = makeSumX(arr, x, s+l, i+1);
		boolean b2 = makeSumX(arr, x, s+r, i+1);
		
		return (b1 || b2);
	}
}
