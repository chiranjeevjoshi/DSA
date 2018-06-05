package dynamic;

import java.util.Scanner;

public class CoinChange {


	   
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n,m, c);
        System.out.print(ways);
    }
    
    static long getWays(int n , int m , long []c){
        long arr[][] = new long[m+1][n+1];
        for(int i=0 ;i<=m ;i++){
            arr[i][0] =1;
        }
        for(int i = 1 ; i<=m ; i++){
            for(int j =1 ; j<=n ; j++){
                if(c[i-1]<=j){
                    arr[i][j] = arr[i][(int) (j-c[i-1])]+arr[i-1][j];
                }else{
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        return arr[m][n];
    }
}
