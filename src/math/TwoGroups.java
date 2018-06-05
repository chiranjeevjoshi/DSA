package math;

import java.util.Scanner;

/*
 * There are 
N
N people in a room.
Your task is to find the number of ways to divide the people of the room into two groups 
A
A and 
B
B, such that each group contains at-least one member.
As the number of ways can be large, print output modulo 
10
9
+
7
109+7.

Input format

First line contains the number of test cases, 
T
T.
Next 
T
T lines contains 
N
N denoting the number of people in a room.
Output format

For each test case, print the number of ways as modulo 
10
9
+
7
109+7 in a new line.


 */
public class TwoGroups {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();
			long total = (calculatePower(2, n));
			System.out.println(total);
		}

	}

	static long calculatePower(long x, long y) {
		int mod = 1_000_000_007;
		long res = 1; // Initialize result

		while (y > 0) {
			// If y is odd, multiply x with result
			if ((y & 1) != 0)
				res = (res * x) % mod;

			// y must be even now
			y = y >> 1; // y = y/2
			x = (x * x) % mod; // Change x to x^2
		}
		return (res - 2 + mod) % mod;
	}
}
