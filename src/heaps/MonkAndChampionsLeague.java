package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Monk's favourite game is Football and his favourite club is "Manchester United". Manchester United has qualified for the Champions League Final which is to be held at the Wembley Stadium in London. So, he decided to go there and watch his favourite team play. After reaching the stadium, he saw that many people have lined up for the match tickets. He knows that there are M rows in the stadium with different seating capacities. They may or may not be equal. The price of the ticket depends on the row. If the row has K(always greater than 0) vacant seats, then the price of the ticket will be K pounds(units of British Currency). Now, every football fan standing in the line will get a ticket one by one.
Given the seating capacities of different rows, find the maximum possible pounds that the club will gain with the help of the ticket sales.

Input:
The first line consists of M and N. M denotes the number of seating rows in the stadium and N denotes the number of football fans waiting in the line to get a ticket for the match.
Next line consists of M space separated integers X[1],X[2],X[3].... X[M] where X[i] denotes the number of empty seats initially in the ith row.

Output:
Print in a single line the maximum pounds the club will gain.
 */
public class MonkAndChampionsLeague {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>(1000000, Collections.reverseOrder());
		String input[] = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		input =  br.readLine().split(" ");
		for(int i = 0 ; i<m ; i++) {
			queue.offer(Integer.parseInt(input[i]));
		}
		int total = 0;
		while(n >0) {
			int value = queue.poll();
			total+= value;
			n--;
			value--;
			queue.add(value);
		}
		System.out.println(total);
	}
	 

}
