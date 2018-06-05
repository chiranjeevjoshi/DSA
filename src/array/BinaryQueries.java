package array;

import java.util.Scanner;

/*Some problems appear hard though they are very easy. Today Aakash is stuck in a range query problem. He has been given an array with only numbers 0 and 1. There are two types of queries -

0 L R : Check whether the number formed from the array elements L to R is even or odd and print EVEN or ODD respectively. Number formation is the binary number from the bits status in the array L to R

1 X : Flip the Xth bit in the array 

Indexing is 1 based

Input
First line contains a number N and Q as input. Next line contains N space separated 0 or 1. Next Q lines contain description of each query 

Output
Output for only query type 0 L R whether the number in range L to R is "EVEN" or "ODD" (without quotes).

Constraints
1≤ N ≤ 10^6 
1≤ L ≤ R ≤ 10^6 
1≤ Q ≤ 10^6

1≤ X ≤ N*/
public class BinaryQueries {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = scan.nextInt();
		int q = scan.nextInt();
		boolean b[] = new boolean[n];
		for(int i =0 ; i<n ;i++){
			b[i] = scan.nextInt() == 0 ? false : true;
		}
		for(int i = 0 ;i<q ; i++){
			int type = scan.nextInt();
			if(type == 1){
				int flipIndex = scan.nextInt();
				b[flipIndex-1] = !b[flipIndex-1];
			}else{
				int l = scan.nextInt();
				int r = scan.nextInt();
				if(!b[r-1]){
					sb.append("EVEN\n");
				}else{
					sb.append("ODD\n");
				}
			}
		
		}
		scan.close();
		System.out.println(sb);
	}
}
