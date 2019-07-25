package com.example.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	
	/*
	 * Queue being an interface require a concrete class to actually
	 * create an object of Queue type.
	 * The most common classes PriorityQueue and LinkedList. 
	 * 
	 * Essentially, they are the same thing as long as items are added
	 * and removed from opposite sides.
	 * 
	 * One place where queues are often is in breadth-first search or 
	 * in implementing cache. 
	 */

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=-2; i<5; i++) {
			q.add(i);
		}
		
		System.out.println("Elements of queue: " + q);
		
		//To remove the head of the queue
		int x = q.remove();
		System.out.println("removed element: " + x);
		
		System.out.println(q);		
		
		int head = q.peek();
		System.out.println("head of queue: " + head);
		
		int size = q.size();
		System.out.println("Size of queue: " + size);
	}

}
