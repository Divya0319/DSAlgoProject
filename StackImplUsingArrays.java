package com.dsalgoproblems.javaproblems;

public class StackImplUsingArrays {
	
	protected int capacity;
	
	public static final int CAPACITY = 10;
	
	protected int[] stackRep;
	
	protected int top = -1;
	
	public StackImplUsingArrays() {
		this(CAPACITY);
	}
	
	public StackImplUsingArrays(int cap) {
		capacity = cap;
		stackRep = new int[capacity];
	}
	
	public int size() {
		return (top+1);
	}
	
	public boolean isEmpty() {
		return (top < 1);
	}
	
	public int top() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		
		return stackRep[top];
	}
	
	public void push(int data) throws Exception {
		if(size() == capacity) {
			throw new Exception("Stack is full");
		}
		stackRep[++top] = data;
		System.out.println(toString());
	}
	
	public int pop() throws Exception {
		int data;
		if(isEmpty()) {
			throw new Exception("Stack is empty");
		}
		data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		System.out.println(toString());
		return data;
	}
	
	public String toString() {
		String s;
		s = "[";
		if(size() > 0) {
			s += stackRep[0];
		}
		
		if(size() > 1) {
			for(int i = 1; i <= size() - 1; i++) {
				s += ", " + stackRep[i];
			}
			
		 
		}
		
		return s + "]";
	}
	
	public static void main(String[] args) {
		StackImplUsingArrays stack = new StackImplUsingArrays();
		try {
			stack.push(7);
			stack.push(9);
			stack.push(4);
			stack.push(34);
			stack.pop();
			stack.pop();
			System.out.println("Top:" + stack.top());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
