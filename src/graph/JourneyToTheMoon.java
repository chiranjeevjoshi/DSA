package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
 * The member states of the UN are planning to send  people to the Moon. But there is a problem. In line with their principles of global unity, they want to pair astronauts of  different countries.

There are  trained astronauts numbered from  to . But those in charge of the mission did not receive information about the citizenship of each astronaut. The only information they have is that some particular pairs of astronauts belong to the same country.

Your task is to compute in how many ways they can pick a pair of astronauts belonging to different countries. Assume that you are provided enough pairs to let you identify the groups of astronauts even though you might not know their country directly. For instance, if  are astronauts from the same country; it is sufficient to mention that  and  are pairs of astronauts from the same country without providing information about a third pair . 
 */
public class JourneyToTheMoon {

    public static void main(String[] args) throws InterruptedException {
		Scanner x = new Scanner(System.in);
		int N, P;
		N = x.nextInt();
		P = x.nextInt();
		
		Graph g = new Graph(N);
		for (int i = 0; i < P; i++) {
			g.addEdge(x.nextInt(), x.nextInt());
		}
		System.out.println(g.solve());
		x.close();
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
    	
    	public ArrayList<Integer> traversal(){
    		ArrayList<Integer> countrySizes = new ArrayList<>();
    		for (int i = 0; i < visited.length; i++) {
    			if(!visited[i])
    				countrySizes.add(DFS(i));
    		}
    		return countrySizes;
    	}
    	
    	public long solve() {
    		ArrayList<Integer> countrySizes = traversal();
    		long sum = 0, result=0;
    		for(int size : countrySizes){
    		   result += sum*size;
    		   sum += size;    
    		 }   
    		return result;
    	}

    }
}


