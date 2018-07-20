package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * Nikki's latest work is writing an story of letters. However, she finds writing story so boring that, after working for three hours, she realized that all she has written are M long words consisting entirely of letters A and B. Having accepted that she will never finish the story in time, poor Nikki has decided to at least have some fun with it by counting bubbly words.

Now Nikki is connecting pairs of identical letters (A with A, B with B) by drawing arches above the word. A given word is bubbly if each letter can be connected to exactly one other letter in such a way that no two arches intersect. So here is your task. Help Nikki count how many words are bubbly.

Input :

The first line of input contains the positive integer M , the number of words written down by Nikki. Each of the following M lines contains a single word consisting of letters A and B, with length between 2 and 10^5, inclusive. The sum of lengths of all words doesn't exceed 10^6.

Output :

The first and only line of output must contain the number of bubbly words.
 */
public class NiceArches {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int total = 0;
		for (int i = 0; i < m; i++) {
			Stack<Character> stack = new Stack<>();
			char[] input = br.readLine().toCharArray();
			for (char value : input) {
				if (stack.isEmpty()) {
					stack.push(value);
				} else if (value == stack.peek()) {
					stack.pop();
				} else {
					stack.push(value);
				}
			}
			if (stack.empty()) {
				total++;
			}
		}
		System.out.println(total);
	}
}
