package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reunionof1s {

	 public static void main(String args[] ) throws Exception {

			// Scanner
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			int arr[] = new int[n];
			char input[] =br.readLine().toCharArray();
			arr[0] = input[0] - 48;
			for(int i = 1 ; i<input.length ; i++){
				arr[i] = input[i] - 48;
			}
			for (int i = 0; i < q; i++) {
				s = br.readLine().split(" ");
				int type = Integer.parseInt(s[0]);
				if (type == 2) {
					int index = Integer.parseInt(s[1]);
					if(arr[index-1] == 0){
						arr[index-1] = 1;
					}
					
				} else {
					int count = 0, tempCount = 0;
					for (int j = 0; j < n; j++) {
						if (arr[j] == 1) {
							tempCount++;
						} else {
							if (tempCount > count) {
								count = tempCount;
							}
							tempCount = 0;
						}
					}
					if (tempCount > count) {
						count = tempCount;
					}
					System.out.println(count);
				}
			}


		}
}
