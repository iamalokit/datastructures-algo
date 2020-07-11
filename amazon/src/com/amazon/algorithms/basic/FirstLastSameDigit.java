package com.amazon.algorithms.basic;

public class FirstLastSameDigit {
	public static void main(String[] args) {
		int start = 5, end = 40;
		System.out.println(getCountWithSameStartAndEnd(start, end));
	}

	private static int getCountWithSameStartAndEnd(int start, int end) {
		return getCountWithSameStartAndEndFrom1(end) - getCountWithSameStartAndEndFrom1(start-1);
	}

	private static int getCountWithSameStartAndEndFrom1(int x) {
		if(x < 10) {
			return x;
		}
		
		int tens = x/10;
		int res = tens + 9;
		int firstDigit = getFirstDigit(x);
		int lastDigit = x % 10;
		
		if(lastDigit < firstDigit)
			res --;
		
		return res;
	}

	private static int getFirstDigit(int x) {
		while(x >= 10)
			x /= 10;
		return x;
	}
}
