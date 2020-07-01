package com.amazon.algorithms.basic;

public class DistinctDigits {
	public static void main(String[] args) {
		int N = 45;
		printDistinctDigits(N);
	}

	private static void printDistinctDigits(int n) {
		for(int i = 0; i <= n; i++) {
			boolean visited[] = new boolean[10];
			for(int j = 0; j < visited.length; j++) {
				visited[j] = false;
			}
			int temp = i;
			while(temp != 0) {
				if(visited[temp % 10])
					break;
				visited[temp % 10] = true;
				temp = temp/10;
			}
			if(temp == 0)
				System.out.println(i);
		}
	}
}
