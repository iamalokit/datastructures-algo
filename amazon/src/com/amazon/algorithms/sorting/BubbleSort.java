package com.amazon.algorithms.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = {5, 4, 3, 2, 1};
		sortAndPrint(arr);
		
	}

	private static void sortAndPrint(int[] arr) {
		// bubble sort
		// compare the first element with the next element 
		// if first element greater than second element swap
		
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
