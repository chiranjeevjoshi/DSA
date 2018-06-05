package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * P
l
a
y
e
r
1
Player1  and 
P
l
a
y
e
r
2
Player2 decided to play a game. The game comprises of a String 
S
S which consist of lowercase English alphabets only and both players take alternative terms.

In each turn, a Player choose a character present in the string and remove all occurrences of the character. For each player to play his turn, there should be at least one character in the string. The Player who is not able to play his turn loses.

Your task is to find the winner of the game, if both the players play optimally and 
P
l
a
y
e
r
1
Player1 plays the first turn.

Input Format : 
The input starts with an integer 
T
T, the number of test cases. 
Each test case contains an String 
S
S on a new line.
 */
public class StringGame {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			char input[] = br.readLine().toCharArray();
			Set<Character> set = new HashSet<>();
			for (char c : input) {
				set.add(c);
			}
			if (set.size() % 2 == 0) {
				System.out.println("Player2");
			} else {
				System.out.println("Player1");
			}
		}
	}
}
