package com.cyf.code.easy;

import com.cyf.code.base.TreeNode;

/**
 * @desc:
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/29 上午8:45
 */
public class _543_二叉树的直径 {

    static int max = Integer.MIN_VALUE;

    public static int diameterOfBinaryTree(TreeNode root) {

        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }

        maxGain(root);

        return max;
    }

    private static int maxGain(TreeNode node){

        if(node == null || (node.left == null && node.right == null)){
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int path = 0;
        if(node.left != null){
            path += leftGain + 1;
        }
        if(node.right != null){
            path += rightGain + 1;
        }


        max = Math.max(max, path);

        return 1 + Math.max(leftGain, rightGain);

    }




    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;


        int max = diameterOfBinaryTree(node1);

        System.out.println("==>max="+max);

    }
}
