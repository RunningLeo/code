package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 09:22 2020-02-21
 * @Desc ：https://leetcode-cn.com/problems/jump-game/
 */
public class _55_跳跃游戏 {


	public static boolean canJump(int[] nums) {

		int index = 0;

		int len = nums.length;

		if (len == 1) {
			return true;
		}

		while (index < len) {

			boolean jump = false;

			if (nums[index] == 0) {
				return false;
			}

			int rangeIndex = index + nums[index];

			if (rangeIndex >= len - 1) {
				return true;
			}

			for (int i = index + 1; i <= rangeIndex; i++) {
				if (i + nums[i] > rangeIndex) {
					index = i;
					jump = true;
					break;
				}
			}

			if (!jump) {
				index = rangeIndex;
			}

		}

		if (index >= len - 1) {
			return true;
		}

		return false;

	}


	public static boolean canJump2(int[] nums) {

		int last = nums.length - 1;

		if(last == 0){
			return true;
		}

		for (int i = last - 1; i >= 0; i--) {

			if (i + nums[i] >= last) {
				last = i;
			}
		}
		return last == 0;
	}

	/**
	 * 贪心算法
	 * @param nums
	 * @return
	 */
	public static boolean canJump3(int[] nums) {

		int n = nums.length;

		int farthest = 0;

		for (int i = 0; i < n ; i++) {

			//不断计算最远距离
			farthest = Math.max(farthest, nums[i] + i);

			//碰到0卡住
			if(farthest <= i){
				return false;
			}


		}

		return farthest >= n-1;



	}


	public static void main(String[] args) {

		int[] nums = new int[]{2,1, 0,1,4};
		boolean flag = canJump3(nums);


		System.out.println("=====是否能够跳跃:" + flag);

	}


}
