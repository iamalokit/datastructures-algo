package com.amazon.algorithms.backtracking;

public class RatMaze {
	static int N;
	static class Move{
		int i;
		int j;
		public Move(int i , int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String [] args) {
		int maze[][] = {
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}};
		N = maze.length;
		solution(maze);
	}

	private static boolean solution(int[][] maze) {
		int sol[][] = new int[maze.length][maze[0].length];
		
		if(solveMazeUtil(maze, 0, 0, sol) == false) {
			System.out.println("Solution does not exist");
			return false;
		}
		printSolution(sol);
		return true;
		
		
	}

	private static void printSolution(int[][] sol) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.println(" "+ sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
		// base condition
		if(x == N-1 && y == N-1 && maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze, x, y) == true) {
			sol[x][y] = 1;
			if(solveMazeUtil(maze, x+1, y, sol))
				return true;
			
			if(solveMazeUtil(maze, x, y+1, sol))
				return true;
			
			sol[x][y] = 0;
			return false;
		}
		return false;
	}

	private static boolean isSafe(int[][] maze, int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
	}
}
