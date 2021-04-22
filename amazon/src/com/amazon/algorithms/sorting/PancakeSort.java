package com.amazon.algorithms.sorting;

//Given an unsorted array, sort the given array. You are allowed to do only following operation on array. 
//flip(arr, i): Reverse array from 0 to i 
// arr - 23, 10, 20, 11, 12, 6, 7
// flip(arr, 4)
// arr - 12, 11, 20, 10, 23, 6, 7

public class PancakeSort {
	
	public static int[] flip(int[] arr, int i) {
		int j = 0;
		while(j < i) {
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			j++;
			i--;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int arr[] = {23, 10, 20, 11, 12, 6, 7};
		int n = arr.length;
		pancakeSort(arr, n);
		System.out.println("Sorted array: ");
		printArray(arr, n);
	}

	private static void printArray(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	private static void pancakeSort(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			int maxIndex = findMaxElementIndex(arr, n-i);
			arr = flip(arr, maxIndex);
			arr = flip(arr, n-i-1);
		}
		
	}

	private static int findMaxElementIndex(int[] arr, int n) {
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] > arr[max]){
				max = i;
			}
		}
		return max;
	}
}
