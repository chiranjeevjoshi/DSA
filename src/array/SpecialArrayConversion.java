package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * You are given an array 
A
A. Now you need to convert this array into special array which has the following characteristics. 
1. All prime numbers come before all non prime numbers in the special array even if they are greater
2. All prime numbers are sorted in increasing order
3. All non prime numbers are sorted in decr
easing order 

For example let the array 
A
A is 
1
,
4
,
3
,
2
,
6
1,4,3,2,6 then the array after special sorting will become 
2
,
3
,
6
,
4
,
1
2,3,6,4,1. Note that 
1
1 is not a prime number. Here 
2
2 and 
3
3 are prime so they are sorted in increasing order and 
6
,
4
,
1
6,4,1 are non prime so they are sorted in decreasing order. Also all the prime numbers come before non prime

Input
First line contains an integer 
N
N as input denoting total elements in the array 
A
A. Next line contains 
N
N space separated integers that denotes the element of array 
A
A.

Output
In the output you need to print the array elements separated by space after it is specially sorted. 


 */
public class SpecialArrayConversion {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<Integer> primeList= new ArrayList<>();
	    List<Integer> nonPrimeList = new ArrayList<>();
	    SortedSet<Integer> primeSet = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.intValue() == o2.intValue()){
					return 1;
				}
				return o1.intValue() - o2.intValue() ;
			}
		});
	    
	    SortedSet<Integer> nonPrimeSet = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.intValue() == o2.intValue()){
					return 1;
				}
				return o2.intValue() - o1.intValue() ;
			}
		});
	   String arr[] = br.readLine().split(" ");
 		for(int i = 0 ; i <arr.length ;i++){
		    int val = Integer.parseInt(arr[i]);
		    if(isPrime(val)){
		    	primeSet.add(val);
		    }else{
		    	nonPrimeSet.add(val);
		    }
		}
		for(int val : primeSet){
		    sb.append(val+" ");
		}
		for(int val : nonPrimeSet){
		    sb.append(val+" ");
		}
        System.out.println(sb);
    }
	

	 public static boolean isPrime(int n) {
	        if (n <= 1 )
	            return false;
	        if (n == 2) 
	            return true;
	        if (n % 2 == 0)
	            return false;
	        for(int i = 3; i <= Math.sqrt(n); i+=2) {
	            if(n % i == 0)
	                return false;
	        }
	        return true;
		 }
	
}
