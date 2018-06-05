package array;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemoriseMe {
	/*
	 * Arijit is a brilliant boy. He likes memory games. He likes to participate
	 * alone but this time he has to have a partner. So he chooses you.
	 * 
	 * In this Game , your team will be shown N numbers for few minutes . You
	 * will have to memorize these numbers.
	 * 
	 * Now, the questioner will ask you Q queries, in each query He will give
	 * you a number , and you have to tell him the total number of occurrences
	 * of that number in the array of numbers shown to your team . If the number
	 * is not present , then you will have to say “NOT PRESENT” (without
	 * quotes).
	 * 
	 * INPUT And OUTPUT
	 * 
	 * The first line of input will contain N, an integer, which is the total
	 * number of numbers shown to your team.
	 * 
	 * The second line of input contains N space separated integers .
	 * 
	 * The third line of input contains an integer Q , denoting the total number
	 * of integers.
	 * 
	 * The Next Q lines will contain an integer denoting an integer, B i Bi ,
	 * for which you have to print the number of occurrences of that number ( B
	 * i Bi) in those N numbers on a new line.
	 * 
	 * If the number B i Bi isn’t present then Print “NOT PRESENT” (without
	 * quotes) on a new line.
	 */
	public static void main(String[] args) throws Exception {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		StringBuilder sb = new StringBuilder();

		br.readLine();
		String temp[] = br.readLine().split(" ");
		int arr[] = new int[100000];
		for (String s : temp) {
			arr[Integer.parseInt(s)]++;
		}
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			int q = Integer.parseInt(br.readLine());
			if (arr[q] == 0) {
				sb.append("NOT PRESENT\n");
			} else {
				sb.append(arr[q] + "\n");
			}
		}

		out.write(sb.toString().getBytes());
		out.flush();
	}

}
