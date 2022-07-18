package com.dsalgoproblems.javaproblems;

import java.util.Arrays;
import java.util.Stack;

public class FindingSpans {
	
	public static void main(String[] args) {
		int[] inp = new int[] {100,80,60,70,60,75,85};
		int[] op = findingSpansUsingStack(inp);
		System.out.println(Arrays.toString(op));
		
	}
	
	public static int[] findingSpans(int[] price) {
		int[] spans = new int[price.length];
		spans[0] = 1;
		for(int i = 1; i < price.length; i++) {
			spans[i] = 1;
			
			for(int j = i-1; (j>=0) && (price[j]<=price[i]); j--) {
				spans[i]++;
			}
		}
		
		return spans;
	}
	
	public static int[] findingSpansUsingStack(int[] price) {
		int[] spans = new int[price.length];
		Stack<Integer> stk = new Stack<>();
		stk.push(0);
		for(int i = 0; i < price.length; i++) {
			while(!stk.isEmpty() && price[stk.peek()] <= price[i]) {
				stk.pop();
			}
			
			if(stk.isEmpty()) {
				spans[i] = i+1;
			} else {
				spans[i] = i-stk.peek();
			}
			
			stk.push(i);
		}
		return spans;
	}

}
