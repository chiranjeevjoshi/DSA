package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;
/*
 * You are given  rectangles each with length  and breadth . Now you have to arrange them in non-decreasing order of their lengths. If length of two rectangles is same then the one with the largest area should be placed first. Print the final arrangement of the rectangles.

Input
First line contains an integer  as input denoting total number of rectangles.
Next  lines contain two space separated integers each denoting length and breadth of the subsequent rectangles.

Output
In the output you need to print  lines where each line contains the length and breadth of the rectangle as they would look in the final arrangement according to the conditions given above.
 */
public class AligningTheRectangles {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder  sb = new StringBuilder();
        TreeMap<Integer , PriorityQueue<Integer>> treeMap = new TreeMap<>();
        for(int i=0 ; i<t ; i++) {
        	String input[] = br.readLine().split(" ");
        	int x= Integer.parseInt(input[0]);
        	int y = Integer.parseInt(input[1]);
        	if(treeMap.get(x) == null) {
        		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        		queue.add(y);
        		treeMap.put(x, queue);
        	}else {
        		 treeMap.get(x).add(y);
        	}
        }
//        for(Map.Entry<Integer , PriorityQueue<Integer>> entry : treeMap.entrySet()) {
//        	PriorityQueue<Integer>  queue = entry.getValue();
//        	int x = entry.getKey();
//        	while(!queue.isEmpty()) {
//        		sb.append(x+" "+queue.remove()+"\n");
//        	}
//        }
		treeMap.forEach((k, v) -> {
			while (!v.isEmpty()) {
				sb.append(k + " " + v.remove() + "\n");
			}
		});
        System.out.println(sb);
	}
}
