package com.cyf.code.easy;

import java.util.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:02 2019-02-18
 * @Desc ：
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {

	/**
	 * 二叉树节点的定义
	 */
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int value){
			this.val = value;
		}
	}

	/**
	 * 使用从上到下的层次遍历，然后结果反序输出
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> resList = new ArrayList<>();

		if(root == null){
			return new ArrayList<>();
		}
		if(root.left == null && root.right == null){
			resList.add(Arrays.asList(root.val));
			return resList;
		}

		//层次遍历，用到队列结构，先进先出
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()){

			TreeNode node = queue.poll();
			if(node == null ){
				continue;
			}
			Queue<TreeNode> nextQueue = new ArrayDeque<>();
			List<Integer> res = new ArrayList<>();
			res.add(node.val);
			if(node.left != null){
				nextQueue.offer(node.left);
			}
			if(node.right != null){
				nextQueue.offer(node.right);
			}

			while (!queue.isEmpty()){
				TreeNode nodeNext = queue.poll();
				res.add(nodeNext.val);
				if(nodeNext.left != null){
					nextQueue.offer(nodeNext.left);
				}
				if(nodeNext.right != null){
					nextQueue.offer(nodeNext.right);
				}
			}

			resList.add(res);
			queue.addAll(nextQueue);
		}

		Collections.reverse(resList);
		return resList;
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

		List<List<Integer>> resList = levelOrderBottom(root);

		System.out.println("====resList="+resList);
	}
}
