package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SaveMrinal {
	/*
	 * Mrinal is a coder from BVCOE. He always takes his laptop with him
	 * wherever he goes. One day (while on a trek trip ) a monster challenged
	 * him to solve one easy task else he was going to kill him.the task is as
	 * follows- Given a series of n numbers a1, a2, ..., an and a number of
	 * magic-queries. A magic-query is a pair (i, j) (1 ≤ i ≤ j ≤ n). For each
	 * magic-query (i, j), you have to return the number of distinct elements in
	 * the subsequence ai, ai+1, ..., aj.
	 * 
	 * Input
	 * 
	 * Line 1: n (1 ≤ n ≤ 30000). Line 2: n numbers a1, a2, ..., an (1 ≤ ai ≤
	 * 10^6). Line 3: q (1 ≤ q ≤ 200000), the number of magic-queries. In the
	 * next q lines, each line contains 2 numbers i, j representing a
	 * magic-query (1 ≤ i ≤ j ≤ n).
	 * 
	 * Output
	 * 
	 * For each magic-query (i, j), print the number of distinct elements in the
	 * subsequence ai, ai+1, ..., aj in a single line. Example
	 */public static void main(String[] args) throws Exception {
		int N;
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(scan.nextInt());
		}
		int Q = scan.nextInt();
		Set<Integer> arr1 = new HashSet<>();
		for (int j = 0; j < Q; j++) {
			int L = scan.nextInt();
			int R = scan.nextInt();
			for (int k = L - 1; k < R; k++) {
				arr1.add(arr.get(k));
			}
			System.out.println(arr1.size());
			arr1.clear();
		}
	}
}
