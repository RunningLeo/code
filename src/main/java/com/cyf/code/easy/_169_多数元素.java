package com.cyf.code.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午1:56 2020/5/19
 * @Desc ：
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class _169_多数元素 {

	/**
	 * 用Map
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			Integer count = map.get(nums[i]);
			map.put(nums[i], count == null ? 1 : ++count);
		}

		int maxCount = 0;
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() > maxCount){
				max = entry.getKey();
				maxCount = entry.getValue();
			}
		}
		return max;
	}

	public static int majorityElement2(int[] nums) {

		Arrays.sort(nums);

		return nums[nums.length / 2];
	}


		public static void main(String[] args) {
		int [] nums = new int[]{2,2,1,1,1,2,2};

		int res = majorityElement2(nums);

		System.out.println("===>"+res);
	}
}
