package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
/*
 * Our Monk loves candy!
While taking a stroll in the park, he stumbled upon N Bags with candies. The i'th of these bags contains Ai candies.
He picks up a bag, eats all the candies in it and drops it on the ground. But as soon as he drops the bag, the number of candies in the bag increases magically! Say the bag that used to contain X candies (before eating), now contains [X/2] candies! ,where [x] is the greatest integer less than x (Greatest Integer Function).
Amazed by the magical spell, Monk can now have a lot more candies! But he has to return home in K minutes. In a single minute,Monk can consume all the candies in a single bag, regardless of the number of candies in it.
Find the maximum number of candies that Monk can consume.

Input:
First line contains an integer T. T test cases follow.
First line of each test case contains two space-separated integers N and K.
Second line of each test case contains N space-separated integers,the number of candies in the bags.
 */
public class MonkAndTheMagicalCandyBags {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < q; i++) {
			PriorityQueue<Long> queue = new PriorityQueue<>(1000000, Collections.reverseOrder());
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			String arr[] = br.readLine().split(" ");
			
			for(int j=0 ;j<n; j++) {
				queue.add(Long.parseLong(arr[j]));
			}
			long total=0l;
			for(int j=0 ;j<m; j++) {
				long max = queue.remove();
				total += max;
				queue.add(max/2);
			}
			sb.append(total+"\n");
		}
		System.out.println(sb);
		
	}
}
