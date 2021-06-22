package com.cyf.code.easy;

import com.cyf.code.base.TreeNode;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:33 2019-02-18
 * @Desc ：
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class _110_平衡二叉树 {

	public static boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		return getMaxSubDepth(root) != -1;

	}

	/**
	 * 获取某节点的子树深度
	 */
	public static int getMaxSubDepth(TreeNode node) {

		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		int leftMax = getMaxSubDepth(node.left);
		int rightMax = getMaxSubDepth(node.right);

		//子节点不满足平衡树
		if(leftMax == -1 || rightMax == -1 || Math.abs(leftMax - rightMax) > 1){
			return -1;
		}

		return Math.max(leftMax, rightMax) + 1;

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

		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(2);
		root.left = left1;
		root.right = right1;

		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(3);
		left1.left = left2;
		left1.right = right2;

		TreeNode left3 = new TreeNode(4);
		TreeNode right3 = new TreeNode(4);
		left2.left = left3;
		left2.right = right3;

		boolean isBalanced = isBalanced(root);

		System.out.println("===是否是平衡树？ : "+isBalanced);
	}
}
