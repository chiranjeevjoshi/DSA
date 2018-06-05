package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * There are 
N
N warehouses. The warehouses are located in a straight line and are indexed from 1 to N. Each warehouse contains some number of sacks.

A thief decides to rob these warehouses. Thief figured out that he can escape the police if and only if he follows both the following 2 constraints:

He will rob only one continuous segment of warehouses.
He will rob same number of sacks from each warehouse.
Thief wants to calculate the maximum number of sacks he can steal without getting caught by the police.

Input Format:

The first line contains an integer 
T
T denoting number test cases.

The first line of each test case contains a single integer 
N
N denoting number of warehouses.

The second line of each test case contains 
N
N space-separated integers :
a
[
1
]
,
a
[
2
]
,
a
[
3
]
.
.
.
a
[
n
]
.
a
[
i
]
a[1],a[2],a[3]...a[n].a[i] denotes number of sacks in 
i
t
h
ith warehouse.
 */
public class ThiefAndWarehouses {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String input[] = br.readLine().split(" ");
			long arr[] = new long[n];
			for (int j = 0; j < input.length; j++) {
				arr[j] = Long.parseLong(input[j]);
			}
			System.out.println(getMaxArea(arr, n));
		}

	}

	static long getMaxArea(long hist[], int n) {
		Stack<Integer> s = new Stack<>();
		long maxArea = 0l;
		int tp;
		long areaTop;
		int i = 0;
		while (i < n) {
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);

			else {
				tp = s.peek();
				s.pop();

				areaTop = hist[tp] * (s.empty() ? i : i - s.peek() - 1);
				if (maxArea < areaTop)
					maxArea = areaTop;
			}
		}
		while (!s.empty()) {
			tp = s.peek();
			s.pop();
			areaTop = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

			if (maxArea < areaTop)
				maxArea = areaTop;
		}
		return maxArea;

	}
}
