package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CompareStrings {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        String a = br.readLine();
        String b = br.readLine();
        StringBuilder sb = new StringBuilder(b);
        StringBuilder output = new StringBuilder();
        boolean flag = false;
        for(int i=0 ; i<q ; i++){
        	int index = Integer.parseInt(br.readLine())-1;
        	if(!flag){
        		sb.setCharAt(index, '1');
            	b = sb.toString();
            	output.append(b.compareTo(a) >=0 ? "YES" : "NO").append("\n");
        	}else{
        		output.append("YES \n");
        	}
        	
        }
        System.out.println(output);
	}
}
