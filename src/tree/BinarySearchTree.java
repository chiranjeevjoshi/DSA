package tree;

import java.util.Stack;

public class BinarySearchTree {

	class Node {
		int key;
		Node left;
		Node right;

		Node(int key) {
			this.key = key;

		}
	}

	private Node root;

	void insertKey(int key) {
		root = insertNode(root, key);
	}

	private Node insertNode(Node root, int key) {

		if (root == null) {
			return  new Node(key);
		}
		if (key <= root.key) {
			root.left = insertNode(root.left, key);
		} else {
			root.right = insertNode(root.right, key);
		}
		return root;
	}

	public int getHeight() {
		return maxDepth(root);
	}

	private int maxDepth(Node node) {
		if (node == null) {
			return 0;
		} else {

			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);
			if (lDepth > rDepth) {
				return lDepth + 1;
			} else {
				return rDepth + 1;
			}
		}
	}
	
	private Node searchRec(Node node, int key){
		
		if(node == null || node.key == key){
			return node;
		}
		
		if (key < node.key) {
			return  searchRec(node.left, key);
		} else {
			return searchRec(node.right, key);
		}
	}
	
	private Node searchKey(int key){
		Node node = root;
		while(node != null){
			
			if(node.key == key){
				break;
			}
			if(node.key > key){
				node = node.left;
			}else{
				node = node.right;
			}
		}
		return node;
	}
	
	public boolean search(int key) {
		if (searchKey(key) == null){
			return false;
		}
		return true;
	}

	public Node getRoot() {
		return root;
	}

	public Node lca(int x , int y){
		return lca(root , x , y);
	}

	private Node lca(Node root2 , int x , int y) {
		if(root2 == null){
			return null;
		}
		if(x > root2.key && y > root2.key){
			return lca(root2.right , x , y);
		}
		if(x < root2.key && y < root2.key){
			return lca(root2.left , x , y);
		}
		return root2;
	}
	 private Node bstFromPreOrder(int arr[]){
		 Stack<Node> stack = new Stack<>();
		 Node root = new Node(arr[0]);
		 stack.push(root);
		 for(int i=0 ; i<arr.length ; i++){
			 Node temp = null;
			 while (!stack.isEmpty() && stack.peek().key < arr[i] ){
				 temp = stack.pop();
			 }
			 if(temp != null){
				 temp.right = new Node(arr[i]);
				 stack.push(temp.right);
			 }else{
				 temp = stack.peek();
				 temp.left = new Node(arr[i]);
				 stack.push(temp.left);
			 }
		 }
		 return root;
	 }
	
}
