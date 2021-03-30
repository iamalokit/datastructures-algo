package com.amazon.simple;


/**
 * Search an element in a sorted and rotated array
 * @author alokitjindal
 *
 */
public class SearchElement {
	public static void main(String[] args) {
		int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int n = arr1.length;
		int key = 3;
		System.out.println("Index of the element is : "
                + pivotedBinarySearch(arr1, n, key));
	}

	private static int pivotedBinarySearch(int[] arr1, int n, int key) {
		int pivot = findPivot(arr1, 0, n-1);
		if(pivot == -1)
			return binarySearch(arr1, 0, n-1, key);
		
		if(arr1[pivot] == key)
			return pivot;
		if(arr1[0] <= key)
			return binarySearch(arr1, 0, pivot-1, key);
		return binarySearch(arr1, pivot+1, n-1, key);
	}

	private static int binarySearch(int[] arr1, int low, int high, int key) {
		if(high < low)
			return -1;
		int mid = (low + high)/2;
		if(key == arr1[mid])
			return mid;
		if(key > arr1[mid])
			return binarySearch(arr1, mid+1, high, key);
		return binarySearch(arr1, low, mid-1, key);
	}

	private static int findPivot(int[] arr1, int low, int high) {
		// base cases
		if(high < low) {
			return -1;
		}
		if(high == low) {
			return low;
		}
		
		int mid = (low + high)/2;
		if(mid < high && arr1[mid] > arr1[mid+1])
			return mid;
		if(mid > low && arr1[mid] < arr1[mid-1])
			return mid;
		if(arr1[low] >= arr1[mid])
			return findPivot(arr1, low, mid-1);
		return findPivot(arr1, mid+1, high);
	}
	
}
