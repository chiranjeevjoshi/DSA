package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Monk loves to preform different operations on arrays, and so being the principal of Hackerearth School, he assigned a task to his new student Mishki. Mishki will be provided with an integer array A of size N and an integer K , where she needs to rotate the array in the right direction by K steps and then print the resultant array. As she is new to the school, please help her to complete the task.

Input:
The first line will consists of one integer T denoting the number of test cases. 
For each test case:
1) The first line consists of two integers N and K, N being the number of elements in the array and K denotes the number of steps of rotation.
2) The next line consists of N space separated integers , denoting the elements of the array A.
 */
public class MonkAndRotation {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<t ; i++) {
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			k = k%n;
			String arr[] = br.readLine().split(" ");
			for(int j=n-k ; j<n ;j++) {
				sb.append(arr[j]+" ");
			}
			for(int j=0 ; j<n-k ;j++) {
				sb.append(arr[j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
