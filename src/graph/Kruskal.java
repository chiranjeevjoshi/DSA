package graph;

import java.util.Arrays;
import java.util.Scanner;

import disjointset.DisjointSet;
import graph.Graph.Edge;

public class Kruskal {

	 
	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
	        int nodeNum = in.nextInt();
	        int edgesNum = in.nextInt();
	        Graph graph = new Graph(nodeNum, edgesNum);
	        for(int i=0;i<edgesNum;i++){
	            graph.edge[i].src = in.nextInt()-1;
	            graph.edge[i].dest = in.nextInt()-1;
	            graph.edge[i].weight = in.nextInt();
	        }
	       long total =  new Kruskal().kruskal(graph);
	       System.out.println(total);
	        in.close();
	    }
	
	private  long kruskal(Graph graph) {
		long total = 0l;
	    Arrays.sort(graph.edge);
		DisjointSet disjoinSet =  new DisjointSet();
		for(Edge edge : graph.edge){
			disjoinSet.makeSet(edge.src);
			disjoinSet.makeSet(edge.dest);
		}
		for(Edge edge : graph.edge){
			long data = disjoinSet.findSet(edge.src);
			long data1 = disjoinSet.findSet(edge.dest);
			if(data == data1){
				continue;
			}
			boolean dist = disjoinSet.union(data , data1);
			if (dist) {
				total = total + edge.weight;
			}
		}
		return total;
	}
	
}
