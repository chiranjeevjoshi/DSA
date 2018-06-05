package array;

import java.util.Scanner;

/*
 * You are given a list(1-indexed) of size , initialized with zeroes. You have to perform  operations on the list and output the maximum of final values of all the  elements in the list. For every operation, you are given three integers ,  and  and you have to add value  to all the elements ranging from index  to (both inclusive).

For example, consider a list  of size . The initial list would be  = [, , ] and after performing the update  = , the new list would be  = [, , ]. Here, we've added value 30 to elements between indices 2 and 3. Note the index of the list starts from 1.
 */
public class ArrayManipulation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		long[] arr = new long[n];
		int a;
		int b;
		long k;
		for (int i = 0; i < m; i++) {
			a = scan.nextInt();
			b = scan.nextInt();
			k = scan.nextInt();
			arr[a - 1] += k;
			if (b < n)
				arr[b] -= k;
		}
		long max = 0;
		long temp = 0;
		for (int i = 0; i < n; i++) {
			temp += arr[i];
			if (temp > max)
				max = temp;
		}
		System.out.println(max);
		scan.close();
	}
}
