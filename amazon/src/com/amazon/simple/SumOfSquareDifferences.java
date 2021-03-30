package com.amazon.simple;

/**
 * Sum of squares of differences between all pairs of an array
 * @author kamina
 *
 */
public class SumOfSquareDifferences {
	public static void main(String[] args) {
		int arr[] = {2, 8, 4};
		int N = arr.length;
		int ans = sumOfSquaredDifferences(arr, N);
		System.out.println(ans);
	}

	private static int sumOfSquaredDifferences(int[] arr, int n) {
		int ans = 0;
		int sumA = 0, sumB = 0;
		for(int i = 0; i< n; i++) {
			sumA += arr[i]*arr[i];
			sumB += arr[i];
		}
		
		ans = n*sumA - (sumB*sumB);
		return ans;
	}
}
