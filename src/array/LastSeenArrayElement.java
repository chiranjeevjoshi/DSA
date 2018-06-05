package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*Given an array of N integers that might contain duplicates, find the element whose last appearance is earliest.

Input:
First line of input contains a single integer T denoting the number of test cases. First line of every test case has one number N denoting the length of the array and second line of every test case has N integers.

Output:
For each test case, print the required output.

Constraints:
1<=T<=100
1<=N<=10^3
1<=A[i]<=10^6*/

public class LastSeenArrayElement {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> countMap = new HashMap<>();
		int t = Integer.parseInt(br.readLine());

		for (int j = 0; j < t; j++) {
			int n = Integer.parseInt(br.readLine());
			String text[] = br.readLine().split(" ");
			int minIndex = Integer.MAX_VALUE;
			int result = 0;
			for (int i = 0; i < text.length; i++) {
				int val = Integer.parseInt(text[i]);
				countMap.put(val, i);
			}
			for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
				if (entry.getValue() < minIndex) {
					minIndex = entry.getValue();
					result = entry.getKey();
				}

			}
			System.out.println(result);
		}

	}

}
