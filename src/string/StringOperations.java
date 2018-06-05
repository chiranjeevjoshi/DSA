package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringOperations {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder(s);
		int q = Integer.parseInt(br.readLine());
		for(int i =0 ; i<q ;i++){
			String input[] = br.readLine().split(" ");
			int indices = Integer.parseInt(input[0]);
			sb.setCharAt(indices-1, input[1].charAt(0));
		}
		System.out.println(sb);
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb1 = new StringBuilder(sb);
		StringBuilder sb2 = new StringBuilder(sb);
		char s3[] = sb2.toString().toCharArray();
		for(int i =0 ; i<m ;i++){
			String input[] = br.readLine().split(" ");
			int startIndex = Integer.parseInt(input[0]);
			int lastIndex = Integer.parseInt(input[1]);
			int range = lastIndex;
			for(int j=startIndex-1 ; j< lastIndex ; j++){
				sb1.setCharAt(--range, s3[j]);
			}
			sb2=sb1;
		}
		System.out.println(sb1);
		int count=0;
		for(int i=0;i<sb.length();i++){
			if(sb.charAt(i) == sb1.charAt(i)){
				count++;
			}
		}
		System.out.println(count);
		
	}
}
