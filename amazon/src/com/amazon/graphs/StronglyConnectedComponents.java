package com.amazon.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponents {
	static int V;
	LinkedList<Integer> adj[];
	Stack<Integer> stack;
	public StronglyConnectedComponents(int V) {
		this.V = V;
		this.adj = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		this.stack = new Stack<Integer>();
	}
	public static void main(String[] args) {
		StronglyConnectedComponents graph = new StronglyConnectedComponents(5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 2);
		graph.addEdge(2, 1);
		graph.addEdge(0, 3);
		graph.addEdge(3, 4);
		System.out.println("Strongly Connected Components are ");
		graph.findStronglyConnectedComponents();
	}
	private void findStronglyConnectedComponents() {
		boolean[] visited = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				DFS(i, visited);
			}
		}
		
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				DFS(i, visited);
			}
		}
		
		StronglyConnectedComponents transposedGraph = getTransposeGraph();
		
		for(int i = 0; i < V; i++) {
			visited[i] = false;
		}
		System.out.println("Following are the strongly connected components -");
		while(!stack.isEmpty()) {
			int n = stack.pop();
			if(!visited[n]) {
				transposedGraph.DFS(n, visited);
			}
			System.out.println();
		}
	}
	private StronglyConnectedComponents getTransposeGraph() {
		StronglyConnectedComponents transposedGraph = new StronglyConnectedComponents(V);
		for(int i = 0; i < V; i++) {
			Iterator<Integer> it = adj[i].iterator();
			while(it.hasNext()) {
				transposedGraph.adj[it.next()].add(i);
			}
		}
		return transposedGraph;
	}
	private void DFS(int v, boolean[] visited) {
		visited[v] = true;
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n]) {
				DFS(n, visited);
			}
		}
//		stack.push(v);
	}
	private void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
}
