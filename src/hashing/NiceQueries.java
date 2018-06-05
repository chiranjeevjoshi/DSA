package hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * You are given an array 
A
A of length 
N
N which is initialised with 
0
0. You will be given 
Q
Q queries of two types:

1
k
1k: set value 
−
1
−1 at index 
k
k in array 
A
A

2
y
2y: print the smallest index 
x
x which is greater than or equal to 
y
y and having value 
−
1
−1. If there is no such index print 
−
1
−1.

Note: Indexing is 
1
1 based

Input Format

First line contains two integers 
N
N and 
Q
Q separated by a space.

The next 
Q
Q lines contain the type of query (i.e. either a 
1
1 or a 
2
2), then a space, then for type 
1
1 queries integer 
k
k and for type 
2
2 queries integer 
y
y

Output Format

For each query type 
2
2, print in new line, the smallest index 
x
x which is greater than or equal to 
y
y and having value 
−
1
−1. If there is no such index print 
−
1
−1.

Constraints
1
≤
n
≤
10
9
1≤n≤109
1
≤
q
≤
5
∗
10
5
1≤q≤5∗105 
1
≤
y
,
k
≤
n
 */
public class NiceQueries {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			if (type == 1) {
				set.add(index);
			} else {
				int indexVal = -1;
				Integer search = set.higher(index - 1);
				if (search != null) {
					indexVal = search;
				}
				sb.append(indexVal + "\n");
			}
		}
		System.out.println(sb);
	}
}
