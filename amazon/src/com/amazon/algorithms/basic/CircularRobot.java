package com.amazon.algorithms.basic;

public class CircularRobot {
	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] main) {
		// input String
		String path = "GLGLGLGRG";
		if (isCircular(path)) {
			System.out.println("Given sequence of moves is circular");
		} else {
			System.out.println("Given sequence of moves is not circular");
		}
	}

	private static boolean isCircular(String path) {
		// define the start position
		Pos currPos = new Pos(0, 0);
		int dir = 0;
		// iterate through each character of the string
		for (int i = 0; i < path.length(); i++) {
			char ch = path.charAt(i);
			// possible characters G, R, L
			switch (ch) {
			case 'G':
				switch (dir) {
				case 0:
					currPos.x++;
					break;
				case 1:
					currPos.y++;
					break;
				case 2:
					currPos.x--;
					break;
				case 3:
					currPos.y--;
					break;
				}
				break;
			case 'L':
				dir = (dir + 1) % 4;
				break;
			case 'R':
				dir = (4 + dir - 1) % 4;
				break;
			default:
				break;
			}
		}	
		if(currPos.x == 0 && currPos.y == 0) {
			return true;
		}
		return false;
	}
}
