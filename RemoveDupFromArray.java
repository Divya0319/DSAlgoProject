package com.dsalgoproblems.javaproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RemoveDupFromArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int n = sc.nextInt();
		int[] inp = new int[n];
		for(int i = 0; i < n; i++) {
			inp[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println("Array before: " + Arrays.toString(inp));
		System.out.println("Array after: " + removeDup(inp));

	}
	
	public static List<Integer> removeDup(int[] inp) {
		int n = inp.length;
		ArrayList<Integer> res = new ArrayList<>();
		int i = 0;
		while(i < n) {
			if(i+1 == n) {
				res.add(inp[i]);
				break;
			}
			if(inp[i] != inp[i+1]) {
				res.add(inp[i]);
				i++;
			}
			if(i+1 < n && inp[i] == inp[i+1]) {
				while(i+1 < n && inp[i] == inp[i+1]) {
					i++;
				}
			i++;
			}
		}
		
		return res;
	}

}
