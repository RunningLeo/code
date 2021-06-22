package com.cyf.code.sword_to_offer;

/**
 * @desc:
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/9/11 上午11:10
 */
public class _35_复杂链表的复制 {

    public static Node copyRandomList(Node head) {

        if(head == null){
            return head;
        }

        Node cur = head;

        //1、增加复制的节点
        while (cur != null){

            Node next = cur.next;
            Node copy = new Node(cur.val);

            copy.next = next;
            cur.next = copy;

            cur = next;
        }

        // 设置复制节点的随机指针
        cur = head;
        while (cur != null){
            Node copy = cur.next;
            copy.random = cur.random == null ? null : cur.random.next;
            cur = copy.next;
        }

        //拆分链表，重新组合
        cur = head;
        Node copyHead = head.next;
        while (cur != null){
            Node next = cur.next;
            if(next != null){
                cur.next = next.next;
            }
            cur = next;
        }

        return copyHead;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(7);

        Node node2 = new Node(13);
        Node node3 = new Node(11);

        Node node4 = new Node(10);

        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;



        Node copyHead = copyRandomList(node1);


        while (copyHead != null) {
            System.out.println(copyHead.val);
            copyHead = copyHead.next;
        }



    }
}
