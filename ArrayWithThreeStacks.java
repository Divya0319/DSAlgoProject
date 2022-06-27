package com.dsalgoproblems.javaproblems;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayWithThreeStacks {
	private int[] dataArray;
	private int size, topOne, topTwo, baseThree, topThree;
	
	public ArrayWithThreeStacks(int size) {
		if (size < 3)
			throw new IllegalStateException("Size < 3 is not allowed");
		dataArray = new int[size];
		
		for(int i = 0; i < size; i++) {
			dataArray[i] = -1;
		}
		this.size = size;
		topOne = -1;
		topTwo = size;
		baseThree = size / 2;
		topThree = baseThree;
	}
	

	public int getTopOne() {
		return topOne;
	}



	public void setTopOne(int topOne) {
		this.topOne = topOne;
	}



	public int getTopTwo() {
		return topTwo;
	}



	public void setTopTwo(int topTwo) {
		this.topTwo = topTwo;
	}



	public int getBaseThree() {
		return baseThree;
	}



	public void setBaseThree(int baseThree) {
		this.baseThree = baseThree;
	}



	public int getTopThree() {
		return topThree;
	}



	public void setTopThree(int topThree) {
		this.topThree = topThree;
	}



	public void push(int stackId, int data) {
		if (stackId == 1) {
			if (topOne + 1 == baseThree) {
				if (stack3RightShiftable()) {
					shiftStack3Right();
					dataArray[++topOne] = data;
				} else
					throw new StackOverflowError("Stack 1 has reached max limit");
			} else {
				dataArray[++topOne] = data;
			}
			
			System.out.println(Arrays.toString(dataArray));

		} else if (stackId == 2) {
			if (topTwo - 1 == topThree) {
				if (stack3LeftShiftable()) {
					shiftStack3Left();
					dataArray[--topTwo] = data;
				} else
					throw new StackOverflowError("Stack 2 has reached max limit");
			} else {
				dataArray[--topTwo] = data;
			}
			
			System.out.println(Arrays.toString(dataArray));
		} else if (stackId == 3) {
			if (topTwo - 1 == topThree) {
				if (stack3LeftShiftable()) {
					shiftStack3Left();
					dataArray[++topThree] = data;
				} else
					throw new StackOverflowError("Stack 3 has reached max limit");
			} else {
				dataArray[++topThree] = data;
			}
			
			System.out.println(Arrays.toString(dataArray));
		} else
			return;
	}

	public int pop(int stackId) {
		if (stackId == 1) {
			if (topOne == -1)
				throw new EmptyStackException();
			int toPop = dataArray[topOne];
			dataArray[topOne--] = -1;
			System.out.println(Arrays.toString(dataArray));
			return toPop;
		} else if (stackId == 2) {
			if (topTwo == getSize())
				throw new EmptyStackException();
			int toPop = dataArray[topTwo];
			dataArray[topTwo++] = -1;
			System.out.println(Arrays.toString(dataArray));
			return toPop;
		} else if(stackId == 3) {
			if (topThree == baseThree && getDataArray()[topThree] == -1)
				throw new EmptyStackException();
			int toPop = dataArray[topThree];
			if(topThree > baseThree)
				dataArray[topThree--] = -1;
			if(topThree == baseThree) 
				dataArray[topThree] = -1;
			System.out.println(Arrays.toString(dataArray));
			return toPop;
		} else
			return -1;
	}

	public int top(int stackId) {
		if (stackId == 1) {
			if (topOne == -1)
				throw new EmptyStackException();

			return dataArray[topOne];
		} else if (stackId == 2) {
			if (topTwo == getSize())
				throw new EmptyStackException();
			return dataArray[topTwo];
		} else if (stackId == 3) {
			if (topThree == baseThree && dataArray[topThree] == -1)
				throw new EmptyStackException();
			return dataArray[topThree];
		} else
			return -1;
	}

	public boolean isEmpty(int stackId) {
		if (stackId == 1) {
			return topTwo == -1;
		} else if (stackId == 2) {
			return topTwo == getSize();
		} else if (stackId == 3) {
			return (topThree == baseThree && dataArray[baseThree] == -1);
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
	
	private boolean stack3LeftShiftable() {
		if(topOne+1 < baseThree) {
			return true;
		}
		
		return false;
	}
	
	private void shiftStack3Left() {
		for(int i = baseThree - 1; i <= topThree -1; i++) {
			dataArray[i] = dataArray[i+1];
		}
		
	
		if(!isEmpty(3)) {
				baseThree--;
		}
		
		dataArray[topThree--] = -1;
		
	}
	
	private boolean stack3RightShiftable() {
		if(topThree+1 < topTwo) {
			return true;
		}
		return false;
	}
	
	private void shiftStack3Right() {
		for(int i = topThree+1; i >= baseThree+1; i--) {
			dataArray[i] = dataArray[i-1];
		}
		dataArray[baseThree++] = -1;
		topThree++;
	}
	

	public static void main(String[] args) {
		ArrayWithThreeStacks awts = new ArrayWithThreeStacks(8);
		
		awts.push(2, 4);
		awts.push(2, 6);
		awts.push(2, 9);
		awts.push(1, 34);
		awts.push(3, 30);
		awts.push(3, 60);
		awts.push(3, 90);
		awts.push(3, 56);
		awts.pop(3);
		awts.push(1, 31);
		awts.pop(2);
		awts.push(3, 87);
		awts.pop(1);
		awts.push(2, 49);

	}

}
