package com.amazon.algorithms.basic;

public class RightMostSetBit {
	public static void main(String[] args) {
		int n = 12;
		System.out.println(getFirstSetBitPos(n));
	}

	private static int getFirstSetBitPos(int n) {
		return (int) (Math.log10(n & -n)/ Math.log10(2)) + 1;
	}
	
	static int positionRightmostSetbit(int n) {
		int position = 1;
		int m = 1;
		while((n & m ) == 0){
			m = m << 1;
			position++;
		}
		
		return position;
	}
}
