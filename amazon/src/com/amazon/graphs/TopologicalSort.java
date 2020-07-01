package com.amazon.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
	static int V;
	LinkedList<Integer> adj[];
	Stack<Integer> stack;
	public TopologicalSort(int V) {
		this.V = V;
		this.stack = new Stack<Integer>();
		this.adj = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		
	}
	public static void main(String[] args) {
		TopologicalSort graph = new TopologicalSort(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		System.out.println("Topological sorting - ");
		graph.doTopologicalSort();
	}
	
	private void doTopologicalSort() {
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				topologicalSort(i, visited);				
				stack.push(i);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	
	private void topologicalSort(int v, boolean[] visited) {
		visited[v] = true;
		Iterator<Integer> it = adj[v].iterator();
		// visit each vertex in the adjacency list of that vertex
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n]) {
				topologicalSort(n, visited);
				stack.push(n);
			}
		}
	}
	private void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
}
