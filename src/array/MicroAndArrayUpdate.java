package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Micro purchased an array 
A
A having 
N
N integer values. After playing it for a while, he got bored of it and decided to update value of its element. In one second he can increase value of each array element by 
1
1. He wants each array element's value to become greater than or equal to 
K
K. Please help Micro to find out the minimum amount of time it will take, for him to do so.

Input: 
First line consists of a single integer, 
T
T, denoting the number of test cases. 
First line of each test case consists of two space separated integers denoting 
N
N and 
K
K. 
Second line of each test case consists of 
N
N space separated integers denoting the array 
A
A.

Output:
For each test case, print the minimum time in which all array elements will become greater than or equal to 
K
K. Print a new line after each test case.

 */
public class MicroAndArrayUpdate {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int j = 0; j < t; j++) {
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			String text[] = br.readLine().split(" ");
			int min = k;
			for (int i = 0; i < text.length; i++) {
				int val = Integer.parseInt(text[i]);
				if (min > val) {
					min = val;
				}
			}
			sb.append(k - min + "\n");

		}
		System.out.println(sb);
	}

}
