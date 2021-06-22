package com.cyf.code.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:17 2018/9/19
 * @Desc ：
 */
public class IsSymmetric101 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {

		//递归解法
		if (root == null) {
			return true;
		}
		return isSymmetricSub(root.left, root.right);

	}

	private boolean isSymmetricSub(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymmetricSub(left.left, right.right) && isSymmetricSub(left.right, right.left);
	}


	public boolean isSymmetricNotRecursive(TreeNode root) {

		//非递归解法
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);

		while (!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null || left.val != right.val) {
				return false;
			}
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;

	}

}
