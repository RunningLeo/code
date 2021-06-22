package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:52 2019-02-18
 * @Desc ：
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class ConvertSortedArraytoBinarySearchTree108 {

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

	public static TreeNode sortedArrayToBST(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}

		int n = nums.length;

		int mid = n / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = getSubBinary(nums, 0, mid - 1);
		root.right = getSubBinary(nums, mid+1, n-1);

		return root;

	}

	public static TreeNode getSubBinary(int[] a, int start, int end) {

		if(start > end){
			return null;
		}

		int mid = (end + start) / 2;
		TreeNode subRoot = new TreeNode(a[mid]);
		subRoot.left = getSubBinary(a, start, mid-1);
		subRoot.right = getSubBinary(a, mid+1, end);

		return subRoot;

	}

	public static void main(String[] args) {
		int [] a = new int[]{-10,-3,0,5,9};
		TreeNode root = sortedArrayToBST(a);
		System.out.println("====res");
	}
}
