package com.amazon.core;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
	private Deque<Integer> doublyQueue;
	private HashSet<Integer> hashSet;

	private final int CACHE_SIZE;

	public LRUCache(int capacity) {
		doublyQueue = new LinkedList<Integer>();
		hashSet = new HashSet<Integer>();
		this.CACHE_SIZE = capacity;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		cache.refer(2);
		cache.refer(2);
		cache.refer(1);
		cache.display();
	}

	public void display() {
		Iterator<Integer> itr = doublyQueue.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public void refer(int page) {
		// check if it the page is in the cache
		if (!hashSet.contains(page)) {
			// if not then add to cache
			// check if the size if full
			// if yes then remove the last element and add the page in front
			if (doublyQueue.size() == CACHE_SIZE) {
				int last = doublyQueue.removeLast();
				hashSet.remove(last);
			}
		} else {/*
				 * The found page may not be always the last element, even if it's an
				 * intermediate element that needs to be removed and added to the start of the
				 * Queue
				 */
			doublyQueue.remove(page);
		}
		doublyQueue.push(page);
		hashSet.add(page);
	}
}
