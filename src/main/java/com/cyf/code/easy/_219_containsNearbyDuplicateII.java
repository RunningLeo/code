package com.cyf.code.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午9:43 2020/3/7
 * @Desc ：
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _219_containsNearbyDuplicateII {

//	public static boolean containsNearbyDuplicate(int[] nums, int k) {
//
//		if (nums == null || nums.length < 2) {
//			return false;
//		}
//
//		Map<Integer, Integer> map = new HashMap<>();
//
//		int len = nums.length;
//
//		for (int i = 0; i < len; i++) {
//
//			int temp = nums[i];
//
//			if (map.containsKey(temp)) {
//				if (Math.abs(map.get(temp) - i) <= k) {
//					return true;
//				}
//			}
//			map.put(temp, i);
//		}
//
//		return false;
//	}


	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		if (nums == null || nums.length < 2 || k == 0) {
			return false;
		}

		int len = nums.length;
		//用快慢指针
		int slow = 0;
		int fast = 1;

		while (slow < len - 1) {

			if (nums[slow] == nums[fast]) {
				return true;
			}

			if (fast < slow + k && fast < len - 1) {
				fast++;
			} else {
				slow++;
				fast = slow + 1;
			}

		}

		return false;
	}


	public static void main(String[] args) {

		int[] nums = new int[]{1,2,3,1,1,2,3};
		int k = 35000;

		boolean flag = containsNearbyDuplicate(nums, k);

		System.out.println("====flag=" + flag);

	}
}
