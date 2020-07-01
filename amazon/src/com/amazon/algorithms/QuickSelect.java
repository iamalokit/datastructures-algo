package com.amazon.algorithms;

// algorithm to find the kth smallest integer
public class QuickSelect {

	public static void main(String[] args) {
		int k = 3;
		int arr[] = {10, 4, 5, 8, 6, 11, 26};
		int arrCopy[] = {10, 4, 5, 8, 6, 11, 26};
		int len = arr.length;
		
		if(k > len) {
			System.out.println("Index out of bound exception");
		}else {
			System.out.println(findKSmallestElement(arrCopy, 0, len-1, k-1));
		}
		
	}

	private static int findKSmallestElement(int[] arrCopy, int low, int high, int k) {
		int partition = partition(arrCopy, low, high);
		
		if(partition == k)
			return arrCopy[partition];
		
		else if(partition < k)
			return findKSmallestElement(arrCopy, partition+1, high, k);
		else
			return findKSmallestElement(arrCopy, low, partition-1, k);
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high], pivotloc = low;
		for(int i = low; i <= high; i++) {
			if(arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[pivotloc];
				arr[pivotloc] = temp;
				pivotloc++;
			}
		}
		
		int temp = arr[high];
		arr[high] = arr[pivotloc]; 
        arr[pivotloc] = temp; 
          
        return pivotloc;
	}

}
