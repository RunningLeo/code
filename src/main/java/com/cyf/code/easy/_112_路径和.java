package com.cyf.code.easy;

import com.cyf.code.base.TreeNode;

/**
 * @author ：caoyafei
 * @Date ：Created in 18:03 2019-02-18
 * @Desc ：
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class _112_路径和 {


	public static boolean hasPathSum(TreeNode root, int sum) {

		if(root == null){
			return sum != 0;
		}

		int value = root.val;

		if(root.left == null & root.right == null && value == sum){
			return true;
		}

		return hasPathSum(root.left, sum - value) || hasPathSum(root.right, sum - value);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode left1 = new TreeNode(4);
		TreeNode right1 = new TreeNode(8);
		root.left = left1;
		root.right = right1;

		TreeNode left2 = new TreeNode(13);
		TreeNode right2 = new TreeNode(4);
		right1.left = left2;
		right1.right = right2;

		TreeNode left3 = new TreeNode(11);
		left1.left = left3;

		TreeNode left4 = new TreeNode(7);
		TreeNode right4 = new TreeNode(2);
		left3.left = left4;
		left3.right = right4;

		TreeNode right5 = new TreeNode(1);
		right2.right = right5;

		boolean flag = hasPathSum(root, 22);

		System.out.println("====是否存在路径: "+ flag);








	}
}
