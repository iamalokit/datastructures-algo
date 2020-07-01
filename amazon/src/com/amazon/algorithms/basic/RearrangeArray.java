package com.amazon.algorithms.basic;

public class RearrangeArray {
	public static void main(String[] args) {
		int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		int n = arr.length;
		rearrangeArray(arr, n);
		printArray(arr, n);
	}

	private static void printArray(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void rearrangeArray(int[] arr, int n) {
		// lets say we have negative numbers in even places
		// and positive numbers in odd places
		// considering 0 as even
		int index1 = -1, index2 = -1;
		for(int i = 0; i < n; i++) {
			// if even and the number is greater than 0 , record the index 
			if(i % 2 == 0 && arr[i] > 0 && index1 == -1) {
				index1 = i;
			}
			else if(i % 2 != 0 && arr[i] < 0 && index2 == -1) {
				index2 = i;
			}
			if(index1 != -1 && index2 != -1 && index1 != index2) {
				int temp = arr[index1];
				arr[index1] = arr[index2];
				arr[index2] = temp;
				i = Math.min(index1, index2);
				index1 = index2 = -1;
			}
			// now find the 
		}
	}

}
