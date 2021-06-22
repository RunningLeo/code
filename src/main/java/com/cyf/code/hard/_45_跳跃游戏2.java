package com.cyf.code.hard;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:50 2020-02-21
 * @Desc ：https://leetcode-cn.com/problems/jump-game-ii/
 */
public class _45_跳跃游戏2 {

	public static int jump(int[] nums) {

		int len = nums.length;

		if(len < 2){
			return 0;
		}

		int min = 1;

		//当前可达到的最远位置
		int curMaxIndex = nums[0];

		//能达到的最远位置
		int maxIndex = nums[0];

		for (int i = 1; i< len; i++){

			if(curMaxIndex < i){

				//走这一步
				min++;

				curMaxIndex = maxIndex;

			}

			if(maxIndex < nums[i] + i){
				maxIndex = nums[i] + i;
			}

		}
		return min;
	}

	public static int jump2(int[] nums) {

		int n = nums.length;

		int end = 0;
		int farthest = 0;
		int jumps = 0;

		for (int i = 0; i < n-1 ; i++) {

			farthest = Math.max(farthest, nums[i] + i);

			if(end == i){
				jumps++;
				end = farthest;
			}
		}

		return jumps;

	}





	public static void main(String[] args) {

		int [] nums = new int[]{2,3,1,1,4};

		int count = jump2(nums);

		System.out.println("======count="+count);

	}
}
