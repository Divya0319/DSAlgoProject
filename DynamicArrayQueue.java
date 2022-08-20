package com.dsalgoproblems.javaproblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class DynamicArrayQueue {
	//Array used to implement queue
	private int[] queueRep;
	private int size, front, rear;
	
	//Length of array used to implement queue
	private static int capacity = 8;   //Default queue size
	
	//Initializes the queue to use an array of default length.
	public DynamicArrayQueue() {
		queueRep = new int[capacity];
		size = 0; front = 0; rear = 0;
	}
	
	//Initializes the queue to use an array of given length
	public DynamicArrayQueue(int cap) {
		queueRep = new int[cap];
		size = 0; front = 0; rear = 0;
	}
	
	//Inserts an element at the rear of the queue. This method runs in O(1) time.
	public void enQueue(int val) throws NullPointerException, IllegalStateException {
		if(size == capacity) 
			expand();
		size++;
		queueRep[rear] = val;
		rear = (rear + 1) % capacity;
			
		
	}
	
	//Removes the front element from the queue. This method runs in O(1) time.
	public int deQueue() throws NullPointerException, IllegalStateException {
		if(size == 0) {
			throw new IllegalStateException("Queue is empty. Underflow");
		} else {
			size--;
			int data = queueRep[(front % capacity)];
			queueRep[front] = -1;
			front = (front + 1) % capacity;
			shrink();
			return data;
		}
	}
	
	//Checks whether queue is empty. This method runs in O(1) time.
	public boolean isEmpty() {
		return size == 0;
	}
	
	//Checks whether queue is full. This method runs in O(1) time.
	public boolean isFull() {
		return size == capacity;
	}
	
	//Returns the size of the queue
	public int size() {
		return size;
	}
	
	//Increases the queue size by double
	public void expand() {
		int length = size();
		int[] newQueue = new int[length << 1];  //<<1 means multiplying by 2
		
		//copy items
		for(int i = 0; i < length ; i++) 
			newQueue[i] = queueRep[(front + i) % capacity];
		queueRep = newQueue;
		front = 0; 
		rear = length;
		capacity  = capacity << 1;
		
		System.out.println("Queue expanded");
	}
	
	//dynamic array operation: shrinks to 1/2 if more than 3/4 empty
	private void shrink() {
		int length = size();
		if(length <= capacity >> 2) {
			capacity = capacity >> 1;
			int[] newQueue = new int[capacity];
			System.arraycopy(queueRep, front, newQueue, 0, length);
			queueRep = newQueue;
			System.out.println("Queue shrinked");
			front = 0;
			rear = length;
		}
		
	}
	
	public void maxEleSlidingWindow(int[] inp, int k) {
		int j, max;
		int n = inp.length;
		// looping from i from 0 to number of windows possible (n-k)
		for(int i = 0; i <= n-k; i++) {
			// created an ArrayList to print considered window elements at each step
			ArrayList<Integer> tempArr = new ArrayList<>();
			// setting max to first element of input array initially
			max = inp[i];
			// also adding this first element to ArrayList
			tempArr.add(inp[i]);
			for(j = 1; j < k; j++) {
				// looping from 2nd element to kth element of current window
				// and adding that element to ArrayList as well
				tempArr.add(inp[i+j]);
				// since i holds the beginning index of the current window, we have to do i+j to progress in window
				if(inp[i+j] > max) {
					// updating max value here
					max = inp[i+j];
				}
			}
			// Printing maximum of current window
			System.out.println("Maximum of " + tempArr.toString() + " is " + max);
		}
	}
	
	public int[] maxEleSlidingWindowOptimised(int[] inp, int k) {
		
		int n = inp.length;
		int[] r = new int[n-k+1];
		Deque<Integer> dq = new ArrayDeque<>();
		int ri = 0;
		for(int i = 0; i < inp.length; i++) {
			if(!dq.isEmpty() && dq.peek() == i - k) {
				dq.poll();
			}
		
			while(!dq.isEmpty() && inp[dq.peekLast()] < inp[i]) {
				dq.pollLast();
			}
			
			dq.offer(i);
			if(i >= k - 1) {
				r[ri++] = inp[dq.peek()];
			}
		
		}
		return r;
		
	}
	
	//Returns a string representation of the queue as list of elements, with 
	// the front element at the end: [..., prev, rear]. This method runs in O(n) time.
	public String toString() {
		String result = "[";
		for(int i = 0; i < capacity; i++) {
			result += Integer.toString(queueRep[i]);
			if(i < capacity - 1) {
				result += ", ";
			}
			
		}
		
		result += "]";
		return result;		
	}

	public static void main(String[] args) {
		DynamicArrayQueue fsaq = new DynamicArrayQueue();
		fsaq.enQueue(1);
		fsaq.enQueue(2);
		fsaq.enQueue(3);
		fsaq.enQueue(4);
		fsaq.enQueue(5);
		fsaq.enQueue(6);
		fsaq.enQueue(7);
		fsaq.enQueue(8);
		System.out.println(fsaq.toString());
		System.out.println("Capacity:" + capacity);
		fsaq.deQueue();
		System.out.println(fsaq.toString());
		fsaq.deQueue();
		System.out.println(fsaq.toString());
		fsaq.deQueue();
		System.out.println(fsaq.toString());
		fsaq.deQueue();
		System.out.println(fsaq.toString());
		fsaq.deQueue();
		System.out.println(fsaq.toString());
		fsaq.deQueue();
		System.out.println(fsaq.toString());
		System.out.println("Capacity:" + capacity);
		fsaq.enQueue(55);
		System.out.println(fsaq.toString());
		fsaq.enQueue(66);
		System.out.println(fsaq.toString());
		fsaq.enQueue(77);
		System.out.println(fsaq.toString());
		fsaq.enQueue(88);
		System.out.println(fsaq.toString());
		fsaq.enQueue(15);
		System.out.println(fsaq.toString());
		fsaq.enQueue(16);
		System.out.println(fsaq.toString());
		fsaq.enQueue(17);
		System.out.println(fsaq.toString());
		fsaq.enQueue(18);
		System.out.println(fsaq.toString());
		fsaq.enQueue(19);
		System.out.println(fsaq.toString());
		fsaq.enQueue(20);
		System.out.println(fsaq.toString());
		fsaq.enQueue(21);
		System.out.println(fsaq.toString());
		fsaq.enQueue(22);
		System.out.println(fsaq.toString());
		fsaq.enQueue(23);
		System.out.println(fsaq.toString());
		System.out.println();
		
		int[] inp = new int[] {1,3,-1,-3,5,3,6,7, 18, 4, 16, -2};
		System.out.println("Input: " + Arrays.toString(inp));
		fsaq.maxEleSlidingWindow(inp, 3);
		
		int[] inp2 = new int[] {1,3,-1,-3,5,3,6,7, 18, 4, 16, -2};
		System.out.println("Input: " + Arrays.toString(inp2));
		int[] res = fsaq.maxEleSlidingWindowOptimised(inp, 3);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

}
