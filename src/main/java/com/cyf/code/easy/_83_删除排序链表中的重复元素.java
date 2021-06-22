package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:40 2018/9/18
 * @Desc ：
 */
public class _83_删除排序链表中的重复元素 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null){
			return head;
		}

		while (head.next != null){
			if(head.val == head.next.val){
				head.next = head.next.next;
			}else {
				head = head.next;
			}
		}
		return head;
	}
}
