package com.amazon.algorithms.basic;

public class ZigZagArray {
	public static void main(String[] args) {
		// input
		int arr[] = {1, 4, 3, 2};
		findZigZagArr(arr);
	}

	private static void findZigZagArr(int[] arr) {
		int flag = 0;
		int swap;
		for(int i = 0; i < arr.length-1; i++) {
			if(flag == 1) {
				if(arr[i] > arr[i+1]) {
					swap = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = swap;
				}
				flag  = 0;
			}
			else if(flag == 0) {
				if(arr[i] < arr[i+1]) {
					swap = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = swap;
				}
				flag = 1;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
