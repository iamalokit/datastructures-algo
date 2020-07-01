package com.amazon.graphs;

public class UnionFind {
	int V, E;
	Edge edge[];
	
	static class Edge{
		int src, dest;
	}
	
	public UnionFind(int V, int E) {
		this.V = V;
		this.E = E;
		edge = new Edge[E];
		for(int i = 0; i < E; i++) {
			edge[i] = new Edge();
		}
	}
	
	public static void main(String[] args) {
		//undirected graph to represent like this
		int V = 3, E = 3;
		UnionFind graph = new UnionFind(V, E);
		
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;
		
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;
		
		if(graph.isCyclic()) {
			System.out.println("Graph contains cycle");
		}else {
			System.out.println("Graph doesn't contains cycle");
		}
	}

	private boolean isCyclic() {
		// if the parent is same then the graph is cyclic
		int parent[] = new int[V];
		for(int i = 0; i < V; i++) {
			parent[i] = -1;
		}
		
		// iterate through each edge and perform findParent and Union operations 
		for(int i = 0; i < E; i++) {
			int srcParent = findParent(edge[i].src, parent);
			int destParent = findParent(edge[i].dest, parent);
			if(srcParent != destParent) {
				performUnion(srcParent, destParent, parent);
			}else {
				return true;
			}	
		}
		return false;
	}

	private void performUnion(int srcParent, int destParent, int[] parent) {
		if(srcParent > destParent) {
			parent[srcParent] = destParent;
		}
		else {
			parent[destParent] = srcParent;
		}
	}

	private int findParent(int v, int[] parent) {
		if(parent[v] < 0) {
			return v;
		}
		findParent(parent[v], parent);
		return parent[v];
	}
}
