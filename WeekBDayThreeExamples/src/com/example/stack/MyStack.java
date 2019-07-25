package com.example.stack;

import java.util.Stack;

public class MyStack {
	/*
	 * We have a Stack class which models and implements
	 * Stack data structure.
	 * Stack extends from vector, so the stack belongs
	 * to the Collection framework.
	 * 
	 * One case where stacks are often useful is in certain
	 * recursive algorithms.
	 * Sometimes you need to push temporary data onto a stack
	 * as you recurse, but then remove them as you backtrack.
	 * 
	 */
	
	//pushing elements on the top of the stack
	static void stackPush(Stack<Integer> stack) {
		for(int i=0; i<5; i++) {
			stack.push(i);
		}
	}
	
	//popping element from the top of the stack
	static void stackPop(Stack<Integer> stack) {
		
		for(int i=0; i<5; i++) {
			Integer y = stack.pop();
			System.out.print("Pop : ");
			System.out.println(y);
		}
	}
	
	//displaying element on the top of the stack
	static void stackPeek(Stack<Integer> stack) {
		Integer element = stack.peek();
		System.out.println("Element on the top of the stack: " + element);
	}
	
	//searching for element in the stack
	static void stackSearch(Stack<Integer> stack, int element) {
		Integer i = stack.search(element);
		if(i == -1) {
			System.out.println("Element not found");
		}else {
			System.out.println("Element is found at position " + i);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stackPush(stack);
		//stackPop(stack);
		stackSearch(stack, 2);
		stackSearch(stack, 910);
	}

}
