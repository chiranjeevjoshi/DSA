package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Akash has lots of assignments to submit in his college.In one of the assignment he is given a string S of length N consisting of lowercase letters(a-z)only.Akash has to answer Q queries and for every query,he is given L,R and K.For each query he has to find the lexicographically Kth smallest character in substring of S starting from L to R,inclusively.Help Akash in solving his assignment.

Input

First line contains 2 integers N and Q,length of string and number of queries.Next line has a string S of length N.Next Q lines contains 3 integers L,R and K.

Output

For each query output the lexicographically Kth smallest character in substring of S starting from L to R if possible,else print"Out of range"(without qoutes).

Constraints

1<=N<=5*10^4

1<=Q<=10^5

1<=L<=R<=N

1<=K<=N

Input

6 2
abcdef
2 6 3
4 6 1

output
d
d*/
public class AkashAndTheAssignment {

	public static void main(String[] args) throws Exception {
		// Scanner

		StringBuilder bf = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int q = Integer.parseInt(input[1]);
		char text[] = br.readLine().toCharArray();
		for (int i = 0; i < q; i++) {
			String input1[] = br.readLine().split(" ");
			int l = Integer.parseInt(input1[0]);
			int r = Integer.parseInt(input1[1]);
			int k = Integer.parseInt(input1[2]);
			if (r - l + 1 < k || l - r > 0 || l < 0 || r > text.length) {
				bf.append("Out of range" + "\n");
			} else {
				char[] charArray = new char[26];
				for (int m = 0; m < 26; m++) {
					charArray[m] = 0;
				}
				for (int m = l - 1; m < r; m++) {
					charArray[text[m] - 'a']++;
				}
				int count = 0;
				for (int m = 0; m < 26; m++) {
					if (charArray[m] > 0) {

						count += charArray[m];
						if (count >= (k)) {

							bf.append((char) (m + 'a') + "\n");
							break;
						}

					}

				}
			}

		}
		System.out.print(bf.toString());
	}
}
