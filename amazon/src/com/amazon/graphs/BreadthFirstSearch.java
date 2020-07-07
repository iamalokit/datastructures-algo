package com.amazon.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {
	int V;
	LinkedList<Integer> adj[];
	public BreadthFirstSearch(int V) {
		this.V = V;
		this.adj = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	public static void main(String[] args) {
		BreadthFirstSearch graph = new BreadthFirstSearch(5);
		graph.adj[0].add(2);
		graph.adj[0].add(1);
		graph.adj[2].add(0);
		graph.adj[2].add(3);
		graph.adj[3].add(3);
		graph.bfs(2);
	}
	private void bfs(int start) {
		boolean visited[] = new boolean[V];
		for(int i = 0; i < V; i ++) {
			visited[i] = false;
		}
		findBFS(start, visited);
	}
	private void findBFS(int start, boolean[] visited) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.add(start);
		while(queue.size() > 0) {
			start = queue.poll();
			System.out.println(start + " ");
			Iterator<Integer> it = adj[start].listIterator();
			while(it.hasNext()) {	
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		
	}

}
