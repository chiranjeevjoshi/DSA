package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Monk was asked to answer some queries in an interview. He is given an empty array A. Queries are of 4 types:-
1. 1 X - Add number X to the array A.
2. 2 X - Remove a single instance of number X from the array A. If not possible, print "-1" without the quotes.
3. 3 - Find the maximum element in the array A.
4. 4 - Find the minimum element in the array A.

Input:
The first line contains the integer Q.
The next Q lines will each contain a query like the ones mentioned above.

Output: 
For queries 3 and 4, print the answer in a new line. If the array is empty for query 3 and 4, then print "-1" without the quotes.

Constraints:
1 <= Q <= 100000
1 <= X <= 100000


 */
public class MonkAndSomeQueries {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> asc = new PriorityQueue<>(100000);
		PriorityQueue<Integer> desc = new PriorityQueue<>(100000, Collections.reverseOrder());
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<q ; i++) {
			String input[] = br.readLine().split(" ");
			int queryType = Integer.parseInt(input[0]);
			switch(queryType) {
			case 1:
				asc.add(Integer.parseInt(input[1]));
				desc.add(Integer.parseInt(input[1]));
				break;
			case 2:
				 boolean isRemove = asc.remove(Integer.parseInt(input[1]));
				desc.remove(Integer.parseInt(input[1]));
				if(!isRemove) {
					sb.append("-1\n");
				}
				break;
			case 3:
				if(desc.peek() == null) {
					sb.append("-1\n");
				}else {
					sb.append(desc.peek()+"\n");
				}
				
				break;
			case 4:
				if(desc.peek() == null) {
					sb.append("-1 \n");
				}else {
					sb.append(asc.peek()+"\n");
				}
				break;
			}
			
		}
		System.out.println(sb);
	}
}
