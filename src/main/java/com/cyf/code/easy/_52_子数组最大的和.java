package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:44 2018/9/17
 * @Desc ：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class _52_子数组最大的和 {
	public static int maxSubArray(int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		int max = nums[0];
//		int totle = nums[0];
//		int len = nums.length;
//		for (int i = 1; i < len; i++) {
//			totle = totle + nums[i] > nums[i] ? totle + nums[i] : nums[i];
//			max = Math.max(max, totle);
//		}
//		return max;


		//dp动态规划
		int len = nums.length;
		int[] dp = new int[len];
		int max = nums[0];
		dp[0] = max;
		for (int i = 1; i < len; i++) {
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}
		return max;

	}

	/**
	 * 贪心算法
	 *
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums) {

		int len = nums.length;

		int max = nums[0];

		int curSum = nums[0];

		for (int i = 1; i < len; i++) {

			curSum = curSum < 0 ? nums[i] : curSum + nums[i];

			max = Math.max(max, curSum);
		}

		return max;
	}



	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
		int max = maxSubArray2(nums);
		System.out.println("=====max=" + max);
	}
}
