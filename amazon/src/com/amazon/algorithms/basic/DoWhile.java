package com.amazon.algorithms.basic;

public class DoWhile {
	public static void main(String[] args) {
		do {
			System.out.print(1);
			do {
				System.out.print(2);
			}while(false);
		}while(true);
	}
}
