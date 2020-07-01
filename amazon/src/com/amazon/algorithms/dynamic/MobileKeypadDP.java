package com.amazon.algorithms.dynamic;

public class MobileKeypadDP {
	static int[] row = { 0, 0, 0, 1, -1 };
	static int[] col = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) {
		char[][] keypad = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };
		int N = 3;
		System.out.println("Total number of formulations with digit " + N + findCount(keypad, N));
	}

	private static int findCount(char[][] keypad, int n) {
		// base conditions
		if (keypad == null || n <= 0) {
			return 0;
		}

		if (n == 1) {
			return 10;
		}
		int[][] count = new int[10][n + 1];
		int totalCount = 0;
		for (int i = 0; i <= 9; i++) {
			count[i][0] = 0;
			count[i][1] = 1;
		}

		for (int k = 2; k <= n; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if (keypad[i][j] != '*' && keypad[i][j] != '#') {
						int num = keypad[i][j] - '0';
						count[num][k] = 0;

						for (int move = 0; move < 5; move++) {
							int ro = i + row[move];
							int co = j + col[move];
							if (ro >= 0 && ro <= 3 && co >= 0 && co <= 2 && keypad[ro][co] != '*'
									&& keypad[ro][co] != '#') {
								int nextNum = keypad[ro][co] - '0';
								count[num][k] += count[nextNum][k - 1];
							}
						}
					}
				}
			}
		}
		
		totalCount = 0;
		for(int i = 0; i <= 9; i++)
			totalCount += count[i][n];
		
		return totalCount;

	}

}
