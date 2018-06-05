package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Sherlock Holmes loves mind palaces! We all know that.

A mind palace, according to Mr. Holmes is something that lets him retrieve a given memory in the least time posible. For this, he structures his mind palace in a very special way. Let a NxM Matrix denote the mind palace of Mr. Holmes. For fast retrieval he keeps each row and each column sorted. Now given a memory X, you have to tell the position of the memory in Sherlock's mind palace.

Input
Input begins with a line containing space separated N and M.
The next N lines each contain M numbers, each referring to a memory Y.
The next line contains Q, the number of queries.
The next Q lines contain a single element X, the memory you have to search in Sherlock's mind palace.

Output
If Y is present in Mr. Holmes memory, output its position (0-based indexing).
Else output "-1 -1" (quotes for clarity only).
 */
public class MindPalaces {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input[] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < input.length; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			int val = Integer.parseInt(br.readLine());
			boolean flag = false;
			for (int j = 0; j < n && !flag; j++) {
				for (int k = 0; k < m; k++) {
					if (arr[j][k] == val) {
						sb.append(j + " " + k + "\n");
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				sb.append("-1 -1 \n");
			}
		}
		System.out.println(sb);
	}
}
