package com.cyf.code.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:23 2020/6/2
 * @Desc ：
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class _300_最长上升子序列 {

	public static int lengthOfLIS(int[] nums) {

		//算法的复杂度O(n log n)，需要二分查找

		int size = nums.length;

		if(size == 0){
			return 0;
		}

		List<Integer> lis = new ArrayList<>();

		lis.add(nums[0]);

		for (int i = 1; i < size; i++) {

			int index = getMaxEqualIndex(lis, nums[i]);

			if(lis.get(index) < nums[i]){
				lis.add(index + 1, nums[i]);
			}else {
				lis.set(index, nums[i]);
			}
		}

		return lis.size();

	}


	private static int getMaxEqualIndex(List<Integer> lis, int tar) {

		//二分查找 大于等于tar的第一个位置，没有找到则返回最后的位置
		int start = 0;
		int end = lis.size() - 1;

		while (start < end) {
			int mid = ((end - start) >> 1) + start;

			if (lis.get(mid) >= tar) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;

	}


	public static int lengthOfLISByDP(int[] nums) {

		//使用动态规划，时间复杂度O(N^2)
		//dp[i]表示数组[0,i]的最长上升子序列的长度

		int n = nums.length;

		int [] dp = new int[n];

		//全部初始化成1
		for (int i = 0; i <n ; i++) {
			dp[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {

				if(nums[i] > nums[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n ; i++) {
			max = Math.max(max, dp[i]);
		}

		return max;



	}

	public static void main(String[] args) {

//		List<Integer> list = new ArrayList<>();
//		list.add(2);
//		list.add(5);
//		list.add(8);
//
//		int index = getMaxEqualIndex(list, 9);
//
//		System.out.println("==index=" + index);


		int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

		int max = lengthOfLIS(nums);

		System.out.println("===>max=" + max);

	}
}
