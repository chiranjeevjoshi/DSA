package linkedlist;

import java.util.Scanner;

public class EvenOddLinkedList {
	/*
	 * Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. Also, keep the order of even and odd numbers same.
	 */
	static class Node{
		int data;
		Node next;
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i<t ; i++){
			int n = sc.nextInt();
			Node head = null;
			Node end = null;
			Node evenRoot = null;
			Node oddRoot = null;
			Node currentEven = null;
			Node currentOdd = null;
			for(int j =0 ; j<n ; j++){
				Node node = new Node(sc.nextInt() , null);
				if(head == null){
					head = node;
					end = node;
				}
				end.next = node;
				end = node;
			}
			Node temp = head;
			while(temp != null){
				if(temp.data %2 ==0){
					if(evenRoot == null){
						evenRoot = temp;
						currentEven = temp;
					}else{
						currentEven.next = temp;
						currentEven = temp;
					}
				}else{
					if(oddRoot == null){
						oddRoot = temp;
						currentOdd = temp;
					}else{
						currentOdd.next = temp;
						currentOdd = temp;
					}
				}
				temp = temp.next;
			}
			if(evenRoot != null ){
				currentEven.next = oddRoot;
				currentOdd.next = null;
				head = evenRoot;
			}else{
				currentOdd.next = null;
				head = oddRoot;
			}
			
			while(head != null){
				System.out.print(head.data +" ");
				head = head.next;
			}
			System.out.println();
		}
		
	}
}
