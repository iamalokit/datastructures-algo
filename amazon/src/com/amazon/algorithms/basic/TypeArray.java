package com.amazon.algorithms.basic;

public class TypeArray {
	public static void main(String[] args) {
		int arr[] = {9, 5, 4, 3, 2, 1};
		printLargestElementAndType(arr);
	}

	private static void printLargestElementAndType(int[] arr) {
		int len = arr.length;
		int i = 0;
		for(i = 0; i < len-1; i++) {
			if(arr[i] > arr[i+1]) {
				break;
			}
		}
		if(i == len-1) {
			System.out.println(arr[i] + " - Ascending");
		}else if(i > 0 && i < len-1){
			System.out.println(arr[i] + " - Ascending Rotated");
		}else if(i == 0) {
			for(i = 0; i < len-1; i++) {
				if(arr[i] < arr[i+1]) {
					break;
				}
			}
			if(i == len - 1) {
				System.out.println(arr[0] + " - Descending");
			}
			else if(i > 0 && i < len - 1) {
				System.out.println(arr[i+1] + " - Descending Rotated");
			}
			
		}
		
	}
}
