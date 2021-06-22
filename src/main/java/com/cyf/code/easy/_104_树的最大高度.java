package com.cyf.code.easy;

import com.cyf.code.base.TreeNode;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:44 2019-02-18
 * @Desc ：
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class _104_树的最大高度 {

	public static int findMaxDepth(TreeNode root){

		if(root == null){
			return 0;
		}

		if(root.left == null && root.right == null){
			return 1;
		}

		//遍历左子树
		int leftMax = findMaxDepth(root.left);
		//遍历右子树
		int rightMax = findMaxDepth(root.right);

		return Math.max(leftMax, rightMax) + 1;


	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		TreeNode left1 = new TreeNode(9);
		TreeNode right1 = new TreeNode(20);
		root.left = left1;
		root.right = right1;

		TreeNode left2 = new TreeNode(15);
		TreeNode right2 = new TreeNode(7);
		right1.left = left2;
		right1.right = right2;

		int max = findMaxDepth(root);

		System.out.println("=====最大深度："+max);



	}

}
