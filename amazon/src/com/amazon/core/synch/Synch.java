package com.amazon.core.synch;

public class Synch {
	synchronized void sum(int n) {
		Thread t = Thread.currentThread();
		for(int i = 1; i <=5; i++) {
			System.out.println(t.getName() + " : " + (n+i));
		}
	}
}
