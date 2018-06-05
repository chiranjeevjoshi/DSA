package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
/*
 * You are given a string s consisting of lowercase English letters and/or '_' (underscore). 
You have to replace all underscores (if any) with vowels present in the string.

The rule you follow is:
Each underscore can be replaced with any one of the vowel(s) that came before it.

You have to tell the total number of distinct strings we can generate following the above rule.

Input format: 
The first line consists of an integer t, denoting the number of test cases.
Each of the next t lines consists of a string s.

Output format:
For each test case, output total number of distinct strings we can generate following the given rule.
Answer for each test case should come in a new line.
 */
public class CanYouCount {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());
		for (int i = 0; i < test; i++) {
			Set<Character> charSet = new HashSet<>();
			long count = 1;
			String input = br.readLine();
			char inputChar[] = input.toCharArray();
			for (int j = 0; j < inputChar.length; j++) {
				if (isVowel(inputChar[j]) && charSet.size() < 5) {
					charSet.add(inputChar[j]);
				}
				if (inputChar[j] == '_') {
					count = count * charSet.size();
				}
			}

			System.out.println(count);
		}
	}

	static boolean isVowel(char c) {
		if (c == 'a' || c == 'i' || c == 'o' || c == 'e' || c == 'u') {
			return true;
		}
		return false;
	}
}
