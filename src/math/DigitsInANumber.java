package math;

import java.util.Scanner;

public class DigitsInANumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i <t ; i++){
			long q =  sc.nextLong();
			long number = 3l;
			long j=1;
			while(number < q){
				number = number +  (long)Math.pow(3, j+1);
				j++;
			}
			System.out.println(j);
		}
	}
}
