package com.dsalgoproblems.javaproblems;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayWithTwoStacks {
	private int[] dataArray;
	private int size, topOne, topTwo;
	

	public ArrayWithTwoStacks(int size) {
		if(size < 2) throw new IllegalStateException("Size < 2 is not allowed");
		dataArray = new int[size];
		this.size = size;
		topOne = -1;
		topTwo = size;
	}
	
	public void push(int stackId, int data) {
		if(topTwo == topOne+1) throw new StackOverflowError("Array is full");
		
		if(stackId == 1) {
			dataArray[++topOne] = data;
		} else if(stackId == 2) {
			dataArray[--topTwo] = data;
		} else return;
	}
	
	public int pop(int stackId) {
		if(stackId == 1) {
			if(topOne == -1) throw new EmptyStackException();
			int toPop = dataArray[topOne];
			dataArray[topOne--] = -1;
			return toPop;
		} else if(stackId == 2) {
			if(topTwo == getSize())  throw new EmptyStackException();
			int toPop = dataArray[topTwo];
			dataArray[topTwo++] = -1;
			return toPop;
		} else return -1;
	}
	
	public int top(int stackId) {
		if(stackId == 1) {
			if(topOne == -1) throw new EmptyStackException();
			
			return topOne;
		} else if(stackId == 2) {
			if(topTwo == getSize())  throw new EmptyStackException();
			return topTwo;
		} else return -1;
	}
	
	public boolean isEmpty(int stackId) {
		if(stackId == 1) {
			return topTwo == -1;
		} else if(stackId == 2) {
			return topTwo == getSize();
		} else {
			return true;
		}
	}
	

	public int[] getDataArray() {
		return dataArray;
	}
	
	

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		ArrayWithTwoStacks awts = new ArrayWithTwoStacks(8);
		awts.push(2, 4);
		awts.push(2, 6);
		awts.push(2, 9);
		awts.push(1, 34);
		awts.push(1, 11);
		awts.push(1, 87);
		
		int[] dataArray = awts.getDataArray();
		
		System.out.println(Arrays.toString(dataArray));
		
		awts.pop(2);
		System.out.println(Arrays.toString(dataArray));
		
		awts.pop(2);
		System.out.println(Arrays.toString(dataArray));
		
		awts.pop(2);
		System.out.println(Arrays.toString(dataArray));
		
		awts.pop(2);
		System.out.println(Arrays.toString(dataArray));
		
		
		awts.push(1,7);
		System.out.println(Arrays.toString(dataArray));
		awts.push(1,14);
		System.out.println(Arrays.toString(dataArray));
		awts.push(1,28);
		System.out.println(Arrays.toString(dataArray));
		
		

	}

}
