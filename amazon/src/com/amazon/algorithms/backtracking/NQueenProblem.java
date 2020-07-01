package com.amazon.algorithms.backtracking;

public class NQueenProblem {
	static final int N = 4;
	public static void main(String[] args) {
		NQueenProblem queen = new NQueenProblem();
		queen.solveNQ();
	}

	private boolean solveNQ() {
		int board[][] = new int[N][N];
		if(solveNQUtil(board, 0) == false) {
			System.out.println("Solution does not exist");
			return false;
		}
		
		printSolution(board);
		return true;
	}

	private void printSolution(int[][] board) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.println(" "+ board[i][j] + " ");
			
			System.out.println();
		}
	}

	private boolean solveNQUtil(int[][] board, int col) {
		if(col >= N)
			return true;
		
		for(int i = 0; i < N; i++) {
			if(isSafe(board, i, col)) {
				board[i][col] = 1;
				if(solveNQUtil(board, col+1) == true)
					return true;
				
				board[i][col] = 0;
			}
		}
		return false;
	}

	private boolean isSafe(int[][] board, int row, int col) {
		int i, j;
		for(i = 0; i < col; i++) {
			if(board[row][i] == 1)
				return false;
		}
		
		for(i = row, j = col ; i >= 0 && j >= 0; i--, j--)
			if(board[i][j] == 1)
				return false;
		
		for(i = row, j = col ; i < N && j >= 0; i++, j--)
			if(board[i][j] == 1)
				return false;
		
		return true;
	}

}
