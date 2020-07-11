package com.amazon.algorithms.basic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToIntegers {
	
	private static final Map<Character, Integer> romanCharacters;
	
	static {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		romanCharacters = Collections.unmodifiableMap(map);
	}
	public static void main(String[] args) {
		String romanNumber = "MMMCMXXVII";
		int integer = findIntegerEquivalent(romanNumber);
		System.out.println(integer);
	}

	private static int findIntegerEquivalent(String romanNumber) {
		char arrRomanNumber[] = romanNumber.toCharArray();
		int total = 0;
		int nextValue = 0, prevValue = 0;
		int i;
		for(i = 0; i < arrRomanNumber.length-1; i++) {
			nextValue = romanCharacters.get(arrRomanNumber[i+1]);
			prevValue = romanCharacters.get(arrRomanNumber[i]);
			if(nextValue > prevValue) {
				total += nextValue - prevValue;
				i++;
			}else {
				total += prevValue;
			}
		}
		if(romanCharacters.get(arrRomanNumber[i]) <= romanCharacters.get(arrRomanNumber[i-1])) {
			total += romanCharacters.get(arrRomanNumber[i]);
		}
		return total;
	}

}
