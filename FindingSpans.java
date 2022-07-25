package com.dsalgoproblems.javaproblems;

import java.util.Arrays;
import java.util.Stack;

public class FindingSpans {
	
	public static void main(String[] args) {
		int[] inp = new int[] {100,80,60,70,60,75,85};
		int[] op = findingSpans(inp);
		System.out.println(Arrays.toString(op));
		
		int[] inp2 = new int[] {8,6,10,12,1,7,4};
		System.out.println("Maximum area = " + largestRectAreaInEff(inp2));
		
		Stack<Integer> istk = new Stack<>();
		istk.push(10);
		istk.push(14);
		istk.push(1);
		istk.push(8);
		istk.push(6);
		istk.push(11);
		istk.push(9);
		System.out.println(istk.toString());
		
		Stack<Integer> rstk = sortStackUsingTempStack(istk);
		while(!rstk.isEmpty()) {
			System.out.print(rstk.pop() + " ");
		}
		
		
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
	
	public static int largestRectAreaInEff(int[] heights) {
		int n = heights.length;
		int maxArea = 0;
		for(int i = 0; i < n; i++) {
			int left = i, right = i;
			while(heights[left] >= heights[i]) {
				left--;
				if(left < 0) break;
			}
			
			while(heights[right] >= heights[i]) {
				right++;
				if(right > n-1) break;
			}
			maxArea = Math.max(maxArea, (right-left-1) * heights[i]);
		}
		
		return maxArea;
	}
	
	public static int largestRectangleArea(int[] heights) {
		int n = heights.length;
		Stack<Integer> st = new Stack<>();
		
		int[] leftSmall = new int[n];
		int[] rightSmall = new int[n];
		
		for(int i = 0; i < n; i++) {
			while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
				st.pop();
			}
			
			if(st.isEmpty()) leftSmall[i] = 0;
			else leftSmall[i] = st.peek() + 1;
			st.push(i);
		}
		
		//clear the stack to be re-used again
		while(!st.isEmpty()) st.pop();
		
		int maxA = 0;
		
		for(int i = n-1; i >= 0; i--) {
			while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
				st.pop();
			}
			
			if(st.isEmpty()) rightSmall[i] = n-1;
			else rightSmall[i] = st.peek() - 1;
			st.push(i);
			
			maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
		}
		
		return maxA;
		
		
	}
	
	public static Stack<Integer> sortStackUsingTempStack(Stack<Integer> istk) {
		Stack<Integer> rstk = new Stack<>();
		while(!istk.isEmpty()) {
			int tmp = istk.pop();
			while(!rstk.isEmpty() && rstk.peek() < tmp) {
				istk.push(rstk.pop());
			}
			rstk.push(tmp);
		}
		
		return rstk;
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
