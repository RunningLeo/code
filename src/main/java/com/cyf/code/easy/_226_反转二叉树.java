package com.cyf.code.easy;

import com.cyf.code.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:45 2020-02-17
 * @Desc ：反转二叉树
 */
public class _226_反转二叉树 {

	public static TreeNode invertTree(TreeNode root) {

		if(root == null){
			return root;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()){

			TreeNode cur = queue.poll();

			TreeNode temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;

			if(cur.left != null){
				queue.offer(cur.left);
			}

			if(cur.right != null){
				queue.offer(cur.right);
			}
		}

		return root;

	}


	public static TreeNode invertTree2(TreeNode root) {

		if(root == null || (root.left == null && root.right == null)){
			return root;
		}

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = right;
		root.right = left;

		invertTree2(left);
		invertTree2(right);

		return root;
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

		invertTree2(root);

		System.out.println("======");



	}




}

