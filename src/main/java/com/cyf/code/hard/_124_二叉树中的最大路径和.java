package com.cyf.code.hard;

/**
 * @desc: 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/28 下午2:11
 */
public class _124_二叉树中的最大路径和 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxGain(root);

        return max;

    }

    /**
     * 返回node节点的最大贡献值
     * @param node
     * @return
     */
    public int maxGain(TreeNode node){

        if(node == null){
            return 0;
        }

        /**
         Q：左右孩子贡献为什么要大于等于0？
         A: 因为计算从某一节点出发的路径和的时候，计算公式为： 当前节点值 + 左孩子贡献 + 右孩子贡献，
         而左右孩子贡献是「可选的」，也就是说当某一边贡献小于0的时候，我可以在计算路径和时不算这一边
         这种情况也就相当于其贡献为 0，但是注意路径和至少包含「当前节点的值」。
         **/

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int newPath = leftGain + node.val + rightGain;

        max = Math.max(max, newPath);

        return node.val + Math.max(leftGain, rightGain);



    }


    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        int sum = new _124_二叉树中的最大路径和().maxPathSum(node1);

        System.out.println("==>sum="+sum);


    }
}
