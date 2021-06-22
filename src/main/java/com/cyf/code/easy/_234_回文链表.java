package com.cyf.code.easy;


import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:05 2020/3/7
 * @Desc ：
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _234_回文链表 {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 思路：快慢先找到中间节点，后面节点逆序，然后比较
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {

		if(head == null || head.next == null){
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode newHead = reverse(slow);

		while (head != null && newHead != null) {
			if (head.val != newHead.val) {
				return false;
			}

			if (head.next == newHead || head == newHead) {
				return true;
			}
			head = head.next;
			newHead = newHead.next;
		}

		return true;
	}

	/**
	 * 逆序链表
	 * @param head
	 * @return
	 */
	private static ListNode reverse(ListNode head){

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

		ListNode node = new ListNode(1);

		ListNode node2 = new ListNode(2);

		ListNode node3 = new ListNode(3);

		ListNode node4 = new ListNode(2);

//		ListNode node5 = new ListNode(1);

		node.next = node2;
		node2.next = node3;
		node3.next = node4;
//		node4.next = node5;

		boolean is = isPalindrome(node);

		System.out.println("=====is="+is);



	}
}
