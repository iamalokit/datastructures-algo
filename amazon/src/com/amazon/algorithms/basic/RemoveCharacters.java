package com.amazon.algorithms.basic;

public class RemoveCharacters {
	static final int NO_OF_CHARS = 256;

	public static void main(String[] args) {
		String str1 = "geeksforgeeks", str2 = "mask";
		System.out.println(removeCharacters(str1, str2));
	}

	private static String removeCharacters(String str1, String str2) {
		int count[] = getCharCountArray(str2);
		int ip_ind = 0, res_ind = 0;
		char[] arr = str1.toCharArray();
		while (ip_ind != arr.length) {
			char temp = arr[ip_ind];
			if (count[temp] == 0) {
				arr[res_ind] = arr[ip_ind];
				res_ind++;
			}
			ip_ind++;
		}
		str1 = new String(arr);
		return str1.substring(0, res_ind);
	}

	private static int[] getCharCountArray(String str2) {
		int count[] = new int[NO_OF_CHARS];
		for (int i = 0; i < str2.length(); i++) {
			count[str2.charAt(i)]++;
		}
		return count;
	}
}
