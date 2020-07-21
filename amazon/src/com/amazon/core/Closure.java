package com.amazon.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Closure {
	public void publicMethod() {
		Integer localVariable1 = 10;
		Integer localVariable2 = 10;
		Integer localVariable3 = 10;
		
		Map<String, Integer> map = new HashMap<String, Integer>(){
			{
				put("a", localVariable1);
				put("b", localVariable2);
				put("c", localVariable3);
			}
			
		};
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(localVariable1);
			}
		});
		
		List<String> list = Arrays.asList("A", "B", "C");
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
	}
}
