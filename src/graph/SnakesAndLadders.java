package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakesAndLadders {

	static class Entry {
		int vertex;
		int dist;
	}

	static int quickestWayUp(int[] moves, int n) {
		Queue<Entry> queue = new LinkedList<>();
		boolean visited[] = new boolean[n];
		Entry entry = new Entry();
		entry.vertex = 0;
		entry.vertex = 0;
		visited[0] = true;
		boolean flag = false;
		queue.add(entry);
		while (!queue.isEmpty()) {
			entry = queue.poll();
			int v = entry.vertex;
			if (v == n - 1) {
				flag = true;
				break;
			}
			for (int i = v + 1; i <= (v + 6) && i < n; i++) {
				if (!visited[i]) {
					Entry newEntry = new Entry();
					newEntry.dist = entry.dist + 1;
					visited[i] = true;
					if (moves[i] != -1) {
						newEntry.vertex = moves[i];
					} else {
						newEntry.vertex = i;
					}
					queue.add(newEntry);
				}
			}
		}
		if (!flag) {
			return -1;
		}
		return entry.dist;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int moves[] = new int[100];
			for (int j = 0; j < 100; j++) {
				moves[j] = -1;
			}
			int l = sc.nextInt();
			for (int j = 0; j < l; j++) {
				moves[sc.nextInt() - 1] = sc.nextInt() - 1;
			}
			int s = sc.nextInt();
			for (int k = 0; k < s; k++) {
				moves[sc.nextInt() - 1] = sc.nextInt() - 1;
			}
			System.out.println(quickestWayUp(moves, 100));
		}
	}
}
