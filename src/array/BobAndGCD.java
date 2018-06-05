package array;

import java.util.Scanner;

public class BobAndGCD {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		for(int i = 0 ; i<test ; i++){
			int k = s.nextInt();
			int n = s.nextInt();
			int arr [] = new int[n];
			int min = k/2;
			for(int j = 0 ; j<n ; j++){
				arr [j] = s.nextInt();
			}
			int count = 0;
			if(k > 1){
				for(int j = 0 ; j< n ; j++){
					if((arr[j] % k) >min){
						count = count + k - (arr[j] % k);
					}else{
						count = count + (arr[j] % k);
					}
				}
			}
			
			System.out.println(count);
		}
	}
}
