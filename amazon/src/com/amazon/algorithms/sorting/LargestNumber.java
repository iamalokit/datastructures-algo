package com.amazon.algorithms.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class LargestNumber {
	public static void main(String[] args) {
		Vector<String> arr;
		
		arr = new Vector<String>();
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		printLargest(arr);
		
	}

	private static void printLargest(Vector<String> arr) {
		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String X, String Y) {
				String XY = X + Y;
				String YX = Y + X;
				
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
			
		});
		
		Iterator<String> it = arr.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
