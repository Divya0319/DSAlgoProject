package com.dsalgoproblems.javaproblems;

public class ArrayWithTwoStacks {
	private int [] dataArray;
	private int size, topOne, topTwo;
	

	public ArrayWithTwoStacks(int size) {
		if(size < 2) throw new IllegalStateException("Size < 2 is not allowed");
		dataArray = new int[size];
		this.size = size;
		topOne = -1;
		topTwo = -1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
