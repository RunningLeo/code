package com.cyf.code.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:43 2019-02-15
 * @Desc ：
 * <p>
 * Given an array S of n integers, are there elements a,b,c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * • Elements in a triplet (a, b, c) must be in non-descending order. (ie, a ≤ b ≤ c) •
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4}.
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);

		int n = nums.length;

		for (int i = 0; i < n; i++) {

			if(nums[i] > 0){
				continue;
			}
			if(i>0 && nums[i] == nums[i-1]){
				//重复数字
				continue;
			}

			int start = i + 1;
			int end = n - 1;
			while (start < end){
				if (nums[i] + nums[start] + nums[end] < 0) {
					start++;
				}else if(nums[i] + nums[start] + nums[end] > 0){
					end--;
				}else {
					res.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					end--;

					while (start < end && nums[start] == nums[start-1]){
						start++;
					}
					while (start < end && nums[end] == nums[end+1]){
						end--;
					}

				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int [] a = new int[]{-2,0,1,1,2};
		List<List<Integer>> res = threeSum(a);
		System.out.println("====res="+res);
	}


}
