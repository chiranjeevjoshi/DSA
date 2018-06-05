package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * here is a collection of  strings ( There can be multiple occurences of a particular string ). Each string's length is no more than  characters. There are also  queries. For each query, you are given a string, and you need to find out how many times this string occurs in the given collection of  strings.


 */
public class SparseArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String , Integer> map = new HashMap<>();
		for(int i =0 ; i<n ; i++){
			String s = sc.next();
			if(map.get(s) == null){
				map.put(s , 1);
			}else{
				map.put(s , map.get(s) +1);
			}
		}
		int q = sc.nextInt();
		for(int i =0 ; i<q ; i++){
			String s = sc.next();
			if(map.get(s) != null){
				System.out.println(map.get(s));
			}else{
				System.out.println(0);
			}
		}
	}
}
