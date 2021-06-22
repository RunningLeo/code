package com.cyf.code.zuo.chapter3;

import java.util.Stack;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:11 2020/4/27
 * @Desc ：分别用递归和非递归方式实现二叉树的前、中、后序遍历
 */
public class _二叉树遍历_ {


	/**
	 * 二叉树的前序递归遍历
	 */
	public static void preOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}

		System.out.println(head.value);
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	/**
	 * 二叉树的中序递归遍历
	 */
	public static void midOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		preOrderRecur(head.left);
		System.out.println(head.value);
		preOrderRecur(head.right);
	}

	/**
	 * 二叉树的后序遍历
	 */
	public static void postOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		postOrderRecur(head.left);
		postOrderRecur(head.right);
		System.out.println(head.value);
	}


	/**
	 * *****************************************************************************************************
	 */

	/**
	 * 二叉树非递归前序遍历
	 *
	 * @param head
	 */
	public static void preOrder(TreeNode head) {
		if (head == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(head);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();

			//遍历当前节点
			System.out.println(cur.value);

			if (cur.right != null) {
				stack.push(cur.right);
			}

			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}


	/**
	 * 二叉树中序非递归遍历
	 *
	 * @param head
	 */
	public static void midOrder(TreeNode head) {

		if (head == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();

		while (!stack.isEmpty() || head != null) {

			if (head != null) {
				stack.push(head);
				head = head.left;
			} else {
				TreeNode cur = stack.pop();
				System.out.println(cur.value);
				head = cur.right;
			}
		}
	}

	/**
	 * 二叉树的后序非递归遍历
	 * 法1：双栈遍历
	 *
	 * @param head
	 */
	public static void postOrder(TreeNode head) {
		if (head == null) {
			return;
		}

		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		stack1.push(head);

		while (!stack1.isEmpty()) {
			TreeNode cur = stack1.pop();
			stack2.push(cur);

			if (cur.left != null) {
				stack1.push(cur.left);
			}

			if (cur.right != null) {
				stack1.push(cur.right);
			}
		}

		while (!stack2.isEmpty()){
			System.out.println(stack2.pop().value);
		}
	}

	/**
	 * 二叉树的后续非递归遍历2
	 * 法2： 一个栈, 后序遍历的顺序是 左右根，则入栈顺序是 根 左 右， 如果一个节点没有子节点或者子节点已经被访问，则访问该节点
	 * @param head
	 */
	public static void postOrder2(TreeNode head) {
		if (head == null) {
			return;
		}

		//上一个被访问的节点
		TreeNode pre = null;

		Stack<TreeNode> stack = new Stack<>();

		stack.push(head);

		while (!stack.isEmpty()){
			TreeNode cur = stack.peek();

			if((cur.left == null && cur.right == null) || (cur.left == pre || cur.right == pre)){
				//该节点没有左右子节点 或者 左右子节点 已经被访问过
				System.out.println(cur.value);

				pre = stack.pop();
			}else {
				if(cur.right != null){
					stack.push(cur.right);
				}

				if(cur.left != null){
					stack.push(cur.left);
				}
			}
		}

	}


	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);

		head.left = node1;
		head.right = node2;

		node1.left = node3;
		node1.right = node4;

		node2.left = node5;


		postOrder2(head);

	}


	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}
	}
}
