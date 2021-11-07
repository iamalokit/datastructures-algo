package com.amazon.queues;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IntervalScheduling {
	public static void main(String[] args) {
		int[][] interval = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
		int maxValue = maxTwoNonOverlapping(interval);
		System.out.println(maxValue);
	}

	private static int maxTwoNonOverlapping(int[][] interval) {
		Arrays.sort(interval, (a, b)-> a[0] - b[0]);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		
		int max = 0;
		int ans = 0;
		for(int[] e : interval) {
			while(!pq.isEmpty()) {
				if(pq.peek() [0] >= e[0])
					break;
				int[] qu = pq.remove();
				max = Math.max(max, qu[1]);
			}
			
			ans = Math.max(ans , max + e[2]);
			pq.add(new int[] {e[1], e[2]});
		}
		
		return ans;
	}
}
