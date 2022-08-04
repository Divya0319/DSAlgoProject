package com.dsalgoproblems.javaproblems;

public class FixedSizeArrayQueue {
	//Array used to implement queue
	private int[] queueRep;
	private int size, front, rear;
	
	//Length of the array used to implement queue.
	private static final int capacity = 8;  //default queue size
	
	//Initializes the queue to use an array of default length
	public FixedSizeArrayQueue() {
		queueRep = new int[capacity];
		size = 0; front = 0; rear = 0;
	}
	
	
	//Initializes the queue to use an array of given length
	public FixedSizeArrayQueue(int capacity) {
		queueRep = new int[capacity];
		size = 0; front = 0; rear = 0;
		
	}

	//Inserts an element at the rear of the queue. This method runs in O(1) time.
	public void enQueue(int ele) throws NullPointerException, IllegalStateException {
		if(size == capacity) {
			throw new IllegalStateException("Queue is full: Overflow");
		} else {
			queueRep[rear] = ele;
			size++;
			rear = (rear + 1) % capacity;
		}
	}
	
	//Removes an element at the front of the queue. This method runs in O(1) time.
	public int deQueue() throws NullPointerException, IllegalStateException {
		//Effects: if queue is empty, throw IllegalStateException,
		//Else remove and return the dequeued element
		if(size == 0) {
			throw new IllegalStateException("Queue is empty: Underflow");
		} else {
			size--;
			int data = queueRep[front % capacity];
			queueRep[front] = Integer.MIN_VALUE;
			front = (front + 1) % capacity;
			return data;
		}
	}
	
	//Checks whether the queue is empty. This method runs in O(1) time
	public boolean isEmpty() {
		return (size == 0);
	}
	
	//Checks whether the queue is full. This method runs in O(1) time
	public boolean isFull() {
		return (size == capacity);
	}
	
	//Returns the number of elements in the queue. This method runs in O(1) time
	public int size() {
		return size;
	}
	
	//Returns the string representation of the queue as a list of elements, with
	//front element at the end: [...,prev, rear]. This method runs in O(1) time, where n is the size of queue.
	public String toString() {
		String result = "[";
		for(int i = 0; i < size; i++) {
			result += Integer.toString(queueRep[(front + i) % capacity]);
			if(i < size - 1) {
				result += ",";
			}
		}
		
		result += "]";
		
		return result;
	}

	public static void main(String[] args) {
		FixedSizeArrayQueue fsaq = new FixedSizeArrayQueue();
		fsaq.enQueue(1);
		fsaq.enQueue(2);
		fsaq.enQueue(3);
		fsaq.enQueue(4);
		fsaq.enQueue(5);
		fsaq.enQueue(6);
		fsaq.enQueue(7);
		fsaq.enQueue(8);
		System.out.println(fsaq.toString());
		fsaq.deQueue();
		fsaq.deQueue();
		fsaq.deQueue();
		System.out.println(fsaq.toString());
		fsaq.enQueue(55);
		fsaq.enQueue(66);
		fsaq.enQueue(77);
		System.out.println(fsaq.toString());
		fsaq.enQueue(88);
		System.out.println(fsaq.toString());

	}

}
