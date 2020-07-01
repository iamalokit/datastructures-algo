package com.amazon.algorithms.basic;

public class ReverseArray {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6};
		int k = 3;
		reverseArray(arr, k);
	}

	private static void reverseArray(int[] arr, int k) {
		int i = 0;
		while(i <= k) {
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			i++;
			k--;
		}
		
		for(i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
