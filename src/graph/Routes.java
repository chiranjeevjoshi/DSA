package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Routes {
	static class Route {

		int hour;
		int cost;

		public Route(int hour, int cost) {
			this.hour = hour;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int x = Integer.parseInt(br.readLine());
		Route[][] routeArr = new Route[n][n];
		for (int i = 0; i < x; i++) {
			String input[] = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]) - 1;
			int end = Integer.parseInt(input[1]) - 1;
			int hour = Integer.parseInt(input[2]);
			int cost = Integer.parseInt(input[3]);
			Route route = new Route(hour, cost);
			routeArr[start][end] = route;
		}
		int s = Integer.parseInt(br.readLine()) - 1;
		int d = Integer.parseInt(br.readLine()) - 1;
		int[] parent = new int[n];
		int cost[] = new int[n];
		for (int j = 0; j < n; j++) {
			cost[j] = Integer.MAX_VALUE;
		}
		boolean visit[] = new boolean[n];
		LinkedList<Integer> queue = new LinkedList<>();
		findCost(k, n, routeArr, s, parent, cost, visit, queue);
		int child = d;
		int totalCost = 0;
		int totalTime = 0;
		parent[s] = -1;
		int size = 0;
		cost[s] = 0;
		String sb = new String();
		if (parent[d] == 0) {
			System.out.println("error");
		} else {
			while (child >= 0) {
				size++;
				sb = child + 1 + "->" + sb;
				int v = parent[child];
				totalCost += cost[child];
				if (v != -1)
					totalTime += routeArr[v][child].hour;
				child = v;
			}
			System.out.println(sb.substring(0, sb.length() - 2) + " " + (totalTime + size - 2) + " "
					+ (totalCost + ((size - 2) * k)));
		}

	}

	private static void findCost(int k, int n, Route[][] routeArr, int s, int[] parent, int[] cost, boolean[] visit,
			LinkedList<Integer> queue) {
		queue.add(s);
		visit[s] = true;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int j = 0; j < n; j++) {
				if (routeArr[v][j] != null && cost[j] > routeArr[v][j].cost + routeArr[v][j].hour * k) {
					cost[j] = routeArr[v][j].cost + routeArr[v][j].hour * k;
					parent[j] = v;
					if (!visit[j]) {
						queue.add(j);
						visit[j] = true;
					}
				}
			}
		}
	}
}
