package com.cyf.code.medium;

/**
 * @desc:
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *  
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/24 下午4:55
 */
public class _413_等差数列划分 {

    public static int numberOfArithmeticSlices(int[] A) {

        if(A == null || A.length <= 2){
            return 0;
        }

        int len = A.length;

        //dp[i]表示 以A[i]结尾时比 以A[i-1]结尾时多的等差数列的个数

        int [] dp = new int[len];

        for (int i = 2; i < len; i++) {

            if( 2 * A[i-1] == A[i] + A[i-2]){
                dp[i] = dp[i-1] + 1;
            }
        }

        int count = 0;
        for (int i : dp){
            count += i;
        }

        return count;


    }

    public static void main(String[] args) {

        int [] A = new int[]{1, 3, 5, 7, 9};

        int count = numberOfArithmeticSlices(A);

        System.out.println("===>"+count);

    }
}
