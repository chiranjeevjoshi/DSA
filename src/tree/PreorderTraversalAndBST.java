package tree;

import java.util.Scanner;
import java.util.Stack;
/*
 * Given an array, write a program that prints 1 if given array can represent preorder traversal of a BST, else prints 0.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input A[i].

Output:
Should print 1 if given array can represent preorder traversal of BST. Otherwise 0.

 */
public class PreorderTraversalAndBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i<t ; i++){
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int j=0 ;j<n ; j++){
				arr[j] = sc.nextInt();
			}
			if(isBst(arr)){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
		sc.close();
	}

	private static boolean isBst(int arr[]) {
		
		Stack<Integer> stack = new Stack<>();
		int root  = Integer.MIN_VALUE;
		for(int j =0 ; j<arr.length ; j++){
			
			if(arr[j] < root){
				return false;
			}
			while(!stack.isEmpty() && stack.peek() < arr[j] ){
				root = stack.peek();
				stack.pop();
			}
			stack.push(arr[j]);
		}
		return true;
	}
}
