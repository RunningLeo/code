package com.cyf.code.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:55 2019-02-15
 * @Desc ：
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		int n = nums.length;
		Arrays.sort(nums);

		List<List<Integer>> resList = new ArrayList<>();

		for (int i = 0; i < n - 3; i++) {

			if(i>0 && nums[i] == nums[i-1]){
				continue;
			}

			for (int j = i + 1; j < n - 2; j++) {

				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				int k = j + 1;
				int m = n - 1;
				while (k < m) {

					if (nums[i] + nums[j] + nums[k] + nums[m] < target) {
						k++;
					} else if (nums[i] + nums[j] + nums[k] + nums[m] > target) {
						m--;
					} else {

						resList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
						k++;
						m--;

						while (k < m && nums[k] == nums[k - 1]) {
							k++;
						}
						while (k < m && nums[m] == nums[m + 1]) {
							m--;
						}

					}

				}

			}

		}
		return resList;
	}

	public static void main(String[] args) {
//		int [] a = new int[]{1, 0, -1, 0, -2, 2};
		int[] a = new int[]{0, 0, 0, 0};
		List<List<Integer>> res = fourSum(a, 0);
		System.out.println("====res=" + res);

	}
}
