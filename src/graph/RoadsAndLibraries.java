package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/*
 * The Ruler of HackerLand believes that every citizen of the country should have access to a library. Unfortunately, HackerLand was hit by a tornado that destroyed all of its libraries and obstructed its roads! As you are the greatest programmer of HackerLand, the ruler wants your help to repair the roads and build some new libraries efficiently.

HackerLand has  cities numbered from  to . The cities are connected by  bidirectional roads. A citizen has access to a library if:

Their city contains a library.
They can travel by road from their city to a city containing a library.
The following figure is a sample map of HackerLand where the dotted lines denote obstructed roads:

image

The cost of repairing any road is  dollars, and the cost to build a library in any city is  dollars.

You are given  queries, where each query consists of a map of HackerLand and value of  and .

For each query, find the minimum cost of making libraries accessible to all the citizens and print it on a new line.

Input Format

The first line contains a single integer, , denoting the number of queries. The subsequent lines describe each query in the following format:

The first line contains four space-separated integers describing the respective values of  (the number of cities),  (the number of roads),  (the cost to build a library), and  (the cost to repair a road).
Each line  of the  subsequent lines contains two space-separated integers,  and , describing a bidirectional road connecting cities  and .

 */
public class RoadsAndLibraries {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			long lCost = sc.nextLong();
			long rCost = sc.nextLong();

			Graph g = new Graph(v);
			for (int j = 0; j < e; j++) {
				g.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
			}
			if (rCost >= lCost) {
				System.out.println(lCost * v);
			} else {
				System.out.println(g.solve(lCost, rCost));
			}
		}
		sc.close();
	}
    
    static class Graph{
    	static int V;
    	static boolean visited[];
    	HashMap<Integer, ArrayList<Integer>> graph;
    	Graph(int V){
    		this.V = V;
    		visited = new boolean[V];
    		graph = new HashMap<>();
    		for (int i = 0; i < V; i++) {
    			graph.put(i, new ArrayList<>());
    		}
    	}
    	
    	public void addEdge(int s, int d) {
    		graph.get(s).add(d);
            graph.get(d).add(s);
    	}
    	
    	public int DFS(int s) {
    		int count = 1;
    		visited[s] = true;
    		for (Integer i : graph.get(s)) {
    			if(!visited[i]) {
    				count+=DFS(i);
    			}
    		}
    		return count;
    	}
    	
    	public List<Integer> traversal(){
    		ArrayList<Integer> countrySizes = new ArrayList<>();
    		for (int i = 0; i < visited.length; i++) {
    			if(!visited[i])
    				countrySizes.add(DFS(i));
    		}
    		return countrySizes;
    	}
    	
    	public long solve(long lCost , long rCost) {
    		List<Integer> countrySizes = traversal();
    		long  result=0l;
    		for(long size : countrySizes){
    			if(size > 0)
    		   result += (size-1)*rCost + lCost;
    		 }   
    		return result;
    	}

    }
}
