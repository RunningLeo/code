package com.cyf.code.hard;

/**
 * @desc:
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/10/21 上午11:17
 */
public class _72_编辑距离 {

    public static int minDistance(String word1, String word2) {

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();


        if(w1.length == 0){
            return w2.length;
        }

        if(w2.length == 0){
            return w1.length;
        }

        //dp[i][j]代表 str1[0....i]和str2[0...j]的最小编辑距离
        int[][]dp = new int[w1.length][w2.length];

        dp[0][0] = w1[0] == w2[0] ? 0 : 1;

        for (int i = 1; i < w1.length ; i++) {
            dp[i][0] = w1[i] == w2[0] ? i : dp[i-1][0] + 1;
        }

        for (int j = 1; j < w2.length; j++) {
            dp[0][j] = w1[0] == w2[j] ? j : dp[0][j-1] + 1;
        }


        for (int i = 1; i < w1.length; i++) {

            for (int j = 1; j < w2.length; j++) {

                dp[i][j] = w1[i] == w2[j] ? dp[i-1][j-1] : Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;

            }
        }

        return dp[w1.length - 1][w2.length - 1];

    }


    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";

        int cost = minDistance(s1, s2);

        System.out.println("==cost=>"+cost);
    }
}
