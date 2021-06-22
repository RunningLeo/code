package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 13:45 2019-05-25
 * @Desc ：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEnd {

	public static Node RemoveNthFromEnd(Node head, int n){

		Node first = head;
		Node second = head;

		Node pre = null;

		if(head.next == null){
			return null;
		}


		while (n>1){
			first = first.next;
			n--;
		}

		while (first.next!= null){
			first = first.next;
			pre = second;
			second = second.next;
		}

		if(pre != null){
			pre.next = second.next;
		}else {
			return second.next;
		}


		return head;
	}


	public static void main(String[] args) {

		Node node1 = new Node(1);
//		Node node2 = new Node(2);
//		Node node3 = new Node(3);
//		Node node4 = new Node(4);
//		Node node5 = new Node(5);

//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;


		Node head = RemoveNthFromEnd(node1, 1);

		while (head != null){
			System.out.println("======"+head.value);
			head = head.next;
		}


	}



	static class Node{
		int value;
		Node next;
		Node(int x){
			value = x;
		}
	}
}
