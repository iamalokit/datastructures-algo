package com.amazon.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParenthesis {
	public static void main(String[] args) {
		String expr = "([{}])";
		if(areParenthesisBalanced(expr))
			System.out.println("Balanced");
		else{
			System.out.println("Not Balanced");
		}
	}

	private static boolean areParenthesisBalanced(String expr) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for(int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if(x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			
			if(stack.isEmpty())
				return false;
			
			switch (x) {
			case ')':
				stack.pop();
				if(x == '{' || x == '[') {
					return false;
				}
				break;
			case '}':
				stack.pop();
				if(x == '(' || x == '[') {
					return false;
				}
				break;
			case ']':
				stack.pop();
				if(x == '(' || x == '{') {
					return false;
				}
				break;
			}
		}
		
		return (stack.isEmpty());
	}
}
