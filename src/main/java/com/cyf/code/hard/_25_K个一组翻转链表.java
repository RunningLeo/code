package com.cyf.code.hard;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:40 2020/3/10
 * @Desc ：
 */
public class _25_K个一组翻转链表 {


	public static ListNode reverseKGroup(ListNode head, int k) {

		if(head == null || head.next == null){
			return head;
		}

		ListNode cur = head;

		for (int i = 1; i < k && cur != null; i++) {
			cur = cur.next;
		}

		//不够K个，直接返回
		if(cur == null){
			return head;
		}

		//记录下一段的头节点
		ListNode temp = cur.next;

		cur.next = null;

		//对分出来的K个逆序
		ListNode newHead = reverse(head);

		//连接这两段
		head.next = reverseKGroup(temp, k);

		return newHead;

	}

	private static ListNode reverse(ListNode head){

		if(head == null || head.next == null){
			return head;
		}

		ListNode pre = null;
		ListNode cur = head;
		while (cur != null){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;
	}


	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
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

		ListNode listNode = reverseKGroup(node, 3);

		while (listNode != null){
			System.out.println(listNode.val);
			listNode = listNode.next;
		}

	}
}


/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
