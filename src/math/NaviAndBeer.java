package math;

import java.util.Scanner;
/*
 * Navi is at the Beer Bar where he has ordered N beers. After seeing his love with the beers, Bar's Manager has decided to make as much money as they can by asking Navi to pay K * i3 Rupees for the ith beer. But Navi has only M Rupees in his purse. So you are required to lent him some money so that he can still be able to pay for all of the N beers.

Input:
First line will contain T (No. of test cases).
Each test case will contain only one line having three space separated integers : N, K and M
Output:
For every test case, print the required answer in a new line.
 */
public class NaviAndBeer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t ; i++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int m = sc.nextInt();
			long val = (long) Math.pow(n*(n+1)/2,2)*k;
			if(val-m >0)
			sb.append(val-m+"\n");
			else
				sb.append(0+"\n");
			
		}
		System.out.println(sb);
	}
}
