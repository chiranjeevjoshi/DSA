package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
 * Fill the boxes
You are given an array of size N, denoting capacity of N boxes, and an integer K, denoting extended capacity factor. You are also given the weights of M balls. Each  box can accommodate exactly one ball having weight in range  (both inclusive). Find the maximum number of boxes that can be filled.

Constraints:

Input format:
First line: T i.e. Number of test cases.
For each test case:
First line: Three space-separated integers N, M and K.
Second line: N space-separated integers denoting the capacity of boxes.
Third line: M space-separated integers denoting the weight of balls.

Output format:
For each test case, print the answer in a separate line.
 */
public class FillTheBoxes {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i<t ; i++) {
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);
			PriorityQueue<Integer> queue1 = new PriorityQueue<>();
			PriorityQueue<Integer> queue2 = new PriorityQueue<>();
			int count =0;
			input = br.readLine().split(" ");
			for(int j=0 ;j<n ; j++) {
				queue1.add(Integer.parseInt(input[j]));
			}
			input = br.readLine().split(" ");
			for(int j=0 ;j<m ; j++) {
				queue2.add(Integer.parseInt(input[j]));
			}
			while(!queue2.isEmpty() && !queue1.isEmpty()) {
				int peek1 = queue1.peek();
				int peek2 = queue2.peek();
				if(peek2 >= peek1 && peek2<=peek1+k) {
					count++;
					queue2.remove();
					queue1.remove();
				}else if(peek2 <peek1){
					queue2.remove();
				}else {
					queue1.remove();
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}
