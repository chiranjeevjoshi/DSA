package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ThiefandWarehouses {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String input[] = br.readLine().split(" ");
			long arr[] = new long[n];
			for (int j = 0; j < input.length; j++) {
				arr[j] = Long.parseLong(input[j]);
			}
			System.out.println(getMaxArea(arr, n));
		}

	}

	static long getMaxArea(long hist[], int n) {
		Stack<Integer> s = new Stack<>();

		long maxArea = 0l;
		int tp;
		long areaTop;

		int i = 0;
		while (i < n) {
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);

			else {
				tp = s.peek();
				s.pop();

				areaTop = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

				// update max area, if needed
				if (maxArea < areaTop)
					maxArea = areaTop;
			}
		}

		while (!s.empty()) {
			tp = s.peek();
			s.pop();
			areaTop = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

			if (maxArea < areaTop)
				maxArea = areaTop;
		}

		return maxArea;

	}
}
