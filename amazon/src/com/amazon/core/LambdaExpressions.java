package com.amazon.core;

interface FuncInterface{
	void abstractFunc(int x);
	
	default void normalFun() {
		System.out.println("Hello");
	}
}
public class LambdaExpressions {
	public static void main(String[] args) {
		FuncInterface fobj = (int x)->System.out.println(2*x);
		fobj.abstractFunc(5);
	}
}
