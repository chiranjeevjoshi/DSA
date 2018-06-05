package array;

import java.util.Scanner;

public class MonkAndWelcomeProblem {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}

		for (int i = 0; i < n; i++) {
			b[i] = scan.nextInt();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(a[i] + b[i] + " ");
		}
		scan.close();
		System.out.println(sb);
	}
}
