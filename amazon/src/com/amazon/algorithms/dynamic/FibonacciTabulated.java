package com.amazon.algorithms.dynamic;

public class FibonacciTabulated {
	int fib(int n) {
		int f[] = new int[n+1];
		f[0] = 1;
		f[1] = 1;
		for(int i = 2; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}
	
	public static void main(String[] args) {
		FibonacciTabulated fibonacci = new FibonacciTabulated();
		int n = 9;
		System.out.println("Fibonacci number is " + " "+ fibonacci.fib(n));
	}
}
