package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:30 2018/9/19
 * @Desc ：
 */
public class IsSameTree100 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null){
			return true;
		}
		if(p != q){
			return false;
		}
		if(p.val == q.val){
			return isSameTree(p.left, p.left)&& isSameTree(p.right, q.right);
		}
		return false;
	}
}
