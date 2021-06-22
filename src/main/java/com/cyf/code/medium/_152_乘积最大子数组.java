package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午9:59 2020/5/29
 * @Desc ：
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class _152_乘积最大子数组 {

	public static int maxProduct(int[] nums) {

		if(nums == null || nums.length == 0){
			return 0;
		}

		// 声明dp[i][2] 定义：
		// dp[i][0] 以num[i]结尾的子数组的整数最大值，dp[i][1] 以num[i]结尾的子数组的负数最大值
		int len  = nums.length;


		int [] [] dp = new int[len][2];

		int res = nums[0];
		dp[0][0] = nums[0];
		dp[0][1] = nums[0];

		for (int i = 1; i < len; i++) {

			int cur = nums[i];

			dp[i][0] = Math.max(Math.max(dp[i-1][0] * cur, dp[i-1][1] * cur), cur);
			dp[i][1] = Math.min(Math.min(dp[i-1][0] * cur, dp[i-1][1] * cur), cur);

			res = Math.max(dp[i][0], res);

		}

		return res;

	}


	public static void main(String[] args) {
		int [] nums = new int[]{2,3,-2,4};

		int max = maxProduct(nums);

		System.out.println("===>max="+max);
	}
}
