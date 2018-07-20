package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
/*
 * You are given flights route map of a country consisting of N cities and M undirected flight routes. Each city has an airport and each airport can work as layover. The airport will be in two states, Loading and Running. In loading state, luggage is loaded into the planes. In the running state, planes will leave the airport for the next city. All the airports will switch their states from Loading to Running and vice versa after every T minutes. You can cross a city if its airport state is running. Initially, all the airports are in running state. At an airport, if its state is loading, you have to wait for it to switch its state to running. The time taken to travel through any flight route is C minutes. Find the lexicographically smallest path which will take the minimum amount of time (in minutes) required to move from city X to city Y.

It is guaranteed that the given flight route map will be connected. Graph won't contain multiple edges and self loops. A self loop is an edge that connects a vertex to itself.

Input Format:
The first line contains 4 space separated integers, N, M, T and C. Next M lines contains two space separated integers each, U and V denoting that there is a bidirectional road between city U and city V. Next line contains two space separated integers, X and Y.

Output Format:
In the first line print an integer K, denoting the number of city you need to go through to reach city Y from the city X. In next line, print K space separated integers denoting the path which will take the minimum amount of time (in minutes) required by to move from city X to city Y. There can be multiple paths. Print the lexicographically smallest one.
 */
public class TheFlightPlan {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int graph[][] = new int[n][n];
		boolean visit[] = new boolean[n];
		int parent[] = new int[n];
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i =0 ; i<m ;i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0])-1;
			int y = Integer.parseInt(input[1])-1;
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		input = br.readLine().split(" ");
		int s = Integer.parseInt(input[0])-1;
		 int d = Integer.parseInt(input[1]);
		queue.add(s);
		visit[s] = true;
		while(!queue.isEmpty()) {
			int v = queue.remove();
			for(int i = 0 ; i<n ; i++) {
				if(graph[v][i] ==1 && !visit[i]) {
					queue.add(i);
					visit[i] = true;
					parent[i] = v;
					if(i==d-1) {
						queue = new LinkedList<>();
						break;
					}
				}
			}
		}
		int child = d-1;
		int size = 0;
		parent[s] = -1;
		String sb = new String();
		while(child>=0) {
				sb = child+1 +" "+sb;
				size++;
				child = parent[child];
		}
		System.out.println(size);
		System.out.println(sb.trim());
		 
	}
}
