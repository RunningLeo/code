package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 20:33 2019-02-12
 * @Desc ：单连表逆序
 */
public class ReverseLinkedList {

	private static class Node{
		private int data;
		private Node next;
		Node(int data){
			this.data = data;
		}
	}

	public static Node reverseLinkedList(Node head){

		if(head == null || head.next == null){
			return head;
		}

		Node pre = head;
		Node cur = head.next;
		Node next = null;

		while (cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		head.next = null;
		return pre;
	}

	public static void main(String[] args) {
		//构建链表

		Node head = new Node(3);
		head.next = new Node(5);
		head.next.next = new Node(6);
		head.next.next.next = new Node(10);

		Node temp = head;
		System.out.println("逆序前：");

		while (temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}

		head = reverseLinkedList(head);

		temp = head;
		System.out.println("逆序后：");
		while (temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}


}
