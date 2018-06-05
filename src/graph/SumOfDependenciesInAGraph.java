package graph;

import java.util.Scanner;
import java.util.Vector;

public class SumOfDependenciesInAGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int vertex = sc.nextInt();
			int edge = sc.nextInt();
			Vector<Integer> adj[] = new Vector[edge * 2];
			for (int l = 0; l < adj.length; l++) {
				adj[l] = new Vector<>();
			}
			for (int j = 0; j < edge; j++) {
				addEdge(adj, sc.nextInt(), sc.nextInt());
			}
			System.out.println(findSum(adj, vertex));
		}

	}

	static void addEdge(Vector<Integer> adj[], int u, int v) {
		adj[u].addElement((v));
	}

	static int findSum(Vector<Integer> adj[], int V) {
		int sum = 0;
		for (int u = 0; u < V; u++)
			sum += adj[u].size();

		return sum;
	}
}
