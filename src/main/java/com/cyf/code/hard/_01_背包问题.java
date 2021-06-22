package com.cyf.code.hard;

/**
 * @desc: 0-1背包问题
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。
 * 其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * <p>
 * 举个简单的例子，输入如下：
 * <p>
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * 算法返回 6，选择前两件物品装进背包，总重量 3 小于W，可以获得最大价值 6。
 * @Author: caoyafei
 * @Date: 2020/10/21 下午3:51
 * https://mp.weixin.qq.com/s/RXfnhSpVBmVneQjDSUSAVQ
 */
public class _01_背包问题 {

    public static int getMax(int N, int W, int[] wt, int[] val) {

        //定义dp[i][j] 表示 对前i个物品，容量为j的包可装的最大价值
        int[][] dp = new int[N+1][W+1];

        for (int i = 0; i < W+1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < N+1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < N+1; i++) {

            for (int j = 1; j < W+1; j++) {

                dp[i][j] = wt[i-1] > j ? dp[i-1][j] : Math.max(dp[i-1][j-wt[i-1]]+val[i-1], dp[i-1][j]);

            }

        }

        return dp[N][W];


    }

    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};


        int max = getMax(N, W, wt, val);

        System.out.println("===" + max);


    }
}
