package com.cyf.code.sword_to_offer;

import com.cyf.code.base.ListNode;

/**
 * @desc:
 * @Author: caoyafei
 * @Date: 2020/9/11 上午10:44
 */
public class _0_LinkListUtil {

    public static ListNode buildLinkList(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);

        ListNode pre = head;

        for (int i = 1; i < nums.length; i++) {

            ListNode node = new ListNode(nums[i]);

            pre.next = node;

            pre = node;
        }

        return head;

    }


    public static void printLinkList(ListNode head) {

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
