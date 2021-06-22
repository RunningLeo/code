package com.cyf.code.easy;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:26 2019-02-15
 * @Desc ：
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1+2+1=2).
 */
public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {

		int n = nums.length;
		int res = 0;
		int sum = 0;
		int abs = Integer.MAX_VALUE;
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				int abs2 = Math.abs(sum-target);

				if(abs2 < abs){
					res = sum;
					abs = abs2;
				}
				if (sum > target){
					k--;
				}else if(sum < target){
					j++;
				}else {
					return target;
				}


			}


		}

		return res;
	}

	public static void main(String[] args) {
		int [] a = new int[]{-1,2,1,-4};
		int res = threeSumClosest(a, 1);
		System.out.println("=====res="+res);
	}
}
