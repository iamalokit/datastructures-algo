package com.amazon.algorithms.backtracking;

public class KnightTour {
	private int boardSize;
	private int board[][];
	static int xMove[] = {1, 2, -2, -1, 1, 2, -2, -1};
	static int yMove[] = {2, 1, 1, 2, -2, -1, -1, -2};
	public KnightTour(int boardSize) {
		this.boardSize = boardSize;
		this.board = new int[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				board[i][j] = 0;
			}
		}
	}
	public static void main(String[] args) {
		KnightTour knightTour = new KnightTour(8);
		knightTour.board[0][0] = 1;
		if(knightTour.findKnightTour(0, 0, knightTour.board, 1)) {
			printBoard(knightTour.board, knightTour.boardSize);
		}
		else {
			System.out.println("No path exists");
		}
		
	}
	
	private static void printBoard(int[][] board, int boardSize) {
		for(int i = 0; i < boardSize; i++) {
			for(int j = 0; j < boardSize; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	private boolean findKnightTour(int row, int col, int[][] board, int count) {
		if(count == boardSize*boardSize)
			return true;
		for(int move = 0; move < xMove.length; move ++) {
			if(isSafeMove(board, row + xMove[move], col+yMove[move])) {
				row = row + xMove[move];
				col = col + yMove[move];
				count += 1;
				board[row][col] = count;
				if(findKnightTour(row, col, board, count)) {
					return true;
				}
				else {
					board[row][col] = 0;
				}
			}
		}
		return false;
		
	}
	private boolean isSafeMove(int[][] board, int x, int y) {
		if((x < 8 && x >= 0) && (y < 8 && y >= 0) && board[x][y] == 0) {
			return true;
		}
		return false;
	}
}
