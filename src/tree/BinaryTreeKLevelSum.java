package tree;

import java.util.Scanner;

/*
 * Given a binary tree and a number K, the task is to find sum of tree nodes at level k. The Binary Tree s given in string form: (node-value(left-subtree)(right-subtree)).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer K denoting level of Binary Tree for which we need sum. Next line is string which represents Binary Tree.
 */
public class BinaryTreeKLevelSum {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i =0 ;i<t ; i++){
			int l  = sc.nextInt();
			String tree = sc.next();
			int level =-1;
			int total = 0;
			for(int j =0 ; j <tree.length() ;j++){
				if(tree.charAt(j) == '('){
					level++;
				}else if(tree.charAt(j) == ')'){
					level --;
				}else if(level == l){
					int nCurrent = 0;
	                while(Character.isDigit(tree.charAt(j))){
	                    nCurrent*=10;
	                    nCurrent+=Character.getNumericValue(tree.charAt(j));
	                    j++;
	                }
	                j--;
	                total+=nCurrent;
				}
			}
			System.out.println(total);
		}
	}
}
