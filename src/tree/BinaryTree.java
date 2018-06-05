package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	class Node{
		Node left;
		Node right;
		int key;
		Node(int key) {
			this.key = key;

		}
	}
	private Node prev;
	public Node lca(Node node , int n1 , int n2){
		if(node == null){
			return null;
		}
		if(node.key == n1 || node.key == n2){
			return node;
		}
		
		Node left = lca(node.left , n1 , n2);
		Node right = lca(node.right , n1  , n2);
		if(left != null && right != null){
			return node;
		}
		if(left == null && right == null){
			return null;
		}
		return left != null ? left : right; 
	}
	
	void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.key + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}

	}
	
	boolean isBST(Node root)  
    {
        if(root != null){
            if(!isBST(root.left)){
                return false;
            }
            if(prev !=null && prev.key >= root.key){
                return false;
            }
            prev = root;
            return isBST(root.right);
        }
        return true;
    }
	
	boolean hasPathSum(Node node, int sum)
    {
        if(node == null){
            return sum ==0;
        }
        else{
            boolean ans = false;
            int subSum = sum-node.key;
            if(subSum == 0 && node.left == null && node.right == null){
                return true;
            }
            if(node.left != null){
               ans = ans || hasPathSum(node.left , subSum); 
            }
            if(node.right != null){
                ans = ans || hasPathSum(node.right , subSum); 
            }
            return ans;
        }
    }
}
