package graph;

public class Graph {

	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // collection of all edges

	class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	}

	// Creates a graph with V vertices and E edges
	Graph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

}
