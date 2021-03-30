package com.amazon.graphs;

import java.util.Vector;

public class GraphUtil {
	public static void util(Vector<Vector<Integer>> adjacencyList, Vector<Integer> color) {
		int a = 0;
		while (a != -1) {
			a = removeAll(adjacencyList, color);
			if (a != -1)
				color.set(a, 0);
		}
	}

	private static int removeAll(Vector<Vector<Integer>> adjacencyList, Vector<Integer> color) {
		int a = -1, max = -1;
		for (int i = 0; i < color.size(); ++i) {
			if (color.get(i) == 1 && canRemove(adjacencyList.get(i), color) == 1) {
				Vector<Integer> tmpColor = new Vector<Integer>();
				for (int j = 0; j < color.size(); ++j)
					tmpColor.add(color.get(j));

				tmpColor.set(i, 0);

				int sum = 0;

				for (int j = 0; j < tmpColor.size(); ++j)
					if (tmpColor.get(j) == 1 && canRemove(adjacencyList.get(j), tmpColor) == 1)
						++sum;

				if (sum > max) {
					max = sum;
					a = i;
				}
			}
		}

		return a;
	}

	private static int canRemove(Vector<Integer> adjacencyList, Vector<Integer> color) {
		int check = 1;

		for (int i = 0; i < adjacencyList.size(); ++i)
			if (color.get(adjacencyList.get(i)) == 0)
				check = 0;

		return check;
	}

	public static int util3(Vector<Integer> color) {
		int cnt = 0;
		for (int i = 0; i < color.size(); i++)
			if (color.get(i) == 1)
				++cnt;
		return cnt;
	}

	public static void util2(Vector<Vector<Integer>> adjacencyList, Vector<Integer> color, int j) {
		int cnt = 0;

		Vector<Integer> tmp_color = new Vector<Integer>();
		for (int g = 0; g < color.size(); ++g)
			tmp_color.add(color.get(g));

		for (int i = 0; i < color.size(); ++i) {
			if (tmp_color.get(i) == 1) {
				int sum = 0;
				int idx = -1;
				for (int g = 0; g < adjacencyList.get(i).size(); ++g)
					if (tmp_color.get(adjacencyList.get(i).get(g)) == 0) {
						idx = g;
						sum++;
					}

				if (sum == 1 && color.get(adjacencyList.get(i).get(idx)) == 0) {
					tmp_color.set(adjacencyList.get(i).get(idx), 1);
					tmp_color.set(i, 0);
					util(adjacencyList, tmp_color);
					++cnt;
				}

				if (cnt > j)
					break;
			}
		}
		for (int g = 0; g < color.size(); ++g)
			color.set(g, tmp_color.get(g));
	}

}
