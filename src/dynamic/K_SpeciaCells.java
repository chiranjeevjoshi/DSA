package dynamic;

import java.util.Scanner;
/*
 * You are given a N×M matrix which has K special cells in it. You have to reach (N,M) from (1,1). From any cell, you can only move rightwards or downwards.
The K−special cells are those cells in this grid which have special strength at them. ith special cell has P[i] units of strength and if you travel through this cell, you store the strength.
Find the total strength you can store after travelling through all the possible paths in the grid to reach cell (N,M).

Note:
The strength of a path is the sum of strength P[i] of all the special cells that are visited in this path.
The cells that are not special have power quotient equals to zero.
 */
public class K_SpeciaCells {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i =0 ; i<t ; i++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k =  sc.nextInt();
			int cellMatrix[][] = new int[n][m];
			for(int j =0 ; j<k ; j++){
				cellMatrix[sc.nextInt()-1][sc.nextInt()-1] = sc.nextInt();
			}
			int finalMatrix[][] = new int[n+1][m+1];
			for(int j =1 ; j<=n ; j++){
				for(int l =1; l<=m ; l++){
					finalMatrix[j][l] = (cellMatrix[j-1][l-1]+finalMatrix[j-1][l]+finalMatrix[j][l-1])%1000000007;
				}
			}
			System.out.println(finalMatrix[n][m]);
		}
		
	}
}
