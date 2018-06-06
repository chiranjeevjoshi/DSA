package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
/*
 * Little Monk is a huge cricket fan, so he decides that he'll meet his five favorite cricketers in this problem-set of heaps. And he'll try to impress them. The first cricketer he wants to impress is: Kane Williamson. He asked Kane to answer some queries in a press interview. Kane is irritated by Little Monk's constant interruption during his interview, so he decides to give Monk a run for his money by asking him the answer to various queries.

Williamson will give a query of the types mentioned below, to the Monk and will expect him to answer those.

 X -- Insert Williamson's score in an array. - Query type 1.
 -- Find out the difference between Willamson's current highest and current lowest score, currently present in the array. And then remove a singular instance of those values from the array. - Query type 2. 
In case, the current lowest and current highest score are same, then only one instance of that score will be removed from the array.
 -- Find out the number of times Williamson has scored his current highest score, currently present in array. - Query type 3.
 -- Find out the number of times Williamson has scored his current lowest score, currently present in array. - Query type 4.
Input format:
The first line contains an integer Q, which denotes the number of queries which have to be dealt by The Monk. The next Q lines will contain a query like the ones mentioned above.

Output format: 
For the query type 2, 3, and 4, print the answer in a new line. If there is no record of any innings, that is, the array of Williamson's score is empty for query type 2, 3 and 4, then print 1

 */
public class LittleMonkAndWilliamson {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> asc = new PriorityQueue<>(100000);
		PriorityQueue<Integer> desc = new PriorityQueue<>(100000, Collections.reverseOrder());
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int countArr[] = new int[100001];
		for (int i = 0; i < q; i++) {
			String input[] = br.readLine().split(" ");

			switch (input[0]) {
			case "Push":
				asc.add(Integer.parseInt(input[1]));
				desc.add(Integer.parseInt(input[1]));
				countArr[Integer.parseInt(input[1])]++;
				break;
			case "Diff":
				if (asc.isEmpty() && desc.isEmpty()) {
					sb.append("-1\n");
				} else if (asc.isEmpty()) {
					int max = desc.poll();
					sb.append(max + "\n");
					countArr[max]--;
				} else if (desc.isEmpty()) {
					int min = asc.poll();
					sb.append(min + "\n");
					countArr[min]--;
				} else {
					int max = desc.poll();
					int low = asc.poll();
					int diff;
					if (max >= low) {
						diff = max - low;
					} else {
						diff = low - max;
					}
					asc.remove(max);
					desc.remove(low);
					if (max == low) {
						countArr[max]--;
					} else {
						countArr[max]--;
						countArr[low]--;
					}
					sb.append(diff + "\n");
				}
				break;
			case "CountHigh":
				if (desc.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(countArr[desc.peek()] + "\n");
				}
				break;
			case "CountLow":
				if (asc.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(countArr[asc.peek()] + "\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
	
}
