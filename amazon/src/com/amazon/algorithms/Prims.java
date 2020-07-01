package com.amazon.algorithms;

import java.util.LinkedList;

public class Prims {
	int V, E;
	static class Edge{
		int src, dest, weight;
		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}
	Edge edges[];
	
	LinkedList<Integer> adj[];
//	public Prims(int V, int E) {
//		this.V = V;
//		this.E = E;
//		this.edges = new Edge[E];
//		for(int i = 0; i < E; i++) {
//			edges[i] = new Edge();
// 		}
//		this.adj = new LinkedList[V];
//		for(int i = 0; i < V; i++) {
//			adj[i] = new LinkedList<Integer>();
//		}
//	}

	public static void main(String[] args) {
		// we need a graph with vertex and edge
		Prims prim = new Prims();
		int graph[][] = new int[][] { 
			{0, 2, 0, 6, 0 },
			{2, 0, 3, 8, 5 },
			{0, 3, 0, 0, 7 },
			{6, 8, 0, 0, 9 },
			{0, 5, 7, 9, 0 }
		};
		prim.mst(graph);
	}

	private void mst(int[][] graph) {
		int parent[] = new int[V];
		int key[] = new int[V];
		Boolean mstSet[] = new Boolean[V];
		for(int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		key[0] = 0;
		parent[0] = -1;
		
		for(int count = 0; count < V-1; count++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for(int v = 0; v < V; v++) {
				if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		
		printMst(parent, graph);
	}

	private void printMst(int[] parent, int[][] graph) {
		System.out.println("Edge \t Weight");
		for(int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	private int minKey(int[] key, Boolean[] mstSet) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for(int v = 0; v < V; v++) {
			if(mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}
}
