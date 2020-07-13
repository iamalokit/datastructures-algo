package com.amazon.stack;

import java.util.Stack;

public class SpecialStackOptimized {
	Stack<Integer> s;
	Integer minEle;
	
	public SpecialStackOptimized() {
		s = new Stack<Integer>();
	}
	public static void main(String[] args) {
		SpecialStackOptimized stack = new SpecialStackOptimized();
		stack.push(3);
		stack.push(5);
		stack.getMin();
		stack.push(2);
		stack.push(1);
		stack.getMin();
		stack.pop();
		stack.getMin();
		stack.pop();
		stack.peek();
		
	}
	private void pop() {
		if(s.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		
		System.out.println("Top most element removed: ");
		Integer t = s.pop();
		
		if(t < minEle) {
			System.out.println(minEle);
			minEle = 2 * minEle - t;
		}else {
			System.out.println(t);
		}
	}
	private void peek() {
		if(s.isEmpty()) {
			System.out.println("Stack is empty ");
			return;
		}
		
		Integer t = s.peek();
		System.out.println("Top most element is: ");
		
		if(t < minEle)
			System.out.println(minEle);
		else
			System.out.println(t);
	}
	private void getMin() {
		if(s.isEmpty())
			System.out.println("Stack is empty");
		
		else
			System.out.println("Minimum element in the stack is: " + minEle);
	}
	private void push(Integer x) {
		if(s.isEmpty()) {
			minEle = x;
			s.push(x);
			System.out.println("Number inserted: " + x);
			return;
		}
		
		if(x < minEle) {
			s.push(2 * x - minEle);
			minEle = x;
		}else {
			s.push(x);
		}
		
		System.out.println("Number inserted: " + x);
	}
}
