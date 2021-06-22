package com.cyf.code.easy;

import com.cyf.code.base.ListNode;
import com.cyf.code.sword_to_offer._0_LinkListUtil;

/**
 * @desc: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/9/11 下午4:23
 */
public class _82_删除排序链表中的重复元素2 {

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while (b != null && b.next != null) {
            //初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            } else {
                //如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
                while (b != null && b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummy.next;
    }



    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates2(head.next);
        } else {
            head.next = deleteDuplicates2(head.next);
            return head;
        }
    }

    public static void main(String[] args) {

        int [] nums = new int[]{1,2,3,3,4,4,5};
        ListNode head = _0_LinkListUtil.buildLinkList(nums);

        ListNode newHead = deleteDuplicates(head);

        _0_LinkListUtil.printLinkList(newHead);

    }

}
