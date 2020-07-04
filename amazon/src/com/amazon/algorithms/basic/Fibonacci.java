package com.amazon.algorithms.basic;

import java.util.ArrayList;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 9;
		System.out.println(fibonacci(n));
		System.out.println(fibonacciDP(n));
//		System.out.println(fibonacciMatrix(n));
	}

//	private static char[] fibonacciMatrix(int n) {
//		int A[][] = {{1, 1}, {1, 0}};
//		int M[][] = {{0}, {1}};
//		ArrayList<Integer[][]> arrList = new ArrayList<Integer[][]>();
//		for(int i = 0; i < n; i++) {
//			
//		}
//	}

	private static int fibonacciDP(int n) {
		int fib1 = 0, fib2 = 1, fib3 = 0;
		if(n == 0 || n == 1) {
			return n;
		}
		if(n == 2) {
			return fib1 + fib2;
		}
		for(int i = 2; i <= n; i++) {
			fib3 = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib3;
		}
		return fib3;
	}

	private static int fibonacci(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	
}
