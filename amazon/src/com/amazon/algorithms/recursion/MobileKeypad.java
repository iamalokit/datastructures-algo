package com.amazon.algorithms.recursion;

public class MobileKeypad {
	
	static int row[] = {0, 0, -1, 0, 1};
	static int col[] = {0, -1, 0, 1, 0};
	
	public static void main(String[] args) {
		char keypad[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };
		System.out.println(getCount(keypad, 1));
	}

	private static int getCount(char[][] keypad, int N) {
		if(keypad == null || N <= 0)
			return 0;
		if(N == 1) {
			return 10;
		}
		
		int i = 0, j = 0, totalCount = 0;
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 3; j++) {
				if(keypad[i][j] != '*' && keypad[i][j] != '#') {
					totalCount += getCountUtil(keypad, i, j, N);
					
				}
			}
		}
		return totalCount;
	}

	private static int getCountUtil(char[][] keypad, int i, int j, int n) {
		if(keypad == null || n <= 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		int k = 0, move = 0, ro = 0, co = 0, totalCount = 0;
		
		for(move = 0; move < 5; move++) {
			ro = i + row[move];
			co = i + col[move];
			if(ro >= 0 && ro <= 3 && co >= 0 && co <=2 && keypad[ro][co] != '*' && keypad[ro][co] != '#') {
				totalCount += getCountUtil(keypad, ro, co, n-1);
			}
		}
		return totalCount;
	}
}
