package com.dsalgoproblems.javaproblems;

public class StackUsingLinkedList {
	
	class ListNode {
		private int data;
		private ListNode next;
		
		ListNode(int data) {
			this.data = data;
			this.next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
		
	}
	
	private int length;
	private ListNode top;
	
	public StackUsingLinkedList() {
		length = 0;
		top = null;
	}
	
	public void push(int data) {
		ListNode temp = new ListNode(data);
		temp.next = top;
		temp = top;
		length++;
	}
	
	
	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		try {
			stack.push(7);
			stack.push(9);
			stack.push(4);
			stack.push(34);
			stack.push(6);
			stack.push(3);
//			stack.pop();
//			stack.pop();
//			stack.pop();
//			stack.pop();

//			System.out.println("Top: " + stack.top());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
