package com.amazon.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSortAgain {
	private int V;

	private ArrayList<ArrayList<Integer>> adj;

	public TopologicalSortAgain(int v) {
		V = v;
		adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	public static void main(String[] args) {
		TopologicalSortAgain graph = new TopologicalSortAgain(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		System.out.println("Following is a Topological " + "sort of the given graph");
		graph.topologicalSort();
	}

	private void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		// add into stack when there is no child of the node

		for (int i = 0; i < V; i++) {
			if (visited[i] == false) {
				sortAndPush(i, visited, stack);

			}
		}

		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}

	private void sortAndPush(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		Iterator<Integer> it = adj.get(v).iterator();
		Integer i;
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				sortAndPush(i, visited, stack);
			}
		}
		stack.push(new Integer(v));
	}

	private void addEdge(int src, int dest) {
		adj.get(src).add(dest);

	}
}
