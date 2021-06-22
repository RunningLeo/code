package com.cyf.code.sword_to_offer;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:52 2020/3/5
 * @Desc ：反转链表
 */
public class ReverseList206 {


	public static ListNode reverseList(ListNode head) {

		if(head == null || head.next == null){
			return head;
		}

		ListNode pre = head;
		ListNode cur = head.next;
		pre.next = null;

		while (cur != null){
			ListNode next = cur.next;

			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;

	}


	public static void main(String[] args) {

		//1->2->3->4->5->NULL
		ListNode node = new ListNode(1);

		ListNode node2 = new ListNode(2);

		ListNode node3 = new ListNode(3);

		ListNode node4 = new ListNode(4);

		ListNode node5 = new ListNode(5);


		node.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode listNode = reverseList(node);

		while (listNode != null){
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}






	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }

}
