package com.amazon.heaps;

public class HeapSort {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		heapSort(arr);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void heapSort(int[] arr) {
		// generate max heap from the input array
		getMaxHeap(arr);
		
		//delete the root element and heapify
		for(int i = arr.length-1; i>0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
		}

	}

	private static void getMaxHeap(int[] arr) {
		int n = arr.length;
		for(int i = n/2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}		
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l < n && arr[l] > arr[largest])
			largest = l;
		if(r < n && arr[r] > arr[largest])
			largest = r;
		
		if(largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			heapify(arr, n, largest);
		}
	}
}
