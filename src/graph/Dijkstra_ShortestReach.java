package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * Given a graph consisting  nodes (labelled  to ) where a specific given node  represents the starting position  and an edge between two nodes is of a given length, which may or may not be equal to other lengths in the graph.

It is required to calculate the shortest distance from the start position (Node ) to all of the other nodes in the graph.

Note: If a node is unreachable , the distance is assumed as .

Input Format

The first line contains , denoting the number of test cases. 
First line of each test case has two integers , denoting the number of nodes in the graph and , denoting the number of edges in the graph.

The next  lines each consist of three space-separated integers   , where  and  denote the two nodes between which the undirected edge exists,  denotes the length of edge between these corresponding nodes.

The last line has an integer , denoting the starting position.

Constraints 
 
 
 
 

If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

Output Format

For each of the  test cases, print a single line consisting  space separated integers denoting the shortest distance of  nodes other than  from starting position  in increasing order of their labels.

For unreachable nodes, print .
 */
public class Dijkstra_ShortestReach {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    
	public static void main(String[] args) throws IOException  {
		int  t=Integer.parseInt(br.readLine());
		for (int a0 = 0; a0 < t; a0++) {
			st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
			int graph[][] = new int[n][n];
			for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    graph[i][j]=Integer.MAX_VALUE;
                }
            }
			for (int a1 = 0; a1 < m; a1++) {
				st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken())-1;
                int y=Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken());
                if(graph[x][y]>r || graph[y][x]>r){
                	graph[x][y] = r;
    				graph[y][x] = r;
                }
				
			}
			int s = Integer.parseInt(br.readLine())-1;
			int dist[] = dijkstra(graph, s, n);
			 for(int i=0;i<n;i++)
	            {
	                if(i!=s)
	                {
	                    if(dist[i]==Integer.MAX_VALUE) System.out.print("-1 ");
	                    else System.out.print(dist[i]+" ");
	                }
	            }
	            System.out.println();
		}
		
	}

	private static int[] dijkstra(int[][] graph, int s, int n) {
		int dist[] = new int[n];
		boolean visit[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			visit[i] = false;
		}
		dist[s] = 0;
		for (int i = 0; i < n - 1; i++) {
			int u = findMin(dist, visit);
			visit[u] = true;
			for (int j = 0; j < n; j++) {
				if (graph[u][j] != Integer.MAX_VALUE && !visit[j] && dist[u] != Integer.MAX_VALUE
						&& dist[j] > graph[u][j] + dist[u]) {
					dist[j] = dist[u] + graph[u][j];
				}
			}
		}
		return dist;
	}

	private static int findMin(int[] dist, boolean[] visit) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = 0; i < visit.length; i++) {
			if (!visit[i] && dist[i] <= min) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
