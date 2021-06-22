package com.cyf.code.hard;

/**
 * @desc: 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * <p>
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * <p>
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/10/21 下午2:44
 */
public class _312_戳气球 {

    public static int maxCoins(int[] nums) {

        int n = nums.length;

        //在两侧补上虚拟的气球
        int[] points = new int[n + 2];

        points[0] = points[n + 1] = 1;

        for (int i = 1; i < n + 1; i++) {
            points[i] = nums[i - 1];
        }

        //定义 dp[i][j]为 戳破区间（i，j）气球获取的最大硬币数，不包含边界的气球, 问题转化为求 dp[0][n+1]的值

        int[][] dp = new int[n + 2][n + 2];

        //分析可得，当i >= j时， dp[i][j] == 0;

        for (int i = n+1; i >= 0; i--) {

            for (int j = i + 1; j < n + 2; j++) {

                //假设最后戳破的是（i,j）之间的的气球k
                for (int k = i + 1; k < j; k++) {

                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);

                }

            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};

        int coins = maxCoins(nums);

        System.out.println("===>" + coins);
    }
}
