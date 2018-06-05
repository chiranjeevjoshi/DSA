package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/*
 * Monk is standing at the door of his classroom. There are currently N students in the class, i'th student got Ai candies.
There are still M more students to come. At every instant, a student enters the class and wishes to be seated with a student who has exactly the same number of candies. For each student, Monk shouts YES if such a student is found, NO otherwise.

Input:
First line contains an integer T. T test cases follow.
First line of each case contains two space-separated integers N and M.
Second line contains N + M space-separated integers, the candies of the students.

Output:
For each test case, output M new line, Monk's answer to the M students.
Print "YES" (without the quotes) or "NO" (without the quotes) pertaining to the Monk's answer.


 */
public class MonkAndHisFriends {
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i< t ; i++){
			String input[] = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			Map<Long , String> map = new HashMap<>();
			 input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++){
				map.put(Long.parseLong(input[j]), "YES");
			}
			for(int j=n ; j<m+n ; j++){
				long val = Long.parseLong(input[j]);
				if(map.get(val)!=null){
					sb.append("YES \n");
				}else{
						sb.append("NO \n");
					map.put(val,"YES");
				}
			}
		}
		System.out.println(sb);
	}
}
