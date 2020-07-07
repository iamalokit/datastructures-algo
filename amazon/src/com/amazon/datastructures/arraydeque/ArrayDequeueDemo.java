package com.amazon.datastructures.arraydeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeueDemo {
	public static void main(String[] args) {
		Deque<Integer> de_que = new ArrayDeque<Integer>(10);
		de_que.add(10);
		de_que.add(20);
		de_que.add(30);
		de_que.add(40);
		de_que.add(50);
		for(Integer element : de_que) {
			System.out.println("Element : " + element);
		}
		
		System.out.println("Using clear() ");
		de_que.clear();
		
		de_que.addFirst(564);
		de_que.addFirst(291);
		
		de_que.addLast(24);
		de_que.addLast(14);
		
		System.out.println("Above elements are removed now ");
		
		System.out.println("Elements of dequeue using iterator : ");
		
		for(Iterator itr = de_que.iterator(); itr.hasNext(); ) {
			System.out.println(itr.next());
		}
		
		for(Iterator dItr = de_que.descendingIterator(); dItr.hasNext(); ) {
			System.out.println(dItr.next());
		}
		
		System.out.println("Head element using element() : " + de_que.element());
		
		System.out.println("Head element using getFirst() : " + de_que.getFirst());
		
		System.out.println("Head element using getLast() : " + de_que.getLast());
		
		Object[] arr = de_que.toArray();
		System.out.println("Array Size : "+ arr.length);
		
		System.out.println("Array elements : ");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(" "+ arr[i]);
		}
		
		System.out.println("Head Element : " + de_que.peek());
		
		System.out.println("Head Element Poll: " + de_que.poll());
		
		de_que.push(265);
		de_que.push(984);
		de_que.push(2365);
		
		System.out.println("Head element remove : " + de_que.remove());
		System.out.println("The final array is: "+ de_que);
	}
}
