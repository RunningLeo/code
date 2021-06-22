package com.cyf.code.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @desc:
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *  
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/24 上午10:49
 */
public class _95_不同的二叉搜索树2 {

    public List<TreeNode> generateTrees(int n) {

        if(n < 1){
            return new LinkedList();
        }

        return genSubTree(1, n);

    }

    private static List<TreeNode> genSubTree(int s, int e){

        List<TreeNode> res = new LinkedList<>();

        if(s > e){
            res.add(null);
            return res;
        }

        for (int i = s; i <= e ; i++) {

            List<TreeNode> left = genSubTree(s, i-1);
            List<TreeNode> right = genSubTree(i+1, e);

            for (TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }

        }

        return res;
    }


    /**
     * Definition for a binary tree node.
     */
          static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}
