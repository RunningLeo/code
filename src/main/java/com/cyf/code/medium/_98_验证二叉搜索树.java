package com.cyf.code.medium;

/**
 * @desc:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/28 下午3:04
 */
public class _98_验证二叉搜索树 {

    long min = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        if(isValidBST(root.left) && root.val > min){
            min = root.val;
            return isValidBST(root.right);
        }

        return false;
    }


    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);

        TreeNode treeNode3 = new TreeNode(15);


        TreeNode treeNode4 = new TreeNode(6);

        TreeNode treeNode5 = new TreeNode(20);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        boolean is = new _98_验证二叉搜索树().isValidBST(treeNode1);

        System.out.println("===>"+is);
    }



}

/**
 * Definition for a binary tree node.
 */
 class TreeNode {
    Integer val;

    TreeNode left;

    TreeNode right;

    TreeNode(Integer x) {
        val = x;
    }
}
