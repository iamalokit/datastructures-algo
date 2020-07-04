package com.amazon.algorithms.backtracking;

public class Permutations {
	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		Permutations permutation = new Permutations();
		permutation.findPermutations(str, 0, n-1);
	}

	private  void findPermutations(String str, int l, int r) {
		if(l == r)
			System.out.println(str);
		else {
			for(int i = l; i <= r; i++) {
				str = swap(str, l, i);
				findPermutations(str, l+1, r);
				str = swap(str, l, i);
			}
		}
	}

	private String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
