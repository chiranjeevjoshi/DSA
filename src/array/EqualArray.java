package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * You are given an array A of size N

Find the minimum non negative number X such that there exist an index j and when you can replace Aj by Aj+X, the sum of elements of array from index 1 to j  and j+1 to  N becomes equal, where 1≤j≤N−1. Assume array to be 1-indexed.

If there is no possible X print −1 in separate line.

Input Format

The first line contains T, the number of test cases.
For each Test case :
The first line contains an integer N, size of the array.
The second line contains N space-separated integers, the ith of which is Ai.
 */
public class EqualArray {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t =  Integer.parseInt( br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i<t ; i++){
			int n = Integer.parseInt( br.readLine());
			String input[] = br.readLine().split(" ");
			long total = 0l;
			int arr[] =  new int[n];
			for(int j =0 ; j<input.length ; j++){
				int number = Integer.parseInt(input[j]);
				arr[j] = number; 
				total = total + number;
			}
			long subTotal = 0l;
			long min = Long.MAX_VALUE;
			for(int j =0 ; j<arr.length && subTotal >  total ; j++){
				total = total - arr[j];
				subTotal = subTotal + arr[j];
				if(total >= subTotal && min > (total-subTotal)){
					min = total-subTotal;
				}
				
				
			}
			if(min == Long.MAX_VALUE){
			    sb.append("-1 \n");
			}else
			sb.append(min+"\n");
		}
		System.out.println(sb);
	}
}
