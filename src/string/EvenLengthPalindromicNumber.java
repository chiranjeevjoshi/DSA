package string;

import java.util.Scanner;

public class EvenLengthPalindromicNumber {
	
 public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int j=0; j<t;j++){
			
			char arr[] = String.valueOf(sc.nextLong()).toCharArray();
			long a[] = new long[10];
			for(int i=0 ; i<arr.length;i++){
				a[(int)arr[i]-48]++;
			}
			
			long maxNumber = 0l;
			int number = 0;
			for(int i =0 ;i<a.length; i++){
			
				if(a[i] > maxNumber){
					maxNumber = a[i];
					number = i;
				}
			}
			System.out.println(number);
		}

}
}
