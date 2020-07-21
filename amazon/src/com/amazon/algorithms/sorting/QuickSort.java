package com.amazon.algorithms.sorting;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class QuickSort extends RecursiveTask<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5903551182448058554L;
	int start, end;
	int[] arr;
	public QuickSort(int start, int end, int[] arr) {
		this.start = start;
		this.end = end;
		this.arr = arr;
	}
	
	public static void main(String[] args) {
		int n = 7;
		int[] arr = {54, 64, 95, 82, 12, 32, 63};
		ForkJoinPool pool = ForkJoinPool.commonPool();
		pool.invoke(new QuickSort(0, n-1, arr));
		
		for(int i = 0; i < n; i++)
			System.out.println(arr[i] + " ");
	
	}

	@Override
	protected Integer compute() {
		if(start >= end)
			return null;
		
		int p = partition(start, end, arr);
		
		QuickSort left = new QuickSort(start, p-1, arr);
		QuickSort right = new QuickSort(p+1, end, arr);
		
		left.fork();
		right.compute();
		left.join();
		
		return null;
	}

	private int partition(int start, int end, int[] arr) {
		int i = start, j = end;
		int pivot = new Random().nextInt(j - i) + i;
		int t = arr[j];
		arr[j] = arr[pivot];
		arr[pivot] = t;
		j--;
		
		while(i <= j) {
			if(arr[i] <= arr[end]) {
				i++;
				continue;
			}
			if(arr[j] >= arr[end]) {
				j--;
				continue;
			}
			
			t = arr[j];
			arr[j] = arr[i];
			arr[i] = t;
			j--;
			i++;
		}
		
		t = arr[j+1];
		arr[j+1] = arr[end];
		arr[end] = t;
		return j+1;
	}
}
