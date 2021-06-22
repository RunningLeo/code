package com.cyf.code.easy;

/**
 * @desc:给定一个整数数组  nums，
 * 求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/24 下午3:32
 */
public class _303_区域和检索_数组不可变 {

    static  int[][] dp;

    static  int [] sum;

//    public _303_区域和检索_数组不可变(int[] nums) {
//
//        int len = nums.length;
//
//        //dp[i][j]表示（i,j)的范围和， i<=j
//
//        if(len == 0){
//            return;
//        }
//
//        dp = new int[len][len];
//
//        dp[0][0] = nums[0];
//
//        for (int j = 1; j < len; j++) {
//
//            for (int i = 0; i <= j; i++) {
//
//                dp[i][j] = dp[i][j-1] + nums[j];
//
//            }
//
//        }
//    }

//    public int sumRange(int i, int j) {
//        if(dp == null){
//            return 0;
//        }
//        return dp[i] [j];
//    }

    public _303_区域和检索_数组不可变(int[] nums) {

        int len = nums.length;

        if(len == 0){
            return;
        }

        sum = new int[len];

        sum[0] = nums[0];

        for (int i = 1; i < len; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

    }

    public int sumRange(int i, int j) {
        if(sum == null){
            return 0;
        }
        return i == 0 ? sum[j] : sum[j] - sum[i-1];
    }



    /**
     * 用上面的方式，当数组N非常大的时候，需要维护一个 N * N  的二维数组，最后会导致内存溢出
     * 所以为了解决问题，需要维护一个一维数组就好
     * sum[i]表示 (0,i)的和
     * （i,j）的和 = sum[j] - sum[i-1]
     */



    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */

    public static void main(String[] args) {

        int [] nums = new int[]{-2, 0, 3, -5, 2, -1};

        _303_区域和检索_数组不可变 array = new _303_区域和检索_数组不可变(nums);


        int i = 2;
        int j = 5;
        int sum = array.sumRange(i,j);

        System.out.println("===>sum="+sum);

    }
}
