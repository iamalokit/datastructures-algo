package com.amazon.core;

public class Anonymous {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("New thread created");
				
			}
		}).start();
		
		// using lambda expressions
		new Thread(()->{
			System.out.println("Another one created");
		}).start();
	}
}
