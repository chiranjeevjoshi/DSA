package dynamic;

import java.util.Scanner;

/*
 * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children sit in a line (their positions are fixed), and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies given to the children
 */
public class Candies {

	static long candies(int n, int[] arr) {
        long candies[] = new long[n];
        candies[0]=1l;
        for(int i=1 ; i<n; i++){
            if(arr[i]>arr[i-1]){
                candies[i] = candies[i-1]+1;
            }else{
                candies[i]=1;
            }
        }
        for(int i = n-2;i>=0 ;i--){
            if(arr[i] > arr[i+1] && ((candies[i+1]+1) > candies[i])){
                candies[i] =candies[i+1]+1;
            }
        }
        long total =0l;
        for(int i=0 ; i<n;i++){
            total+=candies[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
