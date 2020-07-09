package com.amazon.algorithms.basic;

import java.util.HashSet;

public class Duplicate {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5};
		int k = 3;
		if(!checkForDuplicate(arr, k)) {
			System.out.println("No duplicates element found within the distance " + k);
		}
	}

	private static boolean checkForDuplicate(int[] arr, int k) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(i <= k && !hs.contains(arr[i]))
				hs.add(arr[i]);
			else if(i <= k) {
				System.out.println(arr[i] + " is repeated at distance " + i);
				return true;
			}
		}
		return false;
	}
}
