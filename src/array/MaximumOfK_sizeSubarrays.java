package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Given an array A of size 'N' and an integer k, find the maximum for each and every contiguous subarray of size k.

Input :

First line contains 2 space separated integers 'N' and 'k' .
Second line contains 'N' space separated integers denoting array elements.
Output:

Space separated Maximum of all contiguous sub arrays of size k.
 */
public class MaximumOfK_sizeSubarrays {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long k = Long.parseLong(input[1]);
		String intput[] = br.readLine().split(" ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(intput[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j < i + 3; j++) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			sb.append(max + " ");
		}
		System.out.println(sb);
	}
}
