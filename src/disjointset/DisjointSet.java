package disjointset;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
	
	private Map<Long , Node> nodeMap = new HashMap<>();
	
	class Node {
		long data;
		Node parent;
		int rank;
	}
	
	
	public void makeSet(long data){
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		nodeMap.put(data, node);
	}
	
	public boolean union(long data1 , long data2){
		Node node1 = nodeMap.get(data1);
		Node node2 = nodeMap.get(data2);
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		if(parent1.data == parent2.data){
			return false;
		}
		if(parent1.rank >= parent2.rank){
			parent1.rank = parent1.rank == parent2.rank ? parent1.rank+1 : parent1.rank;
			parent2.parent = parent1;
		}else{
			parent1.parent = parent2;
		}
		return true;
	}
	
	private Node findSet(Node node) {
	    Node parent = node.parent;
	    if(node == parent){
	    	return parent;
	    }else{
	    	Node temp = node;
	    	Node parentTemp = parent;
	    	while(temp != parentTemp){
	    		temp = node.parent;
	    		parent = temp.parent;
	    	}
	    	node.parent = parent;
	    }
	    // node.parent = findSet(node.parent);
		return parent;
	}
	
	public long findSet(long data) {
        return findSet(nodeMap.get(data)).data;
    }
}
