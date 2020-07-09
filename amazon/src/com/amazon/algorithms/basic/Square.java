package com.amazon.algorithms.basic;

public class Square {
	Point p1, p2, p3, p4;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public Square() {
	}

	public static void main(String[] args) {
		Square sq = new Square();
		sq.p1 = new Point(10, 10);
		sq.p2 = new Point(20, 10);
		sq.p3 = new Point(20, 20);
		sq.p4 = new Point(10, 20);
		if (sq.isSquare(sq.p1, sq.p2, sq.p3, sq.p4)) {
			System.out.println("the four points form a square");
		} else {
			System.out.println("the four points does not form a square");
		}
	}

	private boolean isSquare(Point p1, Point p2, Point p3, Point p4) {
		int d2 = calcDistance(p1, p2);
		int d3 = calcDistance(p1, p3);
		int d4 = calcDistance(p1, p4);
		if (d2 == 0 || d3 == 0 || d4 == 0)
			return false;
		if (d2 == d3 && 2 * d2 == d4 && 2 * calcDistance(p2, p4) == calcDistance(p2, p3)) {
			return true;
		}

		// The below two cases are similar to above case
		if (d3 == d4 && 2 * d3 == d2 && 2 * calcDistance(p3, p2) == calcDistance(p3, p4)) {
			return true;
		}
		if (d2 == d4 && 2 * d2 == d3 && 2 * calcDistance(p2, p3) == calcDistance(p2, p4)) {
			return true;
		}
		return false;
	}

	private int calcDistance(Point a, Point b) {
		int dispX = a.x - b.x;
		int dispY = a.y - b.y;
		int distSq = (dispX * dispX) + (dispY * dispY);
		return distSq;
	}
}
