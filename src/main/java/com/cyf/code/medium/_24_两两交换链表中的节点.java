package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:47 2020/3/26
 * @Desc ：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _24_两两交换链表中的节点 {


	public static ListNode swapPairs(ListNode head) {

		if(head == null || head.next == null){
			return head;
		}

		ListNode cur = head.next;

		ListNode newHead = swapPairs(cur.next);

		cur.next = head;
		head.next = newHead;

		return cur;
	}




	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);

		node1.next = node2;
		node2.next = node3;

		node3.next = node4;

		ListNode head = swapPairs(node1);

		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}




	}


}


class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
