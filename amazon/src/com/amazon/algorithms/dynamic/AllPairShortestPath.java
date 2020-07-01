package com.amazon.algorithms.dynamic;

public class AllPairShortestPath {
	final static int INF = 9999, V = 4;
	
	public static void main(String[] args) {
		int graph[][] = {{0, 5, INF, 10},
				{INF, 0, 3, INF},
				{INF, INF, 0, 1}, 
				{INF, INF, INF, 0}};
		AllPairShortestPath shortestPath = new AllPairShortestPath();
		shortestPath.findPathPairs(graph);
		printGraph(graph);
	}
	private static void printGraph(int[][] graph) {
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
	private void findPathPairs(int[][] graph) {
		for(int k = 0; k < V; k++) {
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
	}

}
