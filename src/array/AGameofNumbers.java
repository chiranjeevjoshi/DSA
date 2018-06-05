package array;

import java.util.Scanner;

public class AGameofNumbers {

	/*
	 * You are given an array A [ ] A[] of N N integers. Now, two functions F (
	 * X ) F(X) and G ( X ) G(X) are defined:
	 * 
	 * F ( X ) F(X) : This is the smallest number Z Z such that X < Z ≤ N X<Z≤N
	 * and A [ X ] < A [ Z ] A[X]<A[Z]
	 * 
	 * G ( X ) G(X) : This is the smallest number Z Z such that X < Z ≤ N X<Z≤N
	 * and A [ X ] > A [ Z ] A[X]>A[Z]
	 * 
	 * Now, you need to find for each index i i of this array G ( F ( i ) )
	 * G(F(i)), where 1 ≤ i ≤ N 1≤i≤N . If such a number does not exist, for a
	 * particular index i i, output − 1 −1 as its answer. If such a number does
	 * exist, output A [ G ( F ( i ) ) ] Sample Input 8 3 7 1 7 8 4 5 2
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		int arr[] = new int[n];
		for(int i=0 ; i<n ; i++){
			arr[i] = scan.nextInt();
		}
		for(int i = 0 ;i<n; i++){
			int isMin = 0;
			int isMax = 0;
			for(int j=i+1 ;j<n;j++){
				if(arr[j]>arr[i]){
					isMin++;
					for(int k =j+1 ;k<n ; k++){
						if(arr[k]<arr[j]){
							sb.append(arr[k]+" ");
							isMax++;
							break;
						}
					}
					break;
				}
				
				
			}
			if(isMax == 0 || isMin == 0){
					sb.append(-1+" ");
				}
		}
		System.out.println(sb);
	}
}
