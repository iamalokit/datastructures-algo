package com.amazon.algorithms.dynamic;

public class MaxSumNoAdjacent {
	public static void main(String[] args) {
		int arr[] = {5, 5, 10, 100, 10, 5};
		System.out.println("Maximum sum of the array having no adjacent elements in the sum is " + findSum(arr));
		
	}

	private static int findSum(int[] arr) {
		int incl = 0;
		int excl = 0;
		for(int i = 0; i < arr.length; i++) {
			int temp = incl;
			incl = Math.max(incl, excl + arr[i]);
			excl = temp;
		}
		return incl;
	}

}
