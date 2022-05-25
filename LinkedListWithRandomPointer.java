package com.dsalgoproblems.javaproblems;

public class LinkedListWithRandomPointer {
	
	static class Node {
		int data;
		Node next;
		Node random;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}
	};
	
	public Node copyListWithRandomPointer(Node head) {
		Node iter = head;
		Node front = head;
		
		// First round : make a copy of each node
		// and link them together side by side in a single list
		while(iter != null) {
			front = iter.next;
			
			Node copy = new Node(iter.data);
			iter.next = copy;
			copy.next = front;
			
			iter = front;
		}
		
		// Second round: assign random pointers for each copy node
		iter = head;
		while(iter != null) {
			if(iter.random != null) {
				iter.next.random = iter.random.next;
			}
			
			iter = iter.next.next;
		}
		
		// Third round: restore the original list and extract the copy list
		iter = head;
		Node pseudoHead = new Node(0);
		Node copy = pseudoHead;
		
		while(iter != null) {
			front = iter.next.next;
			
			
			// extract the copy
			copy.next = iter.next;
			copy = copy.next;
			
			// restore the original list
			iter.next = front;
			
			iter = front;
		}
		return pseudoHead.next;
	}

	public static void main(String[] args) {
		
		

	}

}
