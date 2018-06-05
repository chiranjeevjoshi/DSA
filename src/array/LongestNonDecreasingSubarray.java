package array;

import java.util.Scanner;
/*
 * Given an array of Integers A , find the length of Longest sub-array whose elements are in Non-Decreasing Order.

Input:
First line of input contains N size of array A. Next line contains N space separated elements of array.

Output:
Print the length of longest sub-array whose elements are in increasing order .
 */
public class LongestNonDecreasingSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		int count =0;
		int max = 0;
		for(int i =1  ; i<=n;i++){
			int val = sc.nextInt();
			if(arr[i-1]<= val){
				count++;
				
			}else{
				count =1;
			}
			arr[i] = val;
			if(max < count){
				max = count;
			}
		}
		System.out.println(max);
	}
}
