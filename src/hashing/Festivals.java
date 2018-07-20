package hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * lice likes festivals a lot as we all do. He also likes spending money on these festivals. He spends money in buying various things on these festivals. But he has problem of forgetting. He only remembers his top three maximum spendings for any festival.
For eg, on Holi he spends 25 units on colors, 50 units on water sprays, 100 units on gifts, 150 units on sweets but he remebers only his top 3 spendings ,i.e., 50, 100 & 150.
Now as the year ends he wants to know the festival on which he spent most of his money that he can remember.

Input Format

First line contains an integer T, denoting number of test cases.
Second line contains an integer N, denoting number of spendings in a year.
Each of the next N lines contain a string S and an integer X denoting festival name and spending on one of the events of that festival.

Output Format

For each test case, print a single line containing the festival name and its total spending that he remembers.
If there are more than 1 festival with the maximum spending, print the one which has lexiographically smallest name.


 */
public class Festivals {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i<t ; i++){
            int n = Integer.parseInt(br.readLine());
            Map<String , PriorityQueue<Integer>> map = new TreeMap<>();
            for(int j=0; j<n ; j++){
                String input[] = br.readLine().split(" ");
                if(map.get(input[0]) != null){
                   map.get(input[0]).add(Integer.parseInt(input[1]));
                }else{
                   PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
                   queue.add(Integer.parseInt(input[1]));
                    map.put(input[0] , queue);
                }
            }
            long max = 0l;
            String festival = null;
            for(Map.Entry<String , PriorityQueue<Integer>> entry : map.entrySet()){
            	int count = 0;
            	 long tempMax = 0l;
            	PriorityQueue<Integer> queue = entry.getValue();
            	while(count<3 && !queue.isEmpty()) {
            		tempMax+=queue.remove();
            		count++;
            	}
                if(tempMax > max){
                    max = tempMax;
                    festival = entry.getKey();
                }

            }
            sb.append(festival+" "+max+"\n");
            
        }
    System.out.println(sb);
    }
}
