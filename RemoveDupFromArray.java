package com.dsalgoproblems.javaproblems;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDupFromArray {
	static int last_removed;

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
		
		System.out.println("Array after: " + Arrays.toString(remove(inp)));


	}

	
	public static int[] removeUtil(int[] arr) {
		

		if(arr.length == 0 || arr.length == 1) {
			return arr;
		}
		
		if(arr[0] == arr[1]) {
			last_removed = arr[0];
			while(arr.length > 1 && arr[0] == arr[1]) {
				arr = Arrays.copyOfRange(arr, 1, arr.length);
			}
			arr = Arrays.copyOfRange(arr, 1, arr.length);
			return removeUtil(arr);
		}
		
		int[] rem = removeUtil(Arrays.copyOfRange(arr, 1, arr.length));
		
		if(rem.length != 0 && rem[0] == arr[0]){
			last_removed = arr[0];
			
			return Arrays.copyOfRange(rem, 1, rem.length);
		}
		
		if(rem.length == 0 && last_removed == arr[0]) {
			return rem;
		}
		

	   int[] result = new int[rem.length + 1];
	   result[0] = arr[0];
	   for(int i = 0; i < rem.length; i++) {
		   result[i+1] = rem[i];
	   }
	   
	   return result;
		
	}
	
	public static int[] remove(int[] s) {
		last_removed = -1;
		return removeUtil(s);
	}

}
