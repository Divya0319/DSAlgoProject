package com.dsalgoproblems.javaproblems;

import java.util.EmptyStackException;
import java.util.Stack;

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
		top = temp;
		length++;
	}
	
	public int pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		
		int result = top.data;
		top = top.next;
		length--;
		return result;
	}
	
	public int peek() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		
		return top.data;
	}
	
	public boolean isEmpty() {
		return (length == 0);
	}
	
	public int size() {
		return length;
	}
	
	public String toString() {
		String result = "";
		ListNode current = top;
		while(current != null) {
			result = result + current.data + " ";
			current = current.next;
		}
		
		return result;
	}
	
	public boolean isValidSymbolPattern(String s) {
    	Stack<Character> stk = new Stack<>();
    	if(s == null || s.length() == 0) {
    		return true;
    	}
    	
    	for(int i = 0; i < s.length(); i++) {
    	   char c = s.charAt(i);
    	   if(c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
    		if(c == ')') {
    			if(!stk.isEmpty() && stk.peek() == '(') {
    				stk.pop();
    			}
    			else {
    				return false;
    			}
    		} else if(c == ']') {
    			if(!stk.isEmpty() && stk.peek() == '[') {
    				stk.pop();
    			}
    			else {
    				return false;
    			}
    		} else if(c == '}') {
    			if(!stk.isEmpty() && stk.peek() == '{') {
    				stk.pop();
    			}
    			else {
    				return false;
    			}
    		} else {
    			stk.push(s.charAt(i));
    		}
    	  }
    	}
    	
    	if(stk.isEmpty()) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
	public int Prec(char c) {
		switch(c) 
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':	
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}
	
	public String infixToPostFix(String exp) {
		String result = new String("");
		Stack<Character> stk = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c)) {
				result += c;
			}
			else if(c == '(') {
				stk.push(c);
			} else if(c == ')') {
				while(!stk.isEmpty() && stk.peek() != '(') 
					result += stk.pop();
				
					stk.pop();
			} else if(c == '^') {
				stk.push(c);
			} else {
				while(!stk.isEmpty() && Prec(c) <= Prec(stk.peek())) {
					result += stk.pop();
				}
				
				stk.push(c);
			}
		}
		
		while(!stk.isEmpty()) {
			if(stk.peek() == '(') {
				return "Invalid expression";
			}
			
			result += stk.pop();
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		try {
			stack.push(7);
			System.out.println(stack.toString());
			stack.push(9);
			System.out.println(stack.toString());
			stack.push(4);
			System.out.println(stack.toString());
			stack.push(34);
			System.out.println(stack.toString());
			stack.push(6);
			System.out.println(stack.toString());
			stack.push(3);
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());
			stack.pop();
			System.out.println(stack.toString());

			System.out.println("Top: " + stack.peek());
			
			String s = "(A+B)-(E+G^Y^H)";
	        System.out.println(Boolean.toString(stack.isValidSymbolPattern(s)));
	        System.out.println(stack.infixToPostFix(s));
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
