package com.amazon.algorithms.sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = {5, 4, 3, 2, 1};
		sortAndPrint(arr);
		
	}

	private static void sortAndPrint(int[] arr) {
		// selection sort
		// select the minimum element in the array
		
		
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[i]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			System.out.println(arr[i]);
		}
	}
}
