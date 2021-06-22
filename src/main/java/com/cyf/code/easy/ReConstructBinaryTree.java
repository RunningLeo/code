package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:07 2019-06-27
 * @Desc ：根据前序遍历和中序遍历，重构二叉树
 */
public class ReConstructBinaryTree {

	public static TreeNode reConstruct(int[] pre, int startPre, int endPre, int[] mid, int midStart, int midEnd) {


		if(startPre > endPre || midStart > midEnd){
			return null;
		}

		TreeNode root = new TreeNode(pre[startPre], null, null);

		for (int i = midStart; i <= midEnd ; i++) {
			if(mid[i] == pre[startPre]){
				root.left = reConstruct(pre, startPre+1, i-midStart+startPre, mid, midStart, i-1);
				root.right = reConstruct(pre, i-midStart+startPre+1, endPre, mid, i+1, midEnd);
				break;
			}
		}

		return root;

	}


	public static void main(String[] args) {
		int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
		int[] mid = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

		int len = pre.length;

		TreeNode root = reConstruct(pre, 0, len - 1, mid, 0, len - 1);

		preTransfer(root);

		System.out.println("********************************");

		midTransfer(root);

		System.out.println("********************************");

		postTransfer(root);
	}


	/**
	 * 前序遍历
	 * @param root
	 */
	public static void preTransfer(TreeNode root) {

		if (root == null) {
			return;
		}

		System.out.println(root.value);
		preTransfer(root.left);
		preTransfer(root.right);

	}


	/**
	 * 中序遍历
	 * @param root
	 */
	public static void midTransfer(TreeNode root){
		if(root == null){
			return;
		}

		midTransfer(root.left);
		System.out.println(root.value);
		midTransfer(root.right);
	}

	public static void postTransfer(TreeNode root){
		if(root == null){
			return;
		}

		midTransfer(root.left);
		midTransfer(root.right);
		System.out.println(root.value);
	}


	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}
