package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:03 2019-02-18
 * @Desc ：
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its minimum depth = 2.
 */
public class MinimumDepthofBinaryTree111 {

	/**
	 * 二叉树节点的定义
	 */
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			this.val = value;
		}
	}

	public static int minDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		if (root.left == null) {
			return minDepth(root.right) + 1;
		} else if (root.right == null) {
			return minDepth(root.left) + 1;
		} else {
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}

	}

	public static void main(String[] args) {

//		TreeNode root = new TreeNode(3);
//		TreeNode left1 = new TreeNode(9);
//		TreeNode right1 = new TreeNode(20);
//		root.left = left1;
//		root.right = right1;
//
//		TreeNode left2 = new TreeNode(15);
//		TreeNode right2 = new TreeNode(7);
//		right1.left = left2;
//		right1.right = right2;

		TreeNode root = new TreeNode(3);
		TreeNode left1 = new TreeNode(9);
		TreeNode right1 = new TreeNode(20);
		root.left = null;
		root.right = right1;

		int minDepth = minDepth(root);

		System.out.println("====二叉树最小深度: " + minDepth);


	}
}
