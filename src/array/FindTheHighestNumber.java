package array;

import java.util.Scanner;

/*
 * Given an array in such a way that the elements stored in array are in increasing order initially and then after reaching to a peak element , elements stored are in decreasing order. Find the highest element.
 */
public class FindTheHighestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t ; i++){
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int j = 0 ;j <n ; j++){
				arr[j] = sc.nextInt();
			}
			for(int j = 0 ;j <n-1 ; j++){
				if(arr[j+1]<arr[j]){
					System.out.println(arr[j]);
					break;
				}
			}
		}
	}
}
