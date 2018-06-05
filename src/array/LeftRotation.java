package array;

import java.util.Scanner;

/*
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform). 
The second line contains  space-separated integers describing the respective elements of the array's initial state.
 */
public class LeftRotation {
    static int[] leftRotation(int[] a, int d) {
        int[] arr = new int[d];
        for(int i=0 ; i<d ; i++){
            arr[i] = a[i];
        }
        for(int i=0;i<a.length-d ; i++){
            a[i] = a[i+d];
        }
        
        for(int i=0 ; i<d ; i++){
            a[(a.length-d)+i] = arr[i] ;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
