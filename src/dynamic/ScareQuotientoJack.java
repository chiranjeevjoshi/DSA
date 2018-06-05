package dynamic;

import java.util.Scanner;

public class ScareQuotientoJack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t ; i++){
			int n = sc.nextInt();
			int arr[] = new int[n];
			int temp[] = new int[n];
			for(int j = 0 ; j<n ; j++){
				arr[j] = sc.nextInt();
			}
			temp[0] = 1;
			for(int j = 1 ; j<n ; j++){
					int max = 1;
					int count = 0;
					for(int k = 0 ; k<=j ; k++){
						if(arr[j] >= arr[k]){
							count++;
						}else{
							count=0;
							max=0;
						}
						if(max<count){
							max = count;
						}
					}
					temp[j] = max;
			}
			for(int j : temp){
				System.out.print(j +" ");
			}
			System.out.println();
					
		}
	
	}
}
