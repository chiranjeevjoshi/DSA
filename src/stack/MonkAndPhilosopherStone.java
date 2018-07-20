package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * Harry Potter wants to get the Philosopher's stone to protect it from Snape. Monk being the guard of Philosopher's Stone is very greedy and has a special bag, into which he can add one gold coin at a time or can remove the last gold coin he added. Monk will sleep, once he will have the enough number of gold coins worth amount X. To help Harry, Dumbledore has given a same kind of bag to Harry (as of Monk) with N gold coins each having worth  where i range from .

enter image description here

Dumbledore also gave him a set of instructions which contains two types of strings: 
1) "Harry" (without quotes): It means Harry will remove  coin from his bag and throw it towards Monk and Monk will add it in his bag, where i will start from 1 and go up to N. 
2) "Remove" (without quotes): it means Monk will remove the last coin he added in his bag.
Once the worth of the coins in Monk's bag becomes equal to X, Monk will go to sleep. In order to report Dumbledore, Harry wants to know the number of coins in Monk's bag, the first time their worth becomes equal to X.

Help Harry for the same and print the required number of coins. If the required condition doesn't occur print "-1" (without quotes).

Input:
The first line will consists of one integer N denoting the number of gold coins in Harry's Bag. 
Second line contains N space separated integers, denoting the worth of gold coins.
Third line contains 2 space separated integers Q and X, denoting the number of instructions and the value of X respectively. 
In next Q lines, each line contains one string either "Harry" (without quotes) or "Remove" (without quotes).
 */
public class MonkAndPhilosopherStone {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> coinStack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		String arr[] = br.readLine().split(" ");
		int total = 0;
		String input[] = br.readLine().split(" ");
		int q = Integer.parseInt(input[0]);
		int x = Integer.parseInt(input[1]);
		int index=0;
		int size = 0;
		for(int i =0 ; i<q ; i++) {
			String queryType = br.readLine();
			if(queryType.equals("Harry")) {
				int val = Integer.parseInt(arr[index]);
				index++;
				coinStack.add(val);
				total+=val;
				if(total == x) {
					size++;
					break;
				}

			}else {
				if(!coinStack.isEmpty()) {
					int val = coinStack.pop();
					total = total -val;
				}
				
			}
		}
		if(size>0)
		System.out.println(coinStack.size());
		else
		System.out.println(-1);
		
		
	}
}
