package graph;

import java.util.Scanner;
/*
 * Our Code Monk recently learnt about Graphs and is very excited!

He went over to the Graph-making factory to watch some freshly prepared graphs. Incidentally, one of the workers at the factory was ill today, so Monk decided to step in and do her job.

The Monk's Job is to Identify whether the incoming graph is a tree or not. He is given N, the number of vertices in the graph and the degree of each vertex.

Find if the graph is a tree or not.

Input:
First line contains an integer N, the number of vertices.
Second line contains N space-separated integers, the degrees of the N vertices.

Output:
Print "Yes" (without the quotes) if the graph is a tree or "No" (without the quotes) otherwise.
 */
public class MonkAtTheGraphFactory {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum =0;
		for(int i=0; i < n ; i++) {
			sum=sum+sc.nextInt();
		}
		if(sum/2 == n-1) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
