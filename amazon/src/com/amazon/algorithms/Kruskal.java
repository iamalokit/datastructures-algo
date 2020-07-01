package com.amazon.algorithms;

import java.util.Arrays;

public class Kruskal {
	int V, E;
	int parent[];

	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

	Edge edges[];

	public Kruskal(int V, int E) {
		this.V = V;
		this.edges = new Edge[E];
		this.parent = new int[V];
		for (int i = 0; i < E; i++) {
			edges[i] = new Edge();
		}
		for (int i = 0; i < V; i++) {
			parent[i] = -1;
		}
	}

	public static void main(String[] args) {
		Kruskal graph = new Kruskal(4, 5);
		graph.edges[0].src = 0;
		graph.edges[0].dest = 1;
		graph.edges[0].weight = 10;

		graph.edges[1].src = 0;
		graph.edges[1].dest = 2;
		graph.edges[1].weight = 6;

		graph.edges[2].src = 0;
		graph.edges[2].dest = 3;
		graph.edges[2].weight = 5;

		graph.edges[3].src = 1;
		graph.edges[3].dest = 3;
		graph.edges[3].weight = 15;

		graph.edges[4].src = 2;
		graph.edges[4].dest = 3;
		graph.edges[4].weight = 4;

		graph.KruskalMST();
	}

	private void KruskalMST() {
		Edge result[] = new Edge[V - 1];
		for (int i = 0; i < V - 1; i++) {
			result[i] = new Edge();
		}
		// sort all edges in ascending order based on weight
		Arrays.sort(edges);
		int k = 0;
		// pick the edges with minimum weight and add to result set of edges
		for (int i = 0; i < edges.length; i++) {
			// do not add in result until you find that the edge forms a cycle or not
			if (!isCyclic(edges[i]) && k != V-1) {
				result[k].src = edges[i].src;
				result[k].dest = edges[i].dest;
				result[k].weight = edges[i].weight;
				k++;
			}
		}
		
		printResult(result);
	}

	private void printResult(Edge[] result) {
		for(int i = 0; i < V-1; i++) {
			System.out.println(result[i].src + "-->" + result[i].dest + "-" + result[i].weight);
		}
	}

	private boolean isCyclic(Edge edge) {
		boolean isCyclic = false;
		int srcParent = findParent(edge.src);
		int destParent = findParent(edge.dest);
		if(srcParent != destParent) {
			performUnion(srcParent, destParent);
		}
		else {
			isCyclic =  true;
		}
		return isCyclic;
	}

	private void performUnion(int srcParent, int destParent) {
		if(srcParent > destParent) {
			parent[srcParent] = destParent;
		}else {
			parent[destParent] = srcParent;
		}
	}

	private int findParent(int src) {
		if (parent[src] < 0) {
			return src;
		}
		return findParent(parent[src]);
	}

}
