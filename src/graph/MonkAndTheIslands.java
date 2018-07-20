package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
/*
 * Monk visits the land of Islands. There are a total of N islands numbered from 1 to N. Some pairs of islands are connected to each other by Bidirectional bridges running over water.
Monk hates to cross these bridges as they require a lot of efforts. He is standing at Island #1 and wants to reach the Island #N. Find the minimum the number of bridges that he shall have to cross, if he takes the optimal route.

Input:
First line contains T. T testcases follow.
First line of each test case contains two space-separated integers N, M.
Each of the next M lines contains two space-separated integers X and Y , denoting that there is a bridge between Island X and Island Y.

Output:
Print the answer to each test case in a new line.
 */
public class MonkAndTheIslands {
	public static void main(String[] args) throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0 ;i <t ; i++){
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int graph[][] = new int[n][n];
			int result[] = new int[n];
			boolean visit[] = new boolean[n];
			for(int j =0 ; j<m ; j++){
				input = br.readLine().split(" ");
			    int x =Integer.parseInt(input[0])-1;
			    int y = Integer.parseInt(input[1])-1;
				graph[x][y] = 1;
				graph[y][x] = 1;
			}
			Deque<Integer> queue = new LinkedList<>();
			queue.add(0);
			visit[0] = true;
			while(!queue.isEmpty()){
				int v = queue.pop();
				for(int j =0 ; j<n ; j++){
					if (graph[v][j] == 1 && !visit[j]) {
						result[j] = result[v] + 1;
						if(j==n-1){
							 queue = new LinkedList<>(); 
						    break;
						   
						}
						queue.add(j);
						visit[j] = true;
					}
				}
			}
			sb.append(result[n-1]+"\n");
		}
		System.out.println(sb);
	}
}
