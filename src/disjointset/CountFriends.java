package disjointset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * There are N students and M relationships of the form u v, which means that student u and student v are friends. If two students are not friends directly but they have a mutual friend, then they too become friends. Your task is to count the number of friends of the  student where .

Input:
The first line consists of two integers N and M denoting the number of students and the number of relationships respectively.
The next M lines consists of two integers u and v denoting that student u and student v are friends. u and v can never be equal and relationships are not repeated.

Output:
Print N space separated integers which tells us the number of friends of the  student.
 */
public class CountFriends {

	private Map<Long, Node> nodeMap = new HashMap<>();

	class Node {
		long data;
		Node parent;
		int height;
	}

	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.height = 1;
		nodeMap.put(data, node);
	}

	public boolean union(long data1, long data2) {
		Node node1 = nodeMap.get(data1);
		Node node2 = nodeMap.get(data2);
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		if (parent1.data == parent2.data) {
			return false;
		}

		if (parent1.height >= parent2.height) {
			parent1.height = parent1.height + parent2.height;
			parent2.parent = parent1;
		} else {
			parent2.height = parent1.height + parent2.height;
			parent1.parent = parent2;
		}
		return true;
	}

	private Node findSet(Node node) {
		Node parent = node.parent;
		if (parent == node) {
			return parent;
		}
		node.parent = findSet(node.parent);
		return node.parent;
	}

	public long findSet(long data) {
		return findSet(nodeMap.get(data)).data;
	}

	public Node findNode(long data) {
		return findSet(nodeMap.get(data));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		CountFriends set = new CountFriends();
		for (int i = 1; i <= n; i++) {
			set.makeSet(i);
		}
		for (int i = 0; i < m; i++) {
			set.union(sc.nextInt(), sc.nextInt());
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(set.findNode(i).parent.height - 1 + " ");
		}
	}
} 
