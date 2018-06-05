package array;

import java.util.ArrayList;
import java.util.Scanner;

public class EvenAndOddElementsAtEvenAndOddPositions {

	public static void main(String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int z=0;z<T;z++){
			int N = in.nextInt();
			ArrayList<Integer> even = new ArrayList<Integer>();
			ArrayList<Integer> odd = new ArrayList<Integer>();
			for(int i=0;i<N;i++){
				int t = in.nextInt();
				if(t%2==0)
					even.add(t);
				else odd.add(t);
			}
			int size = Math.min(even.size(),odd.size());
			int evenRemain = even.size()-size;
			int oddRemain = odd.size()-size;
			for(int i=0;i<size;i++){
				System.out.print(even.get(i)+" "+odd.get(i)+" ");
			}
			if(evenRemain>0){
				for(int i=size;i<even.size();i++){
					System.out.print(even.get(i)+" ");
				}
			}
			else{
				for(int i=size;i<odd.size();i++){
					System.out.print(odd.get(i)+" ");
				}
			}
			System.out.println();
		}
	}
}
