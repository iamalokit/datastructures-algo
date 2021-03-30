package com.amazon.graphs;

import java.util.Vector;

public class IndependentSets {
	public static void main(String[] args) throws Exception {
		// number of vertices
		int n = 4;
		Vector<Vector<Integer>> adjacenctMatrix = new Vector<Vector<Integer>>(n, (n));

		// connection between every node except from itself
		for (int i = 0; i < n; ++i) {
			Vector<Integer> adj = new Vector<Integer>(n);
			for (int j = 0; j < n; ++j)
				if (i == j)
					adj.add(0);
				else
					adj.add(1);
			adjacenctMatrix.add(adj);
		}

		Vector<Vector<Integer>> adjacencyList = new Vector<Vector<Integer>>();
		// form adjacency list
		for (int i = 0; i < n; ++i) {
			Vector<Integer> adjList = new Vector<Integer>();
			for (int j = 0; j < n; ++j) {
				if (adjacenctMatrix.get(i).get(j) == 1)
					adjList.add(j);
			}
			adjacencyList.add(adjList);
		}

		// least set size
		int x = 2;

		// complement
		int y = n - x;

		int found = 0;
		int size = 0;
		int min = n + 1;

		// store all possible sets here
		Vector<Vector<Integer>> setFound = new Vector<Vector<Integer>>();

		for (int i = 0; i < n; ++i) {
			if (found == 1)
				break;

			// making the initial state of all vertices
			Vector<Integer> color = new Vector<Integer>(n);
			for (int j = 0; j < n; ++j) {
				color.add(1);
			}

			// putting the ith node in the set
			color.set(i, 0);

			GraphUtil.util(adjacencyList, color);
			size = GraphUtil.util3(color);
			if (size < min)
				min = size;

			if (size <= y) {

				// Print and display the size
				System.out.println("Independent set of size " + (n - size) + "found");

				for (int j = 0; j < n; ++j)

					if (color.get(j) == 0)
						System.out.print(j + 1 + " ");
				System.out.println();
				setFound.add(color);

				// Set flaf to 1
				found = 1;

				// Hault the further execution of Program
				break;
			}

			for (int j = 0; j < x; ++j)
				GraphUtil.util2(adjacencyList, color, j);

			size = GraphUtil.util3(color);
			if (size < min)
				min = size;
			System.out.println("Independent set of size " + (n - size) + "found");
			for (int j = 0; j < n; ++j)
				if (color.get(j) == 0)
					System.out.print(j + 1 + " ");
			System.out.println();
			setFound.add(color);
			if (size <= y) {
				found = 1;
				break;
			}
		}

		int r = setFound.size();

		for (int a = 0; a < r; ++a) {
			if (found == 1)
				break;

			for (int b = a + 1; b < r; ++b) {
				if (found == 1)
					break;

				Vector<Integer> color = new Vector<Integer>(n);

				for (int j = 0; j < n; ++j)
					color.add(1);
				for (int c = 0; c < n; ++c)
					if (setFound.get(a).get(c) == 0 && setFound.get(b).get(c) == 0)
						color.set(c, 0);

				GraphUtil.util(adjacencyList, color);
				size = GraphUtil.util3(color);

				if (size < min)
					min = size;
				if (size <= y) {
					System.out.println("Independent set of size" + (n - size));

					for (int j = 0; j < n; ++j)
						if (color.get(j) == 0)

							System.out.print(j + 1 + " ");

					System.out.println();
					found = 1;
					break;
				}

				for (int j = 0; j < y; ++j)
					GraphUtil.util2(adjacencyList, color, j);
				size = GraphUtil.util3(color);
				if (size < min)
					min = size;

				System.out.println("Independent set of size " + (n - size) + "found");

				for (int j = 0; j < n; ++j)
					if (color.get(j) == 0)
						System.out.print(j + 1 + " ");

				System.out.println();
				if (size <= y) {
					found = 1;
					break;
				}
			}
		}

		// If found
		if (found == 1)

			// Display command
			System.out.println("Found the set of given least possible size");
		else

			// Display command
			System.out.println("Couldn't find the set of least size given");

	}

}
