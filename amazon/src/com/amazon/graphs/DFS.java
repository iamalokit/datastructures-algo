package com.amazon.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	private int V; // no of vertices say
	//graph is defined by adjacency list
	LinkedList<Integer> adj[];
	
	public DFS(int v) {
		this.V = v;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	public static void main(String[] args) {
		DFS graph = new DFS(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println("Following is the Depth First Traversal ");
		
		graph.dfs(2);
	}
	private void dfs(int start) {
		boolean[] visited = new boolean[V];
		doDFS(start, visited);
	}
	
	private void doDFS(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n]) {
				doDFS(n, visited);
			}
		}
	}
	
	private void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
}
