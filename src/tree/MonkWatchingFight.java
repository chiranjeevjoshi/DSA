package tree;

import java.util.Scanner;

public class MonkWatchingFight {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n  = sc.nextInt();
			BinarySearchTree bst = new BinarySearchTree();
			for(int i = 0 ; i<n ; i++){
				bst.insertKey(sc.nextInt());
			}
			System.out.println(bst.getHeight());
	}
}
