package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * You are the king of Pensville where you have 
2
N
2N workers. 
All workers will be grouped in association of size 
2
2,so a total of 
N
N associations have to be formed. 
The building speed of the 
i
t
h
ith worker is 
A
i
Ai. 
To make an association, you pick up 
2
2 workers. Let the minimum building speed between both workers be 
x
x, then the association has the resultant building speed 
x
x. 
You have to print the maximum value possible of the sum of building speeds of 
N
N associations if you make the associations optimally.
 */
public class MaximumSumofBuildingSpeed {

	public static void main(String args[] ) throws Exception {
	      Scanner sc = new Scanner(System.in);
	      int n = sc.nextInt();
	      List<Integer> list = new ArrayList<>();
	      for(int i=0 ; i<2*n ; i++){
	          list.add(sc.nextInt());
	      }
	        Collections.sort(list);
	        int total = list.get(0);
	        for(int i =2 ; i<2*n ; i++){
	        	total+= list.get(i);
	        	i++;
	        }
	        System.out.println(total);
	    }
}
