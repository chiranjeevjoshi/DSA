package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Given an encrypted message, Erwin encodes it the following way:

Removes the median letter of the word from the original word and appends it to the end of the encrypted word and repeats the process until there are no letters left.

A median letter in a word is the letter present in the middle of the word and if the word length is even, the median letter is the left one out of the two middle letters.

Given an encoded string, write a program to decode it.

Input Format:

The first line of input contains T, the number of test cases. 
Each test case contains a String S, denoting the encoded word.

Output Format:

Print the decoded word for each test case in a separate line.

Constraints

1
≤
T
≤
100
1≤T≤100 
1
≤
|
S
|
≤
100000
 */
public class Decode {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String s = br.readLine();

			String out_ = decode(s);
			sb.append(out_ + "\n");
		}
		wr.print(sb);
		wr.close();
		br.close();
	}

	static String decode(String s) {
		int len = s.length();
		char[] a = new char[len];
		if (len % 2 != 0) {
			int mid = len / 2;
			int left = mid - 1;
			int right = mid + 1;

			a[mid] = s.charAt(0);
			for (int i = 1; i < len; i++) {
				if (i % 2 != 0) {
					a[left] = s.charAt(i);
					left--;
				} else {
					a[right] = s.charAt(i);
					right++;
				}

			}
		} else {
			int mid = len / 2 - 1;
			int left = mid - 1;
			int right = mid + 1;

			a[mid] = s.charAt(0);
			for (int i = 1; i < len; i++) {
				if (i % 2 == 0) {
					a[left] = s.charAt(i);
					left--;
				} else {
					a[right] = s.charAt(i);
					right++;
				}

			}
		}
		return new String(a);
	}
}
