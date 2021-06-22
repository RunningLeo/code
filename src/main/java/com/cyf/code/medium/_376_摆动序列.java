package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:19 2020-02-20
 * @Desc ：https://leetcode-cn.com/problems/wiggle-subsequence/
 */
public class _376_摆动序列 {


	//最长子串
	public static int wiggleMaxLength(int[] nums) {

		int max = 1;

		int len = nums.length;

		if(len <= 1){
			return len;
		}else if(len == 2 && nums[0] == nums[1]){
			return 1;
		}

		int BEGIN = 0;
		int UP = 1;
		int DOWN = 2;



		int STATE = BEGIN;

		for (int i = 1; i< len; i++){

			switch (STATE){
				case 0:
					if(nums[i] > nums[i-1]){
						STATE = UP;
						max++;
					}else if (nums[i] < nums[i-1]){
						STATE = DOWN;
						max++;
					}
					break;
				case 1:
					if (nums[i] < nums[i-1]){
						STATE = DOWN;
						max++;
					}
					break;
				case 2:
					if(nums[i] > nums[i-1]){
						STATE = UP;
						max++;
					}
					break;
			}

		}

		return max;
	}



	public static void main(String[] args) {
		int [] nums = new int[]{1,17,5,10,13,15,10,5,16,8};

		int len = wiggleMaxLength(nums);

		System.out.println("====最长子摇摆序列:"+len);
	}

}
