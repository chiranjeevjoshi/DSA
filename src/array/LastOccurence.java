package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
Given an array 'a' having 'n' elements.

Now, given 'q' queries , each query has an integer 'x' , you have to find out the index of last occurrence of the 'x' if it is present in the array else print '-1'.

Input :

test cases,t
no. of elements in array , a
a[i]
no. of queries, q
element x
Output:

Desired O/p
Constraints :

1<=t<=10
1<=n<=100000
1<=a[i]<=1000000
1<=x<=10^9
Note : print ans according to 1 - indexing.
*/

public class LastOccurence {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> countMap = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int j = 0; j < t; j++) {
			int n = Integer.parseInt(br.readLine());
			String text[] = br.readLine().split(" ");
			for (int i = 0; i < text.length; i++) {
				int val = Integer.parseInt(text[i]);
				countMap.put(val, i);
			}
			int q = Integer.parseInt(br.readLine());
			for (int k = 0; k < q; k++) {
				int input = Integer.parseInt(br.readLine());
				if (countMap.get(input) != null) {
					sb.append(countMap.get(input) + 1 + "\n");
				} else {
					sb.append("-1\n");
				}
			}

		}
		System.out.println(sb);
	}
}
