package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tree.BinarySearchTree.Node;

public class MonkAndCursedTree {
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		BinarySearchTree bst = new BinarySearchTree();
		for(int i = 0 ; i<input.length ; i++){
			bst.insertKey(Integer.parseInt(input[i]));
		}
		String path[] = br.readLine().split(" ");
		int x = Integer.parseInt(path[0]);
		int y = Integer.parseInt(path[1]);
		Node node = bst.lca(x, y);
		System.out.println(Math.max(getMax(node , x), getMax(node , y)));
	}
	
	static int getMax(Node node , int x){
		int max = x;
		while(node.key !=x){
			if(node.key> x){
				node = node.left;
			}else{
				node = node.right;
			}
			max = Math.max(max, node.key);
		}
		
		return max;
	}
	
}
