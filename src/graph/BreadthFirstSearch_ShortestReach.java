package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * Consider an undirected graph consisting of  nodes where each node is labeled from  to  and the edge between any two nodes is always of length . We define node  to be the starting position for a BFS.

Given  queries in the form of a graph and some starting node, , perform each query by calculating the shortest distance from starting node  to all the other nodes in the graph. Then print a single line of  space-separated integers listing node 's shortest distance to each of the  other nodes (ordered sequentially by node number); if  is disconnected from a node, print  as the distance to that node.

Input Format

The first line contains an integer, , denoting the number of queries. The subsequent lines describe each query in the following format:

The first line contains two space-separated integers describing the respective values of  (the number of nodes) and  (the number of edges) in the graph.
Each line  of the  subsequent lines contains two space-separated integers,  and , describing an edge connecting node  to node .
The last line contains a single integer, , denoting the index of the starting node.
 */
public class BreadthFirstSearch_ShortestReach {
	
	static int[] bfs(int n, int m, int[][] graph, int s) {

		int results[] = new int[n + 1];
		boolean visit[] = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		visit[s] = true;
		results[s] = 0;
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (int i = 1; i < n + 1; i++) {
				if (graph[v][i] == 1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
					if(results[i] == 0 || results[i] > results[v] + 6){
						results[i] = results[v] + 6;
					}
				}
			}
		}
		return results;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int graph[][] = new int[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				graph[x][y] = 1;
				graph[y][x] = 1;
			}
			int s = in.nextInt();
			int[] result = bfs(n, m, graph, s);
			for (int i = 1; i < result.length; i++) {
				if (i != s) {
					if (result[i] == 0) {
						result[i] = -1;
					}
					System.out.print(result[i] + " ");
				}
			}
			System.out.println("");

		}
		in.close();
	}
}
