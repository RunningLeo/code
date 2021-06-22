package com.cyf.code.sword_to_offer;

import com.cyf.code.base.ListNode;

/**
 * @desc: 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/9/11 上午10:42
 */
public class GetKthFromEnd14 {

    public static ListNode getKthFromEnd(ListNode head, int k) {

        //边界条件
        if(head == null){
            return head;
        }


        ListNode fast = head;
        ListNode slow = head;

        while (k > 1 && fast != null) {
            fast = fast.next;
            k--;
        }

        //长度不够的时候，返回头节点
        if(k > 1){
            return head;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 1, 4, 6, 2};
        ListNode head = _0_LinkListUtil.buildLinkList(nums);

        int k = 1;
        ListNode node = getKthFromEnd(head, k);

        _0_LinkListUtil.printLinkList(node);

    }
}
