package com.dsalgoproblems.javaproblems;

import java.util.ArrayList;

class StackForStackSets{
	private int top = -1;
	private int[] arr;
	// Maximum size of stack
	private int capacity;
	public StackForStackSets(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
	}
	
	public void push(int i) {
		arr[++top] = i;
	}
	
	public int pop() {
		return arr[top--];
	}
	
	//if stack is at capacity
	public boolean isAtCapacity() {
		return capacity == top + 1;
	}
	
	// return size of stack
	public int size() {
		return top + 1;
	}
	
	public String toString() {
		String s = "";
		int index = top;
		while(index >= 0) {
			s += "[" + arr[index--] + "]" + "-->";
		}
		
		return s;
	}
	
}
public class StackSets {
	// Number of elements for each stack
	private int threshold;
	private ArrayList<StackForStackSets> listOfStacks = new ArrayList<>();
	
	StackSets(int threshold) {
		this.threshold = threshold;
	}
	
	//get the last stack
	public StackForStackSets getLastStack() {
		int size = listOfStacks.size();
		if(size <= 0) {
			return null;
		}
		else return listOfStacks.get(size - 1);
	}
	
	//get the nth stack
	public StackForStackSets getNthStack(int n) {
		int size = listOfStacks.size();
		if(size <= 0) {
			return null;
		}
		else return listOfStacks.get(n - 1);
	}
	
	//push stack
	public void push(int v) {
		StackForStackSets lastStack = this.getLastStack();
		if(lastStack == null) {
			lastStack = new StackForStackSets(threshold);
			lastStack.push(v);
			listOfStacks.add(lastStack);
		} else {
			if(!lastStack.isAtCapacity()) {
				lastStack.push(v);
			} else {
				StackForStackSets newLastStack = new StackForStackSets(threshold);
				newLastStack.push(v);
				listOfStacks.add(newLastStack);
			}
		}
	}
	
	// the pop
	public int pop() {
		StackForStackSets lastStack = this.getLastStack();
		int v = lastStack.pop();
		if(lastStack.size() == 0) listOfStacks.remove(listOfStacks.size() - 1);
		return v;
	}
	
	// pop from nth stack
	public int pop(int nth) {
		StackForStackSets nthStack = this.getNthStack(nth);
		int v = nthStack.pop();
		if(nthStack.size() == 0) listOfStacks.remove(nth - 1);
		return v;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < listOfStacks.size(); i++) {
			StackForStackSets stack = listOfStacks.get(i);
			int j = i;
			s = "\nStack " + ++j + ":" + stack.toString() + s; 
		}
		
		return s;
	}

	public static void main(String[] args) {
		StackSets stacks = new StackSets(3);
		stacks.push(12);
		stacks.push(11);
		stacks.push(10);
		stacks.push(9);
		stacks.push(8);
		stacks.push(7);
		stacks.push(6);
		stacks.push(5);
		stacks.push(4);
		stacks.push(3);
		stacks.push(2);
		stacks.push(1);
		System.out.println("Popping from stack 2: " + stacks.pop(2));
		System.out.println("Popping from last stack: " + stacks.pop());
		System.out.println("Popping from stack 3: " + stacks.pop(3));
		System.out.println("The stack is : " + stacks);

	}

}
