package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * There are 
N
N balls in a row. The 
i
t
h
ith ball has color 
A
i
Ai. You have to destroy all of the balls by using the following operation any number of times.

Operation: Let the current number of balls be 
k
k. All the balls of color 
k
k are destroyed at the same moment. Given the different scenarios, tell whether you will be able to destroy all the balls or not.

Input Format:
First line contains 
t
t, the number of test cases. 
Each of the test case contains an integer 
N
N, the number of balls. 
Next line contains 
N
N space separated integers corresponding to the color of balls.

Output Format: 
For each test case, print “YES”(without quotes) if all balls can be destroyed otherwise “NO”.
 */
public class DestroyingBalls {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0 ; i< t ; i++){
			Map<Integer , Integer> map =  new HashMap<>();
			int n =  sc.nextInt();
			for(int j=0 ; j <n ; j++){
				int val = sc.nextInt();
				if(map.get(val) == null){
					map.put(val , 1);
				}else{
					map.put(val , map.get(val)+1);
				}
			}
			while(map.size() > 0){
				Integer count = map.remove(n);
				if( count != null){
					n = n - count;
				}else{
					break;
				}
			}
			if(n==0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		sc.close();
	}
}
