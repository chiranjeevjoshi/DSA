package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Due to the demonetization move, there is a long queue of people in front of ATMs. Due to withdrawal limit per person per day, people come in groups to withdraw money. Groups come one by one and line up behind the already present queue. The groups have a strange way of arranging themselves. In a particular group, the group members arrange themselves in increasing order of their height(not necessarily strictly increasing).

Swapy observes a long queue standing in front of the ATM near his house. Being a curious kid, he wants to count the total number of groups present in the queue waiting to withdraw money. Since groups are standing behind each other, one cannot differentiate between different groups and the exact count cannot be given. Can you tell him the minimum number of groups that can be observed in the queue?

Input format:
The first line of input contains one positive integer N. The second line contains N space-separated integers  denoting the height of i-th person. Each group has group members standing in increasing order of their height.
 */
public class LongATMQueue {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		int arr[] = new int[n];
		int total =1;
		arr[0] = Integer.parseInt(input[0]);
		for(int i=1 ;i<n ; i++) {
			int current = Integer.parseInt(input[i]);
			if(current<arr[i-1]) {
				total++;
			}
			arr[i] = current;
		}
		System.out.println(total);
	}
}
