package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Monk has 
N
N friends. They are invited to his birthday party. Each friend has a satisfying factor which is equal to the number of gifts which they are expecting. Monk wants to satisfy at-least 
K
K friends but he is unaware of their satisfying factors. So Monk starts distribution of gifts. As soon as a friend is satisfied he won't take more gifts.

Monk will follow a distribution strategy so as to minimize the number of gifts needed to satisfy atleast 
K
K of his friends. Find the minimum number of gifts which Monk should carry with himself in the worst case.

Input Format

First line contains an integer 
T
T (the number of testcases).

Then first line of each test case contains an integer 
N
N (the number of friends).

Then 
N
N space separated integers follow which are the satisfying factor(
S
[
i
]
S[i]).

Last line of each test case consists of an integer 
K
K.
 */
public class K_Friends {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			int N = Integer.parseInt(br.readLine().trim());
			String[] arr_S = br.readLine().split(" ");
			List<Integer> list = new ArrayList<>();
			for (int i_S = 0; i_S < arr_S.length; i_S++) {
				list.add(Integer.parseInt(arr_S[i_S]));
			}
			int K = Integer.parseInt(br.readLine().trim());

			long out_ = gifts(list, K);
			System.out.println(out_);
		}

		wr.close();
		br.close();
	}

	static long gifts(List<Integer> S, int K) {
		Collections.sort(S, Collections.reverseOrder());
		long totalGift = 0l;
		int maxGift = S.get(S.size() - K);
		for (int val : S) {
			if (maxGift < val) {
				totalGift += maxGift;
			} else {
				totalGift += val;
			}
		}
		return totalGift;
	}
}
