package dynamic;

import java.util.Scanner;

/*
 * Roy has a rope of length 
L
L meters. This rope has several other ropes attached to it at the end of every meter (except for the end of the rope). 
At each meter there are two ropes attached to this main rope, let's call them upper and lower ropes. See the following example.
 */
public class RoyAndRopes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int arr1 [] = new int[n - 1];
			int arr2 [] = new int[n - 1];
			int maxTime = 0;
			for (int j = 0; j < n - 1; j++) {
				arr1[j] = sc.nextInt();
			}
			for (int j = 0; j < n - 1; j++) {
				arr2[j] = sc.nextInt();
			}
			for (int j = 0; j < n - 1; j++) {
				int maxVal = Math.max(arr1[j], arr2[j]);

				int diff = n - (j + 1);
				if (maxVal > diff && maxTime < (maxVal - diff)) {
					maxTime = maxVal - diff;
				}
			}
			System.out.println(maxTime + n);
			sc.close();

		}

	}
}
