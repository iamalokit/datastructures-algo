package com.amazon.algorithms.basic;

public class MaximumProduct {
	public static void main(String[] args) {
		int arr[] = {-1, -3, -4, 2, 0, -5};
		findMaxProduct(arr);
	}

	private static void findMaxProduct(int[] arr) {
		// handle base cases
		int maxPos = Integer.MIN_VALUE;
		int maxSecPos = Integer.MIN_VALUE;
		int maxNeg = Integer.MAX_VALUE;
		int maxSecNeg = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 0) {
				if(arr[i] > maxPos) {
					maxSecPos = maxPos;
					maxPos = arr[i];
				}else if(arr[i] > maxSecPos) {
					maxSecPos = arr[i];
				}
			}else {
				if(arr[i] < maxNeg) {
					maxSecNeg = maxNeg;
					maxNeg = arr[i];
				}
				else if(arr[i] < maxSecNeg) {
					maxSecNeg = arr[i];
				}
			}
		}
		if(maxPos*maxSecPos > maxNeg*maxSecNeg){
			System.out.println(maxPos + " " + maxSecPos);
		}else {
			System.out.println(maxNeg + " " + maxSecNeg);
		}
	}
}
