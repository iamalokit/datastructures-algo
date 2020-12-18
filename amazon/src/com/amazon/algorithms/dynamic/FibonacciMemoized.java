package com.amazon.algorithms.dynamic;

public class FibonacciMemoized {
	final int MAX = 100;
	final int NIL = -1;
	
	int lookup[] = new int[MAX];
	void _initialize() {
		for(int i = 0; i < MAX; i++) {
			lookup[i] = NIL;
			
		}
	}
	
	int fib(int n) {
		if(lookup[n] != NIL) {
			return lookup[n];
		} else {
			if(n <= 1) {
				lookup[n] = n;
			}
			else {
				lookup[n] = fib(n-1) + fib(n-2);
			}
		}
		return lookup[n];
	}
}
