package com.cyf.code.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @desc: 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/28 下午6:12
 */
public class _94_二叉树的中序遍历 {

    static List<Integer> res = new ArrayList<>();


    /**
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {

        //递归
        //    inorderTraversalRecursion(root);

        //非递归
        inorderTraversalNoRecursion(root);

        return res;
    }


    private static void inorderTraversalRecursion(TreeNode root) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left);

        res.add(root.val);

        inorderTraversal(root.right);
    }

    private static void inorderTraversalNoRecursion(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (!stack.empty() || cur != null) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();

                res.add(cur.val);

                cur = cur.right;

            }
        }

    }


    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);

        TreeNode treeNode3 = new TreeNode(2);


        TreeNode treeNode4 = new TreeNode(3);


        treeNode1.left = null;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;


//        TreeNode treeNode1 = new TreeNode(10);
//        TreeNode treeNode2 = new TreeNode(5);
//
//        TreeNode treeNode3 = new TreeNode(15);
//
//
//        TreeNode treeNode4 = new TreeNode(6);
//
//        TreeNode treeNode5 = new TreeNode(20);
//
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//
//        treeNode3.left = treeNode4;
//        treeNode3.right = treeNode5;

        inorderTraversal(treeNode1);

        System.out.println("===>" + res);

    }

}
