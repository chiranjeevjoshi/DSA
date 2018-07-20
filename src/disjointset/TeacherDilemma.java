package disjointset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * Monk is having a hard time teaching the  standard students. He wants to divide the students into small groups so that he can conduct some fun-filled activities for them. But students also want their friends in the same group. So, if student A is a friend of student B, and student B is a friend of student C, then the students A,B and C must be in the same group, otherwise they will start crying. After dividing the students, he will choose a leader from each group who will lead their respective groups. Now he wants to know the number of ways he can choose the group leaders from all the groups. Print this answer modulo .

Note: Two ways A and B will be considered different if at least 1 person is a leader in group A, and is not a leader in group B, or vice-versa.

Input:
The first line consists of two integers N and M denoting the number of students and the number of relationships respectively. The next M lines consists of two integers u and v denoting that student u and student v are friends. u and v can never be equal and relationships are not repeated.

Output:
Print the answer modulo  in a single line.
 */
public class TeacherDilemma {

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
		TeacherDilemma teacherDilemma = new TeacherDilemma();
		for (int i = 1; i <= n; i++) {
			teacherDilemma.makeSet(i);
		}
		for (int i = 0; i < m; i++) {
			teacherDilemma.union(sc.nextInt(), sc.nextInt());
		}
		long total = 1;
		long mode  = 1000000007;
		for (int i = 1; i <= n; i++) {
			if(teacherDilemma.findSet(i) == i) {
				total=(total%mode) * (teacherDilemma.findNode(i).height%mode);
			}
			
		}
		System.out.println(total%mode);
	}
}
