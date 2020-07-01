package com.amazon.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DetectCycle {
	private int V;
	private LinkedList<Integer> adj[];
	public DetectCycle(int V) {
		this.V = V;
		this.adj = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public static void main(String[] args) {
		DetectCycle graph = new DetectCycle(10);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		if(graph.detectCycle())
			System.out.println("Graph contains cycle ");
		else
			System.out.println("Graph doesn't contains cycle");
		
	}
	
	private boolean detectCycle() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			if(DFSCyclicUtil(i, visited, recStack))
				return true;
		}
		return false;

	}

	private boolean DFSCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
		if(recStack[v]) {
			return true;
		}
		if(visited[v]) {
			return false;
		}
		
		visited[v] = true;
		recStack[v] = true;
	
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			int n = it.next();
			if(DFSCyclicUtil(n, visited, recStack)) {
				return true;
			}
		}
		
		recStack[v] = false;
		
		return false;
	}

	private void addEdge(int src, int dest) {
		adj[src].add(dest);
	}
}
