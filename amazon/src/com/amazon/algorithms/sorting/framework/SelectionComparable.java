package com.amazon.algorithms.sorting.framework;

public class SelectionComparable<T extends Comparable<T>> extends Sort<T> {
	// selecting the minimum and then swapping
	@Override
	public void sort(T[] nums) {
		int N = nums.length;
		for (int i = 0; i < N - 1; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(nums[j], nums[min])) {
					min = j;
				}
			}
			swap(nums, i, min);
		}

	}

}
